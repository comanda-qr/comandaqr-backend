package com.comandaqr.mapstruct.dto.user;

import java.util.UUID;

public record UserDTO(
    UUID id,
    String name
) {
}
