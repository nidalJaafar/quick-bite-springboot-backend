package com.quickbite.backend.module.order.service;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.order.dto.OrderDto;

public interface AdminOrderService {

  CollectionResponse<OrderDto> getAll();

  OrderDto get(Integer id);

}
