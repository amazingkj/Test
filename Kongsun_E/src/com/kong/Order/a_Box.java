package com.kong.Order;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.kong.Home.My;
import com.kong.JDBC.MemberDAO;
import com.kong.JDBC.MenuDAO;
import com.kong.JDBC.MenuDTO;
import com.kong.JDBC.PayListDTO;
import com.kong.payment.OrderHistory;
import com.kong.payment.Payment;

public class a_Box extends JFrame {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	JPanel panel_ex =new JPanel();
	
	
	
	
	MemberDAO dao = new MemberDAO();
	MenuDAO dao2 = new MenuDAO();
	MenuDTO dto2 = new MenuDTO();
	PayListDTO dto3 = new PayListDTO();

	int price = 0;
	


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					a_Box window = new a_Box(0);
					//window.setVisible(true);	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public a_Box(int a) {
		initialize(a);
	}
	private void initialize(int a) {
		setVisible(true);
		
		
		getContentPane().setBackground(new Color(243,243,237));
		setBounds(0,0,480, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setTitle("콩순이배달");
		setResizable(false);
		setSize(480,800);
		setLocationRelativeTo(null);

		JLabel lblNewLabel = new JLabel("장바구니");
		lblNewLabel.setFont(new Font("배달의민족 주아", Font.BOLD, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(71, 0, 337, 108);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("주소를 확인해주세요!");
		lblNewLabel_1.setFont(new Font("배달의민족 주아", Font.BOLD, 20));
		lblNewLabel_1.setBounds(14, 102, 222, 31);
		getContentPane().add(lblNewLabel_1);

		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setVerifyInputWhenFocusTarget(false);
		textPane.setBackground(new Color(243,243,237));;
		textPane.setFont(new Font("배달의민족 주아", Font.BOLD, 20));

		textPane.setText(dao.TakeAddress());
		textPane.setBounds(159, 145, 186, 68);
		getContentPane().add(textPane);


		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("./images/ys_revise1.png"));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setPressedIcon(new ImageIcon("./images/ys_revise2.png"));

		
		
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				a_AddressChange dialog = new a_AddressChange(frame);
				String address = dialog.getAddress();
				textPane.setText(address);
				
		


			}
		});
		

	      
	      

		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setBounds(14, 145, 131, 68);
		getContentPane().add(btnNewButton);

		JCheckBox chckbxNewCheckBox = new JCheckBox("일회용품이 필요해요!");
		chckbxNewCheckBox.setFont(new Font("배달의민족 주아", Font.BOLD, 17));
		chckbxNewCheckBox.setBackground(new Color(243, 243, 237));
		chckbxNewCheckBox.setBounds(14, 492, 179, 49);
		getContentPane().add(chckbxNewCheckBox);

		JButton btnNewButton_1 = new JButton("");
 
		btnNewButton_1.setIcon(new ImageIcon("./images/ys_order3.png"));
		
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 24));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_1.setBounds(33, 587, 404, 73);
		getContentPane().add(btnNewButton_1);
		btnNewButton_1.setRolloverIcon(new ImageIcon("./images/ys_order1.png"));
		btnNewButton_1.setPressedIcon(new ImageIcon("./images/ys_order2.png"));

		btnNewButton_1.setBorderPainted(false);;
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setFocusPainted(false);
		
		btnNewButton_1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					dto2.setOnce_2("O");
				}else {
					dto2.setOnce_2("X");
				}
				dto2.setPrice_2(textField_2.getText());
				dto2.setAddr(textPane.getText());
				
				switch(a) {
				case 1 : dto2.setCount_2(america01_01.i); dao2.insertMore(dto2,"아메리칸햄치즈샌드위치","에그드랍"); break;
				case 2 : dto2.setCount_2(america01_02.i); dao2.insertMore(dto2,"갈릭베이컨치즈샌드위치","에그드랍"); break;
				case 3 : dto2.setCount_2(america01_03.i); dao2.insertMore(dto2,"아메리카노","에그드랍"); break;
				case 4 : dto2.setCount_2(america02_01.i); dao2.insertMore(dto2,"오리지널엔칠라다","홀리오"); break;
				case 5 : dto2.setCount_2(america02_02.i); dao2.insertMore(dto2,"캘리포니아부리또","홀리오"); break;
				case 6 : dto2.setCount_2(america02_03.i); dao2.insertMore(dto2,"타코","홀리오"); break;
				case 7 : dto2.setCount_2(america03_01.i); dao2.insertMore(dto2,"베이컨알리오파스타","제비파스타리조또"); break;
				case 8 : dto2.setCount_2(america03_02.i); dao2.insertMore(dto2,"베이컨매콤로제파스타","제비파스타리조또"); break;
				case 9 : dto2.setCount_2(america03_03.i); dao2.insertMore(dto2,"베이컨버섯크림파스타","제비파스타리조또"); break;
				case 10 : dto2.setCount_2(china01_01.i); dao2.insertMore(dto2,"짬짜면","운봉"); break;
				case 11 : dto2.setCount_2(china01_02.i); dao2.insertMore(dto2,"차돌박이짬뽕","운봉"); break;
				case 12 : dto2.setCount_2(china01_03.i); dao2.insertMore(dto2,"고추잡채","운봉"); break;
				case 13 : dto2.setCount_2(china02_01.i); dao2.insertMore(dto2,"짬뽕","일품각"); break;
				case 14 : dto2.setCount_2(china02_02.i); dao2.insertMore(dto2,"꿔바로우","일품각"); break;
				case 15 : dto2.setCount_2(china02_03.i); dao2.insertMore(dto2,"라즈기","일품각"); break;
				case 16 : dto2.setCount_2(china03_01.i); dao2.insertMore(dto2,"굴짬뽕","해피판다"); break;
				case 17 : dto2.setCount_2(china03_02.i); dao2.insertMore(dto2,"삼선짬뽕","해피판다"); break;
				case 18 : dto2.setCount_2(china03_03.i); dao2.insertMore(dto2,"탕수육","해피판다"); break;
				case 19 : dto2.setCount_2(japan01_01.i); dao2.insertMore(dto2,"곱창카레도시락","미카코카레"); break;
				case 20 : dto2.setCount_2(japan01_02.i); dao2.insertMore(dto2,"소떡소떡카레도시락","미카코카레"); break;
				case 21 : dto2.setCount_2(japan01_03.i); dao2.insertMore(dto2,"용가리치킨카레도시락","미카코카레"); break;
				case 22 : dto2.setCount_2(japan02_01.i); dao2.insertMore(dto2,"우동+돈까스+샐러드","우동마이루식"); break;
				case 23 : dto2.setCount_2(japan02_02.i); dao2.insertMore(dto2,"냉소바+돈까스+샐러드","우동마이루식"); break;
				case 24 : dto2.setCount_2(japan02_03.i); dao2.insertMore(dto2,"냉소바+김치햄볶음밥","우동마이루식"); break;
				case 25 : dto2.setCount_2(japan03_01.i); dao2.insertMore(dto2,"등심카츠","카츠반프리미엄"); break;
				case 26 : dto2.setCount_2(japan03_02.i); dao2.insertMore(dto2,"프리미엄안심","카츠반프리미엄"); break;
				case 27 : dto2.setCount_2(japan03_03.i); dao2.insertMore(dto2,"골든치즈","카츠반프리미엄"); break;
				case 28 : dto2.setCount_2(korea01_01.i); dao2.insertMore(dto2,"1인불고기세트","별사랑 불고기"); break;
				case 29 : dto2.setCount_2(korea01_02.i); dao2.insertMore(dto2,"2인불고기세트","별사랑 불고기"); break;
				case 30 : dto2.setCount_2(korea01_03.i); dao2.insertMore(dto2,"3~4인불고기세트","별사랑 불고기"); break;
				case 31 : dto2.setCount_2(korea02_01.i); dao2.insertMore(dto2,"꼬끼오~영양닭죽","죽도령"); break;
				case 32 : dto2.setCount_2(korea02_02.i); dao2.insertMore(dto2,"음메~한우소고기","죽도령"); break;
				case 33 : dto2.setCount_2(korea02_03.i); dao2.insertMore(dto2,"예뻐지는호박죽","죽도령"); break;
				case 34 : dto2.setCount_2(korea03_01.i); dao2.insertMore(dto2,"소갈비찜","영웅갈비찜"); break;
				case 35 : dto2.setCount_2(korea03_02.i); dao2.insertMore(dto2,"소갈비찜 중","영웅갈비찜"); break;
				case 36 : dto2.setCount_2(korea03_03.i); dao2.insertMore(dto2,"소갈비찜 대","영웅갈비찜"); break;
				
				}
				if(chckbxNewCheckBox.isSelected()) {
					dto3.setReq("O");
				}else {
					dto3.setReq("X");
				}
				dao2.Ordering();
				new Payment(a);
				dispose();
			}
			
		});
		
		
