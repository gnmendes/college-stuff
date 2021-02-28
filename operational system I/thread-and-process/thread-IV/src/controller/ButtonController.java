package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ButtonController implements ActionListener {
	private JButton btnIniciar;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblCarro;
	private JLabel lblCarro_1;

	public ButtonController(JButton btnIniciar, JTextField textField, JTextField textField_1, JLabel lblCarro,
			JLabel lblCarro_1) {
  
		this.btnIniciar = btnIniciar;
		this.textField = textField;
		this.textField_1 = textField_1;
		this.lblCarro = lblCarro;
		this.lblCarro_1 = lblCarro_1;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		letsAct();
	}

	private void letsAct() {
		
		btnIniciar.setEnabled(false);
		
		Thread ob = new ThreadController(btnIniciar, lblCarro, textField, textField_1, 1);
		Thread obj = new ThreadController(btnIniciar, lblCarro_1, textField, textField_1, 2);
	
		ob.start();
		
		lblCarro.setBounds(42, 117, 131, 54);
	
		obj.start();
		
		lblCarro_1.setBounds(42, 31, 131, 54);
	}
}
