package com.quickbite.backend.module.menu.validation;

import com.quickbite.backend.module.menu.validation.validator.UniqueMenuNameValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = {UniqueMenuNameValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueMenuName {

  String message() default "Menu does not exist";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
