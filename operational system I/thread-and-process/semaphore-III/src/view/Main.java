package view;

import java.util.concurrent.Semaphore;

import controller.Formula1;
import controller.Operacoes;
import controller.Struct;

public class Main {

	public static void main(String[] args) {
		Semaphore sync = new Semaphore(5);
		Semaphore[] allowed = new Semaphore[7];
		Struct[] vetor = new Struct[14];

		Operacoes set = new Operacoes();

		vetor = set.limpaMemoria(vetor);

		for (int i = 0; i < 7; i++) {
			allowed[i] = new Semaphore(1);
		}
		for (int piloto = 1; piloto <= 2; piloto++) {

			for (int id = 1; id <= 7; id++) {
				Thread ob = new Formula1(id, sync, piloto, vetor, allowed);
				ob.start();
			}

		}
	}
}
