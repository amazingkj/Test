package com.kong.Home;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kong.JDBC.MemberDAO;
import com.kong.JDBC.ReviewDAO;
import com.kong.Main.Popup_CreateCheck;
import com.kong.Order.AmericaF01;
import com.kong.Order.AmericaF02;
import com.kong.Order.AmericaF03;
import com.kong.Order.ChinaF01;
import com.kong.Order.ChinaF02;
import com.kong.Order.ChinaF03;
import com.kong.Order.JapanF01;
import com.kong.Order.JapanF02;
import com.kong.Order.JapanF03;
import com.kong.Order.KoreanF01;
import com.kong.Order.KoreanF02;
import com.kong.Order.KoreanF03;
import com.kong.payment.OrderHistory;
class   Home1 extends JFrame{

	Color c1 = new Color(243,243,237);//오트밀
	Color c2 = new Color(107,119,114);//회색

	JTextField tf = new JTextField ();
	JTextField tf1 = new JTextField ();

	JButton Button1 =new JButton();
	JButton Button2 =new JButton();
	JButton Button3 =new JButton();
	JButton Button4 =new JButton();
	JButton Button5 =new JButton();
	JButton Button6 =new JButton();
	JButton Button7 =new JButton();
	JButton Button8 =new JButton();
	JButton Button9 =new JButton(); 
	JButton Button10 =new JButton(); 
	
	
	
	
	JPanel   jpanel = new JPanel();
	JLabel lblJoin =new  JLabel("콩순이배달"); 
	
	MemberDAO dao = new MemberDAO();
	
	ReviewDAO rdao = new ReviewDAO();
	
