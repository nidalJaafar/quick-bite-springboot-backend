package com.quickbite.backend.module.faq.validation.validator;

import com.quickbite.backend.common.repository.FaqRepository;
import com.quickbite.backend.module.faq.validation.UniqueFaqAnswer;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueFaqAnswerValidator implements
    ConstraintValidator<UniqueFaqAnswer, String> {

  private final FaqRepository faqRepository;

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return !faqRepository.existsByAnswer(value);
  }
}