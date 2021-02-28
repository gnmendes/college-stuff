package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Tela;

public class CancelarController implements ActionListener {
	private Tela frame;

	public CancelarController(Tela frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		frame.dispose();

	}

}
