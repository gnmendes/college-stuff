package view;

import controller.StaticQueue;

public class Questao21 {

	public static void main(String[] args) {
		StaticQueue fila = new StaticQueue(10);
		
		for(int i = 0; i < 10; i ++) {
			int data = (int) ((Math.random() * 8) + 1);
			fila.furaFila(data);
			System.out.printf("enfileirado! %d\n", data);
		}
		fila.show();
	}

}
