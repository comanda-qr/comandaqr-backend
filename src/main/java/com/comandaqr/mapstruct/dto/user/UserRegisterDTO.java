package com.comandaqr.mapstruct.dto.user;

public record UserRegisterDTO(
    String username,
    String password,
    String name
) {
}
