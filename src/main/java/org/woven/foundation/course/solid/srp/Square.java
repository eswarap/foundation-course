package org.woven.foundation.course.solid.srp;

public class Square implements Shape{
    private final int length;

    public Square(final int length) {
        this.length = length;
    }

    public int calculateArea() {
        return length * length;
    }
}
