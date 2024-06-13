package org.woven.foundation.course.solid.srp;

/**
 * Single Responsibility Principle - Each class should have one responsibility ,one single purpose
 */
public class Circle implements Shape {
    private final int radius;

    public Circle(final int radius) {
        this.radius = radius;
    }

    public int calculateArea() {
        return (22 * radius * radius)/7;
    }
}
