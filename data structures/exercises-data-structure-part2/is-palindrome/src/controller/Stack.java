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
	
	public void push(char data) {
		Node g = new Node(data); 
		g.setNext(top);
		top = g;
	}
	public char peek() {
		return top.getData();
	}
	
	public char pop() {
		if(isEmpty()) {
			return ' ';
		}
		
		char removed = top.getData();
		top = top.getNext();
		
		return removed;
	}
}
