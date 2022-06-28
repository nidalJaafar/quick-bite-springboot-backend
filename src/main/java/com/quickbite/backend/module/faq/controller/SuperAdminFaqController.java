package com.quickbite.backend.module.faq.controller;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.faq.dto.FaqDto;
import com.quickbite.backend.module.faq.request.FaqRequest;
import com.quickbite.backend.module.faq.service.SuperAdminFaqService;
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

@RequiredArgsConstructor
@RestController
@Validated
@PreAuthorize(value = "hasRole('SUPER_ADMIN')")
@RequestMapping("api/v1/super-admin")
public class SuperAdminFaqController {

  private final SuperAdminFaqService service;

  @GetMapping("/faq")
  @ResponseStatus(HttpStatus.OK)
  public CollectionResponse<FaqDto> getFaqs() {
    return service.getAll();
  }

  @GetMapping("/faq/{id}")
  @ResponseStatus(HttpStatus.OK)
  public FaqDto getFaq(@PathVariable Integer id) {
    return service.get(id);
  }

  @PostMapping("/faq")
  @ResponseStatus(HttpStatus.CREATED)
  public FaqDto createFaq(@Valid @RequestBody FaqRequest request) {
    return service.post(request);
  }

  @PutMapping("/faq/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public FaqDto updateFaq(@Valid @RequestBody FaqRequest request,
      @PathVariable Integer id) {
    return service.put(request, id);
  }

  @DeleteMapping("/faq/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteFaq(@PathVariable Integer id) {
    service.delete(id);
  }
}
