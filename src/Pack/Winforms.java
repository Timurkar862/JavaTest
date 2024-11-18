package Pack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Color;

public class Winforms {

	private JFrame frame;
	private  JLabel lblNewLabel;
	private JTextField textField_1;
	private JList list_1;
	
	public  String name = "";
	public int indexbrand = 0;
	public String brands[] = {"Мерседес", "БМВ", "Ренаулт"};
	private JList list;
	private JLabel lblNewLabel_2;
	public int typecar = 0;
	private JLabel lblNewLabel_3;
	private JTextField textField;
	public double TripTime = 0;
	public double minprice = 0;
	public double gprice = 0;
	public String f = "f";
	private ResultForm resultForm;
	JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Хэтчбек");
	JRadioButton rdbtnNewRadioButton = new JRadioButton("Седан");
	private FError fError;
	public double Gprice () {
		return this.gprice;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Winforms window = new Winforms();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}
	
	public void ReceiveName() {
		name = textField_1.getText();
	}
	
	public void ReceiveBrand() {
		indexbrand = list.getSelectedIndex();

	}
	 
	
	public void ConvertTime() {
		String x = textField.getText();
		String v = "" ;
		boolean c = false;
		boolean forwards = false;
		boolean behind = false;
		/*
		 * char example = ',';
		 
		char ex = '.';
		int index = x.indexOf(example);
		if (index != -1) {
			x = x.substring(0, index) + ex + x.substring(index+1);
		}
		*/
		char b[] = x.toCharArray();
		for (int i  = 0; i < b.length; i++) {
				if ((b[0] == ',') && (c != true)) {		//forwards			
						char ex = '.';	
							v = ex + x.substring(2, b.length);
							forwards = true;
				}
				
				if (b[0] == '.') {
						forwards = true;
			}
				//behind
				if (b[b.length-1] == ',') {
					char ex = '.';	
					v = x.substring(0, b.length-1);
					behind = true;
				}
				if (b[b.length-1] == '.') {
					forwards = true;
		}
			
				if (c== false) {
					if (Character.isDigit(b[i]) || (b[i] == '.')) { //)
						v += b[i];
				}
					else {
					 	if (b[i]==',') {
							char example = ',';
							char ex = '.';
							int index = x.indexOf(example);
							if (index != -1) {
								v = x.substring(0, index) + ex + x.substring(index+1);
								c = true;
								continue;
						}
					}	
			}
			
				
		}
		}
			if (forwards == true) {
				v = "0" + v;
				//x += "r";
			}
			if (behind == true) {
				v = v + "0";
				//x += "r";
			}

		c= false;
		if (v == "") {
			v = "0";
			FError fError = new FError();
			//fError = new FError();
			//fError.frame.setVisible(true);
			fError.frame.setVisible(true);
			fError.ShowError("Неправильный ввод количества часов на прокат!");
			
		}
		TripTime = Double.parseDouble(v);
		//lblNewLabel_2.setText(v);
		v = "";
		forwards = false;
		behind = false;
	}
	
	public void CountMinPrice() {
		if ( (indexbrand == 0 ) && (typecar == 0) ) {
			minprice = 1.01;
		}
		
		if ( (indexbrand == 0 ) && (typecar == 1) ) {
			minprice = 1.21;
		}
		
		if ( (indexbrand == 1 ) && (typecar == 0) ) {
			minprice = 1.34;
		}
		
		if ( (indexbrand == 1 ) && (typecar == 1) ) {
			minprice = 1.32;
		}
		
		if ( (indexbrand == 2 ) && (typecar == 0) ) {
			minprice = 0.89;
		}
		
		if ( (indexbrand == 2 ) && (typecar == 1) ) {
			minprice = 0.987;
		}
	}
	
	public void CountGPrice() {
		gprice = minprice * TripTime*60;
		BigDecimal bd = new BigDecimal(gprice);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		gprice = bd.doubleValue();
	}
	

	/**
	 * Create the application.
	 */
	public Winforms() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Автопрокат");
		frame.getContentPane().setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		frame.setBounds(100, 100, 470, 446);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		resultForm = new ResultForm();
		JButton btnNewButton = new JButton("Нажмите, чтобы рассчитать стоимость поездки"); //button
		btnNewButton.setBackground(new Color(102, 153, 51));
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReceiveName();
				ReceiveBrand();
				ConvertTime();
				CountMinPrice();
				CountGPrice();
				
				 resultForm.SetPrice(Double.toString(gprice));
				 resultForm.ShowName(name);
				 resultForm.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(8, 330, 425, 61);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel = new JLabel("Введите своё имя:");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		lblNewLabel.setBounds(8, 10, 232, 51);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(152, 18, 281, 35);
		frame.getContentPane().add(textField_1);
		
		JLabel lblNewLabel_1 = new JLabel("Выберите марку автомобиля:");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		lblNewLabel_1.setBounds(8, 71, 214, 51);
		frame.getContentPane().add(lblNewLabel_1);
		
		list = new JList(brands);
		list.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		list.setBounds(18, 132, 183, 97);
		frame.getContentPane().add(list);
		list.setSelectedIndex(0);
		
		lblNewLabel_2 = new JLabel("Выберите тип салона:");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		lblNewLabel_2.setBounds(232, 80, 201, 32);
		frame.getContentPane().add(lblNewLabel_2);
		rdbtnNewRadioButton.setSelected(true);
		
		
		rdbtnNewRadioButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			/*	if (rdbtnNewRadioButton.isSelected())
				typecar = 0;
				rdbtnNewRadioButton_1.setSelected(false);
				*/
			}
		});
		rdbtnNewRadioButton.setBounds(232, 130, 101, 21);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		
		rdbtnNewRadioButton_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*if (rdbtnNewRadioButton_1.isSelected())
				typecar = 1;
				else {
					rdbtnNewRadioButton.setSelected(false);
				}
				*/
			}
		});
		rdbtnNewRadioButton_1.setBounds(232, 162, 101, 21);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		lblNewLabel_3 = new JLabel("Введите срок проката в часах:");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		lblNewLabel_3.setBounds(20, 239, 281, 19);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		textField.setBounds(18, 276, 143, 32);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		 ButtonGroup group = new ButtonGroup();
	        group.add(rdbtnNewRadioButton);
	        group.add(rdbtnNewRadioButton_1);
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}
}
