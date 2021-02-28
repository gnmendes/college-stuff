package controller;

import java.util.concurrent.Semaphore;

public class CampThread extends Thread {
	private int id;
	private Semaphore[] pedras;

	public CampThread(int id, Semaphore[] pedras) {
		this.id = id;
		this.pedras = pedras;

	}

	@Override
	public void run() {
  		corridaLivre();

		try {
			pedras[this.id % 3].acquire();
			arremesso();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} finally {
			pedras[this.id % 3].release();
		}

	}

	private void arremesso() {
		int tempo;

		if (this.id % 3 == 0) {
			tempo = (int) ((Math.random() * 3001) + 1000);
			sleepTime(tempo);
			System.out.printf("O corredor #%d arremessou a sua pedra P! %d\n", this.id, tempo);

		} else if (this.id % 3 == 1) {
			tempo = (int) ((Math.random() * 4001) + 3000);
			sleepTime(tempo);
			System.out.printf("O corredor #%d arremessou a sua pedra M! %d\n", this.id, tempo);

		} else if (this.id % 3 == 2) {
			tempo = (int) ((Math.random() * 5001) + 4000);
			sleepTime(tempo);
			System.out.printf("O corredor #%d arremessou a sua pedra G! %d\n", this.id, tempo);
		}
	}

	private void corridaLivre() {
		int tempo = (int) ((Math.random() * 3001) + 2000);
		sleepTime(tempo);
	}

	private void sleepTime(int tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
