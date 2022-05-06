package com.quickbite.backend.module.menu.controller;

import com.quickbite.backend.common.entity.Menu;
import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.menu.dto.MenuDto;
import com.quickbite.backend.module.menu.request.MenuRequest;
import com.quickbite.backend.module.menu.response.MenuResponse;
import com.quickbite.backend.module.menu.service.MenuService;
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

  private final MenuService service;

  @GetMapping("/menu")
  public ResponseEntity<CollectionResponse<MenuDto>> getMenus() {
    return ResponseEntity.ok(service.getEntities());
  }

  @GetMapping("/menu/{id}")
  public ResponseEntity<MenuResponse> getMenu(@PathVariable Integer id) {
    return ResponseEntity.ok(service.getEntity(id));
  }

  @PostMapping("/menu")
  public ResponseEntity<MenuResponse> createMenu(@RequestBody MenuRequest request) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.createEntity(request));
  }

  @PutMapping("/menu/{id}")
  public ResponseEntity<MenuResponse> updateMenu(@RequestBody MenuRequest request, @PathVariable Integer id) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.updateEntity(request, id));
  }

  @DeleteMapping("/menu/{id}")
  public ResponseEntity<MenuResponse> deleteMenu(@PathVariable Integer id) {
    return ResponseEntity.ok(service.deleteEntity(id));
  }
}
