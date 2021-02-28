package view;

import controller.LinkedList;
import model.Node;

public class Questao7 {

	public static void main(String[] args) {
		LinkedList lista = new LinkedList();
		LinkedList lista2 = new LinkedList();

		for (int i = 0; i < 10; i++) {
			lista.add((int) ((Math.random() * 101) + 25));
			lista2.add((int) ((Math.random() * 101) + 25));
		}

		System.out.println(isEqual(lista, lista2));
	}

	private static boolean isEqual(LinkedList lista, LinkedList lista2) {
		Node curr = lista.getHead();
		Node current = lista2.getHead();

		while (curr != null) {

			while (current != null) {

				if (current.getData() == curr.getData()) {
					lista2.remove(current.getData());
					break;
				}
				current = current.getNext();
			}
			curr = curr.getNext();
		}
		
		return lista2.getSize() == 0 ? true : false;
	}

}
