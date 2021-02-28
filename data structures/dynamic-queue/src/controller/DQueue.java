package controller;

public class DQueue {
	protected Node first;
	protected Node last;
	protected int size;

	public DQueue() {
		first = null;
		size = 0;
		last = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int getSize() {
		if (isEmpty()) {
			return -1;
		}
		return size;
	}

	public int showFront() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		return first.getElement();
	}

	public void enqueue(int element) {

		if (isEmpty()) {
			Node newNode = new Node(element);
			first = last = newNode;
		} else {
			Node newNode = new Node(element);
			last.setNext(newNode);
			last = newNode;
		}
		size++;
	}

	public int dequeue() throws EmptyQueueException {

		if (isEmpty()) {
			throw new EmptyQueueException();
		} else if (first == last) {
			Node temp = first;
			first = last = null;
			size--;
			return temp.getElement();
		}
		
		Node temp = first;
		first = first.getNext();
		size--;
		return temp.getElement();
	}
}
