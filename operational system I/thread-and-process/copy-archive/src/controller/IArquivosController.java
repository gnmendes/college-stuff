package controller;

import java.io.IOException;

public interface IArquivosController {
	
	public void copiaArquivos(String diretorio, 
			String nomeArquivo, String novoDiretorio) throws IOException;

}
