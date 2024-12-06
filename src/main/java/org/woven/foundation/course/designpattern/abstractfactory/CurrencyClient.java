package org.woven.foundation.course.designpattern.abstractfactory;

import lombok.*;
import lombok.extern.java.*;
import org.woven.foundation.course.designpattern.factorymethod.*;

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
