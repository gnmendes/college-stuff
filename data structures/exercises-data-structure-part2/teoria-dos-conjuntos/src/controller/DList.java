package controller;

import model.Node;

public class DList {
	protected Node head;
	protected Node tail;
	protected int size;

	public DList() {
		tail = head = null;
		size = 0;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void add(int data) {
		if (isEmpty()) {
			head = tail = new Node(data);
			return;
		} else {
			Node g = new Node(data);
			g.setPrev(tail);
			tail.setNext(g);
			tail = g;
		}
		size++;
	}

	public void add(int data, int xy) {
		if (isEmpty() || xy >= this.size)
			add(data);

		Node curr = head, node = new Node(data);

		for (int i = 1; i < xy - 2; i++)
			curr = curr.getNext();

		curr.getNext().setPrev(node);
		node.setNext(curr.getNext());
		node.setPrev(curr);
		curr.setNext(node);
	}

	public void print() {
		Node current = head;
		StringBuffer sb = new StringBuffer("[");
		if(current == null) {
			sb.append(" ]");
			System.out.println(sb.toString());
			return;
		}

		while (current != null) {
			if (current.getNext() == null)
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

	public Node getHead() {
		return this.head;
	}
}
