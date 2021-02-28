package controller;

public class Heap {
	private int arr[];
	private int size;

	public Heap(int size) {
		this.arr = new int[size];
		this.size = 0;
	}

	public void add(int element) {
		arr[++size] = element;
		subir(size);
	}

	public int remove() {
		int removed = arr[1];
		arr[1] = arr[size--];
		descer(1, size);
		return removed;
	}

	private void descer(int father, int last) {
		int children = father * 2 + 1;

		if (children > last)
			return;
		if (children < last)
			children = getGreatest(children);

		if (arr[children] > arr[father]) {
			int temp = arr[children];
			arr[children] = arr[father];
			arr[father] = temp;
			descer(children, last);
		}

	}

	private int getGreatest(int children) {
		return arr[children] > arr[children + 1] ? children : children + 1;
	}

	private void subir(int children) {
		int father = children / 2;

		if (arr[children] > arr[father]) {
			int temp = arr[children];
			arr[children] = arr[father];
			arr[father] = temp;
			subir(father);
		}

	}

	public void printHeap() {
		StringBuffer buffer = new StringBuffer("[");

		for (int i = 0; i < size; i++) {
			if (i + 1 == size)
				buffer.append(arr[i] + "]");
			else
				buffer.append(arr[i] + " ");
		}

		System.out.println(buffer.toString());
	}

	public boolean isHeap(int v[], int size) { //se eu recebi um suposto vetor que é um heap
		size--;									// e consegui realizar uma troca, ja sei que 
												// é falso

		for (int son = size; son >= 0; son--) {
			int father = size / 2;

			if (v[son] > v[father])
				return false;
		}

		return true;
	}
	
}
