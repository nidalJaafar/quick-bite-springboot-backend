package com.quickbite.backend.module.itemFeedback.controller;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.itemFeedback.dto.ItemFeedbackDto;
import com.quickbite.backend.module.itemFeedback.service.AdminItemFeedbackService;
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
@PreAuthorize(value = "hasRole('ADMIN')")
@RequestMapping("api/v1/admin")
public class AdminItemFeedbackController {

  private final AdminItemFeedbackService service;

  @GetMapping("/item-feedback")
  @ResponseStatus(HttpStatus.OK)
  public CollectionResponse<ItemFeedbackDto> getItemFeedbacks() {
    return service.getAll();
  }

  @GetMapping("/item-feedback/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ItemFeedbackDto getItemFeedback(@PathVariable Integer id) {
    return service.get(id);
  }

}
