package view;

import controller.LinkedList;
import model.Node;

public class Questao14 {

	public static void main(String[] args) {
		LinkedList lista = new LinkedList();

		for (int i = 0; i < 10; i++) {
			lista.add((int) ((Math.random() * 101) + 25));
		}

		lista.print();

		josephus(lista, (int)(Math.random()*9)+1);
	}

	private static void josephus(LinkedList lista, int k) {
		int flag = 0, length = lista.getSize();
		Node current, anti;
		anti = current = lista.getHead();
		
		while (length != 1) {
			flag++;
			if (flag == k) {
				anti.setNext(current.getNext());
				System.out.printf("participante removido: #%d\n", current.getData());
				length--;
				flag = 0;
			}
			anti = current;
			current = current.getNext();
		}
		System.out.printf("O líder foi o: #%d\n", current.getData());
	}
}
