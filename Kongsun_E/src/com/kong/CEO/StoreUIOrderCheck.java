package com.kong.CEO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.kong.JDBC.MemberDAO;
import com.kong.JDBC.MemberDTO;
import com.kong.JDBC.MenuDAO;
import com.kong.JDBC.MenuDTO;
import com.kong.JDBC.PayDAO;
import com.kong.JDBC.PayListDAO;
import com.kong.JDBC.PayListDTO;

class KongFrame05  {
	private JPanel Panel;
	private JFrame frame;
	private JTextField IdText, AddressText, extraText, 
			textField_1, textField_2, textField_3,
			textField_4, textField_5, textField_6;
	private JLabel label2,label3;
	private JScrollPane scrollbar, scrollbar2;
	private JButton Button4,Button5,Button6,Button7;
	
	Font font24 = new Font("배달의민족 주아",Font.PLAIN,24);
	Color c1 = new Color(243, 243, 237);
	
	String id,addr,req,price,menu,img;
	
	int money1;
	
	
	MemberDAO mdao = new MemberDAO();
	MemberDTO mdto = new MemberDTO();
	
	MenuDAO dao = new MenuDAO();
	MenuDTO dto = new MenuDTO();
	
	PayDAO pdao = new PayDAO();
	PayListDTO pdto = new PayListDTO();
	PayListDAO pldao = new PayListDAO();
	
	public KongFrame05() {
		frame = new JFrame();	
		frame.setSize(480, 800);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("점주 페이지 - 주문 확인 요청");
		frame.setBackground(c1);
		
		//getContentPane().
		frame.setLayout(null);
		
		
	
		
		//아이디, 주소 텍스트필드 *DB 연동 필요 
		IdText = new JTextField();
		AddressText = new JTextField();
		extraText = new JTextField();
		IdText.setFont(new Font("배달의민족 주아", Font.BOLD, 20));
		IdText.setBounds(22, 120, 150, 30);
		AddressText.setFont(new Font("MICE고딕 Bold", Font.BOLD, 20));
		AddressText.setBounds(22, 170, 430, 60);
		
		scrollbar2 = new JScrollPane();
		
		
		
		
		IdText.setEditable(false);
		IdText.setBorder(null);
		IdText.setBackground(c1);
		
		AddressText.setEditable(false);
		AddressText.setBorder(null);
		AddressText.setBackground(c1);
		
		
		frame.getContentPane().add(scrollbar2);		
		frame.getContentPane().add(IdText);
		frame.getContentPane().add(AddressText);
		
		//일회용품 
		
		extraText.setBounds(22, 458, 150, 30);
		frame.getContentPane().add(extraText);
		//extraText.setText("일회용품 필요"); //체크박스 되어있으면, 메시지 띄우기 
		//extraText.setText("일회용품 불필요"); //체크박스 안되어있으면 이 메시지 띄우기
		extraText.setFont(new Font("MICE고딕 Bold", Font.BOLD, 15));
		for(MenuDTO a : dao.Outing()) {
			
		}
		extraText.setEditable(false);
		
		
		//주문금액 DB연동 필요  
		textField_1 = new JTextField();
		textField_1.setDisabledTextColor(UIManager.getColor("Button.background"));
		textField_1.setFont(new Font("배달의민족 주아", Font.BOLD, 17));
		textField_1.setBackground(c1);
		textField_1.setText("주문금액");
		textField_1.setBounds(215, 458, 70, 31);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("배달의민족 주아", Font.BOLD, 17));
		textField_2.setBackground(c1);
		//textField_2.setText("1500");
		for(MenuDTO a : dao.Outing()) {
			
		}		
		textField_2.setColumns(10);
		textField_2.setBounds(371, 458, 70, 31);
		frame.getContentPane().add(textField_2);
		textField_2.setBorder(null);
		textField_2.setEditable(false);
		textField_2.setForeground(Color.BLUE);

		
		//배달비 >> 희수님과 동일
		textField_3 = new JTextField();
		textField_3.setFont(new Font("배달의민족 주아", Font.BOLD, 17));
		textField_3.setBackground(c1);
		textField_3.setText("배달비");
		textField_3.setColumns(10);
		textField_3.setBounds(215, 501, 53, 31);
		frame.getContentPane().add(textField_3);
		textField_3.setBorder(null);
		
		
		textField_4 = new JTextField();
		textField_4.setText("2500");
		textField_4.setBackground(c1);
		textField_4.setFont(new Font("배달의민족 주아", Font.BOLD, 17));
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setColumns(10);
		textField_4.setBounds(371, 501, 70, 31);
		textField_4.setEditable(false);
		textField_4.setForeground(Color.BLUE);
		frame.getContentPane().add(textField_4);
		textField_4.setBorder(null);

		
		//총 결제금액 >> 희수님과 동일
		textField_5 = new JTextField();
		textField_5.setFont(new Font("배달의민족 주아", Font.BOLD, 17));
		textField_5.setBackground(c1);
		textField_5.setText("총 결제금액");
		textField_5.setColumns(10);
		textField_5.setBounds(215, 544, 93, 31);
		frame.getContentPane().add(textField_5);
		textField_5.setBorder(null);
		
