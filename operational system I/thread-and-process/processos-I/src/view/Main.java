package view;

import controller.RedesController;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		RedesController objeto = new RedesController();
		//

		Scanner input = new Scanner(System.in);
		int opcao = 0;
		while (opcao != 3) {
			System.out.println("Insira uma das op��es:\n1- para obter informa��es sobre o ip"
					+ "\n2- para obter informa��es sobre o ping" + "\n3- para finalizar a opera��o");
			opcao = input.nextInt();
			switch (opcao) {
			case (1):
				System.out.println(objeto.ip(System.getProperty("os.name")));
				break;
			case (2):
				objeto.ping(System.getProperty("os.name"));
				break;
			case (3):
				System.out.println("Obrigado!");
				break;
			default:
				System.out.println("Opera��o inv�lida!");
			}
		}
		input.close();
	}

}
