package controller;

public class Node {

	private int element;
	private Node next;

	public Node(int element, Node next) {
		this.element = element;
		this.next = next;
	}

	public Node(int element) {
		this(element, null);
	}

	public Node getNext() {
		return this.next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public void setElement(int element) {
		this.element = element;
	}

	public int getElement() {
		return this.element;
	}

}
