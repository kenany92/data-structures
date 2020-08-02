package com.kenany.doublylinkedlist;

/**
 * Data Structures
 * Doubly linked list (basics operations implementation)
 * @author kenany (armelknyobe@gmail.com)
 *
 */
public class DoublyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public int length() {
        return size;
    }

    /**
     * O(1)
     * Add item at the top of the list
     * @param data data to add
     */
    public void push(T data) {

        Node<T> node = new Node<T>(data, null, null);

        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }

        size++;
    }

    /**
     * O(1)
     * Add item at the end of the list
     * @param data data to add
     */
    public void unshift(T data) {

        Node<T> node = new Node<T>(data, tail, null);

        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }

        size++;
    }

    /**
     * O(1)
     * Add item at the end of the list
     * @param data data to add
     */
    public void add(T data) {

        unshift(data);
    }

    /**
     * O(n) n = index - 1
     * Add item at the provided index in the list
     * @param index index in which the item should be added
     * @param data data to add
     */
    public void addItem(int index, T data) {

        if (index > size + 1) {
            throw new IndexOutOfBoundsException();
        }

        if (index < 1) {
            throw new IllegalArgumentException("Index starts at 1");
        }

        if (index == 1) {
            push(data);
            return;
        }

        if (index == size) {
            unshift(data);
            return;
        }

        Node<T> node = new Node<T>(data, null, null);

        Node<T> atIindex = head;

        for (int i = 1; i < index; i++) {

            atIindex = atIindex.next;
        }

        node.prev = atIindex.prev;
        atIindex.prev.next = node;
        atIindex.prev = node;
        node.next = atIindex;

        size++;
    }

    /**
     * O(1)
     * Remove item from the top of the list
     * @return removed item
     */
    public T pop() {

        if (isEmpty()) {
            throw new RuntimeException("Cannot remove item from empty list");
        }

        Node<T> toRemove = head;
        head = head.next;
        head.prev = null;
        size--;

        return toRemove.data;
    }

    /**
     * O(1)
     * Remove item from the end of the list
     * @return removed item
     */
    public T shift() {

        if (isEmpty()) {
            throw new RuntimeException("Cannot remove item from empty list");
        }

        Node<T> toRemove = tail;
        tail = tail.prev;
        tail.next = null;
        size--;

        return toRemove.data;
    }

    /**
     * O(n)
     * Remove item from the specified index in the list
     * @param index index in which item should be removed
     * @return The removed item
     */
    public T remove(int index) {

        if (index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index < 1) {
            throw new IllegalArgumentException("Index starts at 1");
        }

        Node<T> toRemove = head;

        for (int i = 1; i < index; i++) {
            toRemove = toRemove.next;
        }

        toRemove.prev.next = toRemove.next;
        toRemove.next.prev = toRemove.prev;

        size--;

        return toRemove.data;
    }

    /**
     * Remove all item in the list
     */
    public void clear() {
        Node<T> trav = head;
        while (trav != null) {
            Node<T> next = trav.next;
            trav.data = null;
            trav.prev = null;
            trav.next = null;
            trav = next;
        }

        head = tail = trav = null;
        size = 0;
    }

    /**
     * O(1)
     * Get the first item from the list
     * @return retrieved item
     */
    public T peekFirst() {

        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }

        return head.data;
    }

    /**
     * O(1)
     * Get the last item from the list
     * @return the retrieved item
     */
    public T peekLast() {

        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }

        return tail.data;
    }

    /**
     * O(n)
     * Get item from the specified index in the list.
     * @param index
     * @return retreived item
     */
    public T get(int index) {
        Node<T> node = find(index);
        return node.data;
    }

    /**
     * O(1)
     * Update the item at the specified index
     * @param index Index for the item to update
     * @param data
     */
    public void update(int index, T data) {
        Node<T> node = find(index);
        node.data = data;
    }

    /**
     * O(n) n = index - 1
     * Find item from the provided index
     * @param index Index of item to find
     * @return
     */
    private Node<T> find(int index) {

        if (index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index < 1) {
            throw new IllegalArgumentException("Index starts at 1");
        }

        Node<T> node = head;

        for (int i = 1; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    @Override
    public String toString() {

        StringBuilder strb = new StringBuilder("[");
        Node<T> node = head;
        while (node != null) {
            strb.append(node.data + ", ");
            node = node.next;
        }
        strb.append("]");
        return strb.toString();
    }
}