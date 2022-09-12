package com.kong.Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Popup_Agree extends JFrame{
	JLabel announce;
	JButton ok;
	
	Font kFont15 = new Font("배달의민족 주아",Font.PLAIN,15);
	Font kFont24 = new Font("배달의민족 주아",Font.PLAIN,24);
	
	Color c1 = new Color(243,243,237);
	
	ImageIcon okbtn1 = new ImageIcon("./images/kmw_대지 108.png");
	ImageIcon okbtn2 = new ImageIcon("./images/kmw_대지 109.png");
	ImageIcon okbtn3 = new ImageIcon("./images/kmw_대지 110.png");
	
	Popup_Agree(){
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(480,240);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setBackground(c1);
		
		set();
		init();
		layouts();
	}
	
	void set() {
		announce = new JLabel("약관에 모두 동의해야 합니다.");
		announce.setFont(kFont24);
		
		ok = new JButton(okbtn1);
		ok.setRolloverIcon(okbtn2);
		ok.setPressedIcon(okbtn3);
		ok.setContentAreaFilled(false);
		ok.setBorderPainted(false);
		ok.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				
			}
			
		});
	}
	
	void init() {
		add(announce);
		add(ok);
	}
	
	void layouts() {
		setLayout(null);
		announce.setBounds(105,50,300,25);
		ok.setBounds(199,120,81,38);
	}
}
