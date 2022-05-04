package com.quickbite.backend.module.currency.response;

import com.quickbite.backend.module.currency.dto.CurrencyDto;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CurrencyResponse {
  private CurrencyDto currencyDto;
}
