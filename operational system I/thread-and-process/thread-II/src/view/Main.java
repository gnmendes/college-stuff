package view;

import controller.CalculateLine;
import java.security.SecureRandom;

public class Main {

	public static void main(String[] args) {

		int[][] matrix = new int[3][5];
		int line = matrix.length;
		int col = matrix[0].length;
		SecureRandom random = new SecureRandom();

		for (int i = 0; i < line; i++) {

			for (int j = 0; j < col; j++) {

				matrix[i][j] = random.nextInt(975);
			}
		}

		for (int i = 0; i < line; i++) {

			Thread ob = new CalculateLine(matrix[i], i);
			ob.start();

			/*try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			*/
		}
	}

}