		System.out.println(mdao.Ceo_TakeID());
		System.out.println(dao.orderTakeMenu());
		

		if(mdao.Ceo_TakeID().equals("ceo1")) {
			if(dao.orderTakeMenu().equals("1인불고기세트") || dao.orderTakeMenu().equals("2인불고기세트") || dao.orderTakeMenu().equals("3~4인불고기세트")) {
				for(PayListDTO p : pdao.Outing()) {
					if(p.getRest().equals("별사랑 불고기")) {
						
						id = p.getCus_no();
						addr = p.getAddr();
						req = p.getReq();
						price = p.getP_total();
						menu = p.getMenu();
						img = p.getImg();
						
						IdText.setText(id);
						AddressText.setText(addr);
						if(req.equals("O")) {
							extraText.setText("일회용품 필요");
						}else if(req.equals("X")) {
							extraText.setText("일회용품 불필요");
						}
						textField_2.setText(price);
					}
					money1 = Integer.parseInt(textField_2.getText());
				}
				
			}
		}else if(mdao.Ceo_TakeID().equals("ceo2")) {
			if(dao.orderTakeMenu().equals("꼬끼오~영양닭죽") || dao.orderTakeMenu().equals("음메~한우소고기") || dao.orderTakeMenu().equals("예뻐지는 호박죽")) {
				for(PayListDTO p : pdao.Outing()) {
					if(p.getRest().equals("죽도령")) {
						id = p.getCus_no();
						addr = p.getAddr();
						req = p.getReq();
						price = p.getP_total();
						menu = p.getMenu();
						img = p.getImg();
						
						IdText.setText(id);
						AddressText.setText(addr);
						if(req.equals("O")) {
							extraText.setText("일회용품 필요");
						}else if(req.equals("X")) {
							extraText.setText("일회용품 불필요");
						}
						textField_2.setText(price);
					}
					money1 = Integer.parseInt(textField_2.getText());
				}
			}
		}else if(mdao.Ceo_TakeID().equals("ceo3")) {
			if(dao.orderTakeMenu().equals("소갈비찜") || dao.orderTakeMenu().equals("소갈비찜 중") || dao.orderTakeMenu().equals("소갈비찜 대")) {
				for(PayListDTO p : pdao.Outing()) {
					if(p.getRest().equals("영웅갈비찜")) {
						id = p.getCus_no();
						addr = p.getAddr();
						req = p.getReq();
						price = p.getP_total();
						menu = p.getMenu();
						img = p.getImg();
						
						IdText.setText(id);
						AddressText.setText(addr);
						if(req.equals("O")) {
							extraText.setText("일회용품 필요");
						}else if(req.equals("X")) {
							extraText.setText("일회용품 불필요");
						}
						textField_2.setText(price);
					}
					money1 = Integer.parseInt(textField_2.getText());
				}
			}
		}else if(mdao.Ceo_TakeID().equals("ceo4")) {
			if(dao.orderTakeMenu().equals("짬짜면") || dao.orderTakeMenu().equals("차돌박이짬뽕") || dao.orderTakeMenu().equals("고추잡채")) {
				for(PayListDTO p : pdao.Outing()) {
					if(p.getRest().equals("운봉")) {
						id = p.getCus_no();
						addr = p.getAddr();
						req = p.getReq();
						price = p.getP_total();
						menu = p.getMenu();
						img = p.getImg();
						
						IdText.setText(id);
						AddressText.setText(addr);
						if(req.equals("O")) {
							extraText.setText("일회용품 필요");
						}else if(req.equals("X")) {
							extraText.setText("일회용품 불필요");
						}
						textField_2.setText(price);
					}
					money1 = Integer.parseInt(textField_2.getText());
				}
			}
		}else if(mdao.Ceo_TakeID().equals("ceo5")) {
			if(dao.orderTakeMenu().equals("짬뽕") || dao.orderTakeMenu().equals("꿔바로우") || dao.orderTakeMenu().equals("라즈기")) {
				for(PayListDTO p : pdao.Outing()) {
					if(p.getRest().equals("일품각")) {
						id = p.getCus_no();
						addr = p.getAddr();
						req = p.getReq();
						price = p.getP_total();
						menu = p.getMenu();
						img = p.getImg();
						
						IdText.setText(id);
						AddressText.setText(addr);
						if(req.equals("O")) {
							extraText.setText("일회용품 필요");
						}else if(req.equals("X")) {
							extraText.setText("일회용품 불필요");
						}
						textField_2.setText(price);
					}
					money1 = Integer.parseInt(textField_2.getText());
				}
			}
		}else if(mdao.Ceo_TakeID().equals("ceo6")) {
			if(dao.orderTakeMenu().equals("굴짬뽕") || dao.orderTakeMenu().equals("삼선짬뽕") || dao.orderTakeMenu().equals("탕수육")) {
				for(PayListDTO p : pdao.Outing()) {
					if(p.getRest().equals("해피판다")) {
						id = p.getCus_no();
						addr = p.getAddr();
						req = p.getReq();
						price = p.getP_total();
						menu = p.getMenu();
						img = p.getImg();
						
						IdText.setText(id);
						AddressText.setText(addr);
						if(req.equals("O")) {
							extraText.setText("일회용품 필요");
						}else if(req.equals("X")) {
							extraText.setText("일회용품 불필요");
						}
						textField_2.setText(price);
					}
					money1 = Integer.parseInt(textField_2.getText());
				}
			}
		}else if(mdao.Ceo_TakeID().equals("ceo7")) {
			if(dao.orderTakeMenu().equals("곱창카레도시락") || dao.orderTakeMenu().equals("소떡소떡카레도시락") || dao.orderTakeMenu().equals("용가리치킨카레도시락")) {
				for(PayListDTO p : pdao.Outing()) {
					if(p.getRest().equals("미카코카레")) {
						id = p.getCus_no();
						addr = p.getAddr();
						req = p.getReq();
						price = p.getP_total();
						menu = p.getMenu();
						img = p.getImg();
						
						IdText.setText(id);
						AddressText.setText(addr);
						if(req.equals("O")) {
							extraText.setText("일회용품 필요");
						}else if(req.equals("X")) {
							extraText.setText("일회용품 불필요");
						}
						textField_2.setText(price);
					}
					money1 = Integer.parseInt(textField_2.getText());
				}
			}
		}else if(mdao.Ceo_TakeID().equals("ceo8")) {
			if(dao.orderTakeMenu().equals("우동+돈까스+샐러드") || dao.orderTakeMenu().equals("냉소바+돈까스+샐러드") || dao.orderTakeMenu().equals("냉소바+김치햄볶음밥")) {
				for(PayListDTO p : pdao.Outing()) {
					if(p.getRest().equals("우동마이루식")) {
						id = p.getCus_no();
						addr = p.getAddr();
						req = p.getReq();
						price = p.getP_total();
						menu = p.getMenu();
						img = p.getImg();
						
						IdText.setText(id);
						AddressText.setText(addr);
						if(req.equals("O")) {
							extraText.setText("일회용품 필요");
						}else if(req.equals("X")) {
							extraText.setText("일회용품 불필요");
						}
						textField_2.setText(price);
					}
					money1 = Integer.parseInt(textField_2.getText());
				}
			}
		}else if(mdao.Ceo_TakeID().equals("ceo9")) {
			if(dao.orderTakeMenu().equals("등심카츠") || dao.orderTakeMenu().equals("프리미엄안심") || dao.orderTakeMenu().equals("골든치즈")) {
				for(PayListDTO p : pdao.Outing()) {
					if(p.getRest().equals("카츠반프리미엄")) {
						id = p.getCus_no();
						addr = p.getAddr();
						req = p.getReq();
						price = p.getP_total();
						menu = p.getMenu();
						img = p.getImg();
						
						IdText.setText(id);
						AddressText.setText(addr);
						if(req.equals("O")) {
							extraText.setText("일회용품 필요");
						}else if(req.equals("X")) {
							extraText.setText("일회용품 불필요");
						}
						textField_2.setText(price);
					}
					money1 = Integer.parseInt(textField_2.getText());
				}
			}
		}else if(mdao.Ceo_TakeID().equals("ceo10")) {
			if(dao.orderTakeMenu().equals("베이컨알리오파스타") || dao.orderTakeMenu().equals("베이컨매콤로제파스타") || dao.orderTakeMenu().equals("베이컨버섯크림파스타")) {
				for(PayListDTO p : pdao.Outing()) {
					if(p.getRest().equals("제비파스타리조또")) {
						id = p.getCus_no();
						addr = p.getAddr();
						req = p.getReq();
						price = p.getP_total();
						menu = p.getMenu();
						img = p.getImg();
						
						IdText.setText(id);
						AddressText.setText(addr);
						if(req.equals("O")) {
							extraText.setText("일회용품 필요");
						}else if(req.equals("X")) {
							extraText.setText("일회용품 불필요");
						}
						textField_2.setText(price);
					}
					money1 = Integer.parseInt(textField_2.getText());
				}
			}
		}else if(mdao.Ceo_TakeID().equals("ceo11")) {
			if(dao.orderTakeMenu().equals("오리지널엔칠라다") || dao.orderTakeMenu().equals("캘리포니아부리또") || dao.orderTakeMenu().equals("타코")) {
				for(PayListDTO p : pdao.Outing()) {
					if(p.getRest().equals("홀리오")) {
						id = p.getCus_no();
						addr = p.getAddr();
						req = p.getReq();
						price = p.getP_total();
						menu = p.getMenu();
						img = p.getImg();
						
						IdText.setText(id);
						AddressText.setText(addr);
						if(req.equals("O")) {
							extraText.setText("일회용품 필요");
						}else if(req.equals("X")) {
							extraText.setText("일회용품 불필요");
						}
						textField_2.setText(price);
					}
					money1 = Integer.parseInt(textField_2.getText());
				}
			}
		}else if(mdao.Ceo_TakeID().equals("ceo12")) {
			if(dao.orderTakeMenu().equals("아메리칸햄치즈샌드위치") || dao.orderTakeMenu().equals("갈릭베이컨치즈샌드위치") || dao.orderTakeMenu().equals("아메리카노")) {
				for(PayListDTO p : pdao.Outing()) {
					if(p.getRest().equals("에그드랍")) {
						id = p.getCus_no();
						addr = p.getAddr();
						req = p.getReq();
						price = p.getP_total();
						menu = p.getMenu();
						img = p.getImg();
						
						IdText.setText(id);
						AddressText.setText(addr);
						if(req.equals("O")) {
							extraText.setText("일회용품 필요");
						}else if(req.equals("X")) {
							extraText.setText("일회용품 불필요");
						}
						textField_2.setText(price);
					}
					money1 = Integer.parseInt(textField_2.getText());
				}
			}
		}
		
