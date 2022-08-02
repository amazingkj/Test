package com.kong.CEO;
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
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import com.kong.JDBC.PayDAO;
import com.kong.JDBC.PayListDTO;
//주문내역 
class KongFrame06{
	private JPanel panel;
	private JFrame frame;	
	private JScrollPane jsp;
	private JTextArea ta;
	private JButton Button4,Button5,Button6,Button7;
	
	PayListDTO dto = new PayListDTO();
	PayDAO pd = new PayDAO();

	//가장 최근 레코드
	String pdate = "";//주문일시
	String rt = "";//상호명
	String menu = "";//음식

	//최근에서 2번째
	String pdate2 = "";
	String rt2 = "";
	String menu2 = "";

	//최근에서 3번째
	String pdate3 = "";
	String rt3 = "";
	String menu3 = "";
	
	
	/* 주문시간, 메뉴, 수량, 가격 들어가야함.
	 * 배송완료가 되면 주문내역이 들어가야함.
	 */
	public KongFrame06() {		
		//배경 색상 		
		frame = new JFrame();
		frame.setTitle("주문 내역");
		frame.setBounds(100, 100, 480, 800);
		frame.getContentPane().setBackground(new Color(243, 243, 237));
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);//윈도우 창을 화면의 가운데에 띄움
		frame.setVisible(true);


