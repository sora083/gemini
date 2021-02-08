package com.sora.proto.gemini.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

@DataJdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class CurrencyRepositoryTest {

  @Autowired
  private CurrencyRepository currencyRepository;

  @Test
  void test() {
    String name = "TEST";
    String symbol = "TST";

    var testCurrency = Currency.newCurrency(name, symbol);
    Currency save = currencyRepository.save(testCurrency);
    assertNotNull(save.getId());
    Optional<Currency> savedCurrency = currencyRepository.findById(save.getId());
    assertTrue(savedCurrency.isPresent());
    savedCurrency
        .ifPresent(member -> assertEquals(save.getName(), member.getName()));
    savedCurrency
        .ifPresent(member -> assertEquals(save.getSymbol(), member.getSymbol()));
  }

}