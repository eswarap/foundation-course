package org.woven.foundation.course.designpattern.factorymethod;

/**
 * Concreate product
 */
public class Euro implements Currency{
    @Override
    public String getSymbol() {
        return "EUR";
    }
}
