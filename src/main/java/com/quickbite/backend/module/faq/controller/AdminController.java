package com.quickbite.backend.module.faq.controller;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.faq.dto.FaqDto;
import com.quickbite.backend.module.faq.request.FaqRequest;
import com.quickbite.backend.module.faq.response.FaqResponse;
import com.quickbite.backend.module.faq.service.FaqService;
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
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

  private final FaqService faqService;

  @GetMapping("/faq")
  public ResponseEntity<CollectionResponse<FaqDto>> getFaqs() {
    return ResponseEntity.ok(faqService.getEntities());
  }

  @GetMapping("/faq/{id}")
  public ResponseEntity<FaqResponse> getFaq(@PathVariable Integer id) {
    return ResponseEntity.ok(faqService.getEntity(id));
  }

  @PostMapping("/faq")
  public ResponseEntity<FaqResponse> createFaq(@RequestBody FaqRequest request) {
    return ResponseEntity.status(HttpStatus.CREATED).body(faqService.createEntity(request));
  }

  @PutMapping("/faq/{id}")
  public ResponseEntity<FaqResponse> updateFaq(@RequestBody FaqRequest request, @PathVariable Integer id) {
    return ResponseEntity.status(HttpStatus.CREATED).body(faqService.updateEntity(request, id));
  }

  @DeleteMapping("/faq/{id}")
  public ResponseEntity<FaqResponse> deleteFaq(@PathVariable Integer id) {
    return ResponseEntity.ok(faqService.deleteEntity(id));
  }

}
