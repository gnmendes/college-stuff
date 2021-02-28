package view;
import controller.ProcessController;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		ProcessController ob = new ProcessController(); 
		Scanner input= new Scanner(System.in);
		ob.so();
		String processo= input.nextLine();
		input.close();
		ob.mataProcesso(processo);

	}

}