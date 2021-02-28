package view;

import controller.Tree;
import model.Node;

public class Questao3 {

	public static void main(String[] args) {
		Tree arvore = new Tree();

		arvore.add(30);
		arvore.add(10);
		arvore.add(9);
		arvore.add(45);
		arvore.add(48);
		arvore.add(11);
		arvore.add(25);

		Node tmp = arvore.getRoot();
		
		System.out.println(isBST(tmp));
	}

	private static boolean isBST(Node tmp) {
		return isBST(tmp, null, null); //pego a raiz da arvore como referencia e vou trabalhar a partir dela
	}

	private static boolean isBST(Node tmp, Node l, Node r) {
		if(tmp == null) // se não tiver elementos entao é BST
			return true;
		
		if(l != null && l.data > tmp.data)// se a esquerda for diferente de nulo e o dado dela
			return false;				// for maior do que o que eu tenho no pai dela ou raiz
										// eu retorno falso pq n é BST.
		
		if(r != null && r.data < tmp.data)// se o direito for diferente de nulo e o dado dele for
			return false;				// menor do que eu tenho na raiz/pais quer dizer que eu feri
										// a propriedade da BST e logo a arvore não é, então retorno false
		
		return isBST(tmp.l, l, tmp) && isBST(tmp.r, tmp, r);// chamo a recursiva tanto para a esquerda quanto
	}							// para direita, porem para esquerda meu limite superior é a raiz e o inferior o esquerdo msm
								// e para direita o meu limite inferior é a raiz e o superior o direito


}
