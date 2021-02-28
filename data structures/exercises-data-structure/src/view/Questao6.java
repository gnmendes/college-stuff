package view;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import controller.Tree;
import model.Node;

public class Questao6 {

	public static void main(String[] args) {

		Tree arvore = new Tree();

		arvore.add(30);
		arvore.add(10);
		arvore.add(9);
		arvore.add(45);
		arvore.add(48);
		arvore.add(11);
		arvore.add(25);

		Node root = arvore.getRoot();

		preOrder(root);
		System.out.println();
		inOrder(root);
		System.out.println();
		postOrder(root);
		System.out.println();
		BFS(root);
	}

	private static void BFS(Node root) {//percurso em largura utilizando uma fila, para guardar todos
										//os nós de um determinado nível
		Queue<Node> fila = new LinkedList<>();

		Node current = root;
		fila.add(current);

		while (!fila.isEmpty() && current != null) {

			current = fila.remove();
			System.out.println(current.data);
			if (current.l != null) {
				fila.add(current.l);
			}
			if (current.r != null) {
				fila.add(current.r);
			}
		}

	}

	private static void postOrder(Node root) {
		/*o mais complexo dos algoritmos iterativos de percurso, porque exige, na sua implementaçao
		 * mais simples, duas pilhas. Consiste em guardar os pais em uma pilha e empilhar os filhos
		 * desse pai numa outra, depois desempilhar o direito e empilhar os filhos deste.
		 * Repetir esse processo até que a primeira pilha esteja vazia.
		 */
		Stack<Node> pilha = new Stack<>();
		Stack<Node> pilha2 = new Stack<>();

		Node tmp;
		pilha.push(root);

		while (!pilha.isEmpty()) {
			tmp = pilha.pop();
			pilha2.push(tmp);

			if (tmp.l != null) {
				pilha.push(tmp.l);
			}

			if (tmp.r != null) {
				pilha.push(tmp.r);
			}
		}

		while (!pilha2.isEmpty()) {
			System.out.println(pilha2.pop().data);
		}
	}

	private static void inOrder(Node root) {
		/*Percorre todos os filhos de uma dada subarvore para só então, percorrer o pai
		 * 
		 */
		Stack<Node> pilha = new Stack<>();
		Node current = root;
		
		while (!pilha.isEmpty() || current != null) {

			while (current != null) {
				pilha.push(current);
				current = current.l;
			}
			current = pilha.pop();
			System.out.println(current.data);
			current = current.r;
		}
	}

	private static void preOrder(Node root) {
		// Passa primeiro pelo pai, para depois ir para o filho
		Stack<Node> pilha = new Stack<>();

		Node current;
		pilha.push(root);

		while (!pilha.isEmpty()) {
			current = pilha.pop();
			System.out.println(current.data);

			if (current.r != null)
				pilha.push(current.r);

			if (current.l != null)
				pilha.push(current.l);
		}

	}

}
