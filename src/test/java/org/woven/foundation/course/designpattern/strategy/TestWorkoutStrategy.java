package org.woven.foundation.course.designpattern.strategy;

import org.junit.jupiter.api.Test;

public class TestWorkoutStrategy {

    @Test
    public void testWorkout() {
        WorkoutContext workoutContext = new WorkoutContext(new WeightsWorkout());
        workoutContext.workout();
        workoutContext = new WorkoutContext(new CardioWorkout());
        workoutContext.workout();
    }

}
