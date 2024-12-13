package org.woven.foundation.course.algorithm;

public class SelectionSort {

    public static void selectionSort(final int[] arr) {
        int n = arr.length;
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
    }

}
