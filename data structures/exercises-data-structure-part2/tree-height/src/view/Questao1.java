package view;

import controller.Tree;
import model.Node;

public class Questao1 {

	public static void main(String[] args) {

		Tree tree = new Tree();

		tree.add(30);
		tree.add(10);
		tree.add(9);
		tree.add(45);
		tree.add(48);
		tree.add(11);
		tree.add(24);
		tree.add(25);
		tree.add(26);
		tree.add(27);
		tree.add(28);
		tree.add(29);
		tree.add(2);
		tree.add(5);
		tree.add(1);
		tree.add(0);

		Node tmp = tree.getRoot();

		int h1 = h(tmp);
		System.out.println(h1);
	}

	private static int h(Node tmp) {
		if(tmp == null)
			return -1;
		else {
			int l = h(tmp.l) + 1;
			int r = h(tmp.r) + 1;
			
			return l > r ? l : r;
		}
	}
}
