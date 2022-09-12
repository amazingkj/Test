package com.kong.Order;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.SwingConstants;

import com.kong.Home.B_festaurant;
import com.kong.Home.Home;
import com.kong.Home.My;

public class ChinaF02 extends JFrame{




	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChinaF02 window = new ChinaF02();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ChinaF02() {
		initialize();
	}

	private void initialize() {

		setVisible(true);
		setResizable(false);
		setBounds(0, 0, 480, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(243,243,237));
		getContentPane().setLayout(null);
		setSize(480,800);

		JLabel lblNewLabel = new JLabel("일품각");
		lblNewLabel.setBounds(0, 0, 460, 120);
		lblNewLabel.setFont(new Font("배달의민족 주아", Font.BOLD, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel);
		//위에 버튼



		JButton btnNewButton = new JButton("한식");
		btnNewButton.setIcon(new ImageIcon("./images/hs_ch2_1.png"));
		btnNewButton.setBounds(12, 135, 454, 160);
		getContentPane().add(btnNewButton);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);


		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new china02_01();
				dispose();
			}

		});



		JButton button = new JButton("한식1");
		button.setIcon(new ImageIcon("./images/hs_ch2_2.png"));

		button.setBackground(Color.WHITE);
		button.setBounds(12, 291, 454, 160);
		getContentPane().add(button);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);


		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new china02_02();
				dispose();
			}

		});


		JButton button_1 = new JButton("한식2");
		button_1.setIcon(new ImageIcon("./images/hs_ch2_3.png"));
		button_1.setBounds(12, 450, 454, 160);
		getContentPane().add(button_1);
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);

		button_1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			new china02_03();
			dispose();
		
		}

		});
		//아래 버튼
		JButton b24 = new JButton();   
		b24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new B_festaurant();
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
		b27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new My();
				dispose();
			}
		});

	}
}