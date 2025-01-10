package com.comandaqr.mapstruct.mappers;

import com.comandaqr.mapstruct.dto.order.OrderDTO;
import com.comandaqr.models.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
  Order orderDtoToOrder(OrderDTO orderDTO);
  OrderDTO orderToOrderDto(Order order);
}
