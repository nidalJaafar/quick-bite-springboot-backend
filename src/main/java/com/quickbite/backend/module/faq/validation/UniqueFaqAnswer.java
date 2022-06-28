package com.quickbite.backend.module.faq.validation;

import com.quickbite.backend.module.faq.validation.validator.UniqueFaqAnswerValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = {UniqueFaqAnswerValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueFaqAnswer {
  String message() default "Answer already exists";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
