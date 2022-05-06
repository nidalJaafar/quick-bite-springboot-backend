package com.quickbite.backend.module.menu.controller;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.menu.dto.MenuDto;
import com.quickbite.backend.module.menu.response.MenuResponse;
import com.quickbite.backend.module.menu.service.MenuService;
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

  private final MenuService service;

  @GetMapping("/menu")
  public ResponseEntity<CollectionResponse<MenuDto>> getMenus() {
    return ResponseEntity.ok(service.getEntities());
  }

  @GetMapping("/menu/{id}")
  public ResponseEntity<MenuResponse> getMenu(@PathVariable Integer id) {
    return ResponseEntity.ok(service.getEntity(id));
  }
}
