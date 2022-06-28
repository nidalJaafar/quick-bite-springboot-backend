package com.quickbite.backend.module.order.controller;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.order.dto.OrderDto;
import com.quickbite.backend.module.order.service.SuperAdminOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
@PreAuthorize(value = "hasRole('SUPER_ADMIN')")
@RequestMapping("/api/v1/super-admin")
public class SuperAdminOrderController {

  private final SuperAdminOrderService service;

  @GetMapping("/order/{id}")
  @ResponseStatus(HttpStatus.OK)
  public OrderDto getOrder(@PathVariable Integer id) {
    return service.get(id);
  }

  @GetMapping("/order")
  @ResponseStatus(HttpStatus.OK)
  public CollectionResponse<OrderDto> getOrders() {
    return service.getAll();
  }
}
