package org.woven.foundation.course.designpattern.singleton;

import java.io.Serial;
import java.io.Serializable;

public class SerializableSingleton implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private SerializableSingleton() {}

    private static class SingletonHolder {
        private static final SerializableSingleton INSTANCE = new SerializableSingleton();
    }

    public static SerializableSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
