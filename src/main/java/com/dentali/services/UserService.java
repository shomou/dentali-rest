package com.dentali.services;

import java.util.List;

import com.dentali.dto.LoginRequestDTO;
import com.dentali.dto.UserDoctorRegistrationDTO;
import com.dentali.dto.UserResponseDTO;




public interface UserService {

    List<UserResponseDTO> findAll();

    boolean existsByUserName(String username);

    String verify(LoginRequestDTO loginRequest);

    public UserDoctorRegistrationDTO registerUserWithDoctor(UserDoctorRegistrationDTO dto);
}
