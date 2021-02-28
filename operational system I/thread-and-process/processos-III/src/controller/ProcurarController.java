package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ProcurarController implements ActionListener {
	private JTextField textField;

	public ProcurarController(JTextField textField) {
		this.textField=textField;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		procurarArquivo();
	}

	
	private void procurarArquivo() {
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Apenas executaveis (.exe) ", "exe");
		String diretorioBase = System.getProperty("user.home") + "/Desktop";
		File diretorio = new File(diretorioBase);
		
		JFileChooser escolha = new JFileChooser();
		escolha.setCurrentDirectory(diretorio);
		escolha.setFileSelectionMode(JFileChooser.FILES_ONLY);
		escolha.setAcceptAllFileFilterUsed(false);
		escolha.addChoosableFileFilter(filtro);

		StringBuffer caminhoArquivo= new StringBuffer();
		
		int validar= escolha.showOpenDialog(null);
		if(validar == JFileChooser.APPROVE_OPTION) {
			caminhoArquivo.append(escolha.getSelectedFile().getAbsolutePath());
			textField.setText(caminhoArquivo.toString());
		}
		
	}

}

