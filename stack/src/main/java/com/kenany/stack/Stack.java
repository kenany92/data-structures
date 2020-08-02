package com.kenany.stack;

import com.kenany.singlylinkedlist.SinglyLinkedList;

import java.util.EmptyStackException;

/**
 * Data structures
 * com.kenany.stack.Stack
 * @author kenany (armelknyobe@gmail.com)
 */
public class Stack<T> {

    private SinglyLinkedList<T> singlyLinkedList = new SinglyLinkedList();

    public Stack() {
    }

    /**
     *
     * @param data the first item
     */
    public Stack(T data) {
        push(data);
    }

    /**
     * O(1)
     * Add item in the stack
     * It is automatically added at the top of the stack
     * @param data
     */
    public void push(T data) {
        singlyLinkedList.addFirst(data);
    }

    /**
     * O(1)
     * Remove the first item of the stack
     * @return the removed item
     */
    public T pop() {

        if (singlyLinkedList.isEmpty()) {
            throw new EmptyStackException();
        }

        return singlyLinkedList.pop();
    }

    /**
     * O(1)
     * get the first item of the stack (without remove)
     * @return item
     */
    public T peek() {
        if (singlyLinkedList.isEmpty()) {
            throw new EmptyStackException();
        }

        return singlyLinkedList.peekFirst();
    }

    /**
     * Get the size of the stack
     * @return size as integer
     */
    public int size() {
        return singlyLinkedList.size();
    }

    public boolean isEmpty() {
        return singlyLinkedList.isEmpty();
    }
}
