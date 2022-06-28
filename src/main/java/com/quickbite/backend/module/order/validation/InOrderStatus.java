package com.quickbite.backend.module.order.validation;

import com.quickbite.backend.common.type.OrderStatus;
import com.quickbite.backend.module.order.validation.validator.InOrderStatusValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = {InOrderStatusValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface InOrderStatus {

  String message() default "Should be any of {anyOf}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  OrderStatus[] anyOf();
}