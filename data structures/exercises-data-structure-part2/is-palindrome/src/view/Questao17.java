package view;

import java.util.Scanner;

import controller.Stack;

public class Questao17 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("insira a cadeia de caracteres:");
		String s = input.nextLine();
		s = s.replaceAll("\\d|\\W|_", " ");
		s = s.trim();
		System.out.println(s);
		System.out.println(isPalindrome(s));
		input.close();
	}

	private static boolean isPalindrome(String s) {
		StringBuffer str = new StringBuffer();
		Stack pilha = new Stack();
		int length = s.length();
		
		for(int i = 0; i < length; i++)
			pilha.push(s.charAt(i));
		
		while(!pilha.isEmpty())
			str.append(pilha.pop());
		
		
		return s.equals(str.toString());
	}
}
