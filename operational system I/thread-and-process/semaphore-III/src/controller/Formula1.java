package controller;

import java.util.concurrent.Semaphore;

public class Formula1 extends Thread {

	private final int LAP_EXTENSION = 1000; 
	private int id;
	private Semaphore sync;
	private int piloto;
	private Struct[] vetor = new Struct[14];
	private static int count;
	private Semaphore allowed[];

	public Formula1(int id, Semaphore sync, int piloto, Struct[] vetor, Semaphore[] allowed) {
		this.id = id;
		this.sync = sync;
		this.piloto = piloto;
		this.vetor = vetor;
		this.allowed = allowed;
	}

	@Override
	public void run() {
		try {
			allowed [this.id - 1].acquire();
			try {
				sync.acquire();
				pista();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				sync.release();
			}
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}finally {
			allowed [this.id - 1].release();
		}
		
		if (count == 14) {
			Operacoes set = new Operacoes();
			vetor = set.sortStruct(vetor);
			set.exibe(vetor);
		}
	}

	private void pista() {
		int i = 1;
		int traveled = 0;
		long timeB = System.nanoTime();
		double divideBy = Math.pow(10, 9);
		double[] verify = new double[3];

		while (i <= 3) {
			traveled += (int) ((Math.random() * 61) + 40);

			if (traveled >= LAP_EXTENSION) {

				traveled = 0;
				long timeF = System.nanoTime();
				double time = (timeF - timeB) / divideBy;
				verify[i - 1] = time;
				System.out.printf("O piloto #%d da escudaria %d " + "completou a #%d volta em %fs!\n", piloto, id, i,
						time);
				i++;
				timeB = System.nanoTime();
			}
		}

		feedVector(verify);
	}

	private void feedVector(double[] verify) {

		double time = verify[0];
		int lap = 1;
		for (int i = 1; i < 3; i++) { 
			if (verify[i] < time) {
				time = verify[i];
				lap = (i + 1);
			}
		}
		vetor[count].id = id;
		vetor[count].piloto = piloto;
		vetor[count].tempo = time;
		vetor[count].volta = lap;
		count++;
	}
}
