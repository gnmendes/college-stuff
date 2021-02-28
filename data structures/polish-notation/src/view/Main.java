package view;

import controller.Polish;

public class Main {
	public static void main(String[] args) {
		Polish ob = new Polish();
		String expression = "18*(01+1999)/20-3";
		ob.check(expression);
	}

}
