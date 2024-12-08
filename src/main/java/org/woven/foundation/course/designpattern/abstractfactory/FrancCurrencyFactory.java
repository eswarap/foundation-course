package org.woven.foundation.course.designpattern.abstractfactory;

import org.woven.foundation.course.designpattern.factorymethod.Currency;
import org.woven.foundation.course.designpattern.factorymethod.Franc;

public class FrancCurrencyFactory implements CurrencyFactory {
    @Override
    public Currency createCurrency() {
        return new Franc();
    }
}
