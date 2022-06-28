package com.quickbite.backend.module.visitFeedback.controller;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.visitFeedback.dto.VisitFeedbackDto;
import com.quickbite.backend.module.visitFeedback.service.SuperAdminVisitFeedbackService;
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
@PreAuthorize(value = "hasRole('SUPER_ADMIN')")
@RequestMapping("/api/v1/super-admin")
public class SuperAdminVisitFeedbackController {

  private final SuperAdminVisitFeedbackService service;

  @GetMapping("/visit-feedback/{id}")
  @ResponseStatus(HttpStatus.OK)
  public VisitFeedbackDto getVisitFeedback(@PathVariable Integer id) {
    return service.get(id);
  }

  @GetMapping("/visit-feedback")
  @ResponseStatus(HttpStatus.OK)
  public CollectionResponse<VisitFeedbackDto> getVisitFeedbacks() {
    return service.getAll();
  }
}
