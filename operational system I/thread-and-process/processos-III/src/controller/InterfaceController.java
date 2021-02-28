package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import view.Tela;

public class InterfaceController implements ActionListener {
	private JTextField textField;
	private Tela frame;

	public InterfaceController(Tela frame, JTextField textField) {
		this.textField = textField;
		this.frame = frame;
	}

	public boolean runProcess() {
		StringBuffer buffer = new StringBuffer();

		if (System.getProperty("os.name").contains("Windows")) {
			buffer.append("cmd /c ");
			buffer.append(textField.getText());
			
			try {
				Runtime.getRuntime().exec(buffer.toString());
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			
		} else {
			
			String[] cmd = {"/bin/bash","-c","echo \"password\"| sudo -S ls"};
			ProcessBuilder process = new ProcessBuilder();
			process.command(cmd);
			String clean = textField.getText().trim();
			process.command(clean);
			try {
				process.start();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}

		return true;
	}

	public void actionPerformed(ActionEvent e) {
		if (runProcess()) {
			frame.dispose();
		}

	}
}
