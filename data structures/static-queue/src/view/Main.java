package view;

import controller.StaticQueue;

public class Main {

	public static void main(String[] args) {
		StaticQueue fila = new StaticQueue(5);

		System.out.println("A fila ta vazia?: " + fila.isEmpty());
		System.out.println("A fila ta cheia?: " + fila.isFull());

		fila.enqueue(1);
		fila.enqueue(2);
		fila.enqueue(3);
		fila.enqueue(4);
		fila.enqueue(5);
		System.out.printf("tamanho = %d\n", fila.getSize());

		System.out.println("desenfileirado: " + fila.dequeue());
		System.out.println(fila.getSize());
		System.out.println("desenfileirado: " + fila.dequeue());
		System.out.println(fila.getSize());
		System.out.println("desenfileirado: " + fila.dequeue());
		System.out.println(fila.getSize());
		System.out.println("desenfileirado: " + fila.dequeue());
		System.out.println(fila.getSize());
		System.out.println("desenfileirado: " + fila.dequeue());
		System.out.println(fila.getSize());

		System.out.println("A fila ta vazia?: " + fila.isEmpty());
		System.out.println("A fila ta cheia?: " + fila.isFull());
		fila.enqueue(1);
		fila.enqueue(2);
		fila.enqueue(3);
		fila.enqueue(4);
		fila.enqueue(5);
		System.out.println("A fila ta vazia?: " + fila.isEmpty());
		System.out.println("A fila ta cheia?: " + fila.isFull());
	}

}