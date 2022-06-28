package com.quickbite.backend.module.user.validation.validator;

import com.quickbite.backend.common.repository.UserRepository;
import com.quickbite.backend.module.user.validation.UniqueUserEmail;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueUserEmailValidator implements ConstraintValidator<UniqueUserEmail, String> {

  private final UserRepository userRepository;

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return !userRepository.existsByEmail(value);
  }
}
