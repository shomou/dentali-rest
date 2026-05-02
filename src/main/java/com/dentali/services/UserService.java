package com.dentali.services;

import java.util.List;

import com.dentali.dto.Auth.LoginRequestDTO;
import com.dentali.dto.Auth.UserDoctorRegistrationDTO;
import com.dentali.dto.Auth.UserResponseDTO;

public interface UserService {

    List<UserResponseDTO> findAll();

    boolean existsByUserName(String username);

    String verify(LoginRequestDTO loginRequest);

    public UserDoctorRegistrationDTO registerUserWithDoctor(UserDoctorRegistrationDTO dto);
}
