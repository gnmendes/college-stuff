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
			System.out.println("Insira uma das opções:\n1- para obter informações sobre o ip"
					+ "\n2- para obter informações sobre o ping" + "\n3- para finalizar a operação");
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
				System.out.println("Operação inválida!");
			}
		}
		input.close();
	}

}
