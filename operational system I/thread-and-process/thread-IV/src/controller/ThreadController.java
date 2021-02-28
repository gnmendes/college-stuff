package controller;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Rectangle;
import java.security.SecureRandom;

public class ThreadController extends Thread {
	private final int MAX_RANGE = 9500;
	private final int MAX_VELOCITY = 20;
	private JButton btnIniciar;
	private JLabel lblCarro;
	private JTextField textField;
	private JTextField textField_1;
	private int n;
 
	public ThreadController(JButton btnIniciar, JLabel lblCarro, JTextField textField, JTextField textField_1, int n) {
		this.btnIniciar = btnIniciar;
		this.lblCarro = lblCarro;
		this.textField = textField;
		this.textField_1 = textField_1;
		this.n = n;

	}

	private void race() {
		int count = 0;
		SecureRandom random = new SecureRandom();

		Rectangle posicao = lblCarro.getBounds();
		while (count <= MAX_RANGE) {
			posicao.x += random.nextInt(MAX_VELOCITY);
			lblCarro.setBounds(posicao);
			count += posicao.x;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		btnIniciar.setEnabled(true);
	}

	@Override
	public void run() {
		race();
		textField.setText("Carro " + n);
		if (n == 1) {
			n++;
		} else {
			n--;
		}
		textField_1.setText("Carro " + n);
	}
}
