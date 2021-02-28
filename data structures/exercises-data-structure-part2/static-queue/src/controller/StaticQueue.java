package controller;

public class StaticQueue {

	public Object[] queue;
	public int first;
	public int size;

	public StaticQueue(int size) {
		this.first = -1;
		this.queue = new Object[size];
		this.size = 0;
	}

	public boolean isEmpty() {
		return first == -1;
	}

	public boolean isFull() {
		return size == queue.length;
	}

	public void furaFila(int element) {
		if (isEmpty()) {
			queue[++first] = element;
			size++;
		} else if (!isFull()) {
			if (first + 2 == queue.length) {
				queue[++first] = element;
				first = first % first;
				size++;
			} else {
				queue[++first] = element;
				size++;
			}
		}
	}
	public void show() {
		StringBuffer sb = new StringBuffer("[");
		
		for(int i = this.size - 1; i >= first  ; i--) {
			if(i == 0)
				sb.append(queue [i] + "]");
			else
				sb.append(queue[i] + " ");
		}
		
		System.out.println(sb.toString());
	}
}