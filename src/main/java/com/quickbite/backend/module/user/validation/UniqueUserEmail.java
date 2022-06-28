package com.quickbite.backend.module.user.validation;

import com.quickbite.backend.module.user.validation.validator.UniqueUserEmailValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = {UniqueUserEmailValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueUserEmail {

  String message() default "Email already exists";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
