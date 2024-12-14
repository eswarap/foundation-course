package org.woven.foundation.course.algorithm.search;

import java.util.Arrays;
import java.util.logging.Level;
import lombok.extern.java.Log;

@Log
public class FastAndSlowPointerTechnique {

    /**
     * Find duplicate number in an array of size n+1 where n numbers are in range from 1 to n.
     * <p>
     * Algorithm:
     * 1. Use two pointers, slow and fast.
     * 2. Move slow pointer by one step and fast pointer by two steps.
     * 3. If they meet at any point then there is a loop.
     * 4. Find the intersection point of the loop using Floyd's Cycle-Finding Algorithm.
     * 5. The duplicate number is the element at the intersection point.
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * <p>
     * Note: The array contains n+1 numbers in range from 1 to n. So, the maximum value that can be at an index is n.
     * So, we can use the array index as the hash function to store the numbers.
     * <p>
     * Example:
     * Input: arr[] = {1, 3, 4, 2, 2}
     * Output: 2
     * Explanation: The slow pointer and the fast pointer meet at index 2. The element at index 2 is 2.
     * So, 2 is the duplicate number.
     * <p>
     * Example:
     * Input: arr[] = {1, 4, 4, 2, 3}
     * Output: 4
     * Explanation: The slow pointer and the fast pointer meet at index 3. The element at index 3 is 4.
     * So, 4 is the duplicate number.
     * <p>
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

    /**
     * Find kth largest element in an unsorted array.
     * <p>
     * Algorithm:
     * 1. Use QuickSelect algorithm to find the kth largest element.
     * 2. The kth largest element is the (n - k + 1)th smallest element in the sorted array.
     * 3. Use QuickSort algorithm to sort the array.
     * 4. Return the (n - k + 1)th element in the sorted array.
     * <p>
     * Time Complexity: O(n * log(n)) in the worst case.
     * Space Complexity: O(n) for the recursive stack.
     *
     * @param arr
     * @param k
     * @return
     */

    public int findKthLargest(int[] arr, int k) {
        int n = arr.length;
        if (k <= 0 || k > n) {
            return -1;
        }

        return quickSelect(arr, 0, n - 1, n - k + 1);
    }

    /**
     * QuickSelect algorithm to find the kth smallest element in an array.
     * <p>
     * Algorithm:
     * 1. Pick a pivot element.
     * 2. Partition the array around the pivot element.
     * 3. If the index of the pivot element is equal to k, then return the pivot element.
     * 4. If the index of the pivot element is greater than k, then recursively call the function for the left subarray.
     * 5. If the index of the pivot element is less than k, then recursively call the function for the right subarray.
     * <p>
     * Time Complexity: O(n) on average. O(n^2) in the worst case.
     * Space Complexity: O(n) for the recursive stack.
     *
     * @param arr
     * @param low
     * @param high
     * @param k
     * @return
     */
    private int quickSelect(int[] arr, int low, int high, int k) {
        if (low == high) {
            return arr[low];
        }

        int pivot = partition(arr, low, high);
        int index = pivot - low + 1;

        if (index == k) {
            return arr[pivot];
        } else if (index > k) {
            return quickSelect(arr, low, pivot - 1, k);
        } else {
            return quickSelect(arr, pivot + 1, high, k - index);
        }
    }

    /**
     * Partition an array around a pivot element.
     * <p>
     * Algorithm:
     * 1. Pick a pivot element.
     * 2. Place the pivot element at the end of the array.
     * 3. Place index i at the beginning of the array.
     * 4. Iterate through the array from the beginning to the end.
     * 5. If the element is smaller than the pivot element, then swap it with the element at index i and increment i.
     * 6. Swap the pivot element with the element at index i + 1.
     * 7. Return the index of the pivot element.
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * <p>
     * Example:
     * Input: arr[] = {5, 2, 3, 1, 4}
     * Pivot: 4
     * i: -1
     * j: 0
     * arr[] = {5, 2, 3, 1, 4}
     * <p>
     * i: 0
     * j: 1
     * arr[] = {2, 5, 3, 1, 4}
     * <p>
     * i: 0
     * j: 2
     * arr[] = {2, 5, 3, 1, 4}
     * <p>
     * i: 1
     * j: 3
     * arr[] = {2, 5, 3, 1, 4}
     * <p>
     * i: 2
     * j: 4
     * arr[] = {2, 5, 3, 1, 4}
     * <p>
     * Swap 4 and 5.
     * arr[] = {2, 3, 5, 1, 4}
     * <p>
     * Return 2.
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] >= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


    public static void main(String[] args) {
        Integer[] arr = {1, 9, 7, 3, 5, 9, 2};
        Arrays.sort(arr);
        int duplicates = FastAndSlowPointerTechnique.findDuplicate(arr);
        log.log(Level.INFO, String.valueOf(duplicates));
    }
}
