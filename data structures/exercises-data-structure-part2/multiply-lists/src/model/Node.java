package model;

public class Node {
	private Node next;
	private Node previous;
	private int data;
	
	public Node(int data) {
		this.data = data;
		next = previous = null;
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

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}
