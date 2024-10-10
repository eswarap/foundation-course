package org.woven.foundation.course.designpattern.abstractmethod;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.woven.foundation.course.designpattern.abstractfactory.CurrencyClient;
import org.woven.foundation.course.designpattern.abstractfactory.EuroCurrencyFactory;
import org.woven.foundation.course.designpattern.abstractfactory.FrancCurrencyFactory;
import org.woven.foundation.course.designpattern.abstractfactory.PoundCurrencyFatory;
import org.woven.foundation.course.designpattern.abstractfactory.RupeeCurrencyFactory;
import org.woven.foundation.course.designpattern.abstractfactory.SGDCurrencyFactory;
import org.woven.foundation.course.designpattern.abstractfactory.USDCurrencyFactory;

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
