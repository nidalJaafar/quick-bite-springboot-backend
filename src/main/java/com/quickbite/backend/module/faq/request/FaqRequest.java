package com.quickbite.backend.module.faq.request;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class FaqRequest {
  private String question;
  private String answer;
}
