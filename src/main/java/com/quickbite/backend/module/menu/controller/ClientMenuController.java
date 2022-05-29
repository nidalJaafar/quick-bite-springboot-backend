package com.quickbite.backend.module.menu.controller;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.menu.dto.MenuDto;
import com.quickbite.backend.module.menu.service.ClientMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/client")
public class ClientMenuController {

  private final ClientMenuService service;

  @GetMapping("/menu")
  @ResponseStatus(HttpStatus.OK)
  public CollectionResponse<MenuDto> getMenus() {
    return service.getAll();
  }

  @GetMapping("/menu/{id}")
  @ResponseStatus(HttpStatus.OK)
  public MenuDto getMenu(@PathVariable Integer id) {
    return service.get(id);
  }
}
