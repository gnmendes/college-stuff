package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class ProcessController {
	public ProcessController() {
		super();
	}

	public void so() {
		String soVersion = System.getProperty("os.version");
		String soName = System.getProperty("os.name");
		
		System.out.println(soName + "\n" + soVersion);

		if (soName.contains("Linux")) {
			leProcesso("ps -ax");
		} else {
			leProcesso("TASKLIST /FO TABLE");
		}

	}

	public void chamaProcesso(String processo) {
		StringBuffer buffer = new StringBuffer();
		if (System.getProperty("os.name").contains("Windows")) {

			buffer.append("cmd /c ");
			buffer.append(processo);

			try {
				Runtime.getRuntime().exec(buffer.toString());
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}
			
		} else {
		
			String[] cmd = {"/bin/bash","-c","echo \"password\"| sudo -S ls"};
			ProcessBuilder process = new ProcessBuilder();
			String[] command = processo.split(" ");
			process.command(cmd);
			process.command(command);
		
			try {
			
				process.start();
			
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(),
						"ERROR", JOptionPane.ERROR_MESSAGE);
			}
		   
		}
	}

	public void leProcesso(String processo) {
		try {
			Process pr = Runtime.getRuntime().exec(processo);
			InputStream fluxo = pr.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();

			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);

		}

	}

	public void mataProcesso(String info) {
		StringBuffer buffer = new StringBuffer();
		String cmdNome = " ";
		String cmdPID = " ";
		int pid = 0;

		if (System.getProperty("os.name").contains("Windows")) {
			cmdNome = "TASKKILL /IM ";
			cmdPID = "TASKKILL /PID ";

		} else {
			cmdNome = "killall -r --regex ";
			cmdPID = "kill -9 ";
		}

		try {
			pid = Integer.parseInt(info);
			buffer.append(cmdPID);
			buffer.append(pid);
		} catch (NumberFormatException e) {
			buffer.append(cmdNome);
			buffer.append(info);
		} finally {
			chamaProcesso(buffer.toString());
		}

	}

}