package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CancelarController;
import controller.InterfaceController;
import controller.ProcurarController;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField textField;
	private static JButton btnCancelar;
	private static JButton btnOk;
	private static JButton btnProcurar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Tela frame = new Tela();
					frame.setVisible(true);
					frame.setResizable(false);
					
					InterfaceController ob = new InterfaceController(frame, textField);
					CancelarController object = new CancelarController(frame);
					ProcurarController objeto= new ProcurarController(textField);
					
					btnOk.addActionListener(ob);
					textField.addActionListener(ob);
					btnCancelar.addActionListener(object);
					btnProcurar.addActionListener(objeto);
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 437, 293);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblExecutar = new JLabel("Executar");
		lblExecutar.setFont(new Font("Arial", Font.BOLD, 12));
		lblExecutar.setBounds(25, 143, 60, 21);
		contentPane.add(lblExecutar);

		textField = new JTextField();
		textField.setBounds(87, 144, 289, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		btnOk = new JButton("OK");

		btnOk.setBounds(87, 176, 89, 23);
		contentPane.add(btnOk);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(186, 176, 89, 23);
		contentPane.add(btnCancelar);

		btnProcurar = new JButton("Procurar");
		btnProcurar.setBounds(285, 176, 89, 23);
		contentPane.add(btnProcurar);

	}

}
