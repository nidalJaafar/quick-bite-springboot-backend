package com.quickbite.backend.module.currency.service;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.currency.dto.CurrencyDto;

public interface ClientCurrencyService {

  CollectionResponse<CurrencyDto> getAll();

  CurrencyDto get(Integer id);
}
