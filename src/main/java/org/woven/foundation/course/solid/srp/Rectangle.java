package org.woven.foundation.course.solid.srp;

public class Rectangle implements Shape{
    private final int length;
    private final int breadth;

    public Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public int calculateArea() {
        return length * breadth;
    }
}
