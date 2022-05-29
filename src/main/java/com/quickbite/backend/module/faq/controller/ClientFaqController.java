package com.quickbite.backend.module.faq.controller;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.faq.dto.FaqDto;
import com.quickbite.backend.module.faq.service.ClientFaqService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/client")
@RequiredArgsConstructor
public class ClientFaqController {

  private final ClientFaqService service;

  @GetMapping("/faq/{id}")
  @ResponseStatus(HttpStatus.OK)
  public FaqDto getFaq(@PathVariable Integer id) {
    return service.get(id);
  }

  @GetMapping("/faq")
  @ResponseStatus(HttpStatus.OK)
  public CollectionResponse<FaqDto> getFaqs() {
    return service.getAll();
  }
}
