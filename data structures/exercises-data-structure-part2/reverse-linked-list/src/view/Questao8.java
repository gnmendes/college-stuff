package view;

import controller.LinkedList;
import model.Node;

public class Questao8 {

	public static void main(String[] args) {
		LinkedList lista = new LinkedList();

		for (int i = 0; i < 10; i++) 
			lista.add((int) ((Math.random() * 101) + 25));
		
		lista.print();
		
		reverse(lista);
	}

	private static void reverse(LinkedList lista) {
		Node current = lista.getHead();
		Node anti = null, next = null;
	
		while(current != null) {
			next = current.getNext();
			current.setNext(anti);
			anti = current;
			current = next;
		}
		
		lista.print(anti);
	}

}
