package view;

import controller.Tree;
import model.Node;

public class Questao4 {

	public static void main(String[] args) {

		Tree arvore = new Tree();

		arvore.add(30);
//		arvore.add(10);
//		arvore.add(9);
		arvore.add(45);
		arvore.add(48);
//		arvore.add(11);
//		arvore.add(25);

		Node tmp = arvore.getRoot();
		arvore.printInOrder(tmp);
		tmp = remove(tmp);
		System.out.println();
		arvore.printInOrder(tmp);
	}

	private static Node remove(Node root) {
		if(root == null) // caso base que retorna o root
			return null;
		else if(root.l != null) //enquanto eu nao estiver no nó mais a esquerda possivel, eu percorro a arvore
			root.l = remove(root.l);
		else 
			return root.r;// ao chegar nele eu retorno qualquer possivel subarvore a direita do mesmo para
						// nao perder as referencias dessa, ja que vou estar removendo eel
		return root;
	}

}
//*consertar