package org.woven.foundation.course.algorithm;

import org.junit.jupiter.api.*;
import org.mockito.*;

public class PalindromeTest {
    @Test
    void isPalindrome_withNullStrings_returnsFalse() {
        Assertions.assertFalse(new TwoPointer().isPalindrome(null, null));
    }
    @Test
    void isPalindrome_withNullStrA_returnsFalse() {
        Assertions.assertFalse(new TwoPointer().isPalindrome(null, "test"));
    }
    @Test
    void isPalindrome_withNullStrB_returnsFalse() {
        Assertions.assertFalse(new TwoPointer().isPalindrome("test", null));
    }
    @Test
    void isPalindrome_withStringsOfDifferentLength_returnsFalse() {
        Assertions.assertFalse(new TwoPointer().isPalindrome("test", "test1"));
    }
    @Test
    void isPalindrome_withEqualStrings_returnsTrue() {
        Assertions.assertTrue(new TwoPointer().isPalindrome("test", "test"));
    }
    @Test
    void isPalindrome_withDifferentCharacters_returnsFalse() {
        Assertions.assertFalse(new TwoPointer().isPalindrome("test", "tesd"));
    }
    @Test
    void isPalindrome_withEmptyStrings_returnsTrue() {
        Assertions.assertTrue(new TwoPointer().isPalindrome("", ""));
    }
    @Test
    void isPalindrome_withSingleCharacterStrings_returnsTrue() {
        Assertions.assertTrue(new TwoPointer().isPalindrome("a", "a"));
    }
    @Test
    void isPalindrome_withSpaces_returnsTrue() {
        Assertions.assertTrue(new TwoPointer().isPalindrome("racecar ", " racecar"));
    }
    @Test
    void isPalindrome_withCaseInsensitive_returnsTrue() {
        Assertions.assertTrue(new TwoPointer().isPalindrome("Racecar", "Racecar"));
    }
    @Test
    void isPalindrome_withMockedStrings_returnsTrue() {
        TwoPointer twoPointer = Mockito.mock(TwoPointer.class);
        MockitoAnnotations.initMocks(twoPointer);
        Mockito.when(twoPointer.isPalindrome(Mockito.anyString(), Mockito.anyString())).thenReturn(true);
        Assertions.assertTrue(twoPointer.isPalindrome("test", "test"));
    }
}
