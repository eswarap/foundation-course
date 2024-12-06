package org.woven.foundation.course.algorithm;

import org.junit.jupiter.api.*;

public class RemoveDuplicatesTest {
    @Test
    void removeDuplicates_emptyArray_returnsZero() {
        int[] nums = {};
        int result = new TwoPointer().removeDuplicates(nums);
        Assertions.assertEquals(0, result);
    }
    @Test
    void removeDuplicates_singleElementArray_returnsOne() {
        int[] nums = {1};
        int result = new TwoPointer().removeDuplicates(nums);
        Assertions.assertEquals(1, result);
    }
}
