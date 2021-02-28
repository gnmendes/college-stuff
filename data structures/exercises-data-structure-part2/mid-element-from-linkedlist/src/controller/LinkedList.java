package controller;

import model.Node;

public class LinkedList {
	private Node head;
	private int size;

	public LinkedList() {
		head = null;
		size = 0;
	}

	public boolean isEmpty() {
		return this.head == null;
	}

	public void add(int data) {
		Node node = new Node(data);
		if (isEmpty()) {
			head = node;
			this.size++;
			return;
		}

		Node current = head;
		while (current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(node);
		this.size++;
	}

	public Node getHead() {
		return this.head;
	}

	public void remove(int data) {
		Node curr = head;
		Node anti = head;

		while (curr.getData() != data) {
			anti = curr;
			curr = curr.getNext();
		}
		anti.setNext(curr.getNext());
		this.size--;
	}

	public int getSize() {
		return size;
	}

	public void print(Node current) {
		StringBuffer sb = new StringBuffer("[");

		while (current != null) {
			if (current.getNext() == null)
				sb.append(current.getData() + "]");
			else
				sb.append(current.getData() + " ");

			current = current.getNext();
		}

		System.out.println(sb.toString());
	}

	public void print() {
		Node current = head;
		StringBuffer sb = new StringBuffer("[");

		while (current != null) {
			if (current.getNext() == null)
				sb.append(current.getData() + "]");
			else
				sb.append(current.getData() + " ");

			current = current.getNext();
		}

		System.out.println(sb.toString());
	}
}