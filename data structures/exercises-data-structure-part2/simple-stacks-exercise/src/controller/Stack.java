package controller;

import model.Node;

public class Stack {
	private Node top;
	
	public Stack() {
		top = null;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public void push(int data) {
		Node g = new Node(data); 
		g.setNext(top);
		top = g;
	}
	public int peek() {
		return top.getData();
	}
	
	public int pop() {
		if(isEmpty()) {
			return -1;
		}
		
		int removed = top.getData();
		top = top.getNext();
		
		return removed;
	}
}
