package com.quickbite.backend.module.faq.request;

import com.quickbite.backend.module.faq.validation.UniqueFaqAnswer;
import com.quickbite.backend.module.faq.validation.UniqueFaqQuestion;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class FaqRequest {

  @NotBlank(message = "Question should not be empty")
  @UniqueFaqQuestion
  private String question;
  @NotBlank(message = "Answer should not be empty")
  @UniqueFaqAnswer
  private String answer;
}