	public   Home1() {


		setSize(480, 800);
		setResizable(false);
		jpanel.setBackground(c1);
		setLocationRelativeTo(null);
		//setUndecorated(true);
		
		
		jpanel.setBounds(0,0, 480, 800);
		jpanel.setLayout(null);
		add(jpanel);
		
		/*
		 * if(dao.forReview() == 1) { new TextPopup(); }else {
		 * 
		 * }
		 */
		
		

		lblJoin =new  JLabel("콩순이배달"); 
		Font f1 = new Font("배달의민족 주아", Font.BOLD, 40);
		lblJoin.setForeground(c2);
		lblJoin.setFont(f1); 
		lblJoin.setBounds(166, 20, 300, 80);
		jpanel.add(lblJoin);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		

		//검색창

		tf.setColumns(10);
		tf.setBounds(150, 100, 210, 40);
		jpanel.add(tf);

		//검색버튼
		Button9=new JButton();
		ImageIcon icon=new ImageIcon("./images/jh_Magnifier1.jpg");//이미지 아이콘객체 생성
		Button9.setIcon(icon);
		Button9.setBounds(110, 100, 40, 40);
		jpanel.add(Button9);
		Button9.setBorderPainted(false);;
		Button9.setContentAreaFilled(false);
		Button9.setFocusPainted(false);
		Button9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {    	  
				int ek=dao.findNo(tf.getText());

				switch(ek) {
				case 1: new KoreanF01(); dispose(); 
				break;	
			    case 2: new KoreanF02(); dispose(); 
			    break;
			    case 3: new KoreanF03(); dispose(); 
			    break;
			    case 4: new ChinaF01(); dispose(); 
			    break;
			    case 5: new ChinaF02(); dispose(); 
			    break;
			    case 6: new ChinaF03(); dispose(); 
			    break;
			    case 7: new JapanF01(); dispose(); 
			    break;
			    case 8: new JapanF02(); dispose(); 
			    break;
			    case 9: new JapanF03(); dispose(); 
			    break;
			    case 10: new AmericaF01(); dispose(); 
			    break;
			    case 11: new AmericaF02(); dispose(); 
			    break;
			    case 12: new AmericaF03();  dispose(); 
			    break;
			    default : new Popup_CreateCheck();
				}   
			}
		});
		
		
		Button10=new JButton();
		ImageIcon icon80=new ImageIcon("./images/jh_포카칩원빈.gif");//이미지 아이콘객체 생성
		Button10.setIcon(icon80);
		Button10.setBounds(0, 430, 490,200);
		jpanel.add(Button10);
		Button10.setBorderPainted(false);;
		Button10.setContentAreaFilled(false);
		Button10.setFocusPainted(false);



		//매뉴선택버튼
		Button1 = new JButton();//한식
		Button1.setBounds(44,163, 99, 97);
		Font b1 = new Font("배달의민족 주아", Font.BOLD, 20);
		ImageIcon icon5=new ImageIcon("./images/jh_한식1.png");//이미지 아이콘객체 생성
		Button1.setIcon(icon5);
		Button1.setRolloverIcon(new ImageIcon("./images/jh_한식1_1.png"));
		Button1.setFont(b1);
		jpanel.add(Button1);
		Button1.setBorderPainted(false);;
		Button1.setContentAreaFilled(false);
		Button1.setFocusPainted(false);
		Button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {    
				dispose();
				new K_Pud();
				jpanel.setVisible(false);
				
			}
		});



		Button2 = new JButton();//중식
		Button2.setBounds(180, 163, 99,97);
		Font b2 = new Font("나눔고딕", Font.BOLD, 20);
		Button2.setFont(b2);
		ImageIcon icon6=new ImageIcon("./images/jh_중식1.png");//이미지 아이콘객체 생성
		Button2.setIcon(icon6);
		Button2.setRolloverIcon(new ImageIcon("./images/jh_중식1_1.png"));
		jpanel.add(Button2);
		Button2.setBorderPainted(false);;
		Button2.setContentAreaFilled(false);
		Button2.setFocusPainted(false);
		Button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { 
				dispose();
				new C_Pud();
				jpanel.setVisible(false);

			}
		});

		Button3 = new JButton();//일식
		Button3.setBounds(328, 163, 99,97);
		Font b3 = new Font("나눔고딕", Font.BOLD, 20);
		Button3.setFont(b3);
		ImageIcon icon7=new ImageIcon("./images/jh_일식1.png");//이미지 아이콘객체 생성
		Button3.setIcon(icon7);
		Button3.setRolloverIcon(new ImageIcon("./images/jh_일식1_1.png"));
		jpanel.add(Button3);
		Button3.setBorderPainted(false);;
		Button3.setContentAreaFilled(false);
		Button3.setFocusPainted(false);

		Button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new J_Pud();
				jpanel.setVisible(false);
			}
		});
		Button4 = new JButton();//양식
		Button4.setBounds(44, 303, 99,97);
		Font b4 = new Font("나눔고딕", Font.BOLD, 20);
		Button4.setFont(b4);
		ImageIcon icon8=new ImageIcon("./images/jh_양식1.png");//이미지 아이콘객체 생성
		Button4.setIcon(icon8);
		Button4.setRolloverIcon(new ImageIcon("./images/jh_양식1_1.png"));
		jpanel.add(Button4);
		Button4.setBorderPainted(false);;
		Button4.setContentAreaFilled(false);
		Button4.setFocusPainted(false);

		Button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {  
				dispose();
				new W_Pud();  
				jpanel.setVisible(false);
			}
		});

		//하단부 선택창
		ImageIcon icon1=new ImageIcon("./images/jin_pre1.png");//이미지 아이콘객체 생성
		Button5.setIcon(icon1);
		Button5 = new JButton(icon1);//이전버튼
		Button5.setBounds(-1, 672, 120, 105);		
		Button5.setRolloverIcon(new ImageIcon("./images/jin_pre2.png"));
		Button5.setPressedIcon(new ImageIcon("./images/jin_pre3.png"));
		Font b5 = new Font("나눔고딕", Font.BOLD, 15);
		Button5.setFont(b5);
		jpanel.add(Button5);
		Button5.setBorderPainted(false);;
		Button5.setContentAreaFilled(false);
		Button5.setFocusPainted(false);

		ImageIcon icon2=new ImageIcon("./images/jin_home1.png");//이미지 아이콘객체 생성
		Button6.setIcon(icon2);
		Button6 = new JButton(icon2);//홈버튼
		Button6.setBounds(119,672,120,105);
		Button6.setRolloverIcon(new ImageIcon("./images/jin_home2.png"));
		Button6.setPressedIcon(new ImageIcon("./images/jin_home3.png"));
		Font b6 = new Font("나눔고딕", Font.BOLD, 15);
		Button6.setFont(b6);
		jpanel.add(Button6);
		Button6.setBorderPainted(false);;
		Button6.setContentAreaFilled(false);
		Button6.setFocusPainted(false);
		
		Button6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {  
				new Home1();  
				dispose();
				jpanel.setVisible(false);
			}
			});

		ImageIcon icon3=new ImageIcon("./images/jin_OrderList1.png");//이미지 아이콘객체 생성
		Button7.setIcon(icon3);
		Button7 = new JButton(icon3);//주문내역
		Button7.setBounds(239,672,120,105);
		Font b7 = new Font("나눔고딕", Font.BOLD, 15);		
		Button7.setRolloverIcon(new ImageIcon("./images/jin_OrderList2.png"));
		Button7.setPressedIcon(new ImageIcon("./images/jin_OrderList3.png"));
		Button7.setFont(b7);
		jpanel.add(Button7);
		Button7.setBorderPainted(false);;
		Button7.setContentAreaFilled(false);
		Button7.setFocusPainted(false);
		Button7.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new OrderHistory();
				dispose();
			}
			
		});

		Font b8 = new Font("나눔고딕", Font.BOLD, 15);
		ImageIcon icon4=new ImageIcon("./images/jin_Mypage1.png");//이미지 아이콘객체 생성
		Button8 = new JButton(icon4);//마이페이지
		Button8.setBounds(359,672,120,105);		
		Button8.setIcon(icon4);
		Button8.setRolloverIcon(new ImageIcon("./images/jin_Mypage2.png"));
		Button8.setPressedIcon(new ImageIcon("./images/jin_Mypage3.png"));
		Button8.setFont(b8);
		jpanel.add(Button8);
		Button8.setBorderPainted(false);;
		Button8.setContentAreaFilled(false);
		Button8.setFocusPainted(false);
		
		
		Button8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {  
				dispose();
				new My1();  
				
				jpanel.setVisible(false);
			}
			});
		setVisible(true);

	}
}
public class Home  {
	public Home(){
		new Home1();
		
	}
	public static void main(String[] args) {

		new Home1();

	}
}
