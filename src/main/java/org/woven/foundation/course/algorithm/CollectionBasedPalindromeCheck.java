package org.woven.foundation.course.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class CollectionBasedPalindromeCheck {

    /**
     * Checks if a given string is a palindrome.
     * <p>
     * Example:
     * <ul>
     * <li>"radar" is a palindrome.</li>
     * <li>"level" is not a palindrome.</li>
     * </ul>
     * <p>
     * Hint: Use a stack to reverse the string and compare it to the original string.
     * <p>
     * Time complexity: O(n).
     * Space complexity: O(n).
     * @param word
     * @return
     */
    public boolean isPalindrome(final String word) {
        Stack<Character> stack = new Stack<>();
        for (Character c : word.toCharArray()) {
            stack.push(c);
        }
        String reversedWord = "";
        while (!stack.isEmpty()) {
            reversedWord = reversedWord + stack.pop();
        }
        return word.equalsIgnoreCase(reversedWord);
    }

    /**
     * Checks if a given string is a palindrome.
     * <p>
     * Example:
     * <ul>
     * <li>"radar" is a palindrome.</li>
     * <li>"level" is not a palindrome.</li>
     * </ul>
     * <p>
     * Hint: Use a deque (double-ended queue) to reverse the string and compare it to the original string.
     * <p>
     * Time complexity: O(n).
     * Space complexity: O(n).
     * @param word
     * @return
     */
   public boolean isPalindromeWithDeque(final String word) {
        Deque<Character> deque = new ArrayDeque<>();
        for (Character c : word.toCharArray()) {
            deque.addFirst(c);
        }
        String reversedWord = "";
        while (!deque.isEmpty()) {
            reversedWord = reversedWord + deque.removeFirst();
        }
        return word.equalsIgnoreCase(reversedWord);

   }

}
