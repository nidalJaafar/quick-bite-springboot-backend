package com.quickbite.backend.module.order.service.impl;

import com.quickbite.backend.common.entity.Order;
import com.quickbite.backend.common.exception.ExceptionSupplier;
import com.quickbite.backend.common.repository.OrderRepository;
import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.common.type.OrderStatus;
import com.quickbite.backend.common.util.AuthenticatedUser;
import com.quickbite.backend.common.util.CollectionResponseFactory;
import com.quickbite.backend.module.order.dto.OrderDto;
import com.quickbite.backend.module.order.mapper.OrderMapper;
import com.quickbite.backend.module.order.request.OrderRequest;
import com.quickbite.backend.module.order.service.ClientOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClientOrderServiceImpl implements ClientOrderService {

  private final OrderMapper orderMapper;
  private final OrderRepository orderRepository;
  private final AuthenticatedUser authenticatedUser;

  @Override
  public CollectionResponse<OrderDto> getAll() {
    return CollectionResponseFactory.buildResponse(orderMapper.orderListToOrderDtoList(
        orderRepository.findOrdersByUser(authenticatedUser.getAuthenticatedUser())));
  }

  @Override
  public OrderDto get(Integer id) {
    Order order = orderRepository.findById(id)
        .orElseThrow(ExceptionSupplier.orderExceptionSupplier());
    if (!order.getUser().equals(authenticatedUser.getAuthenticatedUser())) {
      throw ExceptionSupplier.accessDeniedExceptionSupplier()
          .get();
    }
    return orderMapper.orderToOrderDto(order);
  }

  @Override
  public OrderDto post(OrderRequest orderRequest) {
    return orderMapper.orderToOrderDto(
        orderRepository.save(orderMapper.orderRequestToOrder(orderRequest)));
  }

  @Override
  public OrderDto put(OrderRequest orderRequest, Integer id) {
    return null;
  }

  @Override
  public void delete(Integer id) {
    if (!orderRepository.existsById(id)) {
      throw ExceptionSupplier.orderExceptionSupplier().get();
    }
    orderRepository.deleteById(id);
  }

  @Override
  public CollectionResponse<OrderDto> getPendingOrders() {
    return CollectionResponseFactory.buildResponse(orderMapper.orderListToOrderDtoList(
        orderRepository.findOrdersByUserAndStatus(authenticatedUser.getAuthenticatedUser(),
            OrderStatus.PENDING.getStatus())));
  }

  @Override
  public CollectionResponse<OrderDto> getDeliveredOrders() {
    return CollectionResponseFactory.buildResponse(orderMapper.orderListToOrderDtoList(
        orderRepository.findOrdersByUserAndStatus(authenticatedUser.getAuthenticatedUser(),
            OrderStatus.DELIVERED.getStatus())));
  }
}
