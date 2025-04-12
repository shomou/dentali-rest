package com.dentali.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dentali.dto.HistorialMedicoDTO;
import com.dentali.entities.HistorialMedico;
import com.dentali.mapper.HistorialMedicoMapper;
import com.dentali.repositories.DoctorRepository;
import com.dentali.repositories.HistorialMedicoRepository;
import com.dentali.repositories.PacienteRepository;
import com.dentali.services.HistorialMedicoServices;

@Service
public class HistorialMedicoServiceImpl implements HistorialMedicoServices{

	@Autowired
    private DoctorRepository doctorRepository;

	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private HistorialMedicoRepository historialRepository;

	@Autowired
	private HistorialMedicoMapper historialMapper;

    HistorialMedicoServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

	@Override
	@Transactional(readOnly = true)
	public List<HistorialMedicoDTO> listar() {
		return historialRepository.findAll().stream()
				.map(historialMapper::toDTO)
				.toList();
	}
	
	@Override
	@Transactional
	public HistorialMedicoDTO create(HistorialMedicoDTO historialDTO) {

		// Convertir un DTO a una entidad
		HistorialMedico nuevoHistorial = historialMapper.toEntity(historialDTO);

		// Guardar la entidad en la base de datos
		HistorialMedico historialGuardado =  historialRepository.save(nuevoHistorial);


		return historialMapper.toDTO(historialGuardado);
	}

	@Override
	@Transactional(readOnly = true)
	public HistorialMedicoDTO buscarPacienteId (Long id){		
		return historialRepository.findById(id)
				.map(historialMapper::toDTO)
				.orElse(null);
	}

	@Override
	@Transactional
	public HistorialMedicoDTO update( HistorialMedicoDTO historialDTO){

		// Convertir el DTO a una entidad
		HistorialMedico historialEntity = historialRepository.findById(historialDTO.getId())
										.orElseThrow(() -> new IllegalArgumentException("El historial médico con ID " 
										+ historialDTO.getId() 
										+ " no existe."));
		

		if(historialEntity != null) {
			// Actualizar los campos de la entidad
			historialEntity.setId(historialDTO.getId());
			historialEntity.setPaciente(pacienteRepository.findById(historialDTO.getPaciente_id()).orElse(null));
			historialEntity.setDoctor(doctorRepository.findById(historialDTO.getDoctor_id()).orElse(null));
			historialEntity.setAntecedentes(historialDTO.getAntecedentes());
			historialEntity.setAlergias(historialDTO.getAlergias());
			historialEntity.setMedicamentosActuales(historialDTO.getMedicamentosActuales());
			historialEntity.setEnfermedadesCronicas(historialDTO.getEnfermedadesCronicas());
			

			// Guardar la entidad actualizada en la base de datos
			HistorialMedico historialActualizado = historialRepository.save(historialEntity);

			return historialMapper.toDTO(historialActualizado);

		}		
		return historialMapper.toDTO(historialEntity);
	}
	
	
}
