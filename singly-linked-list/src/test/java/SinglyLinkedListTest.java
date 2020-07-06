import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.*;

public class SinglyLinkedListTest {

    SinglyLinkedList<String> singlyLinkedList;
    SinglyLinkedList<String> singlyLinkedList2;
    String[] decimalBasis;

    @Before
    public void setUp() throws Exception {

        singlyLinkedList = new SinglyLinkedList<>();

        singlyLinkedList2 = new SinglyLinkedList<>();

        singlyLinkedList2.add("foo");

        decimalBasis = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    }

    @Test
    public void isEmpty() {

        assertTrue("The singly linked list is empty", singlyLinkedList.isEmpty());

        assertFalse("The singly linked list idn't empty", singlyLinkedList2.isEmpty());
    }

    @Test
    public void size() {

        assertEquals("The singly linked list size equals to 0", singlyLinkedList.size(), 0);

        assertEquals("The singly linked list size equals to 0", singlyLinkedList2.size(), 1);
    }

    @Test
    public void add() {

        String foo = "foo";

        assertTrue("The Singly linked list is empty", singlyLinkedList.isEmpty());

        singlyLinkedList.add(foo);

        assertFalse("The singly linked list isn't empty", singlyLinkedList.isEmpty());
    }

    @Test
    public void get() {

        assertTrue("List is empty", singlyLinkedList.isEmpty());

        assertThrows("Can't get item from empty singly linked list", RuntimeException.class, () -> {
            singlyLinkedList.get(1);
        });

        for (int i = 0; i < decimalBasis.length; i++) {

            singlyLinkedList.add(decimalBasis[i]);
        }

        assertFalse("List isn't empty", singlyLinkedList.isEmpty());

        assertThrows("The list index start at 1", IllegalArgumentException.class, () -> {
            singlyLinkedList.get(0);
        });

        int index = 0;

        assertEquals("The first item in the list equals to the first item in the array used to fill the list", singlyLinkedList.get(index + 1), decimalBasis[index]);

        for (int i = 0; i < singlyLinkedList.size(); i++) {

            assertEquals("When same index is used in the list and in the array used to fill the list, the retrieved item is the same", singlyLinkedList.get(i + 1), decimalBasis[i]);
        }
    }

    @Test
    public void peekFirst() {

        assertTrue("List is empty", singlyLinkedList.isEmpty());

        assertThrows("Can't peek item from empty singly linked list", RuntimeException.class, () -> {
            singlyLinkedList.peekFirst();
        });

        for (int i = 0; i < decimalBasis.length; i++) {

            singlyLinkedList.add(decimalBasis[i]);
        }

        assertFalse("List isn't empty", singlyLinkedList.isEmpty());

        String expected = singlyLinkedList.get(1);

        String item = singlyLinkedList.peekFirst();

        assertEquals("The peekfirst method return the first item of singly linked list", item, expected);
    }

    @Test
    public void peekLast() {

        assertTrue("List is empty", singlyLinkedList.isEmpty());

        assertThrows("Can't peek item from empty singly linked list", RuntimeException.class, () -> {
            singlyLinkedList.peekLast();
        });

        for (int i = 0; i < decimalBasis.length; i++) {

            singlyLinkedList.add(decimalBasis[i]);
        }

        assertFalse("List isn't empty", singlyLinkedList.isEmpty());

        int index = singlyLinkedList.size();

        String expected = singlyLinkedList.get(index);

        String item = singlyLinkedList.peekLast();

        assertEquals("The peeklast method return the last item of singly linked list", item, expected);
    }

    @Test
    public void addFirst() {

        String foo = "foo";

        for (int i = 0; i < decimalBasis.length; i++) {

            singlyLinkedList.add(decimalBasis[i]);
        }

        assertFalse("The list isn't empty", singlyLinkedList.isEmpty());

        int size = singlyLinkedList.size();

        String first = singlyLinkedList.peekFirst();

        assertNotEquals("The first item is different to our string", first, foo);

        singlyLinkedList.addFirst(foo);

        first = singlyLinkedList.peekFirst();

        assertEquals("After adding the new item, the List size has been increased to one", singlyLinkedList.size(), size + 1);

        assertEquals("Now the first item equals to the string used as parameter of addfirst method", first, foo);
    }

    @Test
    public void addLast() {

        String foo = "foo";

        for (int i = 0; i < decimalBasis.length; i++) {

            singlyLinkedList.add(decimalBasis[i]);
        }

        assertFalse("The list isn't empty", singlyLinkedList.isEmpty());

        int size = singlyLinkedList.size();

        String last = singlyLinkedList.peekLast();

        assertNotEquals("The last item is different to our string", last, foo);

        singlyLinkedList.addLast(foo);

        last = singlyLinkedList.peekLast();

        assertEquals("After adding the new item, the List size has been increased to one", singlyLinkedList.size(), size + 1);

        assertEquals("Now the last item equals to the string used as parameter of addlast method", last, foo);
    }

