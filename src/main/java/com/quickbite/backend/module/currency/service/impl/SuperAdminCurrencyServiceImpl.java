package com.quickbite.backend.module.currency.service.impl;

import com.quickbite.backend.common.exception.ExceptionSupplier;
import com.quickbite.backend.common.repository.CurrencyRepository;
import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.common.util.CollectionResponseFactory;
import com.quickbite.backend.module.currency.dto.CurrencyDto;
import com.quickbite.backend.module.currency.mapper.CurrencyMapper;
import com.quickbite.backend.module.currency.request.CurrencyRequest;
import com.quickbite.backend.module.currency.service.SuperAdminCurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SuperAdminCurrencyServiceImpl implements SuperAdminCurrencyService {

  private final CurrencyMapper currencyMapper;
  private final CurrencyRepository currencyRepository;

  @Override
  public CollectionResponse<CurrencyDto> getAll() {
    return CollectionResponseFactory.buildResponse(
        currencyMapper.currencyListToCurrencyDtoList(currencyRepository.findAll()));
  }

  @Override
  public CurrencyDto get(Integer id) {
    return currencyMapper.currencyToCurrencyDto(currencyRepository.findById(id).orElseThrow(
        ExceptionSupplier.currencyExceptionSupplier()));
  }

  @Override
  public CurrencyDto put(CurrencyRequest currencyRequest, Integer id) {
    return null;
  }

  @Override
  public CurrencyDto post(CurrencyRequest currencyRequest) {
    return currencyMapper.currencyToCurrencyDto(
        currencyRepository.save(currencyMapper.currencyRequestToCurrency(currencyRequest))
    );
  }

  @Override
  public void delete(Integer id) {
    if (!currencyRepository.existsById(id)) {
      throw ExceptionSupplier.currencyExceptionSupplier().get();
    }
    currencyRepository.deleteById(id);
  }
}
