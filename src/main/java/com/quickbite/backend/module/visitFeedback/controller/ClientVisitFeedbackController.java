package com.quickbite.backend.module.visitFeedback.controller;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.visitFeedback.dto.VisitFeedbackDto;
import com.quickbite.backend.module.visitFeedback.request.VisitFeedbackRequest;
import com.quickbite.backend.module.visitFeedback.service.ClientVisitFeedbackService;
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
@RequestMapping("/api/v1/user")
public class ClientVisitFeedbackController {

  private final ClientVisitFeedbackService service;

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

  @PostMapping("/visit-feedback")
  @ResponseStatus(HttpStatus.CREATED)
  public VisitFeedbackDto createVisitFeedback(@RequestBody
      VisitFeedbackRequest request) {
    return service.post(request);
  }

  @PutMapping("/visit-feedback/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public VisitFeedbackDto updateVisitFeedback(
      @RequestBody VisitFeedbackRequest request, @PathVariable Integer id) {
    return service.put(request, id);
  }

  @DeleteMapping("/visit-feedback/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteVisitFeedback(@PathVariable Integer id) {
    service.delete(id);
  }
}
