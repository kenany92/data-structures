package com.kenany.dynamicarray;

/**
 * Data Structures
 * Dynamic Array (basics operations implementation)
 * @author kenany (armelknyobe@gmail.com)
 *
 */
public class DynamicArray {

	private static final int INITIAL_CAPACITY = 16;
	// The number of existing items
	private int size = 0;
	// The number of items the dynamic array can contains
	private int capacity;
	
	private Object values[];
	
	
	public DynamicArray() {
		this.capacity = INITIAL_CAPACITY;
		this.values = new Object[this.capacity];
	}
	
	public int length() {
		return size;
	}
	
	public boolean isEmpty() {
		return length() == 0;
	}
	
	/**
	 * O(n)
	 * Add item to the dynamic array
	 * @param value item to add
	 * @return true
	 */
	public boolean add(Object value) {
		
		if (size == capacity) {
			capacity *= 2;
			Object twice[] = new Object[capacity];
			
			for (int i = 0; i < size; i++) {
				twice[i] = values[i];
			}
			
			values = twice;
		}
		
		values[size++] = value;
		
		return true;
		
	}
	
	/**
	 * O(n*m) n = size of dynamic, m = size of array to add
	 * Add many items to the dynamic array
	 * @param array Array to items to add
	 * @return true
	 */
	public boolean add(Object array[]) {
		
		for (Object object : array) {
			add(object);
		}
		
		return true;
	}
	
	/**
	 * O(1)
	 * Retrieve item from index in dynamic array; 
	 * Throw IndexOutOfBoundsException if dynamic array size is less or equal than the provided index
	 * @param index
	 * @return
	 */
	public Object get(int index) {
		
		if (index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		return values[index];
	}
	
	/**
	 * O(1)
	 * Update item if it exists in dynamic array; 
	 * Throw IndexOutOfBoundsException if dynamic array size is less or equal than the provided index
	 * @param index Index of item to update
	 * @param value The new value
	 * @return true or throw IndexOutOfBoundsException
	 */
	public boolean update(int index, Object value) {
		
		if (index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		values[index] = value;
		
		return true;
	}
	
	/**
	 * O(n)
	 * Delete item if it exists in dynamic array; 
	 * Throw IndexOutOfBoundsException if dynamic array size is less or equal than the provided index
	 * @param index Index of item to delete
	 * @return the deleted item or throw IndexOutOfBoundsException
	 */
	public Object delete(int index) {
		
		if (index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		Object value = values[index];
		
		Object newArray[] = new Object[capacity];
		
		int j = 0;
		
		for (int i = 0; i < size; i++) {
			
			if (i != index) {
				newArray[j] = values[i];
				j++;
			}
		}
		
		values = newArray;
		size--;
		
		return value;
	}
	
	/**
	 * O(n)
	 * Retrieve index of the given value
	 * @param value Value for which we find the index
	 * @return the value's index or -1 if It doesn't exists
	 */
	public int indexOf(Object value) {
		
		for (int i = 0; i < size; i++) {
			
			if (values[i].equals(value)) {
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * Remove all items from dynamic array
	 */
	public void clear() {
		capacity = INITIAL_CAPACITY;
		values = new Object[capacity];
		size = 0;
	}
	
	/**
	 * O(n) n = end - start + 1
	 * Seek the dynamic array from start index to end index
	 * Throw IllegalArgumentException if start index is greater than end index
	 * Throw IndexOutOfBoundsException if start index is less than 0 or end index is greater than dynamic array size
	 * @param start Index to start
	 * @param end Index to end (It is really end - 1)
	 * @return new dynamic array containing items coming from this one taken at start index to end index
	 */
	public DynamicArray seek(int start, int end) {
		
		if (end < start) {
			throw new IllegalArgumentException("the start index can't be greater than end index");
		}
		
		if (start < 0 || end >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		Object part[] = new Object[end - start + 1];
		int index = 0;
		
		for (int i = start; i <= end; i++) {
			part[index++] = values[i];
		}
		
		DynamicArray seeker = new DynamicArray();
		
		seeker.add(part);
		
		return seeker;
	}
	
	/**
	 * O(n) n = size - start
	 * Seek this dynamic array from start index to the last item
	 * @param start Index to start
	 * @return new dynamic array containing items comming from this one taken at start index to the last item
	 */
	public DynamicArray subList(int start) {
		
		if (start >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		return seek(start, size -1);
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
