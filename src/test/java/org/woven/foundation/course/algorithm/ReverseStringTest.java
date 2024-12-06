package org.woven.foundation.course.algorithm;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.junit.jupiter.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ReverseStringTest {
    @Test
    void reverseString_nullInput_returnsNull() {
        assertNull(new TwoPointer().reverseString(null));
    }
    @Test
    void reverseString_emptyString_returnsEmptyString() {
        assertEquals("", new TwoPointer().reverseString(""));
    }
    @Test
    void reverseString_singleCharacterString_returnsSameString() {
        assertEquals("a", new TwoPointer().reverseString("a"));
    }
    @Test
    void reverseString_evenLengthString_reversesCharacters() {
        assertEquals("ba", new TwoPointer().reverseString("ab"));
    }
    @Test
    void reverseString_oddLengthString_reversesCharacters() {
        assertEquals("cba", new TwoPointer().reverseString("abc"));
    }

}
