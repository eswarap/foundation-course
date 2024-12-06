package org.woven.foundation.course.solid.srp;

import org.junit.jupiter.api.*;

import java.util.*;

public class TestAreaCalculator {

    static Square square = null;
    static Circle circle= null;
    static Rectangle rectangle = null;
    static AreaCalculator areaCalculator = null;

    @BeforeAll
    static void setup() {
        square = new Square(10);
        circle = new Circle(7);
        rectangle = new Rectangle(10,10);
        areaCalculator = new AreaCalculator(Arrays.asList(square,circle,rectangle));
    }

    @Test
    void testAreaOfSquare() {
        Assertions.assertEquals(100,square.calculateArea());
    }

    @Test
    void testAreaOfCircle() {
        Assertions.assertEquals(154,circle.calculateArea());
    }

    @Test
    void testAreaOfRectangle() {
        Assertions.assertEquals(100,rectangle.calculateArea());
    }

    @Test
    void testSum() {
        Assertions.assertEquals(354,areaCalculator.sum());
    }

    @Test
    void testAverage() {
        Assertions.assertEquals(118,areaCalculator.average());
    }
}
