package com.dentali.features.auth.service;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {
    String generateToken(String username);

    boolean validateToken(String token, UserDetails userDetails);

    String extractUsername(String token);

    boolean isTokenExpired(String token);

    Date extractExpiration(String token);
}
