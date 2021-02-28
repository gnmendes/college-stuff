package view;

import java.util.concurrent.Semaphore;

import controller.Garage;

public class Main {
	public static void main(String[] args) {
		Semaphore floor_1st = new Semaphore(1);
		Semaphore floor_2nd = new Semaphore(1);
		
		for(int id = 1; id <= 20; id++) {
			Thread ob =  new Garage(id, floor_1st, floor_2nd);
			ob.start();
		}
		
	}
}
