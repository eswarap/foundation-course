package org.woven.foundation.course.designpattern.strategy;

/**
 * Context class
 */
public class WorkoutContext {
    private final Strategy strategy;

    public WorkoutContext(final Strategy strategy) {
        this.strategy = strategy;
    }

    public void workout() {
        strategy.doWorkOut();
    }
}
