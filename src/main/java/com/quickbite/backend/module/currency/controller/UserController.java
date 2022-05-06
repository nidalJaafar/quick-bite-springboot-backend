package com.quickbite.backend.module.currency.controller;

import com.quickbite.backend.common.entity.Currency;
import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.currency.dto.CurrencyDto;
import com.quickbite.backend.module.currency.response.CurrencyResponse;
import com.quickbite.backend.module.currency.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

  private final CurrencyService service;

  @GetMapping("/currency")
  public ResponseEntity<CollectionResponse<CurrencyDto>> getCurrencies() {
    return ResponseEntity.ok(service.getEntities());
  }

  @GetMapping("/currency/{id}")
  public ResponseEntity<CurrencyResponse> getCurrency(@PathVariable Integer id) {
    return ResponseEntity.ok(service.getEntity(id));
  }
}
