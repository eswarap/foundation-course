package org.woven.foundation.course.designpattern.strategy;

import java.util.HashMap;
import java.util.Map;

public class ShippingCostCalculator {
    private static final Map<String,Double> shippingCosts = new HashMap<>();

    public static final String STANDARD = "STANDARD";

    public static final String EXPRESS = "EXPRESS";

    public static final String SAME_DAY = "SAME_DAY";

    public static final String INTERNATIONAL = "INTERNATIONAL";

    public static final String OVERNIGHT = "OVERNIGHT";

    static {
        shippingCosts.put(STANDARD,5.0);
        shippingCosts.put(EXPRESS, 10.0);
        shippingCosts.put(SAME_DAY, 20.0);
        shippingCosts.put(INTERNATIONAL, 50.0);
        shippingCosts.put(OVERNIGHT, 30.0);
    }

    public double calculateShippingCost(final String shippingType, final double weight) {
        return shippingCosts.entrySet().stream()
                .filter(entry -> entry.getKey().equalsIgnoreCase(shippingType))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(0.0)
                * weight;
    }
}
