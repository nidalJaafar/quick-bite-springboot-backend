package com.quickbite.backend.module.currency.controller;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.currency.dto.CurrencyDto;
import com.quickbite.backend.module.currency.service.ClientCurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Validated
@PreAuthorize(value = "hasRole('CLIENT')")
@RequestMapping("/api/v1/client")
public class ClientCurrencyController {

  private final ClientCurrencyService service;

  @GetMapping("/currency")
  @ResponseStatus(HttpStatus.OK)
  public CollectionResponse<CurrencyDto> getCurrencies() {
    return service.getAll();
  }

  @GetMapping("/currency/{id}")
  @ResponseStatus(HttpStatus.OK)
  public CurrencyDto getCurrency(@PathVariable Integer id) {
    return service.get(id);
  }
}
