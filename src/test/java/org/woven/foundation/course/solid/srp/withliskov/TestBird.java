package org.woven.foundation.course.solid.srp.withliskov;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

public class TestBird {

    private static final Logger logger = Logger.getLogger(TestBird.class.getName());

    static Duck duck = null;
    static Penguin penguin = null;
    @BeforeAll
    static void setup() {
        logger.info("@BeforeAll - executes once before all test methods in this class");
        duck = new Duck();
        penguin = new Penguin();
    }

    @Test
    void testFly() {
        duck.fly();
    }

    @Test
    void testSwim() {
        duck.swim();
        penguin.swim();
    }
}
