package com.quickbite.backend.module.currency.mapper;

import com.quickbite.backend.module.currency.dto.CurrencyDto;
import com.quickbite.backend.common.entity.Currency;
import java.util.List;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CurrencyMapper {

  Currency currencyDtoToCurrency(CurrencyDto currencyDto);

  CurrencyDto currencyToCurrencyDto(Currency currency);

  List<CurrencyDto> currencyListToCurrencyDtoList(List<Currency> currencyList);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateCurrencyFromCurrencyDto(
      CurrencyDto currencyDto, @MappingTarget Currency currency);
}
