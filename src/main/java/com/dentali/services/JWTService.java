package com.dentali.services;



public interface JWTService {
    String generateToken(String username);

    boolean validateToken(String token, String username);

    //String getUsernameFromToken(String token);
}
