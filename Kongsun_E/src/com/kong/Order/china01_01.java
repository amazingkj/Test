package com.kong.Order;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.kong.Home.Home;
import com.kong.Home.My;
import com.kong.JDBC.MenuDAO;
import com.kong.JDBC.MenuDTO;

public class china01_01 extends JFrame{
	MenuDAO dao = new MenuDAO();
	MenuDTO dto = new MenuDTO();
	//private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					china01_01 window = new china01_01();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public china01_01() {
		initialize();
	}

	
	private void initialize() {
		setVisible(true);
		//frame = new JFrame();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);
		setSize(480,800);
		setLocationRelativeTo(null);
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(24, 537, 427, 104);
		getContentPane().add(btnNewButton);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setIcon(new ImageIcon("./images/hs_in1.png"));
		btnNewButton.setPressedIcon(new ImageIcon("./images/hs_in2.png"));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dto.setMeimg_2("./images/hs_ch1_1.png");
				
				dao.insertImg(dto);
				new a_Box(10);
				dispose();
			}

		});




		
		JLabel btn1_1c = new JLabel("New label");
		btn1_1c.setIcon(new ImageIcon("./images/hs_ch1_1.png"));
		btn1_1c.setBounds(12, 0, 448, 203);
		getContentPane().add(btn1_1c);
		

		JLabel lblNewLabel_1 = new JLabel(" 가격");
		lblNewLabel_1.setFont(new Font("배달의민족 주아", Font.BOLD, 20));
		lblNewLabel_1.setBounds(0, 201, 53, 59);
		getContentPane().add(lblNewLabel_1);

		JLabel label = new JLabel(" 수량");
		label.setFont(new Font("배달의민족 주아", Font.BOLD, 20));

		label.setBounds(0, 288, 53, 59);
		getContentPane().add(label);
		//아래 버튼
		JButton b24 = new JButton();   
		b24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChinaF01();
				dispose();
			}
		});


		b24.setBorderPainted(false);
		b24.setContentAreaFilled(false);
		b24.setFocusPainted(false);
		b24.setIcon(new ImageIcon("./images/hs_14.png"));
		b24.setBounds(-1, 672, 120, 105); 
		getContentPane().add(b24);
		b24.setRolloverIcon(new ImageIcon("./images/hs_34.png"));
		b24.setPressedIcon(new ImageIcon("./images/hs_24.png"));
		
	



		JButton b25 = new JButton();
		b25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Home();
				dispose();
			}
		});
		b25.setBorderPainted(false);
		b25.setContentAreaFilled(false);
		b25.setFocusPainted(false);
		b25.setIcon(new ImageIcon("./images/hs_15.png"));
		b25.setBounds(119,672,120,105);
		getContentPane().add(b25);
		b25.setRolloverIcon(new ImageIcon("./images/hs_35.png"));
		b25.setPressedIcon(new ImageIcon("./images/hs_25.png"));

		JButton b26 = new JButton();
		b26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		b26.setBorderPainted(false);
		b26.setContentAreaFilled(false);
		b26.setFocusPainted(false);
		b26.setIcon(new ImageIcon("./images/hs_16.png"));
		b26.setBounds(239,672,120,105);
		getContentPane().add(b26);
		b26.setRolloverIcon(new ImageIcon("./images/hs_36.png"));
		b26.setPressedIcon(new ImageIcon("./images/hs_26.png"));
		

		JButton b27 = new JButton();
		b27.setBorderPainted(false);
		b27.setContentAreaFilled(false);
		b27.setFocusPainted(false);
		b27.setIcon(new ImageIcon("./images/hs_17.png"));
		b27.setBounds(359,672,120,105);
		getContentPane().add(b27);
		b27.setRolloverIcon(new ImageIcon("./images/hs_37.png"));
		b27.setPressedIcon(new ImageIcon("./images/hs_27.png"));
		b27.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new My();
				dispose();
			}
			
		});
		JButton btnNewButton_1= new JButton();


		btnNewButton_1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				i++;
				String a=Integer.toString(i);
				textField_1.setText(a);
				String b=Integer.toString(8500*i);
				textField.setText(b);
			}
		});

		//메뉴 각각의 수량,가격 
		btnNewButton_1.setIcon(new ImageIcon("./images/plus.png"));
		btnNewButton_1.setBounds(425, 307, 26, 26);
		getContentPane().add(btnNewButton_1);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setPressedIcon(new ImageIcon("./images/plus_1.png"));


		JButton button = new JButton("");
		button.setIcon(new ImageIcon("./images/minus.png"));
		button.setBounds(305, 307, 26, 26);
		getContentPane().add(button);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setPressedIcon(new ImageIcon("./images/minus_1.png"));


		button.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(i>0) {
					i--;
					String a=Integer.toString(i);
					textField_1.setText(a);//수량
					String b=Integer.toString(8500*i);
					textField.setText(b);//가격
				}
			}
		});

		textField = new JTextField("0");
		textField.setBackground(new Color(243,243,237));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		textField.setBounds(339, 203, 78, 59);
		getContentPane().add(textField);
		textField.setColumns(10);
		getContentPane().setBackground(new Color(243,243,237));
		textField.setBorder(null);


		textField_1 = new JTextField("0");
		textField_1.setForeground(new Color(0, 0, 0));
		textField_1.setBackground(new Color(243,243,237));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(339, 290, 78, 59);
		getContentPane().add(textField_1);
		getContentPane().setBackground(new Color(243,243,237));
		textField_1.setBorder(null);

	}
	static int i=0;
	private static JTextField textField;
	private JTextField textField_1;
	public static String Price() {
		return textField.getText();
			
	}
	public static int Count() {
		return i;
	}
}
