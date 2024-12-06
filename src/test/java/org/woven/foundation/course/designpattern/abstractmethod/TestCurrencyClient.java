package org.woven.foundation.course.designpattern.abstractmethod;

import lombok.extern.java.*;
import org.junit.jupiter.api.*;
import org.woven.foundation.course.designpattern.abstractfactory.*;

@Log
public class TestCurrencyClient {

    @Test
    public void testCurrencyClient() {
        CurrencyClient currencyClient = new CurrencyClient(new RupeeCurrencyFactory());
        Assertions.assertEquals("INR",currencyClient.getCurrency().getSymbol());

        currencyClient = new CurrencyClient(new PoundCurrencyFatory());
        Assertions.assertEquals("GBP",currencyClient.getCurrency().getSymbol());

        currencyClient = new CurrencyClient(new EuroCurrencyFactory());
        Assertions.assertEquals("EUR",currencyClient.getCurrency().getSymbol());

        currencyClient = new CurrencyClient(new SGDCurrencyFactory());
        Assertions.assertEquals("SGD",currencyClient.getCurrency().getSymbol());

        currencyClient = new CurrencyClient(new USDCurrencyFactory());
        Assertions.assertEquals("USD",currencyClient.getCurrency().getSymbol());

        currencyClient = new CurrencyClient(new FrancCurrencyFactory());
        Assertions.assertEquals("CHF",currencyClient.getCurrency().getSymbol());
    }
}
