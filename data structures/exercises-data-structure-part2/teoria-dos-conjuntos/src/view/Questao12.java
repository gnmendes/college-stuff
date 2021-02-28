package view;

import controller.DList;
import model.Node;

public class Questao12 {

	public static void main(String[] args) {
		DList A = new DList();
		DList B = new DList();

		for (int i = 0; i < 5; i++) {
			A.add((int) ((Math.random() * 9) + 1));
			B.add((int) ((Math.random() * 9) + 1));
		}

		A.print();
		B.print();

		interseccao(A, B);
		uniao(A, B);
		diferenca(A, B);
	}

	private static void diferenca(DList a, DList b) {
		Node conj_a = a.getHead();
		Node conj_b;
		boolean flag;
		
		DList dif = new DList();
		
		while (conj_a != null) {
			conj_b = b.getHead();
			flag = true;
			
			while (conj_b != null) {
				
				if(conj_a.getData() == conj_b.getData()) {
					flag = false;
					break;
				}
				
				conj_b = conj_b.getNext();
			}
			if(flag && !exist(conj_a.getData(), dif)) 
				dif.add(conj_a.getData());
			
			conj_a = conj_a.getNext();
		}

		dif.print();
		
	}

	private static void uniao(DList a, DList b) {
		Node conj_a = a.getHead();
		Node conj_b = b.getHead();

		DList uniao = new DList();
		
		while(conj_a != null) {
			if(!exist(conj_a.getData(), uniao)) 
				uniao.add(conj_a.getData());
			conj_a = conj_a.getNext();
		}
		
		while(conj_b != null) {
			if(!exist(conj_b.getData(), uniao)) 
				uniao.add(conj_b.getData());
			conj_b = conj_b.getNext();
		}
		
		uniao.print();
	}

	private static void interseccao(DList a, DList b) {
		Node conj_a = a.getHead();
		Node conj_b = b.getHead();

		DList intersecc = new DList();

		while (conj_a != null) {

			while (conj_b != null) {

				if (conj_a.getData() == conj_b.getData() && !exist(conj_a.getData(), intersecc)) {
					intersecc.add(conj_a.getData());
					break;
				}
				conj_b = conj_b.getNext();
			}
			conj_a = conj_a.getNext();
			conj_b = b.getHead();
		}

		intersecc.print();
	}

	private static boolean exist(int data, DList tmp) {
		Node current = tmp.getHead();

		while (current != null) {
			if (current.getData() == data)
				return true;
			current = current.getNext();
		}
		return false;
	}
}