package controller;

import javax.swing.JOptionPane;

public class DCLinkedList {

	protected Node head;
	protected int size;

	public DCLinkedList() {

		head = null;
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

		Node current = head;

		for (int i = 0; i < size - 1; i++) {
			current = current.getNext();
		}

		return current;
	}

	public void insertFirst(Node element) {

		if (isEmpty()) {
			head = element;

		} else {
			head.setPrevious(element);
			element.setNext(head);
			head = element;
		}

		size++;
	}

	public void insertLast(Node element) throws UnderFlowException {

		if (isEmpty()) {
			insertFirst(element);
		} else {
			Node temp = getLast();

			temp.setNext(element);
			element.setPrevious(temp);
			element.setNext(head);
			head.setPrevious(element);
			size++;
		}
	}

	public Node removeLast() throws UnderFlowException {

		if (isEmpty()) {
			throw new UnderFlowException();
		}

		Node removedItem;
		if (hasOne()) {
			removedItem = head;
			head = null;
		} else {
			removedItem = getLast();
			removedItem.getPrevious().setNext(head);
			head.setPrevious(removedItem.getPrevious());
		}
		size--;
		return removedItem;
	}

	public Node removeFirst() throws UnderFlowException {

		if (isEmpty()) {
			throw new UnderFlowException();
		}

		Node removedItem;

		if (hasOne()) {
			removedItem = head;
			head = null;
		} else {
			removedItem = head;
			head = head.getNext();
			head.setPrevious(removedItem.getNext());
			removedItem.getPrevious().setNext(head);
		}
		size--;
		return removedItem;
	}

	public void show() {

		if (isEmpty()) {
			System.out.println("Lista vazia!");
		} else {

			Node current = head;

			for (int i = 0; i < size; i++) {

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
			try {
				insertLast(element);
			} catch (UnderFlowException e) {
				e.printStackTrace();
			}
		} else {
			int currentPosition;
			Node current;

			if (position < (size / 2)) {
				current = head;

				for (currentPosition = 0; currentPosition < position; currentPosition++) {
					current = current.getNext();
				}

			} else {
				current = head.getPrevious();

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
			current = head.getPrevious();

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

	public boolean hasOne() {
		return size == 1;
	}
}
