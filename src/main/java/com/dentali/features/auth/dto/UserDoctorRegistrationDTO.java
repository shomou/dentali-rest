package com.dentali.features.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDoctorRegistrationDTO {

    // Datos del usuario
    @NotBlank(message = "no puede estar vacío")
    @Size(min = 3, max = 30, message = "debe tener entre 3 y 20 caracteres")
    private String username;
    @NotBlank(message = "no puede estar vacía")
    @Size(min = 6, message = "Debe tener al menos 6 caracteres")
    private String password;
    private String role;

    // Datos del doctor
    @NotBlank(message = "no puede estar vacío")
    private String nombre;
    @NotBlank(message = "no puede estar vacío")
    private String apellido;
    private String especialidad;
    private String telefono;
    @NotBlank(message = "no puede estar vacío")
    @Email(message = "debe ser una dirección de correo electrónico válida")
    private String email;

    // Constructor
    public UserDoctorRegistrationDTO() {
    }

    // Getters & Setters
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
