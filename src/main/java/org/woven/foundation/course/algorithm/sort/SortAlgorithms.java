package org.woven.foundation.course.algorithm.sort;

import java.util.logging.Level;
import lombok.extern.java.Log;

@Log
public class SortAlgorithms {

    public void heapSort(int[] arr) {
        log.logp(Level.INFO,this.getClass().getName(), "Entering",
                Thread.currentThread().getStackTrace()[1].getMethodName());
        int size = arr.length;
        printArray(arr);
        //Build max heap
        for (int i = size - 2 - 1; i > 0; i--) {
            heapify(arr, size, i);
        }

        //Heap sort
        for (int i = size - 1; i >= 0; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }
        printArray(arr);
        log.logp(Level.INFO,this.getClass().getName(), "Exiting",
                Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    private static void heapify(int[] arr, int size, int i) {
        // Find largest among root, left child and right child
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }
        // Swap and continue heapifying if root is not largest
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, size, largest);
        }
    }

    private static void swap(int[] arr, int i, int largest) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
    }

    /**
     * Bubble sort algorithm
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     * In-place algorithm
     * Stable algorithm
     *
     * @param arr
     */
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        printArray(arr);
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
                if (!swapped) break;
            }
        }
        printArray(arr);
    }

    /**
     * Selection sort algorithm
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     * In-place algorithm
     * Stable algorithm
     *
     * @param arr
     */
    public void selectionSort(final int[] arr) {
        int n = arr.length;
        printArray(arr);
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            boolean minIndexFound = false;
            for (int j = minIndex + 1; j < n - 1; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                    minIndexFound = true;
                }
            }
            if (minIndexFound) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
        printArray(arr);
    }

    public void insertionSort(final int[] arr) {
        int n = arr.length;
        printArray(arr);
        for (int i = 1; i < n - 1; i++) {
            int j = i - 1;
            // insert arr[i] into sorted sequence arr[0..i-1]
            // shift elements in arr[0..i-1] to make space for arr[i]
            // find the location to insert arr[i]
            int key = arr[i];
            System.out.format("key = %s%n", key);
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
            printArray(arr);
        }
        printArray(arr);

    }

    private static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SortAlgorithms sortAlgorithms = new SortAlgorithms();
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        sortAlgorithms.bubbleSort(arr);
        sortAlgorithms.selectionSort(arr);
        sortAlgorithms.insertionSort(arr);
        sortAlgorithms.heapSort(arr);
    }
}

