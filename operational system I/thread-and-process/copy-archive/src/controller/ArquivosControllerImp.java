package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ArquivosControllerImp implements IArquivosController {

	public ArquivosControllerImp() {
		super();
	}
	
	@Override
	public void copiaArquivos(String diretorio, String nomeArquivo, String novoDiretorio) throws IOException {
		File archive = new File(diretorio, nomeArquivo); // o meu arquivo a ser copiado
		File copy = new File(novoDiretorio, nomeArquivo);

		if(new File(novoDiretorio).isDirectory()) {
			OutputStream os = new FileOutputStream(copy);

			if(archive.isFile() && archive.exists()) {
				FileInputStream fluxo = new FileInputStream(archive);

				byte[] bufferzinho = new byte[4096]; // tamanho ótimo

				int len = fluxo.read(bufferzinho);

				while (len != -1) {
					os.write(bufferzinho, 0, len);
					len = fluxo.read(bufferzinho);
				}
				os.flush(); //sei o q é isso n
				fluxo.close();
				os.close();
				System.out.println("arquivo copiado com sucesso!");
			}
		}else
			throw new IOException();

	}

}
