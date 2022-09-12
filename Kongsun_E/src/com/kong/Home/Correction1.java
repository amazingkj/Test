package com.kong.Home;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

class Correction extends JFrame{	
	

	Font Font1 = new Font("배달의민족 주아",Font.PLAIN,16);
	
	
	private JLabel  lblJoin;

	public  Correction() {

		//컬러
		Color c1 = new Color(243,243,237);//오트밀
		Color c2 = new Color(107,119,114);//회색

		//패널
		setSize(480, 800);
		JPanel jpanel = new JPanel();
		JLabel lblJoin1 =new  JLabel("");
		setContentPane(jpanel);
		jpanel.setLayout(null);
		jpanel.setBackground(c1);
		//setUndecorated(true);
		
		setTitle("콩순이배달");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);



		


		lblJoin = new JLabel("");
		Font f1 = new Font("배달의민족 주아", Font.BOLD, 40);
		lblJoin.setForeground(c2);
		lblJoin.setFont(f1); 
		lblJoin.setBounds(195, 32, 270, 80);
		jpanel.add(lblJoin);
		setResizable(false);

	
		
		
		
		
		

		setVisible(true);
	}
}
public class Correction1 {

	public static void main(String[] args) {
	
    new Correction();
	}

}
