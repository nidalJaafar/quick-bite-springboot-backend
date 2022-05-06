package com.quickbite.backend.module.faq.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Getter
@Accessors(chain = true)
public class FaqDto implements Serializable {

  private final Integer id;
  private final String question;
  private final String answer;
}
