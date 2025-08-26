package com.dentali.services;

import java.util.List;

import com.dentali.dto.LoginRequestDTO;
import com.dentali.dto.UserDoctorRegistrationDTO;
import com.dentali.dto.UserResponseDTO;
import com.dentali.entities.User;



public interface UserService {

    List<UserResponseDTO> findAll();

    User save(User user);

    boolean existsByUserName(String username);

    String verify(LoginRequestDTO loginRequest);

    public UserDoctorRegistrationDTO registerUserWithDoctor(UserDoctorRegistrationDTO dto);
}
