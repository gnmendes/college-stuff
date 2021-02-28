package controller;

public class ThreadController extends Thread{
		
	private int number;
	public ThreadController(int number) {
		this.number = number;
	}
	
	@Override
	public void run() {
		
		showNumber();
	}

	private void showNumber() {
		
		System.out.printf("Número: %d\n",this.number);
		
	}
}
