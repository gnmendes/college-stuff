package controller;

import java.security.SecureRandom;

import javax.swing.JButton;
import javax.swing.JTextField;

public class ThreadController extends Thread {
	private final int MAX_NUMBER = 7;
	private JTextField textField;
	private JButton btnStart;

	public ThreadController(JTextField textField, JButton btnStart) {
		this.textField = textField;
		this.btnStart = btnStart;
	}
	
	@Override
	public void run() {
		isWorking();
	}

	private void isWorking() {
		
		SecureRandom random = new SecureRandom();
		
		for(int i = 1; i <= 150; i++) {
		textField.setText(String.valueOf(random.nextInt(MAX_NUMBER)));
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		btnStart.setEnabled(true);
	}
}
