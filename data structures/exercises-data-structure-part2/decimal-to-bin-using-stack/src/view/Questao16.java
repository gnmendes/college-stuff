package view;

import java.util.Scanner;

import controller.LinkedList;
import controller.Stack;

public class Questao16 {

	public static void main(String[] args) {
		Stack pilha = new Stack();
		LinkedList lista = new LinkedList();

		convert2Bin(pilha, lista, readNumber());

	}

	private static void convert2Bin(Stack pilha, LinkedList lista, int n) {
		while (n != 0) {
			pilha.push(n % 2);
			n /= 2;
		}

		while (!pilha.isEmpty()) {
			lista.add(pilha.pop());
		}

		lista.print();
	}

	private static int readNumber() {
		Scanner input = new Scanner(System.in);
		System.out.println("insira um número inteiro!");

		int n = input.nextInt();
		input.close();
		return n;
	}

}
