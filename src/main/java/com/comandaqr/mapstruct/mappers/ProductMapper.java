package com.comandaqr.mapstruct.mappers;

import com.comandaqr.mapstruct.dto.product.ProductDTO;
import com.comandaqr.models.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
  Product productDtoToProduct(ProductDTO productDTO);
  ProductDTO productToProductDto(Product product);
}
