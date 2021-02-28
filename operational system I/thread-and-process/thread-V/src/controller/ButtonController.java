package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class ButtonController implements ActionListener {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnStart;
	
	public ButtonController(JTextField textField, JTextField textField_1,
			JTextField textField_2, JButton btnStart) {
		
		this.textField = textField;
		this.textField_1 = textField_1;
		this.textField_2 = textField_2;
		this.btnStart = btnStart;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		makeThisWork();
	}

	private void makeThisWork() {
		btnStart.setEnabled(false);
		
		ThreadController ob = new ThreadController(textField, btnStart);
		ThreadController objeto =  new ThreadController(textField_1, btnStart);
		ThreadController outroObjeto = new ThreadController(textField_2, btnStart);
		
		ob.start();
		objeto.start();
		outroObjeto.start();
	}
}
