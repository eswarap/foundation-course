package org.woven.foundation.course.designpattern.strategy;

import lombok.extern.java.Log;

/**
 * Concrete implementation of strategy
 */
@Log
public class CardioWorkout implements Strategy {
    @Override
    public void doWorkOut() {
        log.info("Workout using cardio");
    }
}
