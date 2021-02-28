package controller;

import java.util.concurrent.Semaphore;

public class CavaleirosThread extends Thread {
	private final int X = 2000;
	public static boolean flag[];
	private Semaphore divider;
	private int id;
	private int survivor;

	public CavaleirosThread(Semaphore divider, int id, int survivor) {
		this.divider = divider;
		this.id = id;
		this.survivor = survivor;
	}

	@Override
	public void run() {
		flag = new boolean[2];
		caminhando();
		doors();
	}

	private void doors() {

		try {
			divider.acquire();
			if (this.id != survivor) {
				System.out.printf("O cavaleiro #%d foi devorado pelo monstro\n", this.id);
			} else {
				System.out.printf("O sobrevivente foi o cavaleiro #%d\n", this.id);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			divider.release();
		}

	}

	private void caminhando() {

		int desloc = 0;
		int velocidade = (int) ((Math.random() * 3) + 2);

		while (desloc <= X) {
			desloc += velocidade;
			System.out.printf("O cavaleiro #%d percorreu #%dm!\n", this.id, desloc);

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			velocidade = checkpointTocha(desloc, velocidade);
			velocidade = checkpointPedra(desloc, velocidade);
		}

	}

	private int checkpointPedra(int desloc, int velocidade) {
		try {
			divider.acquire();
			if (desloc >= 1500 && !flag[1]) { // pedra
				upgradeVelocidade(velocidade);
				flag[1] = true;
				System.out.printf("O cavaleiro #%d foi quem conquistou a pedra!\n", this.id);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			divider.release();
		}

		return velocidade;
	}

	private int checkpointTocha(int desloc, int velocidade) {
		try {
			divider.acquire();

			if (desloc >= 500 && !flag[0]) { // tocha
				sleepTime();
				upgradeVelocidade(velocidade);
				flag[0] = true;
				System.out.printf("O cavaleiro #%d foi quem conquistou a tocha! \n", this.id);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			divider.release();
		}
		return velocidade;
	}

	private void sleepTime() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private int upgradeVelocidade(int velocidade) {
		return velocidade + 2;
	}

}
