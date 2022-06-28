package com.quickbite.backend.module.item.validation.validator;

import com.quickbite.backend.common.repository.MenuRepository;
import com.quickbite.backend.module.item.validation.MenuExists;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MenuExistsValidator implements ConstraintValidator<MenuExists, Integer> {

  private final MenuRepository menuRepository;

  @Override
  public boolean isValid(Integer value, ConstraintValidatorContext context) {
    return menuRepository.existsById(value);
  }
}
