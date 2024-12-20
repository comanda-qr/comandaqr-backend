package com.comandaqr.mapstruct.dto;

import java.util.UUID;

public record UserDTO(
    UUID id,
    String name
) {
}
