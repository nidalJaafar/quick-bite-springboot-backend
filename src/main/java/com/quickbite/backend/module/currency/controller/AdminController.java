package com.quickbite.backend.module.currency.controller;

import com.quickbite.backend.common.entity.Currency;
import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.currency.request.CurrencyRequest;
import com.quickbite.backend.module.currency.response.CurrencyResponse;
import com.quickbite.backend.module.currency.service.CurrencyService;
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

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

  private final CurrencyService service;

  @GetMapping("/currency")
  public ResponseEntity<CollectionResponse<Currency>> getCurrencies() {
    return ResponseEntity.ok(service.getEntities());
  }

  @GetMapping("/currency/{id}")
  public ResponseEntity<CurrencyResponse> getCurrency(@PathVariable Integer id) {
    return ResponseEntity.ok(service.getEntity(id));
  }

  @PostMapping("/currency")
  public ResponseEntity<CurrencyResponse> addCurrency(@RequestBody CurrencyRequest request) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.createEntity(request));
  }

  @PutMapping("/currency/{id}")
  public ResponseEntity<CurrencyResponse> updateCurrency(@RequestBody CurrencyRequest request,
      @PathVariable Integer id) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.updateEntity(request, id));
  }

  @DeleteMapping("currency/{id}")
  public ResponseEntity<CurrencyResponse> deleteCurrency(@PathVariable Integer id) {
    return ResponseEntity.ok(service.deleteEntity(id));
  }


}
