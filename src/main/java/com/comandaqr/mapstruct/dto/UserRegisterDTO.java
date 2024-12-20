package com.comandaqr.mapstruct.dto;

public record UserRegisterDTO(
    String username,
    String password,
    String name
) {
}
