package view;

import controller.Tree;
import model.Node;

public class Questão4 {

	public static void main(String[] args) {

		Tree tree = new Tree();

		tree.add(30);
		tree.add(45);
		tree.add(48);

		Node tmp = tree.getRoot();
		
		tree.printInOrder(tmp);
		
		tmp = remove(tmp);
		System.out.println();
		tree.printInOrder(tmp);
	}

	private static Node remove(Node root) {
		if(root == null) 
			return root;
		else if(root.l != null) 
			root.l = remove(root.l);
		else 
			return root.r;
		
		return root;
	}
}