package org.woven.foundation.course.algorithm;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.extern.java.Log;

@Log
public class CollectionBasedDuplicateCheck {

    /**
     * Find duplicates in an array using collection.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param arr
     */
    public static void findDuplicates(Integer[] arr) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicate = new HashSet<>();
        for (Integer num : arr) {
            if (seen.contains(num)) {
                duplicate.add(num);
            } else {
                seen.add(num);
            }
        }

        if (duplicate.isEmpty())
            log.info("No duplicate found");
        else
            log.info(duplicate.toString());
    }

    /**
     * Find duplicates in an array using sorting.
     * Time Complexity: O(nlogn)
     * Space Complexity: O(n)
     * @param arr
     */
    public static void findDuplicatesUsingSorting(Integer[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (Objects.equals(arr[i], arr[i + 1])) {
                log.info("Duplicate found: " + arr[i]);
            }
        }
    }

    /**
     * Find duplicates in an array using Java 8 stream.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param arr
     */
    public static void findDuplicatesUsingLamdba(Integer[] arr) {

        List<Integer> list = Arrays.stream(arr).toList();

        List<Integer> duplicates = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue().intValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        if (duplicates.isEmpty()) {
            log.info("No duplicates found");
        } else {
            log.info("Duplicates found: " + duplicates);
        }
    }


    public static void main(String[] args) {
        Integer[] arr = {1, 3, 5, 7, 9, 6, 7, 8,3};
        CollectionBasedDuplicateCheck.findDuplicates(arr);
        CollectionBasedDuplicateCheck.findDuplicatesUsingSorting(arr);
        CollectionBasedDuplicateCheck.findDuplicatesUsingLamdba(arr);
    }
}