		ImageIcon img1 = new ImageIcon(img);
		
		scrollbar = new JScrollPane();
		scrollbar.setBounds(20, 213, 427, 250);
		frame.getContentPane().add(scrollbar);
		JPanel panel_ex =new JPanel() {
			public void paint(Graphics g) {
				g.drawImage(img1.getImage(), 0, 0, null);
			}
		};
		Dimension size =new Dimension();
		size.setSize(427,233);
		panel_ex.setPreferredSize(size);
		scrollbar.setViewportView(panel_ex);
		scrollbar.setBounds(0,240,480,190);
		scrollbar.setBorder(null);
		panel_ex.setBackground(c1);
		panel_ex.setLayout(null);
		frame.getContentPane().add(scrollbar);
		
		
		
		int money2 = money1+2500;
		String money3 = String.valueOf(money2);
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setBackground(c1);
		textField_6.setText(money3);
		textField_6.setColumns(10);
		textField_6.setBounds(371, 544, 70, 31);
		frame.getContentPane().add(textField_6);
		textField_6.setBorder(null);
		textField_6.setForeground(Color.BLUE);
		textField_6.setEditable(false);
		
		textField_6.setFont(new Font("배달의민족 주아", Font.BOLD, 17));

		
		//ID 뒤 고정 텍스트 라벨 "님"
		label3 = new JLabel("님");
		label3.setFont(new Font("배달의민족 주아", Font.BOLD, 20));
		label3.setBounds(180, 123, 40, 30);
		frame.getContentPane().add(label3);
		
		
		//배경 색상 
		
