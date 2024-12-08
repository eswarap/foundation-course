package org.woven.foundation.course.designpattern.abstractfactory;

import org.woven.foundation.course.designpattern.factorymethod.Currency;

/**
 * Abstract Factories
 */
public interface CurrencyFactory {
    Currency createCurrency();
}
