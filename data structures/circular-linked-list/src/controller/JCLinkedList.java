package controller;

public class JCLinkedList {

	protected Node head;
	protected Node tail;
	protected int size;

	public JCLinkedList() {

		this.tail = null;
		this.head = null;
		this.size = 0;
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
			tail = head = element;
		} else {
			element.setNext(head);
			head = element;
		}
		size++;
	}

	public void insertLast(Node element) throws UnderFlowException {
		if (isEmpty()) {
			insertFirst(element);
		} else {

			Node current = getLast();
			current.setNext(element);
			element.setNext(head);
			tail = element;
			size++;

		}
	}

	public Node removeFirst() throws UnderFlowException {

		if (isEmpty()) {
			throw new UnderFlowException();
		}

		Node removedItem = head;
		tail.setNext(head.getNext());
		head = tail.getNext();
		size--;

		return removedItem;
	}

	public Node removeLast() throws UnderFlowException {

		if (isEmpty()) {
			throw new UnderFlowException();
		}

		Node current = head;
		Node removedItem = tail;
		while (current.getNext() != tail) {

			current = current.getNext();
		}

		current.setNext(head);
		tail = current;
		size --;
		
		return removedItem;
	}

	public void show() {
		if (isEmpty()) {
			System.out.println("List Vazia!");
		} else if (size == 1) {
			System.out.println(head.getElement());
		} else {
			Node current = head;
			
			for(int i = 0; i < size; i++) {
			System.out.print(current.getElement() + " ");
				current =  current.getNext();
			}
			
			System.out.println();
		}
	}
}
