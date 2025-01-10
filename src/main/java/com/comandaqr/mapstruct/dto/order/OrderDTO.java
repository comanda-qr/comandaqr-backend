package com.comandaqr.mapstruct.dto.order;

import com.comandaqr.mapstruct.dto.product.ProductDTO;

import java.util.List;
import java.util.UUID;

public record OrderDTO(
    UUID id,
    List<ProductDTO> products
) {
}
