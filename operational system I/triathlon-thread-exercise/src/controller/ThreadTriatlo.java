package controller;

import model.Tree;

import java.util.concurrent.Semaphore;

public class ThreadTriatlo extends Thread {
	private Semaphore competitorsSemaphore;
	private int id;
	private final int X_CORRIDA = 3000;
	private final int X_CICLISMO = 5000;
	private static int RANKING = 0;
	private static int TOTAL_SCORE = 250;
	private Semaphore treeSemaphore;
	private Tree arvore;
	private int[] tmp = new int[25];

	public ThreadTriatlo(Semaphore competitorsSemaphore, int id, Semaphore treeSemaphore, Tree arvore) {
		this.competitorsSemaphore = competitorsSemaphore;
		this.id = id;
		this.treeSemaphore = treeSemaphore;
		this.arvore = arvore;
	}

	@Override
	public void run() {
		corrida();

		try {
			competitorsSemaphore.acquire();
			tiroAlvo();
			ciclismo();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			competitorsSemaphore.release();
		}
		
		RANKING++;
		insertAtTree();
		
		if (RANKING == 25) {
			arvore.show();
		}
	}

	private void insertAtTree() {
		try {
			treeSemaphore.acquire();
			arvore.insert(TOTAL_SCORE + tmp[this.id - 1], this.id);
			TOTAL_SCORE -= 10;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			treeSemaphore.release();
		}
	}

	private void ciclismo() {
		int total = 0;
		while (total < X_CICLISMO) {
			sleep(40);
			int tmp = (int) ((Math.random() * 11) + 30);
			total += tmp;
			System.out.printf("A thread #%d andou, nesse instante, %dm!\ntotal = %d\n", this.id, tmp, total);
		}
		System.out.printf("A thread #%d terminou o circuito de ciclismo!\n", this.id);
	}

	private void sleep(int tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void tiroAlvo() {
		for (int i = 1; i <= 3; i++) {
			int pontuacao = (int) ((Math.random() * 11));
			int tempo = (int) ((Math.random() * 2501) + 500);
			tmp[this.id - 1] += pontuacao;
			sleep(tempo);
			System.out.printf("A thread #%d pontuou %d no %dº tiro, que levou %ds!\n", this.id, pontuacao, i,
					tempo / 1000);
		}
	}

	private void corrida() {
		int total = 0;
		while (total < X_CORRIDA) {
			sleep(30);
			int tmp = (int) ((Math.random() * 6) + 20);
			total += tmp;
			System.out.printf("A thread #%d correu nesse instante %dm!\ntotal = %d\n", this.id, tmp, total);
		}
		System.out.printf("A thread #%d terminou o circuito de corrida!\n", this.id);
	}
}
