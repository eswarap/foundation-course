package org.woven.foundation.course.solid.srp.withliskov;


import java.util.logging.Level;
import java.util.logging.Logger;

public class Penguin implements ISwimmable {
    private static final Logger logger  = Logger.getLogger(Penguin.class.getName());
    @Override
    public void swim() {
        logger.log(Level.INFO,"i am swimming");
    }
}
