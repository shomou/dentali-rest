package com.dentali.services;



public interface JWTService {
    String generateToken(String username);

    boolean validateToken(String token, String username);

    public String extractUsername(String token);
}
