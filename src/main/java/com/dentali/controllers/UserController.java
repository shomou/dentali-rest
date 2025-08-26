package com.dentali.controllers;


import java.util.Collections;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dentali.dto.LoginRequestDTO;
import com.dentali.dto.UserDoctorRegistrationDTO;
import com.dentali.entities.User;
import com.dentali.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/login")
   public ResponseEntity<?> login(@RequestBody @Valid LoginRequestDTO loginRequest) {
       // La lógica de try-catch ahora es manejada por GlobalExceptionHandler
       String token = userService.verify(loginRequest);
       return ResponseEntity.ok(Map.of("token", token));
   }
     

    @GetMapping("/list")
    public ResponseEntity<?> list(){

        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                .body(Collections.singletonMap("error", "This endpoint is disabled for security reasons. Use a DTO if needed."));
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody User user) {  
        /* 
        if(result.hasFieldErrors()){
            return validation(result);
        }*/

                
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDoctorRegistrationDTO  userDoctorRegistrationDTO) {

        UserDoctorRegistrationDTO registeredUser = userService.registerUserWithDoctor(userDoctorRegistrationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    }


   
    /*
    private ResponseEntity <?> validation(BindingResult result){
       Map<String, String> errors = new HashMap<>();
       result.getFieldErrors().forEach(err ->
       {
           errors.put(err.getField(), "El campo "+err.getField()+" "+ err.getDefaultMessage());
       }); 
        
       return ResponseEntity.badRequest().body(errors);
    } */

}
