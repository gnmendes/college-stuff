package view;

import controller.BinaryTree;

public class Main {

	public static void main(String args[]) {
		BinaryTree arvore = new BinaryTree();
		arvore.inserir(arvore.raiz, 50);
		arvore.inserir(arvore.raiz, 40);
		arvore.inserir(arvore.raiz, 60);
		arvore.inserir(arvore.raiz, 35);
		arvore.inserir(arvore.raiz, 45);
		arvore.inserir(arvore.raiz, 55);
		arvore.inserir(arvore.raiz, 65);
		System.out.println(arvore.printTree(arvore.raiz));

		arvore.raiz = arvore.remover(arvore.raiz, 45);
		System.out.println(arvore.printTree(arvore.raiz));
		arvore.raiz = arvore.remover(arvore.raiz, 65);
		System.out.println(arvore.printTree(arvore.raiz));
		arvore.raiz = arvore.remover(arvore.raiz, 40);
		System.out.println(arvore.printTree(arvore.raiz));
		arvore.raiz = arvore.remover(arvore.raiz, 60);
		System.out.println(arvore.printTree(arvore.raiz));
		arvore.raiz = arvore.remover(arvore.raiz, 50);
		System.out.println(arvore.printTree(arvore.raiz));
		arvore.raiz = arvore.remover(arvore.raiz, 55);
		System.out.println(arvore.printTree(arvore.raiz));
		arvore.raiz = arvore.remover(arvore.raiz, 35);
		System.out.println(arvore.printTree(arvore.raiz));

	}
}
