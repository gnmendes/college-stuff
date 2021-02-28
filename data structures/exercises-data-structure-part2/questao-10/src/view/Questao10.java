package view;

import controller.DList;

public class Questao10 {

	public static void main(String[] args) {
		DList lista = new DList();
		
		for(int i = 0; i < 10; i ++)
			lista.add((int) ((Math.random() * 101) + 56));
			
			
		lista.print();
		lista.add(13, 7);
		lista.print();
	}

}
