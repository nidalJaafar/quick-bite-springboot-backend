package com.quickbite.backend.module.faq.controller;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.faq.dto.FaqDto;
import com.quickbite.backend.module.faq.response.FaqResponse;
import com.quickbite.backend.module.faq.service.FaqService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

  private final FaqService faqService;

  @GetMapping("/faq")
  public ResponseEntity<CollectionResponse<FaqDto>> getFaqs() {
    return ResponseEntity.ok(faqService.getEntities());
  }

  @GetMapping("/faq/{id}")
  public ResponseEntity<FaqResponse> getFaq(@PathVariable Integer id) {
    return ResponseEntity.ok(faqService.getEntity(id));
  }
}
