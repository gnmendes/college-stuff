package view;

import controller.RunFrog;

public class Main {

	public static void main(String[] args) {
		
		
		for(int id = 1; id <= 5; id++) {
			
			Thread ob = new RunFrog(id);
			ob.start();
		}
	}

}