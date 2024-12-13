package org.woven.foundation.course.algorithm;

import lombok.extern.java.Log;

@Log
public class Fibonacci {

    /**
     * Recursive
     * Time Complexity: O(2^n)
     * Space Complexity: O(n)
     *
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * Dynamic Programming
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param n
     * @return
     */
    public static int fibonacci2(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0 || n == 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        log.info("fibonacci(10) = " + fibonacci(10));
        log.info("fibonacci(10) = " + fibonacci(10));

    }
}
