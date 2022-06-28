package com.quickbite.backend.module.menu.controller;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.menu.dto.MenuDto;
import com.quickbite.backend.module.menu.service.GuestMenuService;
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
@RequestMapping("/api/v1/guest")
public class GuestMenuController {

  private final GuestMenuService service;

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