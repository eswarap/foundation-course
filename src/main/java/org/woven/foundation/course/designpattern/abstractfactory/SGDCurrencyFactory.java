package org.woven.foundation.course.designpattern.abstractfactory;

import org.woven.foundation.course.designpattern.factorymethod.Currency;
import org.woven.foundation.course.designpattern.factorymethod.SGDollar;

public class SGDCurrencyFactory implements CurrencyFactory {
    @Override
    public Currency createCurrency() {
        return new SGDollar();
    }
}
