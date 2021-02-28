package controller;

import java.util.concurrent.Semaphore;

public class Bank extends Thread {
	private int id;
	private double valorConta;
	private int saldo;
	private Semaphore[] permissions;

	public Bank(int id, double valorConta, int saldo, Semaphore[] permissions) {

		this.id = id;
		this.valorConta = valorConta;
		this.saldo = saldo;
		this.permissions = permissions;
	}

	@Override
	public void run() {

		try {
			permissions[this.id % 2].acquire();
			account();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			permissions[this.id % 2].release();
		}
	
	}

	private void account() {

		if (id % 2 == 0) {
			valorConta += saldo;
			System.out.printf("A conta realizou um deposito no valor de R$%d!\nSaldo atual: %f\n", saldo, valorConta);
		} else {
			valorConta -= saldo;
			System.out.printf("A conta efetuou um saque no valor de R$%d!\nSaldo atual: %f\n", saldo, valorConta);
		}

	}
}
