package com.dentali.features.cita.application.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dentali.features.cita.application.dto.request.CitaRequest;
import com.dentali.features.cita.application.dto.response.CitaResponse;
import com.dentali.features.cita.application.mapper.CitaDtoMapper;
import com.dentali.features.cita.application.service.CitaService;
import com.dentali.features.cita.domain.model.Cita;
import com.dentali.features.cita.domain.repository.CitaRepository;
import com.dentali.features.doctor.domain.Doctor;
import com.dentali.features.doctor.repository.DoctorRepository;
import com.dentali.features.paciente.domain.model.Paciente;
import com.dentali.features.paciente.domain.repository.PacienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CitaServiceImpl implements CitaService{
    
    private final CitaRepository citaRepository;
    private final PacienteRepository pacienteRepository;
    private final DoctorRepository doctorRepository;
    private final CitaDtoMapper dtoMapper;
   
    @Override
    @Transactional
    public CitaResponse createCita(CitaRequest request) {

        Optional<Paciente> pacienteBd = pacienteRepository.findById(request.pacienteId());
        Optional<Doctor> doctorBb = doctorRepository.findById(request.doctorId());

        if(pacienteBd.isEmpty() || doctorBb.isEmpty()){
            throw new RuntimeException("Paciente o Doctor no encontrado");
        }

        Cita citaASalvar = dtoMapper.toDomain(request, pacienteBd.get(), doctorBb.get());
        citaRepository.save(citaASalvar);

        return dtoMapper.toResponse(citaASalvar);
    }

    @Override
    @Transactional(readOnly = true)
    public CitaResponse getCitaById(Long id) {
        
        return dtoMapper.toResponse(citaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada")));
                
    }

    @Override
    @Transactional(readOnly = true)
    public List<CitaResponse> listarCitas() {
        return citaRepository.findAll().stream()
                .map(dtoMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public CitaResponse updateCita(Long id, CitaRequest request) {
        Cita citaExistente = citaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));

        Paciente paciente = pacienteRepository.findById(request.pacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        Doctor doctor = doctorRepository.findById(request.doctorId())
                .orElseThrow(() -> new RuntimeException("Doctor no encontrado"));

        citaExistente.setFechaHora(request.fecha_hora());
        citaExistente.setMotivo(request.motivo());
        citaExistente.setObservaciones(request.observaciones());
        citaExistente.setPaciente(paciente);
        citaExistente.setDoctor(doctor);

        Cita citaActualizada = citaRepository.save(citaExistente);
        return dtoMapper.toResponse(citaActualizada);
    }
}
