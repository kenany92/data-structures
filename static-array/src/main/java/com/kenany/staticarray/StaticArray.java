package com.kenany.staticarray;

/**
 * Data Structures
 * Static Array (basics operations implementation)
 * @author kenany (armelknyobe@gmail.com)
 *
 */
public class StaticArray {

    private int capacity = 0;
    private int size = 0;

    private static final int DEFAULT_CAPACITY = 16;

    private Object values[];

    /**
     * Default constructor use default capacity
     */
    public StaticArray() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructor with capacity as parameter
     * @param capacity int
     */
    public StaticArray(int capacity) {
        this.capacity = capacity;
        values = new Object[capacity];
    }

    /**
     * O(1)
     * Add Object at the end of array
     * @param object object to add
     * @return true if object has been added successfully
     */
    public boolean add(Object object) {

        if (size == capacity) {
            throw new IndexOutOfBoundsException();
        }

        values[size++] = object;

        return true;
    }

    /**
     * O(1)
     * Change object value at index
     * @param object new value
     * @param index index to insert the new value
     * @return true if operation is performed successfully.
     */
    public boolean update(Object object, int index) {

        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }

        values[index] = object;

        return true;
    }

    /**
     * O(1)
     * Delete object at index
     * @param index index for object to deletz
     * @return deleted object
     */
    public Object delete(int index) {

        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Object data = values[index];
        values[index] = null;
        size--;

        return data;
    }

    /**
     * O(1)
     * Retreive a object value from index
     * @param index index for the object
     * @return retrieved object
     */
    public Object get(int index) {

        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }

        return values[index];
    }

    /**
     * O(n)
     * Retrieve the index of an object in array
     * @param item object for with index should be found
     * @return index
     */
    public int indexOf(Object item) {

        for (int i = 0; i < size; i++) {

            Object object = values[i];

            if (item.equals(object)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Get the size of the array
     * @return
     */
    public int length() {
        return size;
    }

    /**
     * Check if array is empty
     * @return
     */
    public boolean isEmpty() {
        return length() == 0;
    }

    @Override
    public String toString() {

        StringBuilder asString = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            asString.append(values[i].toString() + ",");
        }

        asString.append("]");

        return asString.toString();
    }



}
