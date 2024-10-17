package org.woven.foundation.course.designpattern.strategy;

import lombok.extern.java.Log;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

@Log
public class TestWorkoutStrategy {
    private static WorkoutContext workoutContext;

    @BeforeAll
    static void setUp() {
        log.info("setUp");
        workoutContext = new WorkoutContext(new WeightsWorkout());
    }

    @Test
    public void testWorkout() {
        workoutContext.workout();
        workoutContext = new WorkoutContext(new CardioWorkout());
        workoutContext.workout();
    }

    @AfterAll
    static void tearDown() {
        workoutContext = null;
        log.info("tearDown");
    }
}
