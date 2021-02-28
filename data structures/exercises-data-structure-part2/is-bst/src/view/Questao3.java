package view;

import controller.Tree;
import model.Node;

public class Questao3 {

	public static void main(String[] args) {
		Tree tree = new Tree();

		tree.add(30);
		tree.add(10);
		tree.add(9);
		tree.add(45);
		tree.add(48);
		tree.add(11);
		tree.add(25);

		Node tmp = tree.getRoot();

		System.out.println(isBST(tmp));
	}

	private static boolean isBST(Node tmp) {
		return isBST(tmp, null, null);
	}

	private static boolean isBST(Node tmp, Node l, Node r) {
		if (tmp == null)
			return true;

		if (l != null && l.data > tmp.data)
			return false;

		if (r != null && r.data < tmp.data)
			return false;

		return isBST(tmp.l, l, tmp) && isBST(tmp.r, tmp, r);
	}
}
