package view;

import java.util.concurrent.Semaphore;

import controller.KatyPerryConcert;

public class Main {

	public static void main(String[] args) {
		
		Semaphore gate = new Semaphore(1);
		
		for(int id = 1; id <=300; id ++) {
			
			Thread prism = new KatyPerryConcert((int)(Math.random()*4 + 1), gate, id);
			prism.start();
		}
	}

}
