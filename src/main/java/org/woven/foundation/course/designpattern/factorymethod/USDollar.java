package org.woven.foundation.course.designpattern.factorymethod;

public class USDollar implements Currency{
    @Override
    public String getSymbol() {
        return "USD";
    }
}
