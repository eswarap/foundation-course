package org.woven.foundation.course.algorithm;

public class Permutation {
    public static void main(String[] args) {
        String input = "abc";
//        permute(input, 0, input.length() - 1);
        System.out.println("--------------------");
        heapPermute(input);
    }

    /**
     * Permute the given input string
     * Time Complexity: O(n * n!)
     * Space Complexity: O(n!)
     *
     * @param input
     * @param l
     * @param r
     */
    public static void permute(String input, int l, int r) {
        if (l == r) {
            System.out.println(input);
        } else {
            for (int i = l; i <= r; i++) {
                input = swap(input, l, i);
                permute(input, l + 1, r);
                input = swap(input, l, i);
            }
        }
    }

    /**
     * Swap the characters at index i and j in the given input string
     *
     * @param input
     * @param i
     * @param j
     * @return
     */
    private static String swap(String input, int i, int j) {
        char[] charArray = input.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    /**
     * Permute the given input string using Heap's Algorithm
     * Time Complexity: O(n * n!)
     * Space Complexity: O(n!)
     *
     * @param input
     */
    public static void heapPermute(String input) {
        int n = input.length();
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            count[input.charAt(i) - 'a']++;
        }
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        heapPermuteUtil(input, count, index, 0, n);
    }

    private static void heapPermuteUtil(String input, int[] count, int[] index, int level, int n) {
        if (level == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(input.charAt(index[i]));
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (count[i] > 0) {
                count[i]--;
                index[level] = i;
                heapPermuteUtil(input, count, index, level + 1, n);
                count[i]++;
            }
        }
    }


}
