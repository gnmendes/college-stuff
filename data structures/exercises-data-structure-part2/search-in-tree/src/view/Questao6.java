package view;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import controller.Tree;
import model.Node;

public class Questao6 {

	public static void main(String[] args) {

		Tree tree = new Tree();

		tree.add(30);
		tree.add(10);
		tree.add(9);
		tree.add(45);
		tree.add(48);
		tree.add(11);
		tree.add(25);

		Node root = tree.getRoot();

		preOrder(root);
		System.out.println();
		inOrder(root);
		System.out.println();
		postOrder(root);
		System.out.println();
		BFS(root);
	}

	private static void BFS(Node root) {
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
