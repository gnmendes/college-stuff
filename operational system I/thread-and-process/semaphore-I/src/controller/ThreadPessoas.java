package controller;

import java.util.concurrent.Semaphore;

public class ThreadPessoas extends Thread {
	private final int CORREDOR = 200;
	private Semaphore sync;
	private int id;
	private static int posChegada;
	private static int posSaida;

	public ThreadPessoas(int id, Semaphore sync) {
		this.id = id;
		this.sync = sync;
	}

	@Override
	public void run() {
		caminhando();
		try {
			sync.acquire();
			chegada();
			saida();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			sync.release();
		}
	}

	private void saida() {
		posSaida++;
		System.out.printf("A pessoa #%d foi a %d a sair!\n", id, posSaida);
	}

	private void chegada() {
		posChegada++;
		System.out.printf("A pessoa #%d foi a %dº a chegar a porta!\n", id, posChegada);
		int tempo = (int) ((Math.random() * 1001) + 1000);
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void caminhando() {

		int alreadyWalked = 0;

		while (alreadyWalked < CORREDOR) {
			int desloc = (int) ((Math.random() * 2) + 4);
			alreadyWalked += desloc;
			System.out.printf("A pessoa #%d andou %dm, e ja percorreu %dm!\n ", id, desloc, alreadyWalked);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