		Panel = new JPanel();
		Panel.setBackground(c1);
		frame.add(Panel);
		
		//text
		label2 = new JLabel("띵동! 주문이 들어왔습니다!");
		label2.setFont(new Font("배달의민족 주아", Font.BOLD, 30));
		label2.setBounds(83, 30, 400, 100);

		frame.getContentPane().add(label2);
		Panel.setLayout(null);
	
		
		//scroll 주문 내역 DB연결 필요 	> 희수님과 동일	
		
		
	
		
		//button		
		JButton b13 = new JButton();	
		b13.setBorderPainted(false);
		b13.setContentAreaFilled(false);
		b13.setFocusPainted(false);
		b13.setIcon(new ImageIcon("./images/jiconfirm3.png"));
		b13.setPressedIcon(new ImageIcon("./images/jiconfirm4.png"));	
		b13.setBounds(30, 570, 420, 100);
		frame.getContentPane().add(b13);
		b13.addActionListener(new ActionListener() {
	      
			@Override
	         public void actionPerformed(ActionEvent e) {
	            frame.getContentPane().removeAll();         
	            frame.repaint();
	            frame.add(b13);
	        	new KongFrame03();//메서드해당 창이동
	            frame.setVisible(false);//창안보이게하기
	         } 
		});
		
		
		

