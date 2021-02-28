package controller;

import model.Node;

public class Tree {
	private Node root;
	
	public Tree() {
		root = null;
	}
	
	public void add(int element) {
		root = add(root, element);
	}

	private Node add(Node root, int element) {
		
		if(root == null) {
			root = new Node(element);
		}
		
		if(root.data > element)
			root.l = add(root.l, element);
		else if(root.data < element)
			root.r = add(root.r, element);
		
		return root;
	}

	public Node getRoot() {
		return this.root;
	}

	public void printInOrder(Node root) {
		
		if(root != null) {
			printInOrder(root.l);
			System.out.println(root.data);
			printInOrder(root.r);
		}
	}
}
