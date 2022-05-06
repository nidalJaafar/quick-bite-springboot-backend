package com.quickbite.backend.module.itemFeedback.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ItemFeedbackRequest {
  private Integer rating;
  private String details;
  private Integer itemId;
}
