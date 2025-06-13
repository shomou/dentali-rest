package com.dentali.services;

import java.util.List;

import com.dentali.entities.User;

public interface UserService {

    List<User> findAll();

    User save(User user);

    boolean existsByUserName(String username);

}
