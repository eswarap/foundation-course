package org.woven.foundation.course.algorithm;

public class SortAlgorithms {

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
        // sortAlgorithms.bubbleSort(arr);
        //sortAlgorithms.selectionSort(arr);
        sortAlgorithms.insertionSort(arr);
    }
}

