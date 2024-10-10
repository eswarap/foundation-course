package org.woven.foundation.course.designpattern.factorymethod;

public class Rupee implements Currency{
    @Override
    public String getSymbol() {
        return "INR";
    }
}
