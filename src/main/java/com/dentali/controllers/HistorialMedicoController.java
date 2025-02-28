package com.dentali.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dentali.entities.HistorialMedico;
import com.dentali.services.HistorialMedicoServices;

@RestController
@RequestMapping("/api/historial")
public class HistorialMedicoController {
	
	@Autowired
	private HistorialMedicoServices historialService;
	
	@GetMapping("/list")
	public List<HistorialMedico> list(){
		return historialService.listar();
	}
	
}
