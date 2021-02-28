package view;

import controller.DQueue;
import controller.EmptyQueueException;

public class Main {

	public static void main(String[] args) {
		DQueue fila = new DQueue();
		try {
			fila.enqueue(1); 
			System.out.println("primeiro elemento: " + fila.showFront());
			fila.enqueue(2);
			System.out.println("desinfileirado: " + fila.dequeue()); 
			System.out.println("primeiro elemento: " + fila.showFront());
			fila.enqueue(3);
			System.out.println("desinfileirado: " + fila.dequeue());
			fila.enqueue(4);
			fila.enqueue(5);
			System.out.println("primeiro elemento: " + fila.showFront());
			System.out.println("desinfileirado: " + fila.dequeue());

			while (!fila.isEmpty()) {
				System.out.print(fila.dequeue() + " ");
			}

		} catch (EmptyQueueException e) {
			System.out.println("ERRO: Imposs�vel remover!");
			e.printStackTrace();
		}

	}

}
