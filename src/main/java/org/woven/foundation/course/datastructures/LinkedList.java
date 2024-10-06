package org.woven.foundation.course.datastructures;

import lombok.Getter;

import java.util.logging.Logger;

@Getter
public class LinkedList<T> {

    private static final Logger logger = Logger.getLogger(LinkedList.class.getName());

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList(final T value) {
        Node<T> newNode = new Node<>(value);
        head = newNode;
        tail = newNode;
        size = 1;
    }

    public void print() {
        Node<T> current = head;
        while (current != null) {
            logger.info(String.valueOf(current.element));
            current = current.next;
        }
    }

    public void append(final T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            size = 1;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public Node<T> removeLast() {
        if (head == null) {
            return null;
        }
        Node<T> temp = head;
        Node<T> prev = head;

        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        tail = prev;
        tail.next = null;
        size--;
        if (size == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public Node<T> removeFirst() {
        if (head == null) {
            return null;
        }
        Node<T> temp = head;
        head = head.next;
        temp.next = null;
        size--;
        if (size == 0) {
            tail = null;
        }
        return temp;
    }

    public Node<T> get(final int index) {
        Node<T> current = head;
        if (index < 0 || index >= size) {
            return null;
        }
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(final T value) {
        Node<T> current = head;
        while (current != null) {
            if (current.element.equals(value)) {
                return true;
            }
            else {
                current = current.next;
            }
        }
        return false;
    }

    public boolean set(final int index, final T value) {
        Node<T> temp = get(index);
        if (temp == null) {
            return false;
        } else {
            temp.element = value;
            return true;
        }
    }
}
