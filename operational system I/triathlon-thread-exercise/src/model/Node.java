package model;

public class Node {
	public Node right;
	public Node left;
	public int data;
	public int id;
	public int h;
	
	public Node(int data, int id) {
		right = left = null;
		this.data = data;
		this.id = id;
		h = 0;
	}
}
