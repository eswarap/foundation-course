package org.woven.foundation.course.designpattern.factorymethod;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;

import java.util.Locale;

@Log
public class TestCurrencyFactory {

    @Test
    void testCurrencyFactory() {
        Currency defaultCurrency = CurrencyFactory.getCurrency(Locale.getDefault().getDisplayCountry());
        log.info(defaultCurrency.getSymbol());
        Currency euroCurrency = CurrencyFactory.getCurrency(CurrencyFactory.FRANCE);
        log.info(euroCurrency.getSymbol());
        Currency poundCurrency = CurrencyFactory.getCurrency(CurrencyFactory.UK);
        log.info(poundCurrency.getSymbol());
    }
}
