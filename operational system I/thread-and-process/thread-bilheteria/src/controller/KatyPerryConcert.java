package controller;
import java.util.concurrent.Semaphore;

public class KatyPerryConcert extends Thread {
	private static int TICKETS = 100;
	private int ticketsToBuy;
	private Semaphore gate;
	private int id;

	public KatyPerryConcert(int ticketToBuy, Semaphore gate, int id) {
		this.ticketsToBuy = ticketToBuy;
		this.gate = gate;
		this.id = id;

	}

	@Override
	public void run() {
		login();
	}

	private void login() {
		int tempo = (int) ((Math.random() * 1951) + 50);

		sleepTime(tempo);

		if (tempo >= 1000) {
			timeout(tempo);
		} else {
			shop();
		}
	}

	private void sleepTime(int tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void timeout(int tempo) {
		float temp = tempo/1000;
		System.out.printf("TIMEOUT! tempo esgotado!(%f)\n", temp);
	}

	private void shop() {
		int tempo = (int) ((Math.random() * 2001) + 1000);

		sleepTime(tempo);

		if (tempo >= 2500) {
			timeout(tempo);
		} else {
			try {
				gate.acquire();
				soldOut();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				gate.release();
			}
		
		}
	}

	private void soldOut() {
		int tempo = (int)(Math.random()*40 + 150) + 1;
		sleepTime(tempo);
		
		if (this.ticketsToBuy <= TICKETS) {
			TICKETS -= this.ticketsToBuy;
			System.out.printf("O fã #%d comprou %d ingressos!\n", this.id, this.ticketsToBuy);
		} else {
			System.out.printf("Há somente %d ingressos disponíveis! Erro em concluir a transação. Você solicitou (%d)\n", TICKETS, this.ticketsToBuy);
			
		}
	}
}
