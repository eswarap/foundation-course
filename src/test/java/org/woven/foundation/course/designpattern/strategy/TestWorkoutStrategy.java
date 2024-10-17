package org.woven.foundation.course.designpattern.strategy;

import lombok.extern.java.Log;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

@Log
public class TestWorkoutStrategy {
    private static WorkoutContext workoutContext;

    @BeforeEach
    void setUp() {
        log.info("setUp");
        workoutContext = new WorkoutContext(new WeightsWorkout());
    }

    @Test
    public void testWorkout() {
        workoutContext.workout();
        workoutContext = new WorkoutContext(new CardioWorkout());
        workoutContext.workout();
    }

    @AfterEach
    void tearDown() {
        workoutContext = null;
        log.info("tearDown");
    }
}
