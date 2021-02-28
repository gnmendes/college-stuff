package view;

import java.util.concurrent.Semaphore;
import controller.ThreadTriatlo;
import model.Tree;

public class Main {
	private static final int SIMULTANEOUS_COMPETITORS = 5;
	private static final int SIMULTANEOUS_INSERTS_AT_TREE = 1;
	private static final int TOTAL_COMPETITORS = 25;

	public static void main(String[] args) {
		Semaphore competitorsSemaphore = new Semaphore(SIMULTANEOUS_COMPETITORS);
		Semaphore treeSemaphore = new Semaphore(SIMULTANEOUS_INSERTS_AT_TREE);
		Tree arvore = new Tree();
		
		for(int id = 1; id <= TOTAL_COMPETITORS; id++) {
			final Thread ob = new ThreadTriatlo(competitorsSemaphore, id, treeSemaphore, arvore);
			ob.start();
		}
	}

}
