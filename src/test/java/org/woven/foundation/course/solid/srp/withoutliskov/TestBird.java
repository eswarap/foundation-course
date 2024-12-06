package org.woven.foundation.course.solid.srp.withoutliskov;

import org.junit.jupiter.api.*;

import java.util.logging.*;

public class TestBird {

    private static final Logger logger = Logger.getLogger(TestBird.class.getName());

    static Bird duck = null;
    static Bird penguin = null;
    @BeforeAll
    static void setup() {
        logger.info("@BeforeAll - executes once before all test methods in this class");
        duck = new Duck();
        penguin = new Penguin();
    }

    @Test
    void testFly() {
        Assertions.assertThrows(RuntimeException.class,()->penguin.fly());
        duck.fly();
    }

    @Test
    void testSwim() {
        duck.swim();
        penguin.swim();
    }
}
