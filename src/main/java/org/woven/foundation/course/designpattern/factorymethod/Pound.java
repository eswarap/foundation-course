package org.woven.foundation.course.designpattern.factorymethod;

public class Pound implements Currency{
    @Override
    public String getSymbol() {
        return "GBP";
    }
}
