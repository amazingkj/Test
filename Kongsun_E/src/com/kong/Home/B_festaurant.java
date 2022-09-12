package com.kong.Home;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.kong.Order.*;
import com.kong.payment.OrderHistory;


class C_Pud extends JFrame{

	private CardLayout cardLayoutSet;
	private JButton Button1, Button2 ,Button3,Button4,
	Button5,Button6,Button7;
	private JLabel  lblJoin;

	public C_Pud() {
		//컬러
		Color c1 = new Color(243,243,237);//오트밀
		Color c2 = new Color(107,119,114);//회색

		//패널
		setSize(480, 800);
		JPanel jPanel = new JPanel();

		setContentPane(jPanel);
		jPanel.setLayout(null);
		jPanel.setBackground(c1);
		//setUndecorated(true);
		
		setTitle("콩순이배달");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);


		JScrollPane scrollbar = new JScrollPane();
		JPanel panel_ex =new JPanel();
		Dimension size =new Dimension();
		size.setSize(400,1100);
		panel_ex.setPreferredSize(size);
		scrollbar.setViewportView(panel_ex);
		scrollbar.setBounds(0,0,475,669);
		panel_ex.setBackground(c1);
		add(scrollbar); 



		lblJoin = new JLabel("중식");
		Font f1 = new Font("배달의민족 주아", Font.BOLD, 40);
		lblJoin.setForeground(c2);
		lblJoin.setFont(f1); 
		lblJoin.setBounds(195, 32, 270, 80);
		panel_ex.add(lblJoin);
		setResizable(false);


		//매뉴선택버튼
		Button1 = new JButton();//운봉
		Button1.setBounds(66,60,350, 97);
		panel_ex.add(Button1);
		ImageIcon icon9=new ImageIcon("./images/jh_대지 30.png");//이미지 아이콘객체 생성
		Button1.setIcon(icon9);
		Button1.setPressedIcon(new ImageIcon("./images/jh_대지 72.png"));
		Button1.setBorderPainted(false);
		Button1.setContentAreaFilled(false);
		Button1.setFocusPainted(false);
		Button1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new ChinaF01();
				dispose();
			}
			
		});


		Button2 = new JButton();//일품각
		Button2.setBounds(66,220, 350,400);
		ImageIcon icon10=new ImageIcon("./images/jh_대지 31.png");//이미지 아이콘객체 생성
		Button2.setIcon(icon10);
		Button2.setPressedIcon(new ImageIcon("./images/jh_대지 69.png"));
		panel_ex.add(Button2);
		Button2.setBorderPainted(false);;
		Button2.setContentAreaFilled(false);
		Button2.setFocusPainted(false);
		Button2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new ChinaF02();
				dispose();
			}
			
		});



		Button3 = new JButton();//해피판다
		Button3.setBounds(66,400, 350,400);
		ImageIcon icon11=new ImageIcon("./images/jh_대지 32.png");//이미지 아이콘객체 생성
		Button3.setIcon(icon11);
		Button3.setPressedIcon(new ImageIcon("./images/jh_대지 64.png"));
		panel_ex.add(Button3);
		Button3.setBorderPainted(false);;
		Button3.setContentAreaFilled(false);
		Button3.setFocusPainted(false);
		Button3.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new ChinaF03();
				dispose();
			}
			
		});


		//하단부 선택창
		Button4 = new JButton("");
		Button4.setBounds(-1, 672, 120, 105);
		Font b4 = new Font("나눔고딕", Font.BOLD, 15);
		ImageIcon icon1=new ImageIcon("./images/jin_pre1.png");//이미지 아이콘객체 생성
		Button4.setIcon(icon1);
		Button4.setRolloverIcon(new ImageIcon("./images/jin_pre2.png"));
		Button4.setPressedIcon(new ImageIcon("./images/jin_pre3.png"));
		Button4.setFont(b4);
		jPanel.add(Button4);
		Button4.setBorderPainted(false);;
		Button4.setContentAreaFilled(false);
		Button4.setFocusPainted(false);

		//이전으로 이동
		Button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Home1();
				setVisible(false);//창안보이게하기
			} 
		});


		Button5 = new JButton("");
		Button5.setBounds(119,672,120,105);
		Font b5 = new Font("나눔고딕", Font.BOLD, 15);
		ImageIcon icon2=new ImageIcon("./images/jin_home1.png");//이미지 아이콘객체 생성
		Button5.setIcon(icon2);
		Button5.setRolloverIcon(new ImageIcon("./images/jin_home2.png"));
		Button5.setPressedIcon(new ImageIcon("./images/jin_home3.png"));
		Button5.setFont(b5);
		jPanel.add(Button5);
		Button5.setBorderPainted(false);;
		Button5.setContentAreaFilled(false);
		Button5.setFocusPainted(false);
		
		//홈으로
		Button5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Home1();
				setVisible(false);//창안보이게하기
			} 
		});
		

		Button6 = new JButton("");
		Button6.setBounds(239,672,120,105);
		ImageIcon icon3=new ImageIcon("./images/jin_OrderList1.png");//이미지 아이콘객체 생성
		Button6.setIcon(icon3);
		Button6.setRolloverIcon(new ImageIcon("./images/jin_OrderList2.png"));
		Button6.setPressedIcon(new ImageIcon("./images/jin_OrderList3.png"));
		Font b6 = new Font("나눔고딕", Font.BOLD, 15);
		Button6.setFont(b6);
		jPanel.add(Button6);
		Button6.setBorderPainted(false);;
		Button6.setContentAreaFilled(false);
		Button6.setFocusPainted(false);
		Button6.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new OrderHistory();
				dispose();
			}
			
		});

		Button7 = new JButton("");
		Button7.setBounds(359,672,120,105);
		ImageIcon icon4=new ImageIcon("./images/jin_Mypage1.png");//이미지 아이콘객체 생성
		Button7.setIcon(icon4);
		Button7.setRolloverIcon(new ImageIcon("./images/jin_Mypage2.png"));
		Button7.setPressedIcon(new ImageIcon("./images/jin_Mypage3.png"));
		Font b7 = new Font("나눔고딕", Font.BOLD, 15);
		Button7.setFont(b7);
		jPanel.add(Button7);
		Button7.setBorderPainted(false);;
		Button7.setContentAreaFilled(false);
		Button7.setFocusPainted(false);
		Button7.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new My1();
				dispose();
			}
			
		});

		setVisible(true);
	}
}


public class B_festaurant { 
	public B_festaurant() {
		new C_Pud();
	}

	public static void main(String[] args) {


		new C_Pud();
	}
} 
