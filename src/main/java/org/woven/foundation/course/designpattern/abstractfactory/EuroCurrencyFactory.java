package org.woven.foundation.course.designpattern.abstractfactory;

import org.woven.foundation.course.designpattern.factorymethod.Currency;
import org.woven.foundation.course.designpattern.factorymethod.Euro;

/**
 * Concrete Factories
 */
public class EuroCurrencyFactory implements CurrencyFactory {
    @Override
    public Currency createCurrency() {
        return new Euro();
    }
}
