package com.quickbite.backend.module.currency.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Data
public class CurrencyDto implements Serializable {

  private final Integer id;
  private final String name;
  private final String symbol;
  private final Double rate;
}
