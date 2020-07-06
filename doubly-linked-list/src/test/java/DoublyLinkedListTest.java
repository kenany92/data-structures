import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.*;

public class DoublyLinkedListTest {

    DoublyLinkedList<String> doubliLinkedList;
    DoublyLinkedList<String> doubliLinkedList2;
    String[] decimalBasis;

    @Before
    public void setUp() throws Exception {

        doubliLinkedList = new DoublyLinkedList<>();
        doubliLinkedList2 = new DoublyLinkedList<>();

        doubliLinkedList2.add("foo");

        decimalBasis = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    }

    @Test
    public void isEmpty() {
        assertTrue("The doubly linked list is empty", doubliLinkedList.isEmpty());

        assertFalse("The doubly linked list idn't empty", doubliLinkedList2.isEmpty());
    }

    @Test
    public void length() {
        assertEquals("The doubly linked list size equals to 0", doubliLinkedList.length(), 0);

        assertEquals("The doubly linked list size equals to 0", doubliLinkedList2.length(), 1);
    }

    @Test
    public void get() {

        assertTrue("The doubly linked list is empty", doubliLinkedList.isEmpty());

        assertThrows("Can't get item from empty doubly linked list", IndexOutOfBoundsException.class, () -> {
            doubliLinkedList.get(1);
        });

        assertFalse("The second doubly linked list isn't empty", doubliLinkedList2.isEmpty());

        assertThrows("Index start at 1", IllegalArgumentException.class, () -> {
            doubliLinkedList2.get(0);
        });

        int index = 1;

        String retrieved = doubliLinkedList2.get(index);

        assertNotNull("The retrieved item isn't null", retrieved);
    }

    @Test
    public void push() {

        String foo = "foo";

        assertTrue("The doubly linked list is empty", doubliLinkedList.isEmpty());

        int size = doubliLinkedList.length();

        doubliLinkedList.push(foo);

        int newSize = doubliLinkedList.length();

        assertFalse("The doubly linked list isn't empty", doubliLinkedList.isEmpty());

        assertTrue("The size of list increased to 1", newSize == size + 1);

        String bar = "bar";

        doubliLinkedList.push(bar);

        String retrieved = doubliLinkedList.get(1);

        assertEquals("The last pushed item is at the top of the list", retrieved, bar);

    }

    @Test
    public void unshift() {

        String foo = "foo";

        assertTrue("The doubly linked list is empty", doubliLinkedList.isEmpty());

        int size = doubliLinkedList.length();

        doubliLinkedList.push(foo);

        int newSize = doubliLinkedList.length();

        assertFalse("The doubly linked list isn't empty", doubliLinkedList.isEmpty());

        assertTrue("The size of list increased to 1", newSize == size + 1);

        String bar = "bar";

        doubliLinkedList.push(bar);

        int index = doubliLinkedList.length();

        String retrieved = doubliLinkedList.get(index);

        assertEquals("The last pushed item is at the end of the list", retrieved, foo);
    }

    @Test
    public void addItem() {

        String foo = "foo";

        assertTrue("The doubly linked list is empty", doubliLinkedList.isEmpty());

        assertThrows("Index start at 1", IllegalArgumentException.class, () -> {
            doubliLinkedList.addItem(0, "foo");
        });

        assertThrows("You can't add item at the index which is greater than the 1 + length of list", IndexOutOfBoundsException.class, () -> {
            int size = doubliLinkedList.length();
            doubliLinkedList.addItem(size + 2, "foo");
        });

        doubliLinkedList.addItem(1, foo);

        assertFalse("The doubly linked list isn't empty", doubliLinkedList.isEmpty());

        String expected = foo;

        String retrieved = doubliLinkedList.get(1);

        assertEquals("The eexpected item equals to the retrieved item", expected, retrieved);

        for (int i = 0; i < decimalBasis.length; i++) {
            doubliLinkedList.add(decimalBasis[i]);
        }

        int size = doubliLinkedList.length();

        int index = ThreadLocalRandom.current().nextInt(1, size);

        String bar = "bar";

        doubliLinkedList.addItem(index, bar);

        int newSize = doubliLinkedList.length();

        assertTrue("The size of the list increased to 1", newSize == size + 1);

        expected = bar;

        retrieved = doubliLinkedList.get(index);

        assertEquals("Expected item equals to retrieved item", expected, retrieved);
    }

    @Test
    public void peekFirst() {

        assertTrue("The doubly linked list is empty", doubliLinkedList.isEmpty());

        assertThrows("Can't peek item from empty list", RuntimeException.class, () -> {
            doubliLinkedList.peekFirst();
        });

        for (int i = 0; i < decimalBasis.length; i++) {
            doubliLinkedList.add(decimalBasis[i]);
        }

        assertFalse("The doubly linked list isn't list", doubliLinkedList.isEmpty());

        String expected = doubliLinkedList.get(1);

        String retrieved = doubliLinkedList.peekFirst();

        assertEquals("The expected item equals to the retrieved item", expected, retrieved);
    }

