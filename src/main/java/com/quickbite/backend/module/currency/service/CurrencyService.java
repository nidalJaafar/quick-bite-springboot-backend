package com.quickbite.backend.module.currency.service;

import com.quickbite.backend.common.entity.Currency;
import com.quickbite.backend.common.repository.CurrencyRepository;
import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.common.service.CrudService;
import com.quickbite.backend.common.util.CollectionResponseFactory;
import com.quickbite.backend.module.currency.dto.CurrencyDto;
import com.quickbite.backend.module.currency.mapper.CurrencyMapper;
import com.quickbite.backend.module.currency.request.CurrencyRequest;
import com.quickbite.backend.module.currency.response.CurrencyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyService implements CrudService<CurrencyResponse, Currency, CurrencyRequest> {

  private final CurrencyRepository repository;
  private final CurrencyMapper mapper;

  @Override
  public CurrencyResponse getEntity(Integer id) {
    CurrencyResponse response = new CurrencyResponse();
    CurrencyDto currencyDto = mapper.currencyToCurrencyDto(repository.getById(id));
    return response.setCurrencyDto(currencyDto);
  }

  @Override
  public CollectionResponse<Currency> getEntities() {
    return CollectionResponseFactory.buildResponse(repository.findAll());
  }

  @Override
  public CurrencyResponse createEntity(CurrencyRequest request) {
    Currency currency = new Currency()
        .setName(request.getName())
        .setRate(request.getRate())
        .setSymbol(request.getSymbol());
    repository.save(currency);
    return new CurrencyResponse().setCurrencyDto(mapper.currencyToCurrencyDto(currency));
  }

  @Override
  public CurrencyResponse updateEntity(CurrencyRequest request, Integer id) {
    Currency currency = repository.getById(id)
        .setSymbol(request.getSymbol())
        .setName(request.getName())
        .setRate(request.getRate());
    repository.save(currency);
    return new CurrencyResponse().setCurrencyDto(mapper.currencyToCurrencyDto(currency));
  }

  @Override
  public CurrencyResponse deleteEntity(Integer id) {
    Currency currency = repository.getById(id);
    repository.delete(currency);
    return new CurrencyResponse().setCurrencyDto(
        mapper.currencyToCurrencyDto(currency));
  }
}
