package controller;

import java.awt.Rectangle;
import java.util.concurrent.Semaphore;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ThreadCarro extends Thread {
	private JLabel label;
	private Semaphore sync;
	private int id;
	private JButton btnStart;
	
	public ThreadCarro(JLabel label, Semaphore sync, int id, JButton btnStart) {
		this.label = label;
		this.sync = sync;
		this.id = id;
		this.btnStart = btnStart;
	}

	@Override
	public void run() {
		btnStart.setEnabled(false);
		caminhoLivre();
		try {
			sync.acquire();
			cruzamento();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			sync.release();
		}

	}

	private void cruzamento() {
		int dist = 500;
		int trip = 0;
		
		Rectangle bounds = label.getBounds();
		while (trip < dist) {
			trip = caso(bounds, trip);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void caminhoLivre() {
		Rectangle bounds = label.getBounds();
		int dist = 0;
		while (dist <= 90) {
				dist = caso(bounds, dist);
			
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

	private int caso(Rectangle bounds, int dist) {
		int aux;
		switch (id) {

		case (1):
			aux = (int) (Math.random() * 11 + 3);
			bounds.x += aux;
			dist += aux;
			label.setBounds(bounds);
			return dist;
			
		case (2):
			aux = (int) (Math.random() * 11 + 3);
			bounds.x -= aux;
			dist += aux;
			label.setBounds(bounds);
			return dist;
			
		case (3):
			aux = (int) (Math.random() * 11 + 3);
			bounds.y += aux;
			dist += aux;
			label.setBounds(bounds);
			return dist;
			
		case (4):
			aux = (int) (Math.random() * 11 + 3);
			bounds.y -= aux;
			dist += aux;
			label.setBounds(bounds);
			return dist;
		}
		return dist;
	}
}
