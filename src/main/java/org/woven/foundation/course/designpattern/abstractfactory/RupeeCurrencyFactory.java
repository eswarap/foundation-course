package org.woven.foundation.course.designpattern.abstractfactory;

import org.woven.foundation.course.designpattern.factorymethod.*;

public class RupeeCurrencyFactory implements CurrencyFactory{
    @Override
    public Currency createCurrency() {
        return new Rupee();
    }
}
