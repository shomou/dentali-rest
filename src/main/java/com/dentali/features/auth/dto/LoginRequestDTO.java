package com.dentali.features.auth.dto;

public class LoginRequestDTO {

    private String username;
    private String password;

    // Constructor sin argumentos (necesario para la deserialización de JSON por
    // frameworks como Jackson)
    public LoginRequestDTO() {
    }

    public LoginRequestDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
