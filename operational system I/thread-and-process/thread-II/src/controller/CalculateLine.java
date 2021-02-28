package controller;

public class CalculateLine extends Thread {
	
	private int [] arr;
	private int line;
	public CalculateLine(int[]arr, int line) {
		this.arr = arr;
		this.line = line;
	}
	
	@Override
	public void run() {
		
		calc();
	}

	private void calc() {
		int sum = 0;
		
		for(int item : arr) {
			sum += item; 
		}
		System.out.printf("A soma da linha (%d) é: %d\n", line, sum);
	}
	
}
