package org.woven.foundation.course.designpattern.singleton;

public class ThreadSafeSingleton {

    private static volatile ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {}

    public synchronized static ThreadSafeSingleton getInstance() {
        if (instance == null) {
                instance =  new ThreadSafeSingleton();
        }
        return instance;
    }

    public static ThreadSafeSingleton getThreadSafeSingleton() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }

}

