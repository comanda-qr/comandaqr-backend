package com.comandaqr.mapstruct.dto.user;

public record AuthenticationDTO(
    UserDTO user,
    String token
) {
}
