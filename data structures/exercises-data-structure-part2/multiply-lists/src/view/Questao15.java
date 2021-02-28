package view;

import controller.DList;
import model.Node;

public class Questao15 {

	public static void main(String[] args) {
		DList lista = new DList();
		DList lista2 = new DList();
		
		for(int i = 0; i < 3; i++) {
			lista.add((int)((Math.random()*8)+1));
			lista2.add((int)((Math.random()*8)+1));
		}
		lista.print();
		lista2.print();
		
		System.out.println(mList(lista, lista2));
	}

	private static long mList(DList lista, DList lista2) {
		Node curr = lista.getTail();
		Node current;
		
		int len_1 = lista.getSize(), len_2 = lista2.getSize();
		long sum = 0;
		int pow = 0;

		for (int i = len_1; i > 0; i--) {
			
			current = lista2.getTail();
			long base = (int) (Math.pow(10, pow));

			for (int j = len_2; j > 0; j--) {
				
				sum += base * (current.getData() * curr.getData());
				current = current.getPrevious();
				base *= 10;
			}
			pow++;
			curr = curr.getPrevious();
		}
		return sum;
	}
}
