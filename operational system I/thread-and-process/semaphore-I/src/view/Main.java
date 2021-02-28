package view;

import java.util.concurrent.Semaphore;

import controller.ThreadPessoas;

public class Main {

	public static void main(String[] args) {
		int allowed = 4;
		Semaphore sync = new Semaphore(allowed);

		for (int id = 0; id < 4; id++) {
			Thread ob = new ThreadPessoas(id, sync);
			ob.start();
		}
	}

}
