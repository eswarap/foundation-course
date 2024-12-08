package org.woven.foundation.course.designpattern.abstractfactory;

import lombok.Getter;
import lombok.extern.java.Log;
import org.woven.foundation.course.designpattern.factorymethod.Currency;

@Log
public class CurrencyClient {
    @Getter
    private final Currency currency;

    public CurrencyClient(CurrencyFactory currencyFactory) {
        this.currency = currencyFactory.createCurrency();
    }

    public void displayCurrency() {
        log.info("Currency : "+ currency.getSymbol());
    }
}
