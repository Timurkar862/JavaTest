package Pack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ResultForm {

	public JFrame frame;
	public String result = "nothing";
	static ResultForm window = new ResultForm();
/*
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					ResultForm window = new ResultForm();
					window.frame.setVisible(true);
					/*if (x == true ) {
					window.frame.setVisible(true);
					} else {
						window.frame.setVisible(false);
					}*/
				} catch (Exception e) {
					e.printStackTrace();
				}}});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public ResultForm() {
		initialize();
	}
	JLabel lblNewLabel_1 = new JLabel("nothing");
	JLabel lblNewLabel_2 = new JLabel("Дорогой клиент ");
	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		this.frame = new JFrame();
		frame.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		frame.setTitle("Оценка результата");
		frame.setBackground(SystemColor.window);
		this.frame.setBounds(100, 100, 511, 268);
		this.frame.getContentPane().setLayout(null);
		lblNewLabel_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));

		lblNewLabel_1.setBounds(278, 71, 212, 41);
		this.frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Стоимость поездки оценена в:");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 71, 252, 41);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		
	
		lblNewLabel_2.setBounds(10, 11, 320, 50);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Закрыть окошко");
		btnNewButton.setBackground(new Color(51, 204, 255));
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(10, 133, 165, 82);
		frame.getContentPane().add(btnNewButton);
		
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public void SetPrice(String x) {
        lblNewLabel_1.setText(x);  
    }
	public void ShowName(String n) {
		lblNewLabel_2.setText("Дорогой клиент "+ n + "!");
	}
}
