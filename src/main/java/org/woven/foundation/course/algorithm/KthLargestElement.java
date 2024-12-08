package org.woven.foundation.course.algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import lombok.extern.java.Log;

@Log
public class KthLargestElement {

    /**
     * Finds the kth largest element in an unsorted array.
     * Time Complexity: O(nlogn)
     * Space Complexity: O(n)
     * @param arr
     * @param k
     * @return
     */
    public static int findKthLargestElement(int[] arr, int k) {
       if (arr == null || arr.length ==0 || k == 0 || k > arr.length) {
           return  -1;
       }
       Arrays.sort(arr);
       return arr[arr.length - k];
    }

    /**
     * Finds the kth largest element in an unsorted array using heap.
     * Time Complexity: O(nlogk)
     * Space Complexity: O(k)
     * @param arr
     * @param k
     * @return
     */
    public static int findKthLargestElementWithHeap(int[] arr, int k) {
        if (arr == null || arr.length ==0 || k == 0 || k > arr.length) {
            return  -1;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        for (int j : arr) {
            heap.add(j);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        if (heap.isEmpty()) {
            return -1;
        }

        return heap.peek();
    }



    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 1;
        int kthLargest = findKthLargestElement(arr, k);
        log.info("Kth largest element is: " + kthLargest);

        kthLargest = findKthLargestElementWithHeap(arr, k);
        log.info("Kth largest element is: " + kthLargest);

        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Elements in Stack:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println("\nElements in Queue:");
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        priorityQueue.add(10);
        priorityQueue.add(20);
        priorityQueue.add(30);
        System.out.println("\nElements in Priority Queue:");
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.remove());
        }
    }
}