		//button
		//이전버튼
		Button4 = new JButton("");	
		Button4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {			
					new KongFrame01();	//홈으로 연결
					frame.setVisible(false);
					frame.setLocationRelativeTo(null);	
		}
		});
		
		Button4.setBorderPainted(false);
		Button4.setContentAreaFilled(false);
		Button4.setFocusPainted(false);
		Button4.setIcon(new ImageIcon("./images/pre.png"));
		Button4.setRolloverIcon(new ImageIcon("./images/Rollpre.png"));
		Button4.setPressedIcon(new ImageIcon("./images/PressedPre.png"));	
		Button4.setBounds(-1, 672, 120, 105);
		frame.getContentPane().add(Button4);
		
		
		//홈버튼
		Button5 = new JButton();
		Button5.setBorderPainted(false);
		Button5.setContentAreaFilled(false);
		Button5.setFocusPainted(false);
		Button5.setIcon(new ImageIcon("./images/Home.png"));
		Button5.setRolloverIcon(new ImageIcon("./images/RollHome.png"));
		Button5.setPressedIcon(new ImageIcon("./images/PressedHome.png"));
		Button5.setBounds(119,672,120,105);
		frame.getContentPane().add(Button5);
				
		Button5.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {			
			new KongFrame01();
			frame.setVisible(false);
		}
		});
		

		//주문내역
		Button6 = new JButton();
		Button6.setBorderPainted(false);
		Button6.setContentAreaFilled(false);
		Button6.setFocusPainted(false);
		Button6.setIcon(new ImageIcon("./images/OrderList.png"));
		Button6.setRolloverIcon(new ImageIcon("./images/RollOrderList.png"));
		Button6.setPressedIcon(new ImageIcon("./images/PressedOrderList.png"));
		Button6.setBounds(239,672,120,105); 
		frame.getContentPane().add(Button6);
		
		Button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				new KongFrame06();
				frame.setVisible(false);
			}
			});
			
		

		Button7 = new JButton();
		Button7.setBorderPainted(false);
		Button7.setContentAreaFilled(false);
		Button7.setFocusPainted(false);
		Button7.setIcon(new ImageIcon("./images/Mypage.png"));
		Button7.setRolloverIcon(new ImageIcon("./images/RollMypage.png"));
		Button7.setPressedIcon(new ImageIcon("./images/PressedMypage.png"));
		Button7.setBounds(359,672,120,105);
		Button7.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new My1();
				frame.dispose();
			}
			
		});
		frame.getContentPane().add(Button7);
		
		
		frame.setVisible(true);
	}

}

public class StoreUIOrderCheck {
	public static void main(String[] args) {
		new KongFrame05();
		
	}
}
