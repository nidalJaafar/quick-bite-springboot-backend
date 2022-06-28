package com.quickbite.backend.module.itemFeedback.controller;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.itemFeedback.dto.ItemFeedbackDto;
import com.quickbite.backend.module.itemFeedback.request.ItemFeedbackRequest;
import com.quickbite.backend.module.itemFeedback.service.ClientItemFeedbackService;
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
@PreAuthorize(value = "hasRole('CLIENT')")
@RequestMapping("api/v1/client")
public class ClientItemFeedbackController {

  private final ClientItemFeedbackService service;

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

  @PostMapping("/item-feedback")
  @ResponseStatus(HttpStatus.CREATED)
  public ItemFeedbackDto createItemFeedback(@Valid @RequestBody ItemFeedbackRequest request) {
    return service.post(request);
  }

  @PutMapping("/item-feedback/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public ItemFeedbackDto updateItemFeedback(@Valid @RequestBody ItemFeedbackRequest request,
      @PathVariable Integer id) {
    return service.put(request, id);
  }

  @DeleteMapping("/item-feedback/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteItemFeedback(@PathVariable Integer id) {
    service.delete(id);
  }

}
