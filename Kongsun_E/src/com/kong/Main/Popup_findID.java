package com.kong.Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.kong.JDBC.MemberDAO;

public class Popup_findID extends JFrame{
	JButton ok;
	
	JLabel whatisyourID = new JLabel();
	
	Font kFont15 = new Font("배달의민족 주아",Font.PLAIN,15);
	Font kFont24 = new Font("배달의민족 주아",Font.PLAIN,24);
	
	Color c1 = new Color(243,243,237);
	
	ImageIcon okbtn1 = new ImageIcon("./images/kmw_대지 108.png");
	ImageIcon okbtn2 = new ImageIcon("./images/kmw_대지 109.png");
	ImageIcon okbtn3 = new ImageIcon("./images/kmw_대지 110.png");
	
	
	MemberDAO dao = new MemberDAO();
	
	Popup_findID(int check, String id){
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(480,240);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setLayout(null);
		setBackground(c1);
		
		if(check == 0) {
			Fail(id);
		}else if(check == 1) {
			Success(id);
		}
		add(whatisyourID);
		
		whatisyourID.setBounds(85,50,380,25);
		whatisyourID.setFont(kFont24);
			
		ok = new JButton(okbtn1);
		ok.setRolloverIcon(okbtn2);
		ok.setPressedIcon(okbtn3);
		ok.setBorderPainted(false);
		ok.setContentAreaFilled(false);
		ok.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
			
		});
		add(ok);
		ok.setBounds(199,120,81,38);
	}
	
	public void Success(String id) {		
		whatisyourID.setText(id);
	}
	
	public void Fail(String id) {
		whatisyourID.setText(id);	
	}

}
