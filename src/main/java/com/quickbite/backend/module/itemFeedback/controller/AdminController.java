package com.quickbite.backend.module.itemFeedback.controller;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.itemFeedback.dto.ItemFeedbackDto;
import com.quickbite.backend.module.itemFeedback.response.ItemFeedbackResponse;
import com.quickbite.backend.module.itemFeedback.service.ItemFeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminController {

  private final ItemFeedbackService service;

  @GetMapping("/itemFeedback/{id}")
  public ResponseEntity<ItemFeedbackResponse> getVisitFeedback(@PathVariable Integer id) {
    return ResponseEntity.ok(service.getEntity(id));
  }

  @GetMapping("/itemFeedback")
  public ResponseEntity<CollectionResponse<ItemFeedbackDto>> getVisitFeedbacks() {
    return ResponseEntity.ok(service.getEntities());
  }
}