//주문금액
		textField_1 = new JTextField();
		textField_1.setDisabledTextColor(UIManager.getColor("Button.background"));
		textField_1.setFont(new Font("배달의민족 주아", Font.BOLD, 17));
		textField_1.setBackground(new Color(243, 243, 237));
		textField_1.setText("주문금액");
		textField_1.setBounds(215, 458, 70, 31);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("배달의민족 주아", Font.BOLD, 17));
		textField_2.setBackground(new Color(243, 243, 237));
		//.System.out.println(a);
		switch(a) {
		case 1 : textField_2.setText(america01_01.Price()); break;
		case 2 : textField_2.setText(america01_02.Price()); break;
		case 3 : textField_2.setText(america01_03.Price()); break;
		case 4 : textField_2.setText(america02_01.Price()); break;
		case 5 : textField_2.setText(america02_02.Price()); break;
		case 6 : textField_2.setText(america02_03.Price()); break;
		case 7 : textField_2.setText(america03_01.Price()); break;
		case 8 : textField_2.setText(america03_02.Price()); break;
		case 9 : textField_2.setText(america03_03.Price()); break;
		case 10 : textField_2.setText(china01_01.Price()); break;
		case 11 : textField_2.setText(china01_02.Price()); break;
		case 12 : textField_2.setText(china01_03.Price()); break;
		case 13 : textField_2.setText(china02_01.Price()); break;
		case 14 : textField_2.setText(china02_02.Price()); break;
		case 15 : textField_2.setText(china02_03.Price()); break;
		case 16 : textField_2.setText(china03_01.Price()); break;
		case 17 : textField_2.setText(china03_02.Price()); break;
		case 18 : textField_2.setText(china03_03.Price()); break;
		case 19 : textField_2.setText(japan01_01.Price()); break;
		case 20 : textField_2.setText(japan01_02.Price()); break;
		case 21 : textField_2.setText(japan01_03.Price()); break;
		case 22 : textField_2.setText(japan02_01.Price()); break;
		case 23 : textField_2.setText(japan02_02.Price()); break;
		case 24 : textField_2.setText(japan02_03.Price()); break;
		case 25 : textField_2.setText(japan03_01.Price()); break;
		case 26 : textField_2.setText(japan03_02.Price()); break;
		case 27 : textField_2.setText(japan03_03.Price()); break;
		case 28 : textField_2.setText(korea01_01.Price()); break;
		case 29 : textField_2.setText(korea01_02.Price()); break;
		case 30 : textField_2.setText(korea01_03.Price()); break;
		case 31 : textField_2.setText(korea02_01.Price()); break;
		case 32 : textField_2.setText(korea02_02.Price()); break;
		case 33 : textField_2.setText(korea02_03.Price()); break;
		case 34 : textField_2.setText(korea03_01.Price()); break;
		case 35 : textField_2.setText(korea03_02.Price()); break;
		case 36 : textField_2.setText(korea03_03.Price()); break;
		
		}
		
		
		//textField_2.setText(String.valueOf(price));
		
		textField_2.setColumns(10);
		textField_2.setBounds(371, 458, 70, 31);
		getContentPane().add(textField_2);
		textField_2.setBorder(null);


		
