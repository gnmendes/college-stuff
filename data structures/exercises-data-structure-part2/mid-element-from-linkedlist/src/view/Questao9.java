package view;

import controller.LinkedList;
import model.Node;

public class Questao9 {
	
	public static void main(String[] args) {
		LinkedList lista = new LinkedList();

		for (int i = 0; i < 11; i++) 
			lista.add((int) ((Math.random() * 101) + 25));
		
		lista.print();
		
		System.out.println(midElement(lista));
		
	}

	private static int midElement(LinkedList lista) {
		Node step2, curr; 
		
		curr = step2 = lista.getHead();
		
		while(step2 != null) {
			
			if(step2.getNext() == null || step2.getNext().getNext() == null)
				return curr.getData();
			
			curr = curr.getNext();
			step2 = step2.getNext().getNext();
		}
		return curr.getData();
	}
}
