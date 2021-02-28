package model;

public class Tree {
	public Node head;
	
	public Tree() {
		this.head = null;
	}
	
	public void insert(int key, int id) {
		head = add(head, key, id);
	}
	
	public void show() {
		System.out.println();
		posOrder(head);
		System.out.println();
//		preOrder(head);
	}
	
	private void preOrder(Node head2) {
		if(head2 != null) {
			System.out.println(head2.data);
			preOrder(head2.left);
			preOrder(head2.right);
		}
	}

	private int getHeight(Node hght) {
		return hght == null ? - 1 : hght.h;
	}
	
	private int max(int a, int b) {
		return a > b ? a : b;
	}
	private Node add(Node root, int key, int id) {
		if(root == null) {
			root = new Node(key, id);
		} else if(root.data >= key) {
			root.left = add(root.left, key, id);
		} else {
			root.right = add(root.right, key, id);
		}
		root = balance(root);
		return root;
	}
	
	private Node balance(Node root) {
		if(bFactor(root) == 2) {
			
			if(bFactor(root.left) > 0)
				root = turnRight(root);
			else {
				root.left = turnLeft(root.left);
				root = turnRight(root);
			}

		} else if (bFactor(root) == - 2) {

			if(bFactor(root.right) < 0) {
				root = turnLeft(root);
			} else {
				root.right = turnRight(root.right);
				root = turnLeft(root);
			}
		}
		root.h = max(getHeight(root.left), getHeight(root.right)) + 1;
		return root;
	}

	private Node turnRight(Node root) {
		Node tmp = root.left;
		root.left = tmp.right;
		tmp.right = root;
		
		root.h = max(getHeight(root.left), getHeight(root.right)) + 1;
		tmp.h = max(getHeight(tmp.left), tmp.h) + 1;
		return tmp;
	}

	private Node turnLeft(Node root) {
		Node tmp = root.right;
		root.right = tmp.left;
		tmp.left = root;
		
		root.h = max(getHeight(root.left), getHeight(root.right)) + 1;
		tmp.h = max(tmp.h, getHeight(tmp.right)) + 1;
		return tmp;
	}
	private int bFactor(Node root) {
		return getHeight(root.left) - getHeight(root.right);
	}

	public void posOrder(Node root) {
		if(root != null) {
			posOrder(root.right);
			System.out.printf("A thread #%d ficou com %d pontos!\n", root.id, root.data);
			posOrder(root.left);
		}
	}
}
