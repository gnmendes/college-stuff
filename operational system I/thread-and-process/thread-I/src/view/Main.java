package view;

import controller.ThreadController;
import java.security.SecureRandom;

public class Main {

	public static void main(String[] args) {

		SecureRandom random = new SecureRandom();

		for (int i = 0; i < 5; i++) {

			Thread ob = new ThreadController(random.nextInt(475));
			ob.start();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
