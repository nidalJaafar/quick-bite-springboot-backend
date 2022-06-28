package com.quickbite.backend.module.faq.validation;

import com.quickbite.backend.module.faq.validation.validator.UniqueFaqQuestionValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = {UniqueFaqQuestionValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueFaqQuestion {

  String message() default "Answer already exists";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}