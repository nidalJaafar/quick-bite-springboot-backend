package com.quickbite.backend.common.repository;

import com.quickbite.backend.common.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
  boolean existsByName(String name);
  boolean existsBySymbol(String symbol);
}