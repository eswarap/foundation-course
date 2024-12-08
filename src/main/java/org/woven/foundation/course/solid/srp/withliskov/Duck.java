package org.woven.foundation.course.solid.srp.withliskov;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Duck implements IFlyable,ISwimmable{

    private static final Logger logger  = Logger.getLogger(Duck.class.getName());
    @Override
    public void fly() {
        logger.log(Level.INFO,"i am flying");
    }

    @Override
    public void swim() {
        logger.log(Level.INFO,"i am swimming");
    }
}
