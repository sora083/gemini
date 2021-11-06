package com.sora.proto.gemini.domain;

import java.math.BigDecimal;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Currency {

  /** ID */
  @Id private Long id;

  /** 仮想通貨名 */
  private String name;

  /** シンボル */
  private String symbol;

  /** 数量 */
  private BigDecimal amount;

  // TODO builderに変える
  public static Currency newCurrency(String name, String symbol) {
    Currency currency = new Currency();
    currency.name = name;
    currency.symbol = symbol;
    currency.amount = BigDecimal.ZERO;
    return currency;
  }
}
