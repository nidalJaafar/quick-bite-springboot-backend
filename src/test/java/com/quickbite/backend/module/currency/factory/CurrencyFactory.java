package com.quickbite.backend.module.currency.factory;

import com.github.javafaker.Faker;
import com.quickbite.backend.common.entity.Currency;
import com.quickbite.backend.common.repository.CurrencyRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

@SpringBootTest
public class CurrencyFactory {

  @Autowired
  private CurrencyRepository repository;

  @Test
  public void seed() {
    Faker faker = new Faker();
    for (int i = 0; i < 10; i++) {
      Currency c = new Currency();
      com.github.javafaker.Currency currency = faker.currency();
      c
          .setName(currency.name())
          .setSymbol(currency.code())
          .setRate(faker.number().randomDouble(2, 1, 10));
      repository.save(c);
    }
  }
}
