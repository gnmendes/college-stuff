package controller;

public class StaticQueue {

	public Object[] queue;
	public int first;
	public int last;
	public int size;

	public StaticQueue(int size) {
		this.first = 2;
		this.last = 3;
		this.queue = new Object[size];
		this.size = 0;
	}

	public boolean isEmpty() {
		if (this.size == 0)
			return true;

		else
			return false;
	}

	public boolean isFull() {
		if (this.size == this.queue.length)
			return true;

		else
			return false;

	}

	public int getSize() {
		if (isEmpty())
			return 0;

		else
			return this.size;
	}

	public Object showFront() {
		if (isEmpty())
			return null;

		else
			return this.queue[this.first];
	}

	public void enqueue(int element) {
		if (isEmpty()) {
			this.queue[this.first] = element;
			this.size++;
		} else if (!isFull()) {
			if (this.last == this.queue.length - 1) {
				this.queue[this.last] = element;
				this.last = this.last % this.last;
			} else {
				this.queue[this.last++] = element;
			}
			this.size++;
		}
	}

	public Object dequeue() {
		if (isEmpty()) {
			return null;
		}

		Object tmp = this.queue[this.first];

		if (this.first == this.queue.length - 1) {
			this.queue[this.first] = -1;
			this.first = this.first % this.first;
		} else {
			this.queue[this.first++] = -1;
		}
		this.size--;

		if (this.size == 0) {
			this.first = 2;
			this.last = 3;
		}

		return tmp;
	}
}