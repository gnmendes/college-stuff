package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class RedesController {

	public RedesController() {
		super();
	}

	public String ip(String soInfo) {
		StringBuffer buffer = new StringBuffer();
		if (soInfo.contains("Windows")) {

			buffer.append("cmd /c ");
			buffer.append("IPCONFIG");
		} else {
			buffer.append("ifconfig");
		}

		StringBuffer temp = new StringBuffer();
		try {

			Process processo = Runtime.getRuntime().exec(buffer.toString());
			InputStream fluxo = processo.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader ler = new BufferedReader(leitor);
			String linha = ler.readLine();

			while (linha != null) {

				if (linha.contains("Ethernet") || linha.contains("IPv4") || linha.contains("netmask")
						|| linha.contains("inet")) {
					temp.append(linha);
					temp.append("\n");
				}

				linha = ler.readLine();

			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}

		return temp.toString();
	}

	public void ping(String soName) {
		StringBuffer buffer = new StringBuffer();
		if (soName.contains("Windows")) {

			buffer.append("cmd /c ");
			buffer.append("PING -t www.google.com.br");

		} else {
			buffer.append("ping -c 10 www.google.com.br");

		}
		try {

			Process processo = Runtime.getRuntime().exec(buffer.toString());
			InputStream fluxo = processo.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader ler = new BufferedReader(leitor);

			String linha = ler.readLine();
			int i = 0;
			float media = 0F;

			while (linha != null && i++ <= 10) {

				linha = ler.readLine();

				if (linha.contains("ms")) {

					int indice = linha.lastIndexOf('=');
					int index = linha.lastIndexOf('m');

					media += Float.parseFloat(linha.substring(indice + 1, index));
					indice = linha.lastIndexOf("tempo");
					index = linha.lastIndexOf('s');

					System.out.println(linha.substring(indice + 1, index + 1));
				}

			}
			media /= 10;
			System.out.printf("A media do ping é: %fms\n ", media);

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
}
