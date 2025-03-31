package com.dentali.mapper;

import org.springframework.stereotype.Component;

import com.dentali.dto.DoctorDTO;
import com.dentali.entities.Doctor;


@Component
public class DoctorMapper {
	
	public DoctorDTO toDTO(Doctor doctor){
		return new DoctorDTO();
	}

	public Doctor toEntity(DoctorDTO dto) {	
		
		return new Doctor();
	
	}

}
