package com.quickbite.backend.module.visitFeedback.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class VisitFeedbackRequest {

  @Min(value = 1, message = "Rating should be between 1 and 5")
  @Max(value = 5, message = "Rating should be between 1 and 5")
  private Integer rating;
  @NotBlank(message = "Details should not be empty")
  private String details;
}
