package com.comandaqr.mapstruct.dto;

public record AuthenticationDTO(
    UserDTO user,
    String token
) {
}
