package com.kenany.dynamicarray;

import com.kenany.dynamicarray.DynamicArray;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DynamicArrayTest {

    DynamicArray dynamicArray;
    DynamicArray dynamicArray2;
    Character[] characters;

    @Before
    public void setUp() throws Exception {
        dynamicArray = new DynamicArray();
        dynamicArray2 = new DynamicArray();
        dynamicArray2.add("foo");

        characters = new Character[97];

        for (int i = 0; i < 97; i++) {
            char toAdd = (char)(' ' + i);
            characters[i] = toAdd;
        }
    }

    @Test
    public void length() {
        int firstSize = dynamicArray.length();

        assertEquals("The first Dynamic array size equals to 0", firstSize, 0);

        int secondSize = dynamicArray2.length();

        assertEquals("The second Dynamic array size equals to 1", secondSize, 1);
    }

    @Test
    public void isEmpty() {

        assertTrue("The ffirst Dynamic array is empty", dynamicArray.isEmpty());

        assertFalse("The second Dynamic array isn't empty", dynamicArray2.isEmpty());
    }

    @Test
    public void add() {
        int size = dynamicArray.length();
        dynamicArray.add("foo");
        int newSize = dynamicArray.length();

        assertEquals("The new size equals to the first size increased to 1", newSize, size + 1);

        for (int i = 0; i < 15; i++) {
            dynamicArray.add("" + i);
        }

        size = dynamicArray.length();

        assertEquals("The size of dynamic array equals to 16", size, 16);
    }

    // Add array
    @Test
    public void testAdd() {

        int size = dynamicArray.length();

        int arraySize = characters.length;

        dynamicArray.add(characters);

        int newSize = dynamicArray.length();

        assertEquals("The dynamic array size has increased of size of array", newSize, size + arraySize);
    }

    @Test
    public void get() {

        String foo = "foo";

        boolean isEmpty = dynamicArray.isEmpty();

        assertTrue("The dynamic array is empty", isEmpty);

        assertThrows("Cannot get item from empty dynamic array; should throw exception", IndexOutOfBoundsException.class, () -> {
            dynamicArray.get(0);
        });

        final int testIndex = 1;
        int index = 31;

        dynamicArray.add(foo);

        String item = (String)dynamicArray.get(0);

        int size = dynamicArray.length();

        assertEquals("The retrieved item equals to the added item", item, foo);

        assertEquals("Index equals to size of dynamic array", testIndex, size);

        assertThrows("Cannot get item whose the position is greater or equals than the Dynamic array size; should throw exception", IndexOutOfBoundsException.class, () -> {
            dynamicArray.get(testIndex);
        });

        dynamicArray.add(characters);

        Character retrieved = (Character)dynamicArray.get(index);

        Character expected = characters[index - 1];

        assertEquals("The retrieved item equals to expected item", retrieved, expected);

        size = dynamicArray.length();

        final int newIndex = size + 10;

        assertThrows("Cannot get item whose the position is greater or equals than the Dynamic array size; should throw exception", IndexOutOfBoundsException.class, () -> {
            dynamicArray.get(newIndex);
        });
    }

    @Test
    public void update() {

        String toAdd = "foo";
        final String toUpdate = "bar";

        dynamicArray.add(toAdd);

        String retrieved = (String)dynamicArray.get(0);

        assertEquals("The retrieved item equals to added item", retrieved, toAdd);

        dynamicArray.update(0, toUpdate);

        retrieved = (String)dynamicArray.get(0);

        assertEquals("The retrieved item equals to item used for update", retrieved, toUpdate);

        assertThrows("Cannot update item with unexisting index; should throw exception", IndexOutOfBoundsException.class, () -> {
            dynamicArray.update(5, toUpdate);
        });
    }

    @Test
    public void delete() {

        assertThrows("Cannot delete item on an empty Dynamic array; should throw exception", IndexOutOfBoundsException.class, () -> {
            dynamicArray.delete(0);
        });

        String foo = "foo";

        int index = 0;

        dynamicArray.add(foo);
        dynamicArray.add(characters);

        int sizeBeforeDelete = dynamicArray.length();

        String retrievedItem = (String) dynamicArray.get(index);

        String deleted = (String)dynamicArray.delete(index);

        int sizeAfterDelete = dynamicArray.length();

        assertEquals("The Dynamic array size before delete equals to its size after delete + 1", sizeBeforeDelete, sizeAfterDelete + 1);

        assertEquals("The deleted item equals to retrieved item at the same index", deleted, retrievedItem);
    }

    @Test
    public void indexOf() {

        String foo = "foo";
        String bar = "bar";

        dynamicArray.add(characters);
        dynamicArray.add(foo);

        int index = dynamicArray.indexOf(foo);

        assertTrue("The retrieved index exists, that means it is a positive value", index > -1);

        String retrived = (String)dynamicArray.get(index);

        assertSame("The item retrieved at the index is same to item used to get this given index", retrived, foo);

        index = dynamicArray.indexOf(bar);

        assertEquals("This item doesn't exists so the returned index equals to -1", index, -1);
    }

    @Test
    public void clear() {

        dynamicArray.add(characters);

        assertFalse("The Dynamic array it isn't empty", dynamicArray.isEmpty());

        dynamicArray.clear();

        assertTrue("The Dynamic array becomes empty", dynamicArray.isEmpty());
    }

    @Test
    public void seek() {

        dynamicArray.add(characters);

        dynamicArray2.clear();

        int start = 10;
        int end = 20;
        final int size = dynamicArray.length();

        assertThrows("The start position can't be greater than the end position", IllegalArgumentException.class, () -> {
            int begin = 30;
            int stop = 10;

            dynamicArray.seek(begin, stop);
        });

        assertThrows("The start position can't be less than 0", IndexOutOfBoundsException.class, () -> {
            dynamicArray.seek(-1, 20);
        });

        assertThrows("The end position can't be greater or equals than the Dynamic array size", IndexOutOfBoundsException.class, () -> {
            dynamicArray.seek(10, size);
        });

        dynamicArray2 = dynamicArray.seek(start, end);

        int limit = end - start + 1;

        assertEquals("The new dynamic array size equals to end - start + 1", dynamicArray2.length(), limit);

        for (int i = 0; i < limit; i++) {
            assertEquals("The retrieved items from differents Dynamic arrays are equals", dynamicArray2.get(i), dynamicArray.get(start + i));
        }
    }

}