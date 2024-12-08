package org.woven.foundation.course.solid.srp.withoutliskov;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Liskov Substitution principle - Functions that use pointers or references to <b>base</b> classes
 * must be able to use objects of <b>derived</b> classes without knowing it
 *<p>
 * Penguin is derived class of Bird. It expects that both Bird and its subtypes guarantee the
 * fly and swim behaviour, but penguin breaks LSP because it cannot fly
 *</p>
 * <p>
 * Interface Seggregation principle - Clients should not be forced to depend upon interfaces that they
 * do not use
 *</p>
 */

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
