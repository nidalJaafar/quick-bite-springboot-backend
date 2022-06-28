package com.quickbite.backend.module.item.validation;


import com.quickbite.backend.common.type.ItemType;
import com.quickbite.backend.module.item.validation.validator.InItemTypeValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = {InItemTypeValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface InItemType {

  String message() default "Should be any of {anyOf}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  ItemType[] anyOf();
}
