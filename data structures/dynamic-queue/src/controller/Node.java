package controller;

public class Node {
	private Node next;
	private int element;
	
	public Node(Node first, int element) {
		
		this.next = first;
		this.element = element;
	}
	
	public Node(int element) {
		this(null, element);
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	public int getElement() {
		return element;
	}

	public void setElement(int element) {
		this.element = element;
	}
}
