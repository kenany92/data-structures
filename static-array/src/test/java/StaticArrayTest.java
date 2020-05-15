import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StaticArrayTest {

    StaticArray staticArray;

    @Before
    public void setUp() throws Exception {

        staticArray = new StaticArray();
        staticArray.add("test");
    }

    @Test
    public void add() {
        String str = "aaa";
        int size = staticArray.length();
        staticArray.add(str);
        int newSize = staticArray.length();

        assertEquals("After adding item, the new size is greater than the previous", newSize, size + 1);

        for (int i = 0; i < 14; i++) {
            staticArray.add(""+i);
        }

        size = staticArray.length();

        assertEquals("The current length of array is 16", size, 16);

        assertThrows("The max default size of array is 16 so you can't add more thing", IndexOutOfBoundsException.class, () -> {
            staticArray.add("should throw exception");
        });

    }

    @Test
    public void update() {

        String oldValue = (String) staticArray.get(0);
        String newValue = "new_value";
        staticArray.update(newValue, 0);
        String updatedValue = (String) staticArray.get(0);

        assertNotSame("New value should be different to the old", newValue, oldValue);
        assertSame("New value is equals to the updated value", newValue, updatedValue);

        assertThrows("You can't update an unexisting item", IndexOutOfBoundsException.class, () -> {
            staticArray.update("unexisting", 8);
        });

    }

    @Test
    public void delete() {

        int oldSize = staticArray.length();
        staticArray.delete(0);
        int newSize = staticArray.length();

        assertEquals("After delete, old size is greater than the new size", oldSize, newSize + 1);

        assertThrows("You can't delete an unexisting item", IndexOutOfBoundsException.class, () -> {
            staticArray.delete(8);
        });
    }

    @Test
    public void get() {

        String item = "last";
        staticArray.add(item);
        int size = staticArray.length();
        String retrieved = (String) staticArray.get(size - 1);

        assertNotNull("The retrieved item exists", retrieved);

        assertEquals("The retrieved item equals to the added item", retrieved, item);

        assertThrows("You can't get an unexisting item", IndexOutOfBoundsException.class, () -> {
            staticArray.get(6);
        });
    }

    @Test
    public void indexOf() {

        String item = "to_find";
        staticArray.add(item);
        int index = staticArray.indexOf(item);
        int unexistingIndex = staticArray.indexOf("unexisting_index");
        String retrieved = (String) staticArray.get(index);

        assertEquals("The index of 'unexisting_index' doesn't exists", unexistingIndex, -1);
        assertNotEquals("The index of item exists", index, -1);
        assertEquals("The retrieved item by index equals to the item used to the this given index", retrieved, item);
    }

}