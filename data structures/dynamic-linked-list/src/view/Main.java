package view;
import javax.swing.JOptionPane;

import controller.JDLinkedList;
import controller.Node;
import controller.UnderFlowException;
public class Main {

	public static void main(String[] args) {
		
		JDLinkedList ob = new JDLinkedList();
		
		try {
		
		ob.insertFirst(new Node(7));
		ob.insertFirst(new Node(8));
		ob.insertFirst(new Node(19));
		ob.insertLast(new Node(20));
		ob.insertLast(new Node(40));
		ob.insertFirst(new Node(1999));
		ob.show();
		System.out.println(ob.removeFirst().getElement());
		}catch(UnderFlowException e) {
			JOptionPane.showMessageDialog(null,  e.getMessage(), "ERROR", 
					JOptionPane.ERROR_MESSAGE);
		}
		ob.show();
		
		try {
			
			System.out.println(ob.removeAfter(3).getElement());
		
		}catch(IndexOutOfBoundsException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"ERROR", JOptionPane.ERROR_MESSAGE);
		}
		
		ob.show();
	}

}
