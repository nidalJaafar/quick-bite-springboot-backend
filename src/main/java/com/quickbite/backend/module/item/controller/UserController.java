package com.quickbite.backend.module.item.controller;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.item.dto.ItemDto;
import com.quickbite.backend.module.item.response.ItemResponse;
import com.quickbite.backend.module.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
  private final ItemService service;

  @GetMapping("/item")
  public ResponseEntity<CollectionResponse<ItemDto>> getItems() {
    return ResponseEntity.ok(service.getEntities());
  }

  @GetMapping("/item/{id}")
  public ResponseEntity<ItemResponse> getItem(@PathVariable Integer id) {
    return ResponseEntity.ok(service.getEntity(id));
  }

}
