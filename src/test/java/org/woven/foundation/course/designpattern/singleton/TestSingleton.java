package org.woven.foundation.course.designpattern.singleton;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestSingleton {

    private static final Logger logger = Logger.getLogger(TestSingleton.class.getName());

    @Test
    public void testSingleton() {
        EagerInitializedSingleton singleton = EagerInitializedSingleton.getInstance();
        EagerInitializedSingleton singleton2 = null;
        try {
            Constructor<?>[] constructors = EagerInitializedSingleton.class.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                constructor.setAccessible(true);
                singleton2 = (EagerInitializedSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
        assert singleton != null;
        assert singleton2 != null;
        logger.log(Level.INFO, "singleton hash {0}",singleton.hashCode());
        logger.log(Level.INFO,  "singleton2 hash {0}",singleton2.hashCode());
    }

    @Test
    void testSerializedSingleton() throws IOException, ClassNotFoundException {
        SerializableSingleton singleton = SerializableSingleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("output.ser"));
        out.writeObject(singleton);
        out.close();

        ObjectInput in = new ObjectInputStream(new FileInputStream("output.ser"));
        SerializableSingleton singleton1 = (SerializableSingleton) in.readObject();
        in.close();

        logger.log(Level.INFO, "singleton hash {0}",singleton.hashCode());
        logger.log(Level.INFO, "singleton hash {0}",singleton1.hashCode());
    }
}
