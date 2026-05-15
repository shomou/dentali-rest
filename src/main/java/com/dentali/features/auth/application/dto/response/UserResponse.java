package com.dentali.features.auth.application.dto.response;

import java.util.List;

public record UserResponse(
    Long id,
    String username,
    boolean enabled,
    List<String> roles
) {}