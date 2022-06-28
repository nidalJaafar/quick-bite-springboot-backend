package com.quickbite.backend.module.item.controller;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.item.dto.ItemDto;
import com.quickbite.backend.module.item.request.ItemRequest;
import com.quickbite.backend.module.item.service.AdminItemService;
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
@PreAuthorize(value = "hasRole('ADMIN')")
@RequestMapping("api/v1/admin")
public class AdminItemController {

  private final AdminItemService service;

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

  @PostMapping("/item")
  @ResponseStatus(HttpStatus.CREATED)
  public ItemDto createItem(@Valid @RequestBody ItemRequest request) {
    return service.post(request);
  }

  @PutMapping("/item/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public ItemDto updateItem(@Valid @RequestBody ItemRequest request,
      @PathVariable Integer id) {
    return service.put(request, id);
  }

  @DeleteMapping("/item/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteItem(@PathVariable Integer id) {
    service.delete(id);
  }

}
