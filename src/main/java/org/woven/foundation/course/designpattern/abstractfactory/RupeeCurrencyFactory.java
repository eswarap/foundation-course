package org.woven.foundation.course.designpattern.abstractfactory;

import org.woven.foundation.course.designpattern.factorymethod.Currency;
import org.woven.foundation.course.designpattern.factorymethod.Rupee;

public class RupeeCurrencyFactory implements CurrencyFactory{
    @Override
    public Currency createCurrency() {
        return new Rupee();
    }
}
