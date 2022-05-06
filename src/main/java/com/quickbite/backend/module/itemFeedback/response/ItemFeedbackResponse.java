package com.quickbite.backend.module.itemFeedback.response;

import com.quickbite.backend.module.itemFeedback.dto.ItemFeedbackDto;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ItemFeedbackResponse {
  ItemFeedbackDto itemFeedback;
}
