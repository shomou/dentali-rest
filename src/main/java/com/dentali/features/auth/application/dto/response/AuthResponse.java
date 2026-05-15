package com.dentali.features.auth.application.dto.response;

public record AuthResponse(
    String token,
    String username
) {}