package com.kenany.singlylinkedlist;

/**
 * Data Structures
 * Singly linked list (basics operations implementation)
 * @author kenany (armelknyobe@gmail.com)
 *
 */
public class SinglyLinkedList<T> {

	private Node<T> head;
	private Node<T> tail;
	
	private int size = 0;
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	/**
	 * O(1)
	 * Add Item as the first list items
	 * @param data
	 */
	public void addFirst(T data) {
		
		Node<T> node = new Node<T>(data, null);
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
	 * Add Item as the last list items
	 * @param data
	 */
	public void addLast(T data) {
		
		Node<T> node = new Node<T>(data, null);
		
		if (isEmpty()) {
			tail = head = node;
		} else {
			tail.next = node;
			tail = node;
		}
		size++;
	}
	
	/**
	 * O(1)
	 * Add item at the end of the list
	 * @param data
	 */
	public void add(T data) {
		addLast(data);
	}
	
	/**
	 * O(n) n = index - 2
	 * Add item at the specific position
	 * @param index position
	 * @param data item to add
	 */
	public void addItem(int index, T data) {
		
		if (index > size) {
			throw new IndexOutOfBoundsException();
		}
		
		if (index < 1) {
			throw new IllegalArgumentException("Index starts at 1");
		}
		
		if (index == 1) {
			addFirst(data);
			return;
		}
		
		if (index == size()) {
			addLast(data);
			return;
		}
		
		Node<T> node = new Node<T>(data, null);
		Node<T> previous = head;
		Node<T> atIndex = previous.next;
						
		for (int i = 2; i < index; i++) {
			previous = previous.next;
			atIndex = previous.next;
		}
		
		node.next = atIndex;
		previous.next = node;
		
		size++;
	}
	
	/**
	 * O(1)
	 * Remove the first item of the list
	 * @return the removed item
	 */
	public T pop() {

		if (isEmpty()) {
			throw new RuntimeException("Cannot remove item from empty list");
		}
		
		Node<T> toRemove = head;
		head = head.next;
		size--;
		toRemove.next = null;
		
		return toRemove.data;
	}
	
	/**
	 * O(n) n = size
	 * Remove the last item of the table
	 * @return The removed item
	 */
	public T shift() {

		if (isEmpty()) {
			throw new RuntimeException("Cannot remove item from empty list");
		}

		Node<T> toRemove = tail;
		Node<T> beforeTail = head;
		Node<T> last = beforeTail.next;
		
		while (last.next != null) {
			beforeTail = beforeTail.next;
			last = beforeTail.next;
		}
		
		beforeTail.next = null;
		tail = beforeTail;
		size--;
		toRemove.next = null;
		
		return toRemove.data;
	}
	
	/**
	 * O(n) n = index - 2
	 * Remove item at the specified position
	 * @param index position
	 * @return the removed item
	 */
	public T remove(int index) {

		if (index > size) {
			throw new IndexOutOfBoundsException();
		}

		if (index < 1) {
			throw new IllegalArgumentException("Index starts at 1");
		}
		
		Node<T> previous = head;
		Node<T> toRemove = previous.next;
		Node<T> nextNode = toRemove.next;
		
		if (index == 1) {
			return pop();
		}
		
		if (index == size) {
			return shift();
		}
				
		for (int i = 2; i < index; i++) {
			
			previous = previous.next;
			toRemove = previous.next;
			nextNode = toRemove.next;
		}
		
		previous.next = nextNode;
		toRemove.next = null;
		
		size--;
		
		return toRemove.data;
		
	}
	
	/**
	 * O(n) n = size
	 * Empty the list
	 */
	public void clear() {
		
		Node<T> trav = head;
		
		while (trav != null) {
			Node<T> next = trav.next;
			trav.data = null;
			trav.next = null;
			trav = next;
		}
		
		head = tail = trav = null;
		size = 0;
	}
	
	/**
	 * O(1)
	 * Get the first item of the list
	 * @return
	 */
	public T peekFirst() {
		
		if (isEmpty()) {
			throw new RuntimeException("Empty");
		}
		
		return head.data;
	}
	
	/**
	 * O(1)
	 * Get the last item of the list
	 * @return
	 */
	public T peekLast() {
		
		if(isEmpty()) {
			throw new RuntimeException("Empty");
		}
		
		return tail.data;
	}
	
	/**
	 * O(n)
	 * Retrieve item at the provided position
	 * @param index the position
	 * @return
	 */
	public T get(int index) {
		
		Node<T> node = find(index);
		
		return node.data;
	}
	
	/**
	 * O(n)
	 * Update item at the provided position
	 * @param index the position
	 * @param data to update
	 * @return
	 */
	public T update(int index, T data) {
		
		Node<T> node = find(index);
		
		node.data = data;
		
		return node.data;
	}
	
	/**
	 * O(n) n = index - 1
	 * Find item in the list from the provided index
	 * @param index
	 * @return
	 */
	private Node<T> find(int index) {
		
		if (index > size()) {
			throw new IndexOutOfBoundsException();
		}
		
		if (index < 1) {
			throw new IllegalArgumentException("The list indexes start at 1");
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
