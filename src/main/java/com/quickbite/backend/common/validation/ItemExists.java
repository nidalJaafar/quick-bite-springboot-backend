package com.quickbite.backend.common.validation;

import com.quickbite.backend.common.validation.validator.ItemExistsValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = {ItemExistsValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ItemExists {

  String message() default "Item does not exist";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
