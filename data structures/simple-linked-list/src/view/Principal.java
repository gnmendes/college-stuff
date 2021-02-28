package view;
import controller.JLinkedList;
import controller.Node;
import controller.UnderFlowException;

public class Principal {

	public static void main(String[] args)throws UnderFlowException {
		JLinkedList ob= new JLinkedList();
	
		try {
		ob.insertFirst(new Node(1));
		ob.insertFirst(new Node(4));
		ob.insertFirst(new Node(9));
		ob.insertFirst(new Node(18));
		ob.insertLast(new Node(20));
		ob.show();
		ob.insert(new Node(1999), 3);
		}catch(NullPointerException e) {
			System.out.println("\nta tentando inserir numa posicao inexistente");
			e.printStackTrace();
		}
		try {
		System.out.println();
		ob.show();
		System.out.println("\nO ultimo elemento é:" +ob.getLast().getElement());
		System.out.println("O primeiro elemento é: "+ ob.getFirst().getElement());
		System.out.println("removido: "+ob.removeFirst().getElement());
		System.out.println("removido: "+ob.removeLast().getElement());
		ob.show();
		}catch(UnderFlowException e) {
			System.out.println("lista vazia");
			e.printStackTrace();
		}
	}

}
