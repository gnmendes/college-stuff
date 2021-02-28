package model;

public class Node {
	private Node next;
	private char data;
	
	public Node(char data) {
		this.data = data;
		this.next = null;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}
}
