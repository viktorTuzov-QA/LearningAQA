package leanrning.atm.abstr;

import leanrning.atm.enums.Currency;

import java.math.BigDecimal;

public abstract class Banknote {
    protected final Currency currency;
    protected final BigDecimal nominal;

    public Banknote(Currency currency, BigDecimal nominal) {
        this.nominal = nominal;
        this.currency = currency;
    }

    protected abstract BigDecimal convertTo(Currency target);


}
