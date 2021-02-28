package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.Search;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import javax.swing.JLabel;

public class SearchBoundary extends JFrame {

	private static final long serialVersionUID = -6320850094664444640L;
	private JPanel contentPane;
	private static JButton btnNewButton;
	private static JTextArea textArea;
	private static JLabel lblNewLabel;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchBoundary frame = new SearchBoundary();
					
					frame.setVisible(true);
					frame.setResizable(false);
					Search ob = new Search(textArea, lblNewLabel);
					btnNewButton.addActionListener(ob);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SearchBoundary() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Procurar");
		btnNewButton.setBounds(12, 23, 114, 25);
		contentPane.add(btnNewButton);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setForeground(new Color(51, 51, 51));
		textArea.setLineWrap(true);
		textArea.setBounds(12, 49, 424, 214);
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Courier New", Font.PLAIN, 12));
		
		JScrollPane j = new JScrollPane(textArea);
		j.setBounds(12,60,660,261);
		j.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(j);
		
		lblNewLabel = new JLabel("    ");
		lblNewLabel.setBounds(210, 25, 344, 20);
		contentPane.add(lblNewLabel);
	}
}
