package leanrning.atm.Exchange;

import leanrning.atm.enums.Currency;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ExchangeRate {
    private static final BigDecimal USDtoEUR = new BigDecimal("0.9");
    private static final BigDecimal USDtoRUB = new BigDecimal ("75");
     public static BigDecimal convert(BigDecimal amount, Currency from, Currency to)
     {
         if (from == to) return amount;

         switch (from)
         {
             case USD:
                 if (to == Currency.EUR) return amount.multiply(USDtoEUR);
                 if (to == Currency.RUB) return amount.multiply(USDtoRUB);
                 break;

             case EUR:
                 if (to == Currency.RUB) return amount.multiply(USDtoRUB).divide(USDtoEUR, RoundingMode.HALF_UP);
                 if (to == Currency.USD) return amount.divide(USDtoEUR, RoundingMode.HALF_UP);
                 break;

             case RUB:
                 if (to == Currency.EUR) return amount.multiply(USDtoEUR).divide(USDtoRUB, RoundingMode.HALF_UP);
                 if (to == Currency.USD) return amount.divide(USDtoRUB, RoundingMode.HALF_UP);
                 break;
         }
         return BigDecimal.ZERO;
     }


}
