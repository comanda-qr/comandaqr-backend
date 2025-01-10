package com.comandaqr.mapstruct.dto.product;

import java.util.UUID;

public record ProductCreateDTO(
    String name,
    String description,
    UUID businessId
) {
}
