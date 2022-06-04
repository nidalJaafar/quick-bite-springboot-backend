package com.quickbite.backend.module.currency.request;

import com.quickbite.backend.module.currency.validation.UniqueCurrencyName;
import com.quickbite.backend.module.currency.validation.UniqueCurrencySymbol;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CurrencyRequest {

  @NotBlank(message = "Name should not be empty")
  @UniqueCurrencyName
  private String name;
  @NotBlank(message = "Symbol should not be empty")
  @UniqueCurrencySymbol
  private String symbol;
  @Min(value = 1, message = "Rate should be greater than 1")
  private Double rate;
}
