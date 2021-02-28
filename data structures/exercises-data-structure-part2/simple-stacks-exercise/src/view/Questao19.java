package view;

import controller.Stack;

public class Questao19 {

	public static void main(String[] args) {
		Stack pilha = new Stack();
		Stack pilha2 = new Stack();
		
		for(int i = 0; i < 10; i++)
			enqueue(pilha, pilha2, (int)((Math.random()*251))+1);
		
		while(!pilha.isEmpty())
			System.out.println(pilha.pop());
	}

	public static int dequeue(Stack pilha, Stack pilha2) {
		if(!pilha.isEmpty()) {
			return pilha.pop();
		}else if(!pilha2.isEmpty()) {
			return pilha2.pop();
		}
		return -1;
	}

	public static void enqueue(Stack pilha, Stack pilha2, int data) {
		while(!pilha.isEmpty()) {
			pilha2.push(pilha.pop());
		}
		pilha.push(data);
		while(!pilha2.isEmpty()) {
			pilha.push(pilha2.pop());
		}
		
		System.out.printf("enfileirado! %d\n", data);
	}

}
