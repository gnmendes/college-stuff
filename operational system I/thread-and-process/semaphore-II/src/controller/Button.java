package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Button implements ActionListener {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton btnStart;
	
	public Button(JLabel lblNewLabel, JLabel lblNewLabel_1 ,JLabel lblNewLabel_2,
			JLabel lblNewLabel_3, JButton btnStart) {
		
		this.lblNewLabel = lblNewLabel;
		this.lblNewLabel_1 = lblNewLabel_1;
		this.lblNewLabel_2 = lblNewLabel_2;
		this.lblNewLabel_3 = lblNewLabel_3;
		this.btnStart = btnStart;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		validaBotao();
		
	}

	private void validaBotao() {
		
		Semaphore sync = new Semaphore(1);
		
		Thread ob = new ThreadCarro(lblNewLabel, sync, 1, btnStart);
		Thread ob1 = new ThreadCarro(lblNewLabel_1, sync, 2, btnStart);
		Thread ob2 = new ThreadCarro(lblNewLabel_2, sync, 3, btnStart);
		Thread ob3 = new ThreadCarro(lblNewLabel_3, sync, 4, btnStart);
		
		ob.start();
		ob1.start();
		ob2.start();
		ob3.start();
		
	}

}
