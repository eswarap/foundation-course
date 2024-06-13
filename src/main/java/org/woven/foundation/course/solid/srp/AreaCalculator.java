package org.woven.foundation.course.solid.srp;

import java.util.List;

public class AreaCalculator {
    private final List<Shape> shapes;

    public AreaCalculator(List<Shape> shapes) {
        this.shapes = shapes;
    }

    /**
     * OPEN-CLOSED Principle
     * Instead of calculating area in this method, we delegate the responsibility to individual class and
     * hence open for adding new shapes in the Future. By defining Shape with calculateArea as contract, we are
     * instructing the subclass types to bind/abide/adhere to the methods
     *
     * @return sum
     */
    public int sum() {
        return shapes.stream().map(Shape::calculateArea).reduce(0,Integer::sum);
    }

    public double average() {
        return shapes.stream().mapToDouble(Shape::calculateArea).average().orElseThrow(IllegalArgumentException::new);
    }
}
