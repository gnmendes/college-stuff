package view;

import controller.Tree;
import model.Node;

public class Questao1 {

	public static void main(String[] args) {

		Tree arvore = new Tree();

		arvore.add(30);
		arvore.add(10);
		arvore.add(9);
		arvore.add(45);
		arvore.add(48);
		arvore.add(11);
		arvore.add(24);
		arvore.add(25);
		arvore.add(26);
		arvore.add(27);
		arvore.add(28);
		arvore.add(29);
		arvore.add(2);
		arvore.add(5);
		arvore.add(1);
		arvore.add(0);

		Node tmp = arvore.getRoot();

		int h = calcH(tmp);
		int h1 = calc(tmp);
		System.out.println(h1);
		System.out.printf("a altura da arvore é: %d", h);
	}

	private static int calcH(Node tmp) {
		if(tmp == null)
			return -1; //caso base retornando -1 pra adequar a ideia de que o primeiro nivel é 0
		else {
			int hL = calcH(tmp.l);//chamo a recursiva para a esquerda
			int hR = calcH(tmp.r);//chamo para a direita tambem

			if(hL > hR)//e vejo qual das duas é mais alta, conforme eu vou achando a maior eu incremento
				return hL + 1;// e retorno esse int
			else
				return hR + 1;
		}
	}
	private static int calc(Node tmp) {
		if(tmp == null)
			return -1;
		else {
			int l = calc(tmp.l) + 1;
			int r = calc(tmp.r) + 1;
			
			return l > r ? l : r;
		}
	}
}
