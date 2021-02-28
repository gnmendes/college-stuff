package controller;

public class Node {
	
	private int element;
	private Node next;
	
	public Node(int element, Node next) {
	
		this.setElement(element);
		this.setNext(next);
		
	}
	
	public Node(int element) {
		this(element, null);
	}

	public int getElement() {
		return element;
	}

	public void setElement(int element) {
		this.element = element;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	

}
