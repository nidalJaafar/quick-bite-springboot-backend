package com.quickbite.backend.module.visitFeedback.controller;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.visitFeedback.dto.VisitFeedbackDto;
import com.quickbite.backend.module.visitFeedback.request.VisitFeedbackRequest;
import com.quickbite.backend.module.visitFeedback.response.VisitFeedbackResponse;
import com.quickbite.backend.module.visitFeedback.service.VisitFeedbackService;
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

  private final VisitFeedbackService service;

  @GetMapping("/visitFeedback/{id}")
  public ResponseEntity<VisitFeedbackResponse> getVisitFeedback(@PathVariable Integer id) {
    return ResponseEntity.ok(service.getEntity(id));
  }

  @GetMapping("/visitFeedback")
  public ResponseEntity<CollectionResponse<VisitFeedbackDto>> getVisitFeedbacks() {
    return ResponseEntity.ok(service.getEntities());
  }

  @PostMapping("/visitFeedback")
  public ResponseEntity<VisitFeedbackResponse> createVistiFeedback(@RequestBody
      VisitFeedbackRequest request) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.createEntity(request));
  }

  @PutMapping("/visitFeedback/{id}")
  public ResponseEntity<VisitFeedbackResponse> updateVisitFeedback(
      @RequestBody VisitFeedbackRequest request, @PathVariable Integer id) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.updateEntity(request, id));
  }

  @DeleteMapping("/visitFeedback/{id}")
  public ResponseEntity<VisitFeedbackResponse> deleteVisitFeedback(@PathVariable Integer id) {
    return ResponseEntity.ok(service.deleteEntity(id));
  }
}
