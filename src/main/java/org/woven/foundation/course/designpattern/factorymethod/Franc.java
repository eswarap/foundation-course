package org.woven.foundation.course.designpattern.factorymethod;

public class Franc implements Currency{
    @Override
    public String getSymbol() {
        return "CHF";
    }
}
