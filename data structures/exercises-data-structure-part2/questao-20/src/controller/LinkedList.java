package controller;

import model.Node;

public class LinkedList {
	private Node head;
	private int size;
	private Node tail;

	public LinkedList() {
		tail = head = null;
		size = 0;
	}

	public boolean isEmpty() {
		return this.head == null;
	}

	public void add(int data) {
		Node node = new Node(data);
		node.setNext(head);
		if (isEmpty()) {
			tail = head = node;
			this.size++;
			return;
		}
		tail.setNext(node);
		tail = node;
		this.size++;
	}

	public Node getHead() {
		return this.head;
	}

	public int removeFirst() {
		Node removed = head;
		head = head.getNext();
		size--;
		return removed.getData();
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

	public void print() {
		Node current = head;
		StringBuffer sb = new StringBuffer("[");

		for (int i = 0; i < this.size; i++) {
			if (i + 1 == this.size)
				sb.append(current.getData() + "]");
			else
				sb.append(current.getData() + " ");

			current = current.getNext();
		}

		System.out.println(sb.toString());
	}

	public Node getTail() {
		return this.tail;
	}
}