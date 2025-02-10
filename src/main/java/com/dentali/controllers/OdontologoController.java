package com.dentali.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dentali.services.DoctorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/odontologo")
@RequiredArgsConstructor
public class OdontologoController {		
	
	@Autowired
	DoctorService doctorService;
	
	
}
