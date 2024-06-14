package org.woven.foundation.course.solid.srp.withoutliskov;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Penguin implements Bird {

    private static final Logger logger  = Logger.getLogger(Duck.class.getName());
    @Override
    public void fly() {
        throw new RuntimeException("i cannot fly");
    }

    @Override
    public void swim() {
        logger.log(Level.INFO,"i am swimming");
    }
}
