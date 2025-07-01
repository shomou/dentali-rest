package com.dentali.services;

import org.springframework.stereotype.Service;

@Service
public interface JWTService {
    String generateToken(String username);

    //boolean validateToken(String token, String username);

    //String getUsernameFromToken(String token);
}
