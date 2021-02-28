package view;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.ButtonController;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Font;

public class Boundary extends JFrame {


	private static final long serialVersionUID = 1L;
	private static JButton btnIniciar;
	private static JPanel contentPane;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JLabel lblCarro;
	private static JLabel lblCarro_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Boundary frame = new Boundary();
					frame.setVisible(true);
					frame.setResizable(false);
					ButtonController ob = new ButtonController(btnIniciar, textField, 
							textField_1, lblCarro, lblCarro_1);
					btnIniciar.addActionListener(ob);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		});
	}


	public Boundary() {
		setFont(new Font("Courier 10 Pitch", Font.BOLD, 13));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 344);
		contentPane  = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon carImage = new ImageIcon("car.png");
		Image resize = carImage.getImage();
		Image newOne = resize.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
		carImage = new ImageIcon(newOne);
		lblCarro = new JLabel(carImage);
		lblCarro.setBounds(42, 117, 131, 54);
		contentPane.add(lblCarro);
	
		ImageIcon imageIcon =  new ImageIcon("cart.png");
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg); 
		lblCarro_1 = new JLabel(imageIcon);
		lblCarro_1.setBounds(42, 31, 131, 54);
		contentPane.add(lblCarro_1);
		
		btnIniciar = new JButton("Iniciar");
		btnIniciar.setBounds(22, 255, 117, 25);
		contentPane.add(btnIniciar);
		
		textField = new JTextField();
		textField.setBounds(348, 227, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		textField_1 = new JTextField();
		textField_1.setBounds(348, 258, 114, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEditable(false);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		separator.setBounds(42, 103, 516, 10);
		contentPane.add(separator);
		
		JLabel lblGanhador = new JLabel("Ganhador");
		lblGanhador.setBounds(260, 229, 70, 15);
		contentPane.add(lblGanhador);
		
		JLabel lblPerdedor = new JLabel("Perdedor");
		lblPerdedor.setBounds(260, 260, 70, 15);
		contentPane.add(lblPerdedor);
		
		
	}
}
