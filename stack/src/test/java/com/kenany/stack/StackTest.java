package com.kenany.stack;

import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.*;

public class StackTest {

    Stack<String> stack;
    String[] decimalBasis;
    String data;

    @Before
    public void setUp() throws Exception {
        stack = new Stack<>();
        data = UUID.randomUUID().toString();
        decimalBasis = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    }

    @Test
    public void constructors() {

        stack = new Stack<>();

        assertTrue("The stack is empty", stack.isEmpty());

        stack = new Stack<>(data);

        assertTrue("The stack isn't empty", !stack.isEmpty());
    }

    @Test
    public void push() {

        assertTrue("The stack is empty", stack.isEmpty());

        stack.push(data);

        assertTrue("The stack isn't empty", !stack.isEmpty());

        assertEquals("The stack size equals to 1", stack.size(), 1);

        int oldSize = stack.size();

        for (String item : decimalBasis) {
            stack.push(item);
        }

        int newSize = stack.size();

        assertEquals("The stack size increased to length of array", newSize, oldSize + decimalBasis.length);
    }

    @Test
    public void pop() {

        assertTrue("The stack is empty", stack.isEmpty());

        assertThrows("Can't pop item from empty stack", EmptyStackException.class, () -> {
            stack.pop();
        });

        stack.push(data);

        assertTrue("The stack isn't empty", !stack.isEmpty());

        String removed = stack.pop();

        assertEquals("The removed item equals to the expected", removed, data);

        assertTrue("The stack back to empty", stack.isEmpty());

        for (String item : decimalBasis) {
            stack.push(item);
        }

        int expectedSize = decimalBasis.length;

        int size = stack.size();

        assertEquals("The stack size equals to the expected size", size, expectedSize);

        // The lastest added
        stack.push(data);

        // Stack size increase
        size = stack.size();

        removed = stack.pop();

        int newSize = stack.size();

        assertEquals("The removed item equals to expected", removed, data);

        assertEquals("The last item was removed so the size decreased", newSize, size - 1);

        String lastItem = decimalBasis[decimalBasis.length - 1];

        size = newSize;

        removed = stack.pop();

        newSize = stack.size();

        assertEquals("The removed item equals to the expected", removed, lastItem);

        assertEquals("The size decreased", newSize, size - 1);

        int limit = ThreadLocalRandom.current().nextInt(1, stack.size() - 2);

        int expected = stack.size() - limit;

        for (int i = 0; i < limit; i++) {
            stack.pop();
        }

        size = stack.size();

        assertEquals("The size equals to the expected", size, expected);
    }

    @Test
    public void peek() {

        assertTrue("The stack is empty", stack.isEmpty());

        assertThrows("Can't peek item from an empty stack", EmptyStackException.class, () -> {
           stack.peek();
        });

        stack.push(data);

        int size = stack.size();

        String retrieved = stack.peek();

        int newSize = stack.size();

        assertEquals("The retrieved item equals to the expected", retrieved, data);

        assertEquals("The stack size hasn't changed", newSize, size);

        for (String item : decimalBasis) {
            stack.push(item);
        }

        int limit = ThreadLocalRandom.current().nextInt(1, stack.size() - 2);

        int expected = stack.size();

        for (int i = 0; i < limit; i++) {
            stack.peek();
        }

        size = stack.size();

        assertEquals("The stack size hasn't changed", size, expected);
    }

    @Test
    public void size() {

        int size = stack.size();

        assertEquals("The stack size is zero", size, 0);

        stack.push(data);

        int newSize = stack.size();

        assertEquals("The stack has increased", newSize, size + 1);

        size = newSize;

        for (String item : decimalBasis) {
            stack.push(item);
        }
         newSize = stack.size();

        assertEquals("The stack size increased of the number of new added items", newSize, size + decimalBasis.length);
    }

    @Test
    public void isEmpty() {

        assertTrue("The stack is empty", stack.isEmpty());

        stack.push(data);

        assertFalse("The stack isn't empty", stack.isEmpty());

        stack.pop();

        assertTrue("The stack back to empty", stack.isEmpty());
    }
}
