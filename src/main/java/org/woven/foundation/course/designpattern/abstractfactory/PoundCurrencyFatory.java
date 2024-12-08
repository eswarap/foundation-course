package org.woven.foundation.course.designpattern.abstractfactory;

import org.woven.foundation.course.designpattern.factorymethod.Currency;
import org.woven.foundation.course.designpattern.factorymethod.Pound;

public class PoundCurrencyFatory implements CurrencyFactory {

    @Override
    public Currency createCurrency() {
        return new Pound();
    }
}
