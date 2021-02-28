package view;

import controller.StaticStack;

public class Questao18 {

	public static void main(String[] args) {
		StaticStack pilha = new StaticStack();
		
		for(int i = 0; i < 100; i++) 
			System.out.println(pilha.push((int)((Math.random()*45)+13), (int)((Math.random()*2)+1)));
	
		
		System.out.println(pilha.capacity(1));
		System.out.println(pilha.capacity(2));
	}

}
