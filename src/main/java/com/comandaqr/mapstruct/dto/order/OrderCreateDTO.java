package com.comandaqr.mapstruct.dto.order;

import java.util.List;
import java.util.UUID;

public record OrderCreateDTO(
    List<UUID> productsIds,
    UUID businessId
) {
}
