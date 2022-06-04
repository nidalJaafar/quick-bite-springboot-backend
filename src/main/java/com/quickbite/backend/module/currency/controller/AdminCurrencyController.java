package com.quickbite.backend.module.currency.controller;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.currency.dto.CurrencyDto;
import com.quickbite.backend.module.currency.request.CurrencyRequest;
import com.quickbite.backend.module.currency.service.AdminCurrencyService;
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
@PreAuthorize(value = "hasRole('ADMIN')")
@RequestMapping("/api/v1/admin")
public class AdminCurrencyController {

  private final AdminCurrencyService service;

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

  @PostMapping("/currency")
  @ResponseStatus(HttpStatus.CREATED)
  public CurrencyDto addCurrency(@Valid @RequestBody CurrencyRequest request) {
    return service.post(request);
  }

  @PutMapping("/currency/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public CurrencyDto updateCurrency(@Valid @RequestBody CurrencyRequest request,
      @PathVariable Integer id) {
    return service.put(request, id);
  }

  @DeleteMapping("currency/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteCurrency(@PathVariable Integer id) {
    service.delete(id);
  }


}
