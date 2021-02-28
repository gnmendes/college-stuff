package controller;

import java.util.concurrent.Semaphore;

public class Garage extends Thread {
	private int id;
	private Semaphore floor_1st;
	private Semaphore floor_2nd;

	public Garage(int id, Semaphore floor_1st, Semaphore floor_2nd) {
		this.id = id;
		this.floor_1st = floor_1st;
		this.floor_2nd = floor_2nd;

	}

	@Override
	public void run() {
		int tempo;

		if (this.id % 2 == 0) {
			try {
				floor_2nd.acquire();
				tempo = (int) ((Math.random() * 5001) + 2000);
				procurarVaga("carro", tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				floor_2nd.release();
			}
		} else {
			try {
				floor_1st.acquire();
				tempo = (int) ((Math.random() * 5001) + 2000);
				procurarVaga("moto", tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				floor_1st.release();
			}
		}
	}

	private void procurarVaga(String vehicle, int tempo) {
		System.out.printf("O/A %s #%d está procurando vaga!\n", vehicle, this.id);
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("O/A %s #%d estacionou!\n", vehicle, this.id);

	}

}
