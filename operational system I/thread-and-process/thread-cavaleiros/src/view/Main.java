package view;

import java.util.concurrent.Semaphore;
import controller.CavaleirosThread;

public class Main {

	public static void main(String[] args) {
		
		int survivor = (int)((Math.random()* 3) + 1);
		Semaphore divider = new Semaphore(1);
		
		for(int id = 1; id <= 4; id++) {
			Thread ob =  new CavaleirosThread(divider, id, survivor);
			ob.start();
		}
		
	}

}
