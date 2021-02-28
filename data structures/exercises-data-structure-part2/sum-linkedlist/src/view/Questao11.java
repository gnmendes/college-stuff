package view;

import controller.DList;
import model.Node;

public class Questao11 {

	public static void main(String[] args) {
		DList lista = new DList();
		DList lista2 = new DList();
		
		for(int i = 0; i < 5; i++) {
			lista.add((int)((Math.random() * 9) + 1));
			lista2.add((int)((Math.random() * 9) + 1));
		}
		
		lista.print();
		lista2.print();
		
		System.out.println(sumValues(lista, lista2));
	}

	private static long sumValues(DList lista, DList lista2) {
		Node curr = lista.getTail();
		Node current = lista2.getTail();
		
		int tmp = 1;
		long sum = 0;
		
		while(curr != null && current != null) {
			sum += (curr.getData() + current.getData()) * tmp;
			tmp *= 10;
			curr = curr.getPrev();
			current = current.getPrev();
		}
		
		while(current != null) {
			sum += current.getData() * tmp;
			tmp *= 10;
			current = current.getPrev();
		}
		
		while(curr != null) {
			sum += curr.getData() * tmp;
			tmp *= 10;
			curr = curr.getPrev();
		}
		return sum;
	}
}
