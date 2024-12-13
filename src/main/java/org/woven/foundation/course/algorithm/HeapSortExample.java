package org.woven.foundation.course.algorithm;

import java.util.Arrays;
import lombok.extern.java.Log;

@Log
public class HeapSortExample {
    public static void main(String[] args) {
        int[] arr = {90, 64, 34, 25, 12, 22, 11, 90};
        log.info("Unsorted array:" + Arrays.toString(arr));
        heapSort(arr);
        log.info("Sorted array: " + Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        int size = arr.length;
        //Build max heap
        for (int i = size - 2 - 1; i > 0; i--) {
            heapify(arr, size, i);
        }

        //Heap sort
        for (int i = size - 1; i >= 0; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }
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


}
