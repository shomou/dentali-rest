package com.dentali.features.auth.service;

import java.util.List;

import com.dentali.features.auth.dto.LoginRequestDTO;
import com.dentali.features.auth.dto.UserDoctorRegistrationDTO;
import com.dentali.features.auth.dto.UserResponseDTO;

public interface UserService {

    List<UserResponseDTO> findAll();

    boolean existsByUserName(String username);

    String verify(LoginRequestDTO loginRequest);

    public UserDoctorRegistrationDTO registerUserWithDoctor(UserDoctorRegistrationDTO dto);
}