    @Test
    public void addItem() {

        String foo = "foo";

        final String bar = "bar";

        for (int i = 0; i < decimalBasis.length; i++) {

            singlyLinkedList.add(decimalBasis[i]);
        }

        assertFalse("The list isn't empty", singlyLinkedList.isEmpty());

        int size = singlyLinkedList.size();

        int index = 5;

        assertNotEquals("The item at the given index is different to our string", singlyLinkedList.get(index), foo);

        // I'm going to add the string foo in the list at the position 5
        singlyLinkedList.addItem(index, foo);

        String item = singlyLinkedList.get(index);

        assertEquals("After adding the new item, the List size has been increased to one", singlyLinkedList.size(), size + 1);

        assertEquals("Now the item present at the given index equals to the item used as parameter in additem method", item, foo);

        assertThrows("You can't add item at position which is less than 1", IllegalArgumentException.class, () -> {
            singlyLinkedList.addItem(0, bar);
        });

        assertThrows("You can't add item at the position which is greater than the size of list", IndexOutOfBoundsException.class, () -> {
            int out = singlyLinkedList.size() + 1;
            singlyLinkedList.addItem(out, bar);
        });
    }

    @Test
    public void pop() {

        assertTrue("The list is empty", singlyLinkedList.isEmpty());

        assertThrows("You can't remove item from empty list", RuntimeException.class, () -> {
            singlyLinkedList.pop();
        });

        for (int i = 0; i < decimalBasis.length; i++) {

            singlyLinkedList.add(decimalBasis[i]);
        }

        assertFalse("The list isn't empty", singlyLinkedList.isEmpty());

        int size = singlyLinkedList.size();

        String expected = singlyLinkedList.peekFirst();

        String removed = singlyLinkedList.pop();

        assertEquals("After the pop method, the size of list is decreased", singlyLinkedList.size(), size - 1);

        assertEquals("The removed item equals to item which was at the first position", removed, expected);
    }

    @Test
    public void shift() {

        assertTrue("The list is empty", singlyLinkedList.isEmpty());

        assertThrows("You can't remove item from empty list", RuntimeException.class, () -> {
            singlyLinkedList.shift();
        });

        for (int i = 0; i < decimalBasis.length; i++) {

            singlyLinkedList.add(decimalBasis[i]);
        }

        assertFalse("The list isn't empty", singlyLinkedList.isEmpty());

        int size = singlyLinkedList.size();

        String expected = singlyLinkedList.peekLast();

        String removed = singlyLinkedList.shift();

        assertEquals("After the pop method, the size of list is decreased", singlyLinkedList.size(), size - 1);

        assertEquals("The removed item equals to item which was at the last position", removed, expected);
    }

    @Test
    public void remove() {

        assertTrue("The list is empty", singlyLinkedList.isEmpty());

        assertThrows("You can't remove item from an empty list", IndexOutOfBoundsException.class, () -> {
            singlyLinkedList.remove(1);
        });

        String foo = "foo";

        for (int i = 0; i < decimalBasis.length; i++) {

            singlyLinkedList.add(decimalBasis[i]);
        }

        assertFalse("The list isn't empty", singlyLinkedList.isEmpty());

        int size = singlyLinkedList.size();

        assertThrows("Remember that index in list starts at 1", IllegalArgumentException.class, () -> {
            singlyLinkedList.remove(0);
        });

        int ramdomIndex = ThreadLocalRandom.current().nextInt(1, singlyLinkedList.size());

        String expected = singlyLinkedList.get(ramdomIndex);

        String removed = singlyLinkedList.remove(ramdomIndex);

        assertEquals("After removing an item, the size of list decreased", singlyLinkedList.size(), size - 1);

        assertSame("The removed item is the same to the item which was at the same position", removed, expected);

        int index = 3;
        expected = singlyLinkedList.get(index);

        removed = singlyLinkedList.remove(index);

        assertSame("Removed item equals to expected", removed, expected);
    }

    @Test
    public void clear() {

        assertTrue("List is empty", singlyLinkedList.isEmpty());

        for (int i = 0; i < decimalBasis.length; i++) {

            singlyLinkedList.add(decimalBasis[i]);
        }

        assertFalse("List isn't empty", singlyLinkedList.isEmpty());

        singlyLinkedList.clear();

        assertTrue("List becomes empty", singlyLinkedList.isEmpty());
    }

    @Test
    public void update() {

        assertTrue("List is empty", singlyLinkedList.isEmpty());

        assertThrows("Can't update item from empty list", IndexOutOfBoundsException.class, () -> {
            singlyLinkedList.update(1, "foo");
        });

        String foo = "foo";

        for (int i = 0; i < decimalBasis.length; i++) {

            singlyLinkedList.add(decimalBasis[i]);
        }

        assertFalse("List isn't empty", singlyLinkedList.isEmpty());

        assertThrows("Remember that index starts at 1 so, you can't update item at position 0", IllegalArgumentException.class, () -> {
            singlyLinkedList.update(0, "foo");
        });

        assertThrows("You can't update item at index which is greater than list size", IndexOutOfBoundsException.class, () -> {
            int out = singlyLinkedList.size() + 1;
            singlyLinkedList.update(out, "foo");
        });

        int ramdomIndex = ThreadLocalRandom.current().nextInt(1, singlyLinkedList.size());

        String retrieved = singlyLinkedList.get(ramdomIndex);

        assertNotEquals("The retrieved item is different to our string", retrieved, foo);

        singlyLinkedList.update(ramdomIndex, foo);

        retrieved = singlyLinkedList.get(ramdomIndex);

        assertEquals("The retrieved item equals to item used for update", retrieved, foo);
    }
}