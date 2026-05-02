package com.dentali;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dentali.dto.Tratamiento.TratamientoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class TratamientoMappingTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testJsonMapping() throws Exception {
        // Probamos con "doctor_id" y "paciente_id" (como está ahora tras la
        // unificación)
        String json = "{\"doctor_id\": 1, \"paciente_id\": 2, \"cita_id\": 3, \"descripcion\": \"Test\", \"costo\": 100.0}";
        TratamientoDTO dto = objectMapper.readValue(json, TratamientoDTO.class);

        System.out.println("DTO (unified): idDoctor=" + dto.getIdDoctor() + ", idPaciente=" + dto.getIdPaciente()
                + ", idCita=" + dto.getIdCita());

        assertNotNull(dto.getIdDoctor(), "idDoctor should not be null with 'doctor_id' JSON");
        assertNotNull(dto.getIdPaciente(), "idPaciente should not be null with 'paciente_id' JSON");
        assertNotNull(dto.getIdCita(), "idCita should not be null with 'cita_id' JSON");
        assertEquals(1L, dto.getIdDoctor());
        assertEquals(2L, dto.getIdPaciente());
        assertEquals(3L, dto.getIdCita());
    }
}
