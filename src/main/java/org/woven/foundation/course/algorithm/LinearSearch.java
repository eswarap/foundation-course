package org.woven.foundation.course.algorithm;

import java.util.List;

public class LinearSearch<T> {

    public boolean search(final List<T> input, final T element) {
        for (T t : input) {
            if (t == element) {
                return true;
            }
        }
        return false;
    }

    public boolean lambdaSearch(final List<T> input, final T element) {
       return input.stream().anyMatch(p->p.equals(element));
    }
}
