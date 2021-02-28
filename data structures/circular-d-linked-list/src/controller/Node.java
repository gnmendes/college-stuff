package controller;

public class Node {
	private Node next;
	private Node previous;
	private int element;

	public Node(Node next, Node previous, int element) {

		this.setNext(next);
		this.setPrevious(previous);
		this.setElement(element);
	}

	public Node(int element) {

		this(null, null, element);
	}

	public int getElement() {
		return element;
	}

	public void setElement(int element) {
		this.element = element;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}
