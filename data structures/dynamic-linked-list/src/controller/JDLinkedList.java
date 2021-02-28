package controller;

import javax.swing.JOptionPane;

public class JDLinkedList {

	protected Node head;
	protected Node tail;
	protected int size;

	public JDLinkedList() {

		head = null;
		tail = null;
		size = 0;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public Node getFirst() throws UnderFlowException {

		if (isEmpty()) {
			throw new UnderFlowException();
		}

		return head;

	}

	public Node getLast() throws UnderFlowException {

		if (isEmpty()) {
			throw new UnderFlowException();
		}

		return tail;
	}

	public void insertFirst(Node element) {

		if (isEmpty()) {
			head = tail = element;

		} else {
			head.setPrevious(element);
			element.setNext(head);
			head = element;
		}

		size++;
	}

	public void insertLast(Node element) {

		if (isEmpty()) {
			insertFirst(element);
		} else {
			tail.setNext(element);
			element.setPrevious(tail);
			tail = element;
			size++;
		}
	}

	public Node removeLast() throws UnderFlowException {

		if (isEmpty()) {
			throw new UnderFlowException();
		}

		Node removedItem = tail;
		if (head == tail) {
			head = tail = null;
		} else {
			tail = tail.getPrevious();
			tail.setNext(null);
		}
		size--;
		return removedItem;
	}

	public Node removeFirst() throws UnderFlowException {

		if (isEmpty()) {
			throw new UnderFlowException();
		}
		Node removedItem = head;

		if (head == tail) {
			head = tail = null;
		} else {
			head = head.getNext();
			head.setPrevious(null);
		}
		size--;
		return removedItem;
	}

	public void show() {

		if (isEmpty()) {
			System.out.println("Lista vazia!");
		} else {

			Node current = head;
			while (current != null) {
				System.out.print(current.getElement() + " ");
				current = current.getNext();
			}
			System.out.println();
		}

	}

	public void insertAfter(Node element, int position) throws IndexOutOfBoundsException {

		if (position < 0 || position >= size) {
			throw new IndexOutOfBoundsException();
		}

		if (position == size - 1) {
			insertLast(element);
		} else {
			int currentPosition;
			Node current;

			if (position < (size / 2)) {

				current = head;

				for (currentPosition = 0; currentPosition < position; currentPosition++) {
					current = current.getNext();
				}
			} else {
				current = tail;

				for (currentPosition = size - 1; currentPosition > position; currentPosition--) {
					current = current.getPrevious();
				}
			}

			element.setNext(current.getNext());
			element.setPrevious(current);
			current.getNext().setPrevious(element);
			current.setNext(element);

			size++;
		}
	}

	public Node removeAfter(int position) throws IndexOutOfBoundsException {

		if (position < 0 || position >= size || position == size - 1) {
			throw new IndexOutOfBoundsException();
		}
		Node removedItem;
		int currentPosition;
		Node current;

		if (position == size - 2) {

			try {
				removedItem = removeLast();
				return removedItem;

			} catch (UnderFlowException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

			}
		}

		if (position < (size / 2)) {
			current = head;

			for (currentPosition = 0; currentPosition < position; currentPosition++) {
				current = current.getNext();
			}
		} else {
			current = tail;

			for (currentPosition = size - 1; currentPosition > position; currentPosition--) {
				current = current.getPrevious();
			}
		}
		removedItem = current.getNext();
		current.setNext(current.getNext().getNext());
		removedItem.getNext().setPrevious(current);

		size--;
		return removedItem;
	}
}
