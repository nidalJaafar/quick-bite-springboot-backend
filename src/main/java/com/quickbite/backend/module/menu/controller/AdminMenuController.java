package com.quickbite.backend.module.menu.controller;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.menu.dto.MenuDto;
import com.quickbite.backend.module.menu.request.MenuRequest;
import com.quickbite.backend.module.menu.service.AdminMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/api/v1/admin")
public class AdminMenuController {

  private final AdminMenuService service;

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

  @PostMapping("/menu")
  @ResponseStatus(HttpStatus.CREATED)
  public MenuDto createMenu(@RequestBody MenuRequest request) {
    return service.post(request);
  }

  @PutMapping("/menu/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public MenuDto updateMenu(@RequestBody MenuRequest request, @PathVariable Integer id) {
    return service.put(request, id);
  }

  @DeleteMapping("/menu/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteMenu(@PathVariable Integer id) {
    service.delete(id);
  }
}
