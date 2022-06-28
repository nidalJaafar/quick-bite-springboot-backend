package com.quickbite.backend.module.currency.validation.validator;

import com.quickbite.backend.common.repository.CurrencyRepository;
import com.quickbite.backend.module.currency.validation.UniqueCurrencySymbol;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueCurrencySymbolValidator implements ConstraintValidator<UniqueCurrencySymbol, String> {

  private final CurrencyRepository currencyRepository;

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return !currencyRepository.existsBySymbol(value);
  }
}
