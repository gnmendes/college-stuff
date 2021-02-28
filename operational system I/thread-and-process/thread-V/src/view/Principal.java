package view;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.ButtonController;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Principal extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JButton btnStart;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
					frame.setResizable(false);
					
					ButtonController ob = new ButtonController(textField, textField_1, 
							textField_2, btnStart);
					
					btnStart.addActionListener(ob);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 403, 278);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnStart = new JButton("Start");
		btnStart.setBounds(31, 174, 117, 25);
		contentPane.add(btnStart);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.setBounds(31, 53, 93, 72);
		textField.setFont(new Font("Arial", Font.BOLD, 45 ));
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(JTextField.CENTER);
		textField_1.setBounds(143, 53, 93, 72);
		textField_1.setFont(new Font("Arial", Font.BOLD, 45 ));
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEditable(false);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(JTextField.CENTER);
		textField_2.setBounds(259, 53, 93, 72);
		textField_2.setFont(new Font("Arial", Font.BOLD, 45 ));
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setEditable(false);
		
	}
}
