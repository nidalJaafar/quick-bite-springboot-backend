package com.quickbite.backend.module.order.service.impl;

import com.quickbite.backend.common.exception.ExceptionSupplier;
import com.quickbite.backend.common.repository.OrderRepository;
import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.common.util.CollectionResponseFactory;
import com.quickbite.backend.module.order.dto.OrderDto;
import com.quickbite.backend.module.order.mapper.OrderMapper;
import com.quickbite.backend.module.order.service.SuperAdminOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SuperAdminOrderServiceImpl implements SuperAdminOrderService {

  private final OrderMapper orderMapper;
  private final OrderRepository orderRepository;

  @Override
  public CollectionResponse<OrderDto> getAll() {
    return CollectionResponseFactory.buildResponse(
        orderMapper.orderListToOrderDtoList(orderRepository.findAll()));
  }

  @Override
  public OrderDto get(Integer id) {
    return orderMapper.orderToOrderDto(
        orderRepository.findById(id).orElseThrow(ExceptionSupplier.orderExceptionSupplier()));
  }
}
