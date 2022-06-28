package com.quickbite.backend.common.validation.validator;

import com.quickbite.backend.common.repository.ItemRepository;
import com.quickbite.backend.common.validation.ItemExists;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ItemExistsValidator implements ConstraintValidator<ItemExists, Integer> {

  private final ItemRepository itemRepository;

  @Override
  public boolean isValid(Integer value, ConstraintValidatorContext context) {
    return itemRepository.existsById(value);
  }
}
