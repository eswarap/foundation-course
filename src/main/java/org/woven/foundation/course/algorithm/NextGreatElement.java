package org.woven.foundation.course.algorithm;

import java.util.Arrays;
import java.util.Stack;

public class NextGreatElement {
    public static void main(String[] args) {
        int[] arr = { 15, 20, 13 };
        int[] result = nextGreatElement(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(result));
    }

    public static int[] nextGreatElement(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return result;
    }
}
