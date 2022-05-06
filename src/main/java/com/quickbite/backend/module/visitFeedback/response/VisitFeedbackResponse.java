package com.quickbite.backend.module.visitFeedback.response;

import com.quickbite.backend.module.visitFeedback.dto.VisitFeedbackDto;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class VisitFeedbackResponse {
  private VisitFeedbackDto visitFeedback;
}
