package org.woven.foundation.course.designpattern.iterator;

import java.util.Iterator;
import java.util.List;

/**
 * Concrete iterator implementing Iterator interface
 * @param <T>
 */
public class PersonIterator<T> implements Iterator<T> {
    private final List<T> list;
    private int index = 0;

    public PersonIterator(final List<T> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public T next() {
        if (this.hasNext()) {
            return list.get(index++);
        }
        return null;
    }

}
