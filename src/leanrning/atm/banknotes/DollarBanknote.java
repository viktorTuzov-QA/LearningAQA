package leanrning.atm.banknotes;

import leanrning.atm.Exchange.ExchangeRate;
import leanrning.atm.abstr.Banknote;
import leanrning.atm.enums.Currency;

import java.math.BigDecimal;

public class DollarBanknote extends Banknote {

    public static final int[] nominals = {1,5,10,20,50,100};



    public DollarBanknote(int nominal) {
        super(Currency.RUB, BigDecimal.valueOf(nominal));

    }


    public static boolean CheckNominal(int value) {
        for (int nominal : nominals) {
            if (nominal == value) return true;
        }
        System.out.println("Номинал не корректный");
        return false;
    }

    @Override
    public BigDecimal convertTo(Currency to) {
        return ExchangeRate.convert(this.nominal, Currency.USD, to);
    }

}
