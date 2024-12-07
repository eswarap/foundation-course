package org.woven.foundation.course.algorithm;

import lombok.extern.java.*;

import java.util.*;
import java.util.logging.*;

@Log
public class FastAndSlowPointerTechnique {

    /**
     * Find duplicate number in an array of size n+1 where n numbers are in range from 1 to n.
     *
     * Algorithm:
     * 1. Use two pointers, slow and fast.
     * 2. Move slow pointer by one step and fast pointer by two steps.
     * 3. If they meet at any point then there is a loop.
     * 4. Find the intersection point of the loop using Floyd's Cycle-Finding Algorithm.
     * 5. The duplicate number is the element at the intersection point.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * Note: The array contains n+1 numbers in range from 1 to n. So, the maximum value that can be at an index is n.
     * So, we can use the array index as the hash function to store the numbers.
     *
     * Example:
     * Input: arr[] = {1, 3, 4, 2, 2}
     * Output: 2
     * Explanation: The slow pointer and the fast pointer meet at index 2. The element at index 2 is 2.
     * So, 2 is the duplicate number.
     *
     * Example:
     * Input: arr[] = {1, 4, 4, 2, 3}
     * Output: 4
     * Explanation: The slow pointer and the fast pointer meet at index 3. The element at index 3 is 4.
     * So, 4 is the duplicate number.
     *
     * Example:
     *
     * @param nums
     * @return
     */
    public static int findDuplicate(Integer[] nums) {
        int slow = 0;
        int fast = 0;

        while (slow < nums.length && fast < nums.length * 2) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) {
                break;
            }
        }

        slow = 0;
        while (slow < nums.length && fast < nums.length * 2) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) {
                return slow;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        Integer[] arr = {1, 9, 7, 3, 5, 9,2};
        Arrays.sort(arr);
        int duplicates = FastAndSlowPointerTechnique.findDuplicate(arr);
        log.log(Level.INFO, String.valueOf(duplicates));
    }
}
