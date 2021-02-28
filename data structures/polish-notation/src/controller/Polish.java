package controller;

public class Polish {
	private StringBuffer polish;

	public Polish() {
		super();
	}

	public void check(String expression) {
		expression = expression.trim();
		int tamanho = expression.length();
		Stack operator = new Stack();

		polish = new StringBuffer();

		for (int i = 0; i < tamanho; i++) {

			char temp = expression.charAt(i);

			try {

				if (Character.isDigit(temp)) {
					polish.append(temp);

				} else if (temp == '(') {
					operator.push(temp);

				} else if (temp == ')') {

					while (!operator.isEmpty() && operator.peek() != '(') {
						polish.append(operator.pop());
					}
					operator.pop();

				} else {
					while (!operator.isEmpty() && whatOperator(temp) <= whatOperator(operator.peek())) {
						polish.append(operator.pop());
					}
					operator.push(temp);
				}
			} catch (EmptyStackException e) {
				System.out.println(e);
			}
		}
		copyForgotten(operator);
		System.out.println(polish.toString());

	}

	private void copyForgotten(Stack operadores) {
		while (!operadores.isEmpty()) {
			try {
				char a = operadores.pop();
				polish.append(a);
			} catch (EmptyStackException e) {
				continue;
			}
		}
	}

	public int whatOperator(char op) {

		if (op == '+' || op == '-')
			return 1;
		else if (op == '/' || op == '*')
			return 2;

		return -1;

	}
}
