package view;

import java.util.LinkedList;
import java.util.Queue;

public class Questao1Prova {

	public static void main(String[] args) {
		Queue<Integer> fila = new LinkedList<>();

		int n = 8;
		int i = 2;
		
		while (n > 1) {
			
			if (n % i == 0 && isPrimo(i)) {
				fila.add(i);
				n /= i;
			} else {
				i++;
			}
		}
		
		while(!fila.isEmpty()) {
			System.out.println(fila.remove());
		}
	}

	private static boolean isPrimo(int n) {
		for (int j = 2; j < n; j++) {
			if (n % j == 0)
				return false;
		}
		return true;
	}
}
