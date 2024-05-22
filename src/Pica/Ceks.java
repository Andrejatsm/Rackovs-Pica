package Pica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;

public class Ceks extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ceks frame = new Ceks();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ceks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 555);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		 setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pirkuma Ceks:");
		lblNewLabel.setBounds(10, 11, 159, 14);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(20, 36, 391, 417);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Sutit atkal");
		btnNewButton.setBounds(30, 468, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnBeigt = new JButton("Beigt");
		btnBeigt.setBounds(311, 468, 89, 23);
		contentPane.add(btnBeigt);
		
		
	}
}
