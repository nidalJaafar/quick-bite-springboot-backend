package com.quickbite.backend.module.itemFeedback.controller;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.itemFeedback.dto.ItemFeedbackDto;
import com.quickbite.backend.module.itemFeedback.request.ItemFeedbackRequest;
import com.quickbite.backend.module.itemFeedback.response.ItemFeedbackResponse;
import com.quickbite.backend.module.itemFeedback.service.ItemFeedbackService;
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
@RequestMapping("/api/v1/user")
public class UserController {

  private final ItemFeedbackService service;

  @GetMapping("/itemFeedback/{id}")
  public ResponseEntity<ItemFeedbackResponse> getVisitFeedback(@PathVariable Integer id) {
    return ResponseEntity.ok(service.getEntity(id));
  }

  @GetMapping("/itemFeedback")
  public ResponseEntity<CollectionResponse<ItemFeedbackDto>> getVisitFeedbacks() {
    return ResponseEntity.ok(service.getEntities());
  }

  @PostMapping("/itemFeedback")
  public ResponseEntity<ItemFeedbackResponse> createVistiFeedback(@RequestBody
      ItemFeedbackRequest request) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.createEntity(request));
  }

  @PutMapping("/itemFeedback/{id}")
  public ResponseEntity<ItemFeedbackResponse> updateVisitFeedback(
      @RequestBody ItemFeedbackRequest request, @PathVariable Integer id) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.updateEntity(request, id));
  }

  @DeleteMapping("/itemFeedback/{id}")
  public ResponseEntity<ItemFeedbackResponse> deleteVisitFeedback(@PathVariable Integer id) {
    return ResponseEntity.ok(service.deleteEntity(id));
  }
}
