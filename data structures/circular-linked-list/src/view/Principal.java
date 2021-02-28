package view;

import controller.JCLinkedList;
import controller.Node;
import controller.UnderFlowException;

public class Principal {

	public static void main(String[] args) throws UnderFlowException {
		JCLinkedList ob = new JCLinkedList();
		
		ob.insertFirst(new Node(10));
		ob.insertLast(new Node(1999));
		ob.insertFirst(new Node(70));
		ob.insertFirst(new Node(19));
		ob.insertLast(new Node(14));
		ob.show();
		System.out.println("primeiro item removido: "+ob.removeFirst().getElement());
		ob.show();
		System.out.println("ultimo item removido: "+ob.removeLast().getElement());
		ob.show();

	}
}