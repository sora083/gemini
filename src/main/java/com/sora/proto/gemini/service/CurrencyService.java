package com.sora.proto.gemini.service;

import com.sora.proto.gemini.domain.Currency;
import com.sora.proto.gemini.domain.CurrencyRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyService {

  private final CurrencyRepository currencyRepository;

  public List<Currency> findAll() {
    return (List<Currency>) currencyRepository.findAll();
  }

  public void save(String name, String symbol) {
    currencyRepository.save(Currency.newCurrency(name, symbol));
  }

  public void delete(Long id) {
    currencyRepository.findById(id).ifPresent(currencyRepository::delete);
  }
}
