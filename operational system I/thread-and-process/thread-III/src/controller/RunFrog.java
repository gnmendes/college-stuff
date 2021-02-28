package controller;

public class RunFrog extends Thread {
	private final int LAKE = 1000;
	private final int JUMP = 10;
	private int id;
	private static int classificacao;
	
	public RunFrog(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		race();
	}

	private void race() {
		int desloc = 0;
		
		while(desloc <= LAKE) {
			int salto = (int)(Math.random()*JUMP);
			desloc += salto;
			System.out.printf("O sapo #%d saltou %d e já percorreu %d\n", this.id, salto, desloc);
		}
		
		ranking();
	}

	private void ranking() {
		classificacao++;
		System.out.printf("O sapo #%d chegou em %dº lugar!\n", this.id, classificacao);
	}
}
