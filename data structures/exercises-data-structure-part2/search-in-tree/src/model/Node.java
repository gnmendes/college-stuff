package model;

public class Node {
	public Node l;
	public Node r;
	public int data;
	
	public Node(int data) {
		this.data = data;
		l = r = null;
	}
}
