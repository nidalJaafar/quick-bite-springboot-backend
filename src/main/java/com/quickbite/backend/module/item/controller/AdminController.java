package com.quickbite.backend.module.item.controller;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.item.dto.ItemDto;
import com.quickbite.backend.module.item.request.ItemRequest;
import com.quickbite.backend.module.item.response.ItemResponse;
import com.quickbite.backend.module.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminController {

  private final ItemService service;

  @GetMapping("/item")
  public ResponseEntity<CollectionResponse<ItemDto>> getItems() {
    return ResponseEntity.ok(service.getEntities());
  }

  @GetMapping("/item/{id}")
  public ResponseEntity<ItemResponse> getItem(@PathVariable Integer id) {
    return ResponseEntity.ok(service.getEntity(id));
  }

  @PostMapping("/item")
  public ResponseEntity<ItemResponse> createItem(@RequestBody ItemRequest request) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.createEntity(request));
  }

  @PutMapping("/item/{id}")
  public ResponseEntity<ItemResponse> updateItem(@RequestBody ItemRequest request, @PathVariable Integer id) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.updateEntity(request, id));
  }

  @DeleteMapping("/item/{id}")
  public ResponseEntity<ItemResponse> deleteItem(@PathVariable Integer id) {
    return ResponseEntity.ok(service.deleteEntity(id));
  }
}
