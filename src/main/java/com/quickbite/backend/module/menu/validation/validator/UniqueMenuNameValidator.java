package com.quickbite.backend.module.menu.validation.validator;

import com.quickbite.backend.common.repository.MenuRepository;
import com.quickbite.backend.module.menu.validation.UniqueMenuName;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueMenuNameValidator implements ConstraintValidator<UniqueMenuName, String> {

  private final MenuRepository menuRepository;

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return !menuRepository.existsByName(value);
  }
}
