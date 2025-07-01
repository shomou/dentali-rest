package com.dentali.services;

import java.util.List;

import com.dentali.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    List<User> findAll();

    User save(User user);

    boolean existsByUserName(String username);

    String verify(User user);
}
