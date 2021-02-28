package view;

import java.util.concurrent.Semaphore;

import controller.CampThread;

public class Main {

	public static void main(String[] args) {
		Semaphore[] pedras = new Semaphore[3];

		for (int i = 0; i < 3; i++) {
			pedras[i] = new Semaphore(1);
		}

		for (int id = 1; id <= 21; id++) {
			Thread ob = new CampThread(id, pedras);
			ob.start();
		}
	}

}