    @Test
    public void peekLast() {

        assertTrue("The doubly linked list is empty", doubliLinkedList.isEmpty());

        assertThrows("Can't peek item from empty list", RuntimeException.class, () -> {
            doubliLinkedList.peekLast();
        });

        for (int i = 0; i < decimalBasis.length; i++) {
            doubliLinkedList.add(decimalBasis[i]);
        }

        assertFalse("The doubly linked list isn't list", doubliLinkedList.isEmpty());

        int size = doubliLinkedList.length();

        String expected = doubliLinkedList.get(size);

        String retrieved = doubliLinkedList.peekLast();

        assertEquals("The expected item equals to the retrieved item", expected, retrieved);
    }

    @Test
    public void pop() {

        assertTrue("The doubly linked list is empty", doubliLinkedList.isEmpty());

        assertThrows("Can't remove item from empty list", RuntimeException.class, () -> {
            doubliLinkedList.pop();
        });

        for (int i = 0; i < decimalBasis.length; i++) {
            doubliLinkedList.add(decimalBasis[i]);
        }

        assertFalse("The doubly linked list isn't empty", doubliLinkedList.isEmpty());

        int size = doubliLinkedList.length();

        String expected = doubliLinkedList.peekFirst();

        String removed = doubliLinkedList.pop();

        int newSize = doubliLinkedList.length();

        assertTrue("The size of the list decreased to 1", newSize == size - 1);

        assertEquals("The removed item equals to the expected item", removed, expected);
    }

    @Test
    public void shift() {

        assertTrue("The doubly linked list is empty", doubliLinkedList.isEmpty());

        assertThrows("Can't remove item from empty list", RuntimeException.class, () -> {
            doubliLinkedList.shift();
        });

        for (int i = 0; i < decimalBasis.length; i++) {
            doubliLinkedList.add(decimalBasis[i]);
        }

        assertFalse("The doubly linked list isn't empty", doubliLinkedList.isEmpty());

        int size = doubliLinkedList.length();

        String expected = doubliLinkedList.peekLast();

        String removed = doubliLinkedList.shift();

        int newSize = doubliLinkedList.length();

        assertTrue("The size of the list decreased to 1", newSize == size - 1);

        assertEquals("The removed item equals to the expected item", removed, expected);
    }

    @Test
    public void remove() {

        assertTrue("The list is empty", doubliLinkedList.isEmpty());

        assertThrows("You can't remove item from an empty list", IndexOutOfBoundsException.class, () -> {
            doubliLinkedList.remove(1);
        });

        String foo = "foo";

        for (int i = 0; i < decimalBasis.length; i++) {

            doubliLinkedList.add(decimalBasis[i]);
        }

        assertFalse("The list isn't empty", doubliLinkedList.isEmpty());

        int size = doubliLinkedList.length();

        assertThrows("Remember that index in list starts at 1", IllegalArgumentException.class, () -> {
            doubliLinkedList.remove(0);
        });

        int ramdomIndex = ThreadLocalRandom.current().nextInt(1, size);

        String expected = doubliLinkedList.get(ramdomIndex);

        String removed = doubliLinkedList.remove(ramdomIndex);

        int newSize = doubliLinkedList.length();

        assertEquals("After removing an item, the size of list decreased", newSize, size - 1);

        assertSame("The removed item is the same to the item which was at the same position", removed, expected);

        int index = 3;

        expected = doubliLinkedList.get(index);

        removed = doubliLinkedList.remove(index);

        assertSame("Removed item equals to expected", removed, expected);
    }

    @Test
    public void clear() {

        assertTrue("List is empty", doubliLinkedList.isEmpty());

        for (int i = 0; i < decimalBasis.length; i++) {

            doubliLinkedList.add(decimalBasis[i]);
        }

        assertFalse("List isn't empty", doubliLinkedList.isEmpty());

        doubliLinkedList.clear();

        assertTrue("List becomes empty", doubliLinkedList.isEmpty());
    }

    @Test
    public void update() {

        assertTrue("List is empty", doubliLinkedList.isEmpty());

        assertThrows("Can't update item from empty list", IndexOutOfBoundsException.class, () -> {
            doubliLinkedList.update(1, "foo");
        });

        String foo = "foo";

        for (int i = 0; i < decimalBasis.length; i++) {

            doubliLinkedList.add(decimalBasis[i]);
        }

        assertFalse("List isn't empty", doubliLinkedList.isEmpty());

        assertThrows("Remember that index starts at 1 so, you can't update item at position 0", IllegalArgumentException.class, () -> {
            doubliLinkedList.update(0, "foo");
        });

        assertThrows("You can't update item at index which is greater than list size", IndexOutOfBoundsException.class, () -> {
            int out = doubliLinkedList.length() + 1;
            doubliLinkedList.update(out, "foo");
        });

        int ramdomIndex = ThreadLocalRandom.current().nextInt(1, doubliLinkedList.length());

        String retrieved = doubliLinkedList.get(ramdomIndex);

        assertNotEquals("The retrieved item is different to our string", retrieved, foo);

        doubliLinkedList.update(ramdomIndex, foo);

        retrieved = doubliLinkedList.get(ramdomIndex);

        assertEquals("The retrieved item equals to item used for update", retrieved, foo);
    }
}