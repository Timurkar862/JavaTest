package Pack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FError {

	static JFrame frame;
	static FError window = new FError();
	JLabel lblNewLabel = new JLabel("Ошибка");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FError window = new FError();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FError() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Ошибка");
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		lblNewLabel.setForeground(new Color(51, 255, 0));
		lblNewLabel.setBackground(SystemColor.activeCaption);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 405, 160);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Закрыть сообщение");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBackground(new Color(0, 255, 204));
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btnNewButton.setBounds(10, 182, 183, 70);
		frame.getContentPane().add(btnNewButton);
	}
	
	public void ShowError (String g) {
		lblNewLabel.setText(g);
	}
}
