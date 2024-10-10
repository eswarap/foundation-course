package org.woven.foundation.course.designpattern.factorymethod;

import lombok.extern.java.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Single Concreate Factory
 */
@Log
public class CurrencyFactory {

    private static final Map<String, Currency> CURRENCIES = new HashMap<>();

    public static final String INDIA = "India";

    public static final String USA = "USA";

    public static final String FRANCE = "France";

    public static final String UK = "UK";

    public static final String SWITZERLAND = "Switzerland";

    static {
        CURRENCIES.put(INDIA,new Rupee());
        CURRENCIES.put(USA,new USDollar());
        CURRENCIES.put(FRANCE,new Euro());
        CURRENCIES.put(UK,new Pound());
        CURRENCIES.put(SWITZERLAND,new Franc());
    }

    public static Currency getCurrency(String country) {
        if (CURRENCIES.containsKey(country)) {
            return CURRENCIES.get(country);
        }
        else {
            throw new IllegalArgumentException("Unknown currency: " + country);
        }
    }
}
