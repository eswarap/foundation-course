package org.woven.foundation.course.designpattern.strategy;

import lombok.extern.java.Log;

@Log
public class WeightsWorkout implements Strategy {
    @Override
    public void doWorkOut() {
        log.info("Workout using weight lifting");
    }
}
