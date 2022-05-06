package com.quickbite.backend.module.visitFeedback.controller;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.visitFeedback.dto.VisitFeedbackDto;
import com.quickbite.backend.module.visitFeedback.response.VisitFeedbackResponse;
import com.quickbite.backend.module.visitFeedback.service.VisitFeedbackService;
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

  private final VisitFeedbackService service;

  @GetMapping("/visitFeedback/{id}")
  public ResponseEntity<VisitFeedbackResponse> getVisitFeedback(@PathVariable Integer id) {
    return ResponseEntity.ok(service.getEntity(id));
  }

  @GetMapping("/visitFeedback")
  public ResponseEntity<CollectionResponse<VisitFeedbackDto>> getVisitFeedbacks() {
    return ResponseEntity.ok(service.getEntities());
  }
}