		//하단 패널
		JPanel panel = new JPanel();
		panel.setBounds(-2, 666, 476, 109);
		panel.setBackground(new Color(243, 243, 237));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		//이전 버튼
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(0, 0, 122, 109);
		panel.add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon("./images/sj_01.png"));
		btnNewButton.setPressedIcon(new ImageIcon("./images/sj_02.png"));
		btnNewButton.setRolloverIcon(new ImageIcon("./images/sj_03.png"));
		btnNewButton.setBorderPainted(false);//버튼의 Border(외곽선)을 없애줌
		btnNewButton.setContentAreaFilled(false);//버튼의 내용 영역 채우기 안 함
		btnNewButton.setFocusPainted(false);//버튼이 선택(focus) 되었을 때 생기는 테두리 사용 안 함

		//홈버튼
		JButton button = new JButton("");
		button.setBounds(119, 0, 122, 109);
		panel.add(button);
		button.setIcon(new ImageIcon("./images/sj_04.png"));
		button.setPressedIcon(new ImageIcon("./images/sj_05.png"));
		button.setRolloverIcon(new ImageIcon("./images/sj_06.png"));
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
		button.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new KongFrame01();
				frame.dispose();
			}
			
		});

		//주문내역 버튼
		JButton button_1 = new JButton("");
		button_1.setBounds(238, 0, 122, 109);
		panel.add(button_1);
		button_1.setIcon(new ImageIcon("./images/sj_07.png"));
		button_1.setPressedIcon(new ImageIcon("./images/sj_08.png"));
		button_1.setRolloverIcon(new ImageIcon("./images/sj_09.png"));
		button_1.setBorderPainted(false);
		button_1.setContentAreaFilled(false);
		button_1.setFocusPainted(false);
		button_1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new KongFrame06();
				frame.dispose();
			}
			
		});
		

		//마이페이지 버튼
		JButton button_2 = new JButton("");
		button_2.setBounds(354, 0, 122, 109);
		panel.add(button_2);
		button_2.setIcon(new ImageIcon("./images/sj_10.png"));
		button_2.setPressedIcon(new ImageIcon("./images/sj_11.png"));
		button_2.setRolloverIcon(new ImageIcon("./images/sj_12.png"));
		button_2.setBorderPainted(false);
		button_2.setContentAreaFilled(false);
		button_2.setFocusPainted(false);
		button_2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new My();
				frame.dispose();
			}
			
		});

		//상단 패널
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(-1, 0, 476, 667);
		panel_1.setBackground(new Color(243, 243, 237));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		//주문 내역 라벨
		JLabel lblNewLabel = new JLabel("주문 내역");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setFont(new Font("배달의민족 주아", Font.BOLD, 40));
		lblNewLabel.setBounds(154, 58, 150, 42);
		panel_1.add(lblNewLabel);

		//가장 최근 삽입된 DB값 패널
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(87, 136, 196, 134);
		panel_2.setBackground(new Color(243, 243, 237));
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		//가장 최근 삽입된 DB값 불러오기
		for(PayListDTO b : pd.Orderlist7()) {
			pdate = b.getP_date();//주문일시
			rt = b.getRt();//상호명
			menu = b.getMenu();//음식

			System.out.println(pdate);
			System.out.println(rt);
			System.out.println(menu);
		}

		//주문일시 라벨
		JLabel lblNewLabel_1 = new JLabel(pdate);
		lblNewLabel_1.setBounds(0, 9, 196, 24);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("MICE고딕", Font.PLAIN, 20));

		//상호명 라벨
		JLabel lblNewLabel_2 = new JLabel(rt);
		lblNewLabel_2.setBounds(0, 42, 196, 24);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("MICE고딕", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);

		//음식 라벨
		JLabel lblNewLabel_3 = new JLabel(menu);
		lblNewLabel_3.setBounds(0, 76, 196, 24);
		panel_2.add(lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("MICE고딕", Font.PLAIN, 20));

		//예상 소요시간 라벨
		JLabel lblNewLabel_4 = new JLabel("예상 소요시간");
		lblNewLabel_4.setBounds(0, 108, 114, 24);
		panel_2.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("MICE고딕", Font.PLAIN, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);

		//배달 완료 라벨
		JLabel lblNewLabel_5 = new JLabel("배달 완료");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(295, 145, 78, 24);
		panel_1.add(lblNewLabel_5);

		//예상 소요시간 값 라벨
		JLabel lblNewLabel_6 = new JLabel("0분");
		lblNewLabel_6.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setBounds(333, 244, 40, 24);
		panel_1.add(lblNewLabel_6);

		//구분선
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(70, 280, 335, 2);
		panel_1.add(separator);		

		//구분선
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(70, 436, 335, 2);
		panel_1.add(separator_1);

		//최근에서 2번째
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(243, 243, 237));
		panel_3.setBounds(87, 292, 196, 134);
		panel_1.add(panel_3);

		//가장 최근에서 2번째
		for(PayListDTO b : pd.Orderlist8()) {
			pdate2 = b.getP_date();//주문일시
			rt2 = b.getRt();//상호명
			menu2 = b.getMenu();//음식

			System.out.println(pdate2);
			System.out.println(rt2);
			System.out.println(menu2);
		}


		JLabel label = new JLabel(pdate2);
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("MICE고딕", Font.PLAIN, 20));
		label.setBounds(0, 9, 196, 24);
		panel_3.add(label);

		JLabel label_1 = new JLabel(rt2);
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("MICE고딕", Font.PLAIN, 20));
		label_1.setBounds(0, 42, 196, 24);
		panel_3.add(label_1);

		JLabel label_2 = new JLabel(menu2);
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("MICE고딕", Font.PLAIN, 20));
		label_2.setBounds(0, 76, 196, 24);
		panel_3.add(label_2);

		JLabel label_3 = new JLabel("예상 소요시간");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("MICE고딕", Font.PLAIN, 20));
		label_3.setBounds(0, 108, 114, 24);
		panel_3.add(label_3);

		JLabel label_4 = new JLabel("배달 완료");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		label_4.setBounds(295, 301, 78, 24);
		panel_1.add(label_4);

		JLabel label_5 = new JLabel("0분");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		label_5.setBounds(333, 400, 40, 24);
		panel_1.add(label_5);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(70, 592, 335, 2);
		panel_1.add(separator_2);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(243, 243, 237));
		panel_4.setBounds(87, 448, 196, 134);
		panel_1.add(panel_4);

		//가장 최근에서 3번째
		for(PayListDTO b : pd.Orderlist9()) {
			pdate3 = b.getP_date();//주문일시
			rt3 = b.getRt();//상호명
			menu3 = b.getMenu();//음식

			System.out.println(pdate3);
			System.out.println(rt3);
			System.out.println(menu3);
		}
		JLabel label_6 = new JLabel(pdate3);
		label_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_6.setFont(new Font("MICE고딕", Font.PLAIN, 20));
		label_6.setBounds(0, 9, 196, 24);
		panel_4.add(label_6);

		JLabel label_7 = new JLabel(rt3);
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setFont(new Font("MICE고딕", Font.PLAIN, 20));
		label_7.setBounds(0, 42, 196, 24);
		panel_4.add(label_7);

		JLabel label_8 = new JLabel(menu3);
		label_8.setHorizontalAlignment(SwingConstants.LEFT);
		label_8.setFont(new Font("MICE고딕", Font.PLAIN, 20));
		label_8.setBounds(0, 76, 196, 24);
		panel_4.add(label_8);

		JLabel label_9 = new JLabel("예상 소요시간");
		label_9.setHorizontalAlignment(SwingConstants.LEFT);
		label_9.setFont(new Font("MICE고딕", Font.PLAIN, 20));
		label_9.setBounds(0, 108, 114, 24);
		panel_4.add(label_9);

		JLabel label_10 = new JLabel("배달 완료");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		label_10.setBounds(295, 457, 78, 24);
		panel_1.add(label_10);

		JLabel label_11 = new JLabel("0분");
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		label_11.setBounds(333, 556, 40, 24);
		panel_1.add(label_11);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setBounds(70, 130, 335, 2);
		panel_1.add(separator_3);

		
	}
}

public class StoreUIOrderList {
	public StoreUIOrderList() {
		new KongFrame06();
	}
	public static void main(String[] args) {
		new KongFrame06();
	}

}
