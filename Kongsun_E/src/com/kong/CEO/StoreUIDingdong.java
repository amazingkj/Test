package com.kong.CEO;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.kong.JDBC.PayDAO;
import com.kong.JDBC.ReviewDAO;

class KongFrame03 extends JFrame {
	private JPanel Panel;
	private JRadioButton t1, t2, t3, t4;
	private JButton b1,b2, backspace;
	
	PayDAO pdao = new PayDAO();
	
	ReviewDAO rdao = new ReviewDAO();

	public KongFrame03() {

		setSize(480, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("점주 주문 확인 페이지");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Color
		Color c1 = new Color(243, 243, 237);
		Color c2 = new Color(118, 178, 65);
		Color c3 = new Color(53, 158, 74);

		Panel = new JPanel();
		Panel.setBackground(c1);
		add(Panel);

		// Top Message
		JLabel label = new JLabel("예상 준비 시간을 입력해주세요");
		// label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font("배달의민족 주아", Font.BOLD, 28));
		label.setBounds(65, 100, 400, 100);

		Panel.add(label);
		Panel.setLayout(null);
		
		// time 라디오버튼 그룹
				t1 = new JRadioButton("20~30분");
				t2 = new JRadioButton("30~40분");
				t3 = new JRadioButton("40~50분");
				t4 = new JRadioButton("50~60분");

				ButtonGroup time = new ButtonGroup();
				time.add(t1);
				time.add(t2);
				time.add(t3);
				time.add(t4);

				t1.setBounds(200, 250, 100, 20);
				t2.setBounds(200, 300, 100, 20);
				t3.setBounds(200, 350, 100, 20);
				t4.setBounds(200, 400, 100, 20);
				t1.setBackground(c1);
				t2.setBackground(c1);
				t3.setBackground(c1);
				t4.setBackground(c1);
				t1.setFont(new Font("MICE고딕", Font.BOLD, 16));
				t2.setFont(new Font("MICE고딕", Font.BOLD, 16));
				t3.setFont(new Font("MICE고딕", Font.BOLD, 16));
				t4.setFont(new Font("MICE고딕", Font.BOLD, 16));

				Panel.add(t1);
				Panel.add(t2);
				Panel.add(t3);
				Panel.add(t4);


		// Button

		b1 = new JButton();

		b1.setBackground(c2);
		b1.setBorderPainted(false);
		b1.setContentAreaFilled(false);
		b1.setFocusPainted(false);
		b1.setIcon(new ImageIcon("./images/jisend1.png"));
		b1.setPressedIcon(new ImageIcon("./images/jisend2.png"));
		b1.setBounds(37, 500, 420, 100);

		b1.addActionListener(new ActionListener() {	//예정시간 유효성 검사
			public void actionPerformed(ActionEvent e) {
				if(time.isSelected(null)) {
					JOptionPane.showMessageDialog(null, "시간을 선택해주세요.");	//화면 가운데에 메시지출력
				} else {
					JOptionPane.showMessageDialog(null, "예상 시간이 전달 되었습니다.");//화면 가운데에 메시지출력
					
				}
			}
		});
		
		Panel.add(b1);
		
		
		
		b2 = new JButton();
		b2.setBorderPainted(false);
		b2.setContentAreaFilled(false);
		b2.setFocusPainted(false);
		b2.setIcon(new ImageIcon("./images/jiconfirm1.png"));
		b2.setPressedIcon(new ImageIcon("./images/jiconfirm2.png"));
		b2.setBounds(37, 620, 420, 100);
		b2.setBackground(c2);
		
		b2.addActionListener(new ActionListener() {	//b2 눌렀을 때 효과추가
			public void actionPerformed(ActionEvent e) {
				rdao.reviewOn();
				pdao.reRoll2();
				JOptionPane.showMessageDialog(null, "배송이 완료되었습니다.");	//화면 가운데에 메시지출력
						new KongFrame01();
						
						setVisible(false);					
			}
		});
	
		Panel.add(b2);
		
		
		//뒤로 가기 버튼
		backspace = new JButton();
		backspace.setBorderPainted(false);
		backspace.setContentAreaFilled(false);
		backspace.setFocusPainted(false);
		backspace.setIcon(new ImageIcon("./images/jiback1.png"));
		backspace.setRolloverIcon(new ImageIcon("./images/jiback2.png"));
		backspace.setPressedIcon(new ImageIcon("./images/jibackPress.png"));	
		backspace.setBounds(10,10,84,37);
		backspace.setBackground(c2);
		
		backspace.addActionListener(new ActionListener() {	//b2 눌렀을 때 효과추가
			public void actionPerformed(ActionEvent e) {
				new KongFrame05();	//화면 가운데에 메시지출력
				setVisible(false);
			}
		});
		
		Panel.add(backspace);
		
		
		setVisible(true);
	}
	
	}

public class StoreUIDingdong {
	public static void main(String[] args) {
		new KongFrame03();
	}
	
}
