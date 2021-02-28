package view;

import controller.LinkedList;

public class Questao20 {

	public static void main(String[] args) {
		LinkedList fila = new LinkedList();

		for (int i = 0; i < 10; i++) {
			enqueue(fila, (int) ((Math.random() * 1331) + 1));
		}

		fila.print();
		
		for (int i = 0; i < 5; i++)
			System.out.println(dequeue(fila));
		
		fila.print();
	}

	private static int dequeue(LinkedList fila) {
		return fila.removeFirst();
	}

	private static void enqueue(LinkedList fila, int data) {
		fila.add(data);
	}
}
