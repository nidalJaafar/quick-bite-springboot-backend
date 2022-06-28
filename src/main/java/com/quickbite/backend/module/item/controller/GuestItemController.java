package com.quickbite.backend.module.item.controller;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.item.dto.ItemDto;
import com.quickbite.backend.module.item.service.GuestItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping("api/v1/guest")
public class GuestItemController {

  private final GuestItemService service;

  @GetMapping("/item")
  @ResponseStatus(HttpStatus.OK)
  public CollectionResponse<ItemDto> getItems() {
    return service.getAll();
  }

  @GetMapping("/item/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ItemDto getItem(@PathVariable Integer id) {
    return service.get(id);
  }

}