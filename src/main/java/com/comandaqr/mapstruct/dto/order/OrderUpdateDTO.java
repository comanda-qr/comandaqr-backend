package com.comandaqr.mapstruct.dto.order;

import java.util.List;
import java.util.UUID;

public record OrderUpdateDTO(
    UUID id,
    List<UUID> productsIds
) {
}
