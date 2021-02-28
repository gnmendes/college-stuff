package view;

import controller.LinkedList;
import model.Node;

public class Questão13 {

	public static void main(String[] args) {
		LinkedList lista = new LinkedList();
		LinkedList lista2 = new LinkedList();

		for (int i = 0; i < 10; i++) {
			lista.add((int) ((Math.random() * 101) + 25));
			lista2.add((int) ((Math.random() * 101) + 25));
		}

		lista.print();
		lista2.print();
		
		if(lista.getHead() == lista2.getHead())
			System.out.println("referências de partida iguais");
		
		System.out.println(isEqual(lista, lista2));
	}

	private static boolean isEqual(LinkedList lista, LinkedList lista2) {
		Node curr = lista.getHead();
		
		int length, size;
		
		length = lista.getSize();
		size = lista2.getSize();

		for(int i = 0; i < length && curr != null ; i++) {
			Node current = lista2.getHead();
			
			for(int j = 0; j < size && current != null ; j++) {
				
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
