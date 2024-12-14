package org.woven.foundation.course.algorithm;

import org.junit.jupiter.api.*;

import java.util.*;
import java.util.logging.*;
import org.woven.foundation.course.algorithm.search.BinarySearch;

public class TestBinarySearch {

    private static final Logger logger = Logger.getLogger(TestBinarySearch.class.getName());

    static int[] numbers;

    @BeforeAll
    static void setup() {
        numbers  = new int[]{2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
    }

    @Test
    void testSearchNumbers() {
        BinarySearch binarySearch = new BinarySearch();
        Assertions.assertTrue(binarySearch.search(numbers, 2));
        Assertions.assertFalse(binarySearch.search(numbers, 10));
    }

    @Test
    void testWithCollectionsBinarySearch() {
        List<Integer> numbers = Arrays.asList(100,30,10,2,50);
        Collections.sort(numbers);
        numbers.forEach(i -> logger.info(i+""));
        int index = Collections.binarySearch(numbers,10);
        logger.info("element found at "+index);
    }

}