//배달비
		textField_3 = new JTextField();
		textField_3.setFont(new Font("배달의민족 주아", Font.BOLD, 17));
		textField_3.setBackground(new Color(243, 243, 237));
		textField_3.setText("배달비");
		textField_3.setColumns(10);
		textField_3.setBounds(215, 501, 53, 31);
		getContentPane().add(textField_3);
		textField_3.setBorder(null);
		
		String tip = "2500";
		int tip2 = Integer.parseInt(tip);
		textField_4 = new JTextField();
		textField_4.setText(tip);
		textField_4.setBackground(new Color(243, 243, 237));
		textField_4.setFont(new Font("배달의민족 주아", Font.BOLD, 17));
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setColumns(10);
		textField_4.setBounds(371, 501, 70, 31);
		getContentPane().add(textField_4);
		textField_4.setBorder(null);

		

		
//총 결제금액
		int total = Integer.parseInt(textField_2.getText());
		int total2 = total+tip2;
		String total3 = String.valueOf(total2);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("배달의민족 주아", Font.BOLD, 17));
		textField_5.setBackground(new Color(243, 243, 237));
		textField_5.setText("총 결제금액");
		textField_5.setColumns(10);
		textField_5.setBounds(215, 544, 93, 31);
		getContentPane().add(textField_5);
		textField_5.setBorder(null);
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setBackground(new Color(243, 243, 237));
		textField_6.setText(total3);
		textField_6.setColumns(10);
		textField_6.setBounds(371, 544, 70, 31);
		getContentPane().add(textField_6);
		textField_6.setBorder(null);
		textField_6.setFont(new Font("배달의민족 주아", Font.BOLD, 17));
		dto3.setP_total(String.valueOf(total2));
		dto3.setP_sum(total3);
		dto3.setD_tip("2500");
		dto3.setAddr(textPane.getText());
		

		//아래 버튼
		JButton b24 = new JButton();   

		b24.setBorderPainted(false);
		b24.setContentAreaFilled(false);
		b24.setFocusPainted(false);
		b24.setIcon(new ImageIcon("./images/hs_14.png"));
		b24.setBounds(-1, 672, 120, 105); 
		getContentPane().add(b24);
		b24.setRolloverIcon(new ImageIcon("./images/hs_34.png"));
		b24.setPressedIcon(new ImageIcon("./images/hs_24.png"));
		b24.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				switch(a) {
				case 1 : new america01_01(); break;
				case 2 : new america01_02(); break;
				case 3 : new america01_03(); break;
				case 4 : new america02_01(); break;
				case 5 : new america02_02(); break;
				case 6 : new america02_03(); break;
				case 7 : new america03_01(); break;
				case 8 : new america03_02(); break;
				case 9 : new america03_03(); break;
				case 10 : new china01_01(); break;
				case 11 : new china01_02(); break;
				case 12 : new china01_03(); break;
				case 13 : new china02_01(); break;
				case 14 : new china02_02(); break;
				case 15 : new china02_03(); break;
				case 16 : new china03_01(); break;
				case 17 : new china03_02(); break;
				case 18 : new china03_03(); break;
				case 19 : new japan01_01(); break;
				case 20 : new japan01_02(); break;
				case 21 : new japan01_03(); break;
				case 22 : new japan02_01(); break;
				case 23 : new japan02_02(); break;
				case 24 : new japan02_03(); break;
				case 25 : new japan03_01(); break;
				case 26 : new japan03_02(); break;
				case 27 : new japan03_03(); break;
				case 28 : new korea01_01(); break;
				case 29 : new korea01_02(); break;
				case 30 : new korea01_03(); break;
				case 31 : new korea02_01(); break;
				case 32 : new korea02_02(); break;
				case 33 : new korea02_03(); break;
				case 34 : new korea03_01(); break;
				case 35 : new korea03_02(); break;
				case 36 : new korea03_03(); break;
				}
				dao2.reRoll();
				dispose();
			}
			
		});
		


		JButton b25 = new JButton();
		b25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				dao2.reRoll();
				new OrderHistory();
				dispose();
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
				dao2.reRoll();
				new My();
				dispose();
			}
			
		});
		
		
		ImageIcon img1 = new ImageIcon(dao2.takeImg());  //dao2.takeImg() = 이미지 주소다.
				
		JScrollPane scrollbar = new JScrollPane();
		scrollbar.setBounds(20, 213, 427, 250);
		getContentPane().add(scrollbar);
		JPanel panel_ex =new JPanel() {
			public void paint(Graphics g) {
				g.drawImage(img1.getImage(), 0, 0, null);
				setOpaque(false);
				super.paint(g);
			}
		};
		Dimension size =new Dimension();
		size.setSize(427,233);
		panel_ex.setPreferredSize(size);
		scrollbar.setViewportView(panel_ex);
		scrollbar.setBounds(0,240,480,190);
		scrollbar.setBackground(new Color(243,243,237));
		scrollbar.setBorder(null);
		panel_ex.setBackground(new Color(243,243,237));
		panel_ex.setLayout(null);
		getContentPane().add(scrollbar);
		System.out.println(dto2.getMeimg_2());




	}
}