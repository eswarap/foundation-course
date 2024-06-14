package org.woven.foundation.course.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TestLinearSearch {

    static List<Integer> numbers;
    static List<String> words;
    @BeforeAll
    static void setup() {
        numbers = Arrays.asList(1,2,3,45,3,42,10);
        words = Arrays.asList("Freida","Jacky","Merlin","Violet","Kyra","Millie","Bertram");
    }

    @Test
    void testSearchNumbers() {
        LinearSearch<Integer> linearSearch = new LinearSearch<>();
        Assertions.assertFalse(linearSearch.search(numbers, 0));
        Assertions.assertTrue(linearSearch.search(numbers, 10));
    }

    @Test
    void testLambdaSearchNumbers() {
        LinearSearch<Integer> linearSearch = new LinearSearch<>();
        Assertions.assertFalse(linearSearch.lambdaSearch(numbers, 0));
        Assertions.assertTrue(linearSearch.lambdaSearch(numbers, 10));
    }

    @Test
    void testSearchWords() {
        LinearSearch<String> linearSearch = new LinearSearch<>();
        Assertions.assertTrue(linearSearch.search(words, "Violet"));
        Assertions.assertFalse(linearSearch.search(words, "Violine"));
    }
}
