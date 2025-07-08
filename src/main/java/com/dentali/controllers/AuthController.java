package com.dentali.controllers;

import com.dentali.entities.User;
import com.dentali.services.UserService;

import java.util.Map;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
public class AuthController {



     @Autowired
     private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) throws AuthenticationException {
        //return userService.verify(user);
        //return "success";

        return ResponseEntity.ok(Map.of("token", userService.verify(user)));
    }



    
}
