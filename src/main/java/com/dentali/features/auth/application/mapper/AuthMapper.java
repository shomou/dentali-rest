package com.dentali.features.auth.application.mapper;

import com.dentali.features.auth.application.dto.response.AuthResponse;
import com.dentali.features.auth.application.dto.response.UserResponse;
import com.dentali.features.auth.domain.model.Role;
import com.dentali.features.auth.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthMapper {

    @Mapping(target = "username", source = "user.username")
    @Mapping(target = "token", source = "token")
    AuthResponse toResponse(User user, String token);

    UserResponse toUserResponse(User user);

    default List<String> mapRoles(List<Role> roles) {
        return roles == null ? null : roles.stream().map(Role::getName).toList();
    }
}
