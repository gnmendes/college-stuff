package view;

import java.io.IOException;

import controller.ArquivosControllerImp;

public class ArquivosVisao {

	public static void main(String[] args) {
		
		ArquivosControllerImp inst = new ArquivosControllerImp();
		
		String path_origem = "C:\\Users\\mathe\\Downloads";
		String nome = "Exercicio_Arquivos.pdf";
		
		String destino_path= "C:\\Users\\mathe\\Desktop\\tmp";
		
		try {
			inst.copiaArquivos(path_origem, nome, destino_path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
