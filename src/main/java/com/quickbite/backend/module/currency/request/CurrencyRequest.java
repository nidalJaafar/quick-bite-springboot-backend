package com.quickbite.backend.module.currency.request;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CurrencyRequest {
  private String name;
  private String symbol;
  private Double rate;
}
