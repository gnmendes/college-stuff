package view;

import controller.Heap;

public class Questao10 {

	public static void main(String[] args) {
		Heap heap = new Heap(20);
		
		int v[] = {10, 5, 6, 8, 9, 12, 3, 9, 30};
		
		for(int a : v)
			heap.add(a);
		
		heap.printHeap();
		
		System.out.println(heap.isHeap(v, v.length));
		
	}

}
