package com.quickbite.backend.module.order.validation.validator;

import com.quickbite.backend.common.type.OrderStatus;
import com.quickbite.backend.module.order.validation.InOrderStatus;
import java.util.Arrays;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class InOrderStatusValidator implements ConstraintValidator<InOrderStatus, OrderStatus> {

  private OrderStatus[] anyOf;

  @Override
  public void initialize(InOrderStatus constraintAnnotation) {
    anyOf = constraintAnnotation.anyOf();
  }

  @Override
  public boolean isValid(OrderStatus value, ConstraintValidatorContext context) {
    return Arrays.asList(anyOf).contains(value);
  }
}
