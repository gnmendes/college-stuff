package view;

import java.util.concurrent.Semaphore;

import controller.Bank;

public class Main {

	public static void main(String[] args) {
		Semaphore[] permissions = new Semaphore[2];
		
		for(int i = 0; i < 2; i++) {
			permissions[i] = new Semaphore(1);
		}
		
		double contaValor = Math.random() * 2051 + 2550;

		for (int id = 1; id <= 20; id++) {
			
			Thread ob = new Bank(id, contaValor, ((int) (Math.random() * 101 + 1320)), permissions);
			ob.start();
		
		}
	}

}
