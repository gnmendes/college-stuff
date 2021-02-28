package controller;

public class Stack {
	protected Node top;
	protected int size;
	
	public Stack() {
		top =  null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return this.top == null;
	}
	public int getSize() {
		return size;
	}
	public char peek() throws EmptyStackException {
		
		if(isEmpty()) {
			 throw new EmptyStackException();
		}
		
		return top.getCaracter();
	}
	public void push(char element) {
		Node novo =  new Node(element, top);
		top = novo;
		size ++;
	}
	public char pop() throws EmptyStackException {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		char temp = top.getCaracter(); 
		top = top.getNext();
		size--;
		return temp;
	}
}
