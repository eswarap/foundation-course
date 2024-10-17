package org.woven.foundation.course.designpattern.strategy;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@Log
public class TestShippingCostCalculator {

    static ShippingCostCalculator costCalculator;
    static double weight = 10.0;
    @BeforeAll
    static void setUp() {
        costCalculator = new ShippingCostCalculator();
    }

    @Order(0)
    @Test
    void testStandard() {
        double standardShippingCost = costCalculator.calculateShippingCost(ShippingCostCalculator.STANDARD, weight);
        Assertions.assertEquals(50.0,standardShippingCost);
    }

    @Order(1)
    @Test
    void testExpress() {
        double expressShippingCost = costCalculator.calculateShippingCost(ShippingCostCalculator.EXPRESS, weight);
        Assertions.assertEquals(100.0,expressShippingCost);
    }

    @Order(2)
    @Test
    void testSameDay() {
        double sameDayShippingCost = costCalculator.calculateShippingCost(ShippingCostCalculator.SAME_DAY, weight);
        Assertions.assertEquals(200.0,sameDayShippingCost);
    }

    @Order(3)
    @Test
    void testInternational() {
        double internationalShippingCost = costCalculator.calculateShippingCost(ShippingCostCalculator.INTERNATIONAL, weight);
        Assertions.assertEquals(500.0,internationalShippingCost);
    }

    @Order(4)
    @Test
    void testOvernight() {
        double overnightShippingCost = costCalculator.calculateShippingCost(ShippingCostCalculator.OVERNIGHT, weight);
        Assertions.assertEquals(300.0,overnightShippingCost);
    }
}

