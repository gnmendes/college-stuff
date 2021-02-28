package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Search implements ActionListener {
	private JTextArea textArea;
	private JLabel label;
	
	public Search(JTextArea textArea, JLabel label) {
		this.textArea = textArea;
		this.label = label;
	}

	public void actionPerformed(ActionEvent e) {
		String path = getPath();
		File dir = new File(path);

		displayText(dir);

	}

	private void displayText(File dir) {
		StringBuffer mkStr = new StringBuffer();

		label.setText("\t Diretório: " + dir.getName() + "\n\n");
		mkStr = getContent(dir, dir.length(), mkStr, "");

		this.textArea.setText(mkStr.toString());
		this.textArea.requestFocus();
	}

	private StringBuffer getContent(File dir, long dir_size, StringBuffer mkStr, String tab) {
		if (dir_size == 0)
			return mkStr;
		else {
			File content[] = dir.listFiles();

			for (File a : content) {

				if (a.isFile())
					mkStr.append((tab + "\t       |___" + a.getName() + "\n"));

				else if (a.isDirectory()) {
					mkStr.append((tab + "\t|_____" + a.getName() + "\n"));
					getContent(a, a.length(), mkStr, tab + "    ");
				}
			}
		}
		return mkStr;
	}

	private String getPath() {
		File base = new File(System.getProperty("user.home") + "/Desktop");
		JFileChooser path_dir = new JFileChooser();

		int flag;

		path_dir.setCurrentDirectory(base);
		path_dir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		path_dir.setAcceptAllFileFilterUsed(false);

		do {
			flag = path_dir.showOpenDialog(null);
		} while (flag != JFileChooser.APPROVE_OPTION);

		
		return path_dir.getSelectedFile().getAbsolutePath();

	}
}