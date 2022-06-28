package com.quickbite.backend.module.item.validation.validator;

import com.quickbite.backend.common.type.ItemType;
import com.quickbite.backend.module.item.validation.InItemType;
import java.util.Arrays;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class InItemTypeValidator implements ConstraintValidator<InItemType, ItemType> {

  private ItemType[] anyOf;

  @Override
  public void initialize(InItemType constraintAnnotation) {
    anyOf = constraintAnnotation.anyOf();
  }

  @Override
  public boolean isValid(ItemType value, ConstraintValidatorContext context) {
    return Arrays.asList(anyOf).contains(value);
  }
}
