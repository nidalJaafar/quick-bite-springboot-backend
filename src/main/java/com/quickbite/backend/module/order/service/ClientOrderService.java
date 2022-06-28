package com.quickbite.backend.module.order.service;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.order.dto.OrderDto;
import com.quickbite.backend.module.order.request.OrderRequest;

public interface ClientOrderService {

  CollectionResponse<OrderDto> getAll();

  OrderDto get(Integer id);

  OrderDto post(OrderRequest orderRequest);

  OrderDto put(OrderRequest orderRequest, Integer id);

  void delete(Integer id);

  CollectionResponse<OrderDto> getPendingOrders();

  CollectionResponse<OrderDto> getDeliveredOrders();
}
