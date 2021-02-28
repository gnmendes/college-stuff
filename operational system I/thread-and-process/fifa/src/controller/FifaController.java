package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FifaController implements IFifaController {

	public FifaController() {
		super();
	}

	@Override
	public Stack<String> empilhaBrasileiros(String caminho, String nome) throws IOException {
		Stack<String> stack = new Stack<>();
		File archive = new File(caminho, nome);
		
		if (archive.isFile() && archive.exists()) {
			FileInputStream fluxo = new FileInputStream(archive);
			InputStreamReader leitor_fluxo = new InputStreamReader(fluxo);
			BufferedReader leitor = new BufferedReader(leitor_fluxo); 

			String s = leitor.readLine();
			s = leitor.readLine();

			while (s != null) {
				if (s.contains(LOCAL)) {
					stack.push(s);
				}
				s = leitor.readLine();
			}
			fluxo.close();
			leitor_fluxo.close();
			leitor.close();

		} else
			throw new IOException("Arquivo inválido!");

		return stack;
	}

	@Override
	public void desmpilhaBonsBrasileiros(Stack<String> pilha) throws IOException {
		int value = 0;
		System.out.println("BONS JOGADORES BRASILEIROS:");
		while (!pilha.isEmpty()) {
			String[] s = pilha.pop().split(",");
			
			s[2] = filtro(s[2]);
			s[7] = filtro(s[7]);
			
			value = convert(s[7]);
			if (value > MIN_OVERALL)
				System.out.printf("Nome: %s || Overall : %s\n", s[2], s[7]);

		}

	}

	@Override
	public List<String> listaRevelacoes(String caminho, String nome) throws IOException {
		List<String> list = new ArrayList<>();
		String s = "";
		int age = 0;
		File archive = new File(caminho, nome);

		FileInputStream fluxo = new FileInputStream(archive);
		InputStreamReader r_fluxo = new InputStreamReader(fluxo);
		BufferedReader leitor = new BufferedReader(r_fluxo);

		s = leitor.readLine();
		s = leitor.readLine();
		
		while (s != null) {
			String tmp[] = s.split(",");
			tmp[3] = filtro(tmp[3]);//idade
			tmp[7] = filtro(tmp[7]);//overall
			
			age = convert(tmp[3]);
			if (age <= Limit_AGE) {
				list.add(s);
			}
			s = leitor.readLine();
		}
		r_fluxo.close();
		fluxo.close();
		leitor.close();

		return list;
	}

	@Override
	public void buscaListaBonsJovens(List<String> lista) throws IOException {
		Stack<String> stack = new Stack<>();
		int overall = 0;
		
		System.out.println("BONS JOGADORES JOVENS E BRASILEIROS:");
		for (String tmp : lista) {
			String s[] = tmp.split(",");
			
			s[2] = filtro(s[2]);
			s[3] = filtro(s[3]);
			s[7] = filtro(s[7]);
			
			overall = convert(s[7]);
			if (overall >= MIN_OVERALL) {
				stack.push("Nome: " + s[2] + ", idade: " + s[3] + ", overall: " + s[7]);
			}
				
		}
		
		while(!stack.isEmpty())
			System.out.println(stack.pop());
	}

	private int convert(String s) {
		int value = 0;
		try {
			value = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			System.err.print(e);
		}
		return value;

	}
	
	private String filtro(String s) {
		return s.replace(",", "");
	}
}
