package org.woven.foundation.course.algorithm;

import java.util.Arrays;

public class BinarySearch {

    public boolean search(final int[] input, final int element) {
        int[] sorted = Arrays.stream(input).sorted().toArray();
        int low = 0, high = input.length - 1;

        while (low <= high) {
            int mid = low + (high - low ) / 2;

            if (sorted[mid] == element)
                return true;
            if (sorted[mid] < element)
                low = mid + 1;
            else
                high = mid - 1;

        }
        return false;
    }
}
