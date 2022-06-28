package com.quickbite.backend.module.order.mapper;

import com.quickbite.backend.common.entity.Order;
import com.quickbite.backend.module.order.dto.OrderDto;
import com.quickbite.backend.module.order.request.OrderRequest;
import java.util.List;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrderMapper {

  Order orderDtoToOrder(OrderDto orderDto);

  OrderDto orderToOrderDto(Order order);

  List<OrderDto> orderListToOrderDtoList(List<Order> orderList);

  Order orderRequestToOrder(OrderRequest orderRequest);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateOrderFromOrderDto(
      OrderDto orderDto, @MappingTarget Order order);
}
