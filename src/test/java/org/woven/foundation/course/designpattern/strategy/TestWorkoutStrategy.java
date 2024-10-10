package org.woven.foundation.course.designpattern.strategy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestWorkoutStrategy {
    private static WorkoutContext workoutContext;

    @BeforeAll
    static void setUp() {
        workoutContext = new WorkoutContext(new WeightsWorkout());
    }

    @Test
    public void testWorkout() {
        workoutContext.workout();
        workoutContext = new WorkoutContext(new CardioWorkout());
        workoutContext.workout();
    }
}
