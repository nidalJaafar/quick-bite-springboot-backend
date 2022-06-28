package com.quickbite.backend.module.order.controller;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.order.dto.OrderDto;
import com.quickbite.backend.module.order.request.OrderRequest;
import com.quickbite.backend.module.order.service.ClientOrderService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
@PreAuthorize(value = "hasRole('CLIENT')")
@RequestMapping("/api/v1/client")
public class ClientOrderController {

  private final ClientOrderService service;

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

  @GetMapping("/order-pending")
  @ResponseStatus(HttpStatus.OK)
  public CollectionResponse<OrderDto> getPendingOrders() {
    return service.getPendingOrders();
  }

  @GetMapping("/order-delivered")
  @ResponseStatus(HttpStatus.OK)
  public CollectionResponse<OrderDto> getDeliveredOrders() {
    return service.getDeliveredOrders();
  }

  @PostMapping("/order")
  @ResponseStatus(HttpStatus.CREATED)
  public OrderDto createOrder(@Valid @RequestBody OrderRequest request) {
    return service.post(request);
  }

  @PutMapping("/order/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public OrderDto updateOrder(@Valid @RequestBody OrderRequest request, @PathVariable Integer id) {
    return service.put(request, id);
  }

  @DeleteMapping("/order/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteOrder(@PathVariable Integer id) {
    service.delete(id);
  }
}
