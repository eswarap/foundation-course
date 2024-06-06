package org.woven.foundation.course.designpattern.singleton;

public class StaticBlockSingleton {
    
    private static StaticBlockSingleton instance;
    
    private StaticBlockSingleton() {}

    static {
        if (instance == null) {
            instance = new StaticBlockSingleton();
        }

    }
    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}
