package com.comandaqr.mapstruct.dto.business;

import com.comandaqr.mapstruct.dto.order.OrderDTO;
import com.comandaqr.mapstruct.dto.product.ProductDTO;

import java.util.List;
import java.util.UUID;

public record BusinessDTO(
    UUID id,
    String name,
    List<OrderDTO> orders,
    List<ProductDTO> products
) {
}
