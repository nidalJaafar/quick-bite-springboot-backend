package com.quickbite.backend.module.currency.service;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.currency.dto.CurrencyDto;
import com.quickbite.backend.module.currency.request.CurrencyRequest;
import java.util.List;

public interface AdminCurrencyService {

  CollectionResponse<CurrencyDto> getAll();

  CurrencyDto get(Integer id);

  CurrencyDto put(CurrencyRequest currencyRequest, Integer id);

  CurrencyDto post(CurrencyRequest currencyRequest);

  void delete(Integer id);
}
