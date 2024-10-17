package org.woven.foundation.course.datastructures;

import org.junit.jupiter.api.*;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestLinkedList {
    private static final Logger logger = Logger.getLogger(TestLinkedList.class.getName());

    static LinkedList<String>  linkedList = null;
    @BeforeAll
    static void setUp() throws Exception {
        linkedList = new LinkedList<>("Alphabet");
        linkedList.append("Beta");
        linkedList.append("Gamma");
        linkedList.append("Delta");
        linkedList.append("Epsilon");
    }

    @Test
    @Order(1)
    void printNode() {
        assertEquals(5,linkedList.getSize());
    }

    @Test
    @Order(2)
    void removeLastNode() {
        Node<String> lastNode = linkedList.removeLast();
        assertEquals("Epsilon",lastNode.element);
    }

    @Test
    @Order(3)
    void removeFirstNode() {
        Node<String> firstNode = linkedList.removeFirst();
        assertEquals("Alphabet",firstNode.element);
    }

    @Test
    @Order(4)
    void get() {
        assertEquals("Beta",linkedList.get(0).element);
    }

    @Test
    @Order(5)
    void isEmpty() {
        Assertions.assertFalse(linkedList.isEmpty());
    }

    @Test
    @Order(4)
    void contains() {
        Assertions.assertTrue(linkedList.contains("Beta"));
    }

    @Test
    @Order(5)
    void set() {
        assertTrue(linkedList.set(0,"Alphabet"));
        assertEquals(3,linkedList.getSize());
    }
}
