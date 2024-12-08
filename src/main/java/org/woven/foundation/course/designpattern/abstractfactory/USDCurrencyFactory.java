package org.woven.foundation.course.designpattern.abstractfactory;

import org.woven.foundation.course.designpattern.factorymethod.Currency;
import org.woven.foundation.course.designpattern.factorymethod.USDollar;

public class USDCurrencyFactory implements CurrencyFactory {
    @Override
    public Currency createCurrency() {
        return new USDollar();
    }
}
