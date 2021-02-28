package view;

import controller.DCLinkedList;
import controller.Node;
import controller.UnderFlowException;

public class Main {

	public static void main(String[] args) {
		
		DCLinkedList ob =  new DCLinkedList();
		
		ob.insertFirst(new Node(10));
		ob.insertFirst(new Node(70));
		ob.insertFirst(new Node(100));
		ob.insertFirst(new Node(1999));
		try {
			ob.insertLast(new Node(20));
		} catch (UnderFlowException e) {
			e.printStackTrace();
		}
		ob.show();
		
		try {
			System.out.println("removi o primeiro: " + ob.removeFirst().getElement());
			System.out.println("removi o ultimo: " + ob.removeLast().getElement());
		} catch (UnderFlowException e) {
			e.printStackTrace();
		}
		
		ob.show();
		ob.insertAfter(new Node(1963), 2);
		System.out.println("inseri depois da terceira posição:");
		ob.show();
		System.out.println("removi depois da primeira posição:");
		ob.removeAfter(0);
		ob.show();
		
	}

}
