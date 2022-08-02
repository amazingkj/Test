package com.kong.payment;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import com.kong.Home.Home;
import com.kong.Home.My;
import com.kong.JDBC.MenuDAO;
import com.kong.JDBC.MenuDTO;
import com.kong.JDBC.PayDAO;
import com.kong.JDBC.PayListDAO;
import com.kong.JDBC.PayListDTO;
import com.kong.Main.Popup_CreateCheck;
import com.kong.Order.a_Box;

//결제하기 페이지
public class Payment {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	JLabel totalPrice,tip,sum;
	String id,addr;

	PayListDTO dto = new PayListDTO();
	PayListDAO dao = new PayListDAO();
	PayDAO pd = new PayDAO();
	MenuDAO mdao = new MenuDAO();
	MenuDTO mdto = new MenuDTO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment window = new Payment(0);
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);//윈도우 창을 화면의 가운데에 띄움
					window.frame.setResizable(false);//창 크기 고정
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Payment(int a) {
		initialize(a);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int a) {

		//프레임창
		frame = new JFrame();
		frame.setTitle("결제");
		frame.setBounds(100, 100, 480, 800);
		frame.getContentPane().setBackground(new Color(243, 243, 237));
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		//하단 패널
		JPanel panel = new JPanel();
		panel.setBounds(-2, 666, 476, 109);
		panel.setBackground(new Color(243, 243, 237));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		//이전 버튼
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("./images/sj_01.png"));
		button.setPressedIcon(new ImageIcon("./images/sj_02.png"));
		button.setRolloverIcon(new ImageIcon("./images/sj_03.png"));
		button.setFocusPainted(false);//버튼이 선택(focus) 되었을 때 생기는 테두리 사용 안 함
		button.setContentAreaFilled(false);//버튼의 내용 영역 채우기 안 함
		button.setBorderPainted(false);//버튼의 Border(외곽선)을 없애줌
		button.setBounds(0, 0, 122, 109);
		button.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				pd.reRoll();
				new a_Box(a);
				frame.dispose();
			}
			
		});
		panel.add(button);

		//홈 버튼
		JButton button_1 = new JButton("");
		button_1.setBounds(120, 0, 122, 109);
		panel.add(button_1);
		button_1.setIcon(new ImageIcon("./images/sj_04.png"));
		button_1.setPressedIcon(new ImageIcon("./images/sj_05.png"));
		button_1.setRolloverIcon(new ImageIcon("./images/sj_06.png"));
		button_1.setBorderPainted(false);
		button_1.setContentAreaFilled(false);
		button_1.setFocusPainted(false);
		button_1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				pd.reRoll();
				new Home();
				frame.dispose();
			}
			
		});

		//주문내역 버튼
		JButton button_2 = new JButton("");
		button_2.setBounds(240, 0, 122, 109);
		panel.add(button_2);
		button_2.setIcon(new ImageIcon("./images/sj_07.png"));
		button_2.setPressedIcon(new ImageIcon("./images/sj_08.png"));
		button_2.setRolloverIcon(new ImageIcon("./images/sj_09.png"));
		button_2.addActionListener(new ActionListener() {

			//주문내역 버튼 누르면 주문내역창 이동
			@Override
			public void actionPerformed(ActionEvent e) {
				pd.reRoll();
				OrderHistory oh = new OrderHistory();
				oh.setVisible(true);
				frame.dispose();
			}
		});
		button_2.setBorderPainted(false);
		button_2.setContentAreaFilled(false);
		button_2.setFocusPainted(false);

		//마이페이지 버튼
		JButton button_3 = new JButton("");
		button_3.setBounds(359, 0, 122, 109);
		panel.add(button_3);
		button_3.setIcon(new ImageIcon("./images/sj_10.png"));
		button_3.setPressedIcon(new ImageIcon("./images/sj_11.png"));
		button_3.setRolloverIcon(new ImageIcon("./images/sj_12.png"));
		button_3.setBorderPainted(false);
		button_3.setContentAreaFilled(false);
		button_3.setFocusPainted(false);
		button_3.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				pd.reRoll();
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

		//결제 라벨
		JLabel label = new JLabel("결제");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("배달의민족 주아", Font.BOLD, 40));
		label.setBounds(202, 58, 69, 42);
		panel_1.add(label);

		//배달 or 포장 선택 콤보박스
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"배달", "포장"}));
		comboBox.setToolTipText("");
		comboBox.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setBounds(55, 128, 67, 28);
		panel_1.add(comboBox);

		//로 받을게요 라벨
		JLabel label_1 = new JLabel("로 받을게요");
		label_1.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		label_1.setBounds(130, 132, 87, 22);
		panel_1.add(label_1);

		//결제 수단 전체 패널
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(47, 178, 376, 204);
		panel_1.add(panel_2);

		//결제 수단 라디오버튼 패널
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(29, 53, 221, 129);
		panel_3.setBackground(new Color(255, 255, 255));
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		//카드 라디오버튼
		JRadioButton radioButton = new JRadioButton("카드");		
		buttonGroup.add(radioButton);
		radioButton.setBounds(0, 10, 59, 29);
		panel_3.add(radioButton);
		radioButton.setFont(new Font("MICE고딕", Font.PLAIN, 17));
		radioButton.setBackground(new Color(255, 255, 255));

		//무통장입금 라디오버튼
		JRadioButton radioButton_1 = new JRadioButton("무통장입금");
		buttonGroup.add(radioButton_1);
		radioButton_1.setBounds(0, 49, 103, 29);
		panel_3.add(radioButton_1);
		radioButton_1.setFont(new Font("MICE고딕", Font.PLAIN, 17));
		radioButton_1.setBackground(new Color(255, 255, 255));

		//만나서 결제 라디오버튼
		JRadioButton radioButton_2 = new JRadioButton("만나서 결제(카드/현금 가능)");
		buttonGroup.add(radioButton_2);
		radioButton_2.setBounds(0, 88, 221, 29);
		panel_3.add(radioButton_2);
		radioButton_2.setFont(new Font("MICE고딕", Font.PLAIN, 17));
		radioButton_2.setBackground(new Color(255, 255, 255));

		//결제 수단 선택 라벨
		JLabel label_2 = new JLabel("결제 수단을 선택해주세요");
		label_2.setFont(new Font("MICE고딕", Font.PLAIN, 17));
		label_2.setBounds(29, 21, 175, 20);
		panel_2.add(label_2);

		//총 주문금액 라벨
		JLabel label_3 = new JLabel("총 주문금액");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("MICE고딕", Font.PLAIN, 17));
		label_3.setBounds(73, 406, 80, 20);
		panel_1.add(label_3);

		//배달팁 라벨
		JLabel label_4 = new JLabel("배달팁");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("MICE고딕", Font.PLAIN, 17));
		label_4.setBounds(73, 438, 45, 20);
		panel_1.add(label_4);

		//구분선
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(47, 470, 376, 10);
		panel_1.add(separator);

		//결제예정금액 라벨
		JLabel label_5 = new JLabel("결제예정금액");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("MICE고딕", Font.PLAIN, 20));
		label_5.setBounds(55, 492, 108, 24);
		panel_1.add(label_5);
		
		//총 주문금액
		totalPrice = new JLabel(dao.getPrice());
		totalPrice.setFont(new Font("MICE고딕", Font.PLAIN, 20));
		totalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		totalPrice.setBounds(300,406,108,24);
		panel_1.add(totalPrice);
		
		//배달팁
		tip = new JLabel("2500");
		tip.setFont(new Font("MICE고딕", Font.PLAIN, 20));
		tip.setHorizontalAlignment(SwingConstants.CENTER);
		tip.setBounds(300,438,108,24);
		panel_1.add(tip);
		
		//결제예정금액
		int tot = Integer.parseInt(totalPrice.getText());
		int tp = Integer.parseInt(tip.getText());
		sum = new JLabel(String.valueOf(tot+tp));
		sum.setFont(new Font("MICE고딕", Font.PLAIN, 20));
		sum.setHorizontalAlignment(SwingConstants.CENTER);
		sum.setBounds(300,492,108,24);
		panel_1.add(sum);

		//결제하기 버튼
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon("./images/sj_13.png"));
		button_4.setPressedIcon(new ImageIcon("./images/sj_14.png"));
		button_4.setRolloverIcon(new ImageIcon("./images/sj_14.png"));
		button_4.addActionListener(new ActionListener() {

			//결제하기 버튼 누르면 DB에 저장되고 결제완료창으로 이동
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!(radioButton.isSelected()) && !(radioButton_1.isSelected()) && !(radioButton_2.isSelected())) {
					new Popup_CreateCheck();
				}else {
					dto.setCus_no(dao.getID());
					dto.setD_way(comboBox.getSelectedItem().toString());
					
					if(radioButton.isSelected()) {
						dto.setP_with("카드");
					} 
					else if(radioButton_1.isSelected()) {
						dto.setP_with("무통장입금");
					}
					else if(radioButton_2.isSelected()) {
						dto.setP_with("만나서 결제(카드/현금 가능)");
					}												
					dto.setP_total(totalPrice.getText());
					dto.setD_tip(tip.getText());					
					dto.setP_sum(sum.getText());
					dto.setAddr(dao.getAddr());
					dto.setReq(dao.getReq());
					dto.setMenu(dao.getMenu());
					dto.setImg(mdao.takeImg());
					dto.setRest(dao.getRest());
					System.out.println(dao.getRest());
					
					pd.insertPayList(dto);
					new PayComplete(a);
					frame.dispose();
				}
				
			}
		});
		
		
		
		button_4.setBorderPainted(false);
		button_4.setContentAreaFilled(false);
		button_4.setFocusPainted(false);
		button_4.setBounds(30, 539, 405, 94);
		panel_1.add(button_4);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
