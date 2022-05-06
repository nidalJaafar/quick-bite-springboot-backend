package com.quickbite.backend.module.faq.response;

import com.quickbite.backend.module.faq.dto.FaqDto;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class FaqResponse {
  private FaqDto faq;
}
