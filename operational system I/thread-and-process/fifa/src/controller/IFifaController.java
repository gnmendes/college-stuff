package controller;

import java.io.IOException;
import java.util.List;
import java.util.Stack;

public interface IFifaController {
	public final int MIN_OVERALL = 80;
	public final int Limit_AGE = 20;
	public final String LOCAL = "Brazil";
	
	public Stack<String> empilhaBrasileiros(String caminho, String nome) throws IOException;
	
	public void desmpilhaBonsBrasileiros(Stack<String> pilha) throws IOException;
	
	public List<String> listaRevelacoes(String caminho, String nome) throws IOException;
	
	public void buscaListaBonsJovens(List<String> lista) throws IOException;
}
