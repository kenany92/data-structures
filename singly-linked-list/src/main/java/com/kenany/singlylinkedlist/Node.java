package com.kenany.singlylinkedlist;

public class Node<T> {

	public T data;
	public Node<T> next;
	
	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
	
}
