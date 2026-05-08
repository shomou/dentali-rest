package com.dentali.features.doctor.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dentali.features.auth.domain.Role;
import com.dentali.features.auth.domain.User;
import com.dentali.features.auth.repository.RoleRepository;
import com.dentali.features.auth.repository.UserRepository;
import com.dentali.features.doctor.domain.Doctor;
import com.dentali.features.doctor.dto.DoctorDTO;
import com.dentali.features.doctor.dto.DoctorResponseDTO;
import com.dentali.features.doctor.mapper.DoctorMapper;
import com.dentali.features.doctor.repository.DoctorRepository;
import com.dentali.features.doctor.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private DoctorMapper doctorMapper;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional(readOnly = true)
	public List<DoctorResponseDTO> obtenerTodos() {
		return doctorRepository.findAll().stream()
				.map(doctor -> {
					List<String> roles = obtenerRolesDeUsuario(doctor.getEmail());
					return doctorMapper.toResponseDTO(doctor, roles);
				})
				.collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<DoctorResponseDTO> obtenerPorId(Long id) {
		return doctorRepository.findById(id)
				.map(doctor -> {
					List<String> roles = obtenerRolesDeUsuario(doctor.getEmail());
					return doctorMapper.toResponseDTO(doctor, roles);
				});
	}

	@Override
	@Transactional(readOnly = true)
	public List<DoctorResponseDTO> buscarPorEspecialidad(String especialidad) {
		return doctorRepository.findByEspecialidadIgnoreCase(especialidad).stream()
				.map(doctor -> {
					List<String> roles = obtenerRolesDeUsuario(doctor.getEmail());
					return doctorMapper.toResponseDTO(doctor, roles);
				})
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public DoctorResponseDTO guardar(DoctorDTO doctorDTO) {

		// 1. Asegurar que el usuario exista o crearlo
		if (!userRepository.existsByUsername(doctorDTO.getEmail())) {
			User nuevoUsuario = new User();
			nuevoUsuario.setUsername(doctorDTO.getEmail());
			nuevoUsuario.setPassword(passwordEncoder.encode(doctorDTO.getPassword()));

			// Asignar Roles desde la lista del DTO
			List<Role> roles = new ArrayList<>();
			if (doctorDTO.getRoles() != null && !doctorDTO.getRoles().isEmpty()) {
				for (String nombreRol : doctorDTO.getRoles()) {
					roleRepository.findByName(nombreRol).ifPresent(roles::add);
				}
			} else {
				// Rol por defecto si la lista viene vacía
				roleRepository.findByName("ROLE_USER").ifPresent(roles::add);
			}

			nuevoUsuario.setRoles(roles);
			userRepository.save(nuevoUsuario);
		}

		// 2. Guardar el Doctor
		Doctor doctor = doctorMapper.toEntity(doctorDTO);
		Doctor savedDoctor = doctorRepository.save(doctor);

		List<String> rolesNombres = obtenerRolesDeUsuario(savedDoctor.getEmail());
		return doctorMapper.toResponseDTO(savedDoctor, rolesNombres);
	}

	@Override
	@Transactional
	public Optional<DoctorResponseDTO> eliminar(Long id) {
		return doctorRepository.findById(id).map(doctor -> {
			List<String> roles = obtenerRolesDeUsuario(doctor.getEmail());
			doctorRepository.delete(doctor);
			return doctorMapper.toResponseDTO(doctor, roles);
		});
	}

	@Override
	@Transactional
	public Optional<DoctorResponseDTO> update(Long id, DoctorDTO doctorDTO) {
		System.out.println("asi viene: " + doctorDTO);
		return doctorRepository.findById(id).map(existingDoctor -> {
			// Guardamos el email viejo por si cambió, para buscar al usuario
			String oldEmail = existingDoctor.getEmail();

			// 1. Actualizar datos del Doctor
			existingDoctor.setNombre(doctorDTO.getNombre());
			existingDoctor.setApellido(doctorDTO.getApellido());
			existingDoctor.setEspecialidad(doctorDTO.getEspecialidad());
			existingDoctor.setTelefono(doctorDTO.getTelefono());
			existingDoctor.setEmail(doctorDTO.getEmail());

			// 2. Actualizar el Usuario asociado
			userRepository.findByUsername(oldEmail).ifPresent(user -> {
				user.setUsername(doctorDTO.getEmail());

				if (doctorDTO.getPassword() != null && !doctorDTO.getPassword().isBlank()) {
					user.setPassword(passwordEncoder.encode(doctorDTO.getPassword()));
				}

				// Actualizar lista de Roles
				if (doctorDTO.getRoles() != null && !doctorDTO.getRoles().isEmpty()) {
					List<Role> newRoles = new ArrayList<>();
					for (String nombreRol : doctorDTO.getRoles()) {
						roleRepository.findByName(nombreRol).ifPresent(newRoles::add);
					}
					user.setRoles(newRoles);
				}

				userRepository.save(user);
			});

			// 3. Guardar cambios del Doctor
			Doctor updatedDoctor = doctorRepository.save(existingDoctor);
			List<String> roles = obtenerRolesDeUsuario(updatedDoctor.getEmail());
			return doctorMapper.toResponseDTO(updatedDoctor, roles);
		});
	}

	/**
	 * Método privado para realizar el vínculo lógico entre Doctor y User
	 * basado en que el Email del Doctor coincide con el Username del Usuario.
	 */
	private List<String> obtenerRolesDeUsuario(String email) {
		if (email == null)
			return Collections.emptyList();

		return userRepository.findByUsername(email)
				.map(user -> user.getRoles().stream()
						.map(Role::getName)
						.collect(Collectors.toList()))
				.orElse(Collections.emptyList());
	}
}
