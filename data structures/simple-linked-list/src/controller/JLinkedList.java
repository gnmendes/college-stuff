package controller;

public class JLinkedList {

	protected Node head;

	public JLinkedList() {
		head = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public Node getFirst() throws UnderFlowException {
		if (isEmpty()) {
			System.out.printf("lista vazia\n");
			throw new UnderFlowException();
		} else {
			return head;
		}
	}

	public Node getLast() throws UnderFlowException {
		if (isEmpty()) {
			throw new UnderFlowException();
		}

		Node current = head;

		while (current.getNext() != null) {
			current = current.getNext();
		}
		return current;
	}

	public Node removeLast() throws UnderFlowException {
		Node current = head.getNext();
		Node removedItem = head;

		while (current.getNext() != null) {
			current = current.getNext();
			removedItem = removedItem.getNext();
		}
		removedItem.setNext(null);
		return current;
	}

	public Node removeFirst() throws UnderFlowException {
		Node removedItem = getFirst();
		head = head.getNext();

		return removedItem;

	}

	public void insertFirst(Node element) {
		element.setNext(head);
		head = element;
	}

	public void insertLast(Node element) throws UnderFlowException {
		Node current = getLast();
		current.setNext(element);
		element.setNext(null);
	}

	public void show() {
		Node current = head;
		while (current != null) {

			System.out.print(current.getElement() + " ");
			current = current.getNext();
		}
	}

	public void insert(Node element, int position) throws NullPointerException {
		Node current = head.getNext();
		Node temp = head;
		for (int i = 0; i < position - 1; i++) {

			if (current.getNext() == null) {
				throw new NullPointerException();
			}

			current = current.getNext();
			temp = temp.getNext();
		}
		temp.setNext(element);
		element.setNext(current);
	}

}
