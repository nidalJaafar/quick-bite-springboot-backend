package com.quickbite.backend.module.visitFeedback.request;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class VisitFeedbackRequest {
  private Integer rating;
  private String details;
}
