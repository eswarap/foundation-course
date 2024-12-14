package org.woven.foundation.course.algorithm.search;

import java.util.Arrays;
import java.util.Objects;
import lombok.extern.java.Log;

@Log
public class TwoPointer {

    /**
     * Checks if the two strings {@code strA} and {@code strB} are palindromes.
     * * <p>
     * * A palindrome is a word, phrase, number, or other sequence of characters which reads the same backward as forward.
     * *
     * check if any of the string is null
     * check if both string length are same
     * iterate over the string from left and right and compare the characters
     * return true if all characters are same
     * return false otherwise
     * *
     * * Time Complexity: O(n)
     * * Space Complexity: O(1)
     * *
     * * @param strA
     * *
     *
     * @param strA
     * @param strB
     * @return
     */
    public boolean isPalindrome(final String strA, final String strB) {
        if (Objects.isNull(strA) || Objects.isNull(strB) || strA.length() != strB.length()) {
            return false;
        }
        int left = 0;
        int right = strA.length() - 1;
        while (left < right) {
            if (strA.charAt(left) != strB.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Reverses the given string.
     * <p>
     * check if the input string is null
     * convert the string to char array
     * iterate from left and right and swap the characters
     * convert the char array back to string and return
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param str
     * @return
     */
    public String reverseString(final String str) {
        if (Objects.isNull(str)) {
            return null;
        }
        int left = 0;
        int right = str.length() - 1;
        char[] charArray = str.toCharArray();
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        return new String(charArray);
    }

    /**
     * Removes duplicates from the given sorted array.
     * <p>
     * check if the input array is empty
     * iterate over the array from 1 to length-1
     * if current element is not equal to previous element then increment index and update the value at index
     * return index+1 as new length
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index + 1;
    }

    /**
     * Finds out pairs of elements in the given array that sum up to the given target.
     * <p>
     * sort the array in O(nlogn) time
     * initialize two pointers, one at the start and one at the end
     * while the pointers don't cross each other
     * sum = arr[left] + arr[right]
     * if sum == target then print the pair and move left and right pointers
     * if sum < target then move left pointer
     * if sum > target then move right pointer
     * <p>
     * Time Complexity: O(nlogn)
     * Space Complexity: O(n)
     *
     * @param arr
     * @param target
     */
    public void findOutPairs(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {    // O(n)
            int sum = arr[left] + arr[right];
            if (sum == target) {
                log.info("Pair found: " + arr[left] + ", " + arr[right]);
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }

    /**
     * Moves all zeroes to the end of the given array.
     * <p>
     * initialize two pointers, one at the start and one at the end
     * while the right pointer doesn't reach the end of the array
     * if the element at right pointer is non-zero then swap the elements at left and right pointers and move both pointers
     * if the element at right pointer is zero then move the right pointer only
     * print the modified array
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param arr
     */
    public int[] moveZeroes(int[] arr) {
        int left = 0;
        int right = 0;
        while (right < arr.length) {
            if (arr[right] == 0) {
                right++;
            } else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right++;
            }
        }
        return arr;
    }

    /**
     * Finds out triplets of elements in the given array that sum up to the given target.
     * <p>
     * sort the array in O(nlogn) time
     * iterate over the array from 0 to length-2
     * if the current element is same as previous element then continue
     * initialize two pointers, one at the next index of current element and one at the end of the array
     * while the left and right pointers don't cross each other
     * sum = arr[i] + arr[left] + arr[right]
     * if sum == target then print the triplet and move left and right pointers
     * if sum < target then move left pointer
     * if sum > target then move right pointer
     * if the current element is same as previous element then continue
     * <p>
     * Note: The array must be sorted before using this method.
     * <p>
     * Example:
     * Input: arr[] = {1, 5, 3, 2, 7, 4, 2, 3}, target = 6
     * Output: Triplet found: 1, 2, 3
     * <p>
     * Time Complexity: O(nlogn)
     * Space Complexity: O(1)
     *
     * @param arr
     * @param target
     */
    public void findOutTriplets(final int[] arr, final int target) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == target) {
                    System.out.println("Triplet found: " + arr[i] + ", " + arr[left] + ", " + arr[right]);
                    while (left < right & arr[left] == arr[left + 1])
                        left++;
                    while (left < right & arr[right] == arr[right - 1])
                        right--;
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2, 7, 4, 2, 3};
        TwoPointer twoPointer = new TwoPointer();
//        log.info(Arrays.toString(twoPointer.moveZeroes(arr)));
        twoPointer.findOutTriplets(arr, 9);
    }
}

