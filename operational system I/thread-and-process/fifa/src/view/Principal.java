package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import controller.FifaController;

public class Principal {

	public static void main(String[] args) throws IOException {
		String caminho = "C:\\Users\\mathe\\Desktop\\tmp", nome = "data.csv";
		
		Stack<String> stack = new Stack<>();
		List<String> list = new ArrayList<String>();

		FifaController o = new FifaController();
		stack = o.empilhaBrasileiros(caminho, nome);
		o.desmpilhaBonsBrasileiros(stack);
		list = o.listaRevelacoes(caminho, nome);
		System.out.println();
		o.buscaListaBonsJovens(list);

	}

}
