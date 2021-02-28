package view;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.Button;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class Tela extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JLabel lblNewLabel;
	private static JLabel lblNewLabel_1;
	private static JLabel lblNewLabel_2;
	private static JLabel lblNewLabel_3;
	private static JButton btnStart;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
					frame.setResizable(false);
					
					Button ob = new Button(lblNewLabel, lblNewLabel_1 , lblNewLabel_2,
							lblNewLabel_3, btnStart);
					
					btnStart.addActionListener(ob);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(12, 136, 237, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(444, 136, 237, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(12, 264, 237, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setBounds(444, 264, 237, 2);
		contentPane.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.BLACK);
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(248, 12, 1, 126);
		contentPane.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setForeground(Color.BLACK);
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setBounds(248, 264, 1, 126);
		contentPane.add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setForeground(Color.BLACK);
		separator_6.setOrientation(SwingConstants.VERTICAL);
		separator_6.setBounds(444, 12, 1, 126);
		contentPane.add(separator_6);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setForeground(Color.BLACK);
		separator_7.setOrientation(SwingConstants.VERTICAL);
		separator_7.setBounds(444, 264, 1, 126);
		contentPane.add(separator_7);
		
		ImageIcon carImage =  new ImageIcon("car2.png");
		Image resize = carImage.getImage();
		Image temp = resize.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
		carImage = new ImageIcon(temp);
		lblNewLabel = new JLabel(carImage);
		lblNewLabel.setBounds(22, 205, 117, 54);
		contentPane.add(lblNewLabel);
		
		ImageIcon carImage1 =  new ImageIcon("car1.png");
		Image resize1 = carImage1.getImage();
		Image temp1 = resize1.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
		carImage1 = new ImageIcon(temp1);
		lblNewLabel_1 = new JLabel(carImage1);
		lblNewLabel_1.setBounds(570, 143, 99, 54);
		contentPane.add(lblNewLabel_1);
		
		ImageIcon carImage3 =  new ImageIcon("car3.png");
		Image resize3 = carImage3.getImage();
		Image temp3 = resize3.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
		carImage3 = new ImageIcon(temp3);
		lblNewLabel_2 = new JLabel(carImage3);
		lblNewLabel_2.setBounds(256, 12, 73, 54);
		contentPane.add(lblNewLabel_2);
		
		
		ImageIcon carImage4 =  new ImageIcon("car4.png");
		Image resize4 = carImage4.getImage();
		Image temp4 = resize4.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
		carImage4 = new ImageIcon(temp4);
		lblNewLabel_3 = new JLabel(carImage4);
		lblNewLabel_3.setBounds(372, 334, 73, 54);
		contentPane.add(lblNewLabel_3);
		
		btnStart = new JButton("Start");
		btnStart.setBounds(40, 284, 117, 25);
		contentPane.add(btnStart);
	}
}
