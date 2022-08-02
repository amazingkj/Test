package com.kong.payment;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import com.kong.CEO.TextPopup;
import com.kong.Home.Home;
import com.kong.JDBC.MenuDAO;
import com.kong.JDBC.PayDAO;
import com.kong.JDBC.PayListDTO;

//결제완료 페이지
public class PayComplete extends JFrame{

	private JFrame frame;
	PayListDTO dto = new PayListDTO();
	PayDAO pd = new PayDAO();
	
	MenuDAO mdao = new MenuDAO();

	int pno = 0;
	String pdate = "";
	String psum = "";
	String pwith = "";
	String dway = "";
	String addr = "";
	String req = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayComplete window = new PayComplete(0);
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);//윈도우 창을 화면의 가운데에 띄움
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PayComplete(int a) {
		initialize(a);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
		frame.setResizable(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int a) {

		//프레임창
		frame = new JFrame();
		frame.setTitle("결제완료");
		frame.setBounds(100, 100, 480, 800);
		frame.getContentPane().setBackground(new Color(243, 243, 237));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		//List<PayListDTO> a = dao.getPayList();
		//DB에서 값 불러오기	
				for(PayListDTO b : pd.getPaylist()) {
					pno = b.getP_no();//주문번호
					pdate = b.getP_date();//주문일시
					psum = b.getP_sum();//총 결제금액
					pwith = b.getP_with();//결제수단
					dway = b.getD_way();//픽업방법
					addr = b.getAddr();//배달주소
					req = b.getReq();//요청사항

					
				}		

		//상단 패널
		JPanel panel = new JPanel();
		panel.setBounds(-1, 0, 476, 667);
		panel.setBackground(new Color(243, 243, 237));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		//결제완료 라벨
		JLabel lblNewLabel = new JLabel("결제완료");
		lblNewLabel.setFont(new Font("배달의민족 주아", Font.BOLD, 40));
		lblNewLabel.setBounds(168, 58, 139, 42);
		panel.add(lblNewLabel);

		//결제 완료 알림 패널
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(67, 152, 340, 60);
		panel_2.setBackground(new Color(243, 243, 237));
		panel.add(panel_2);
		panel_2.setLayout(null);

		//결제가 완료되었습니다 라벨
		JLabel lblNewLabel_1 = new JLabel("결제가 완료되었습니다.");
		lblNewLabel_1.setBounds(75, 0, 190, 24);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("MICE고딕", Font.PLAIN, 20));

		//도착 시간 알림 라벨
		JLabel lblNewLabel_2 = new JLabel("주문하신 메뉴는 30분 후 도착 예정입니다.");
		lblNewLabel_2.setBounds(18, 39, 304, 21);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("MICE고딕", Font.PLAIN, 18));

		//배달정보 및 구분선 패널
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(40, 266, 395, 36);
		panel_4.setBackground(new Color(243, 243, 237));
		panel.add(panel_4);
		panel_4.setLayout(null);

		//배달정보 라벨
		JLabel lblNewLabel_3 = new JLabel("배달정보");
		lblNewLabel_3.setBounds(23, 0, 76, 24);
		panel_4.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("MICE고딕", Font.BOLD, 20));

		//구분선
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 34, 393, 2);
		panel_4.add(separator);
		separator.setForeground(Color.BLACK);

		//배달 정보 속성 패널
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(67, 302, 80, 294);
		panel_3.setBackground(new Color(243, 243, 237));
		panel.add(panel_3);
		panel_3.setLayout(null);

		//주문번호 라벨
		JLabel lblNewLabel_4 = new JLabel("주문번호");
		lblNewLabel_4.setBounds(0, 19, 60, 20);
		panel_3.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("MICE고딕", Font.PLAIN, 17));

		//주문일시 라벨
		JLabel lblNewLabel_5 = new JLabel("주문일시");
		lblNewLabel_5.setBounds(0, 58, 60, 20);
		panel_3.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("MICE고딕", Font.PLAIN, 17));

		//총 결제금액 라벨
		JLabel lblNewLabel_6 = new JLabel("총 결제금액");
		lblNewLabel_6.setBounds(0, 97, 80, 20);
		panel_3.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("MICE고딕", Font.PLAIN, 17));

		//결제수단 라벨
		JLabel lblNewLabel_7 = new JLabel("결제수단");
		lblNewLabel_7.setBounds(0, 136, 60, 20);
		panel_3.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("MICE고딕", Font.PLAIN, 17));

		//픽업방법 라벨
		JLabel lblNewLabel_8 = new JLabel("픽업방법");
		lblNewLabel_8.setBounds(0, 175, 60, 20);
		panel_3.add(lblNewLabel_8);
		lblNewLabel_8.setFont(new Font("MICE고딕", Font.PLAIN, 17));

		//배달주소 라벨
		JLabel lblNewLabel_9 = new JLabel("배달주소");
		lblNewLabel_9.setBounds(0, 214, 60, 20);
		panel_3.add(lblNewLabel_9);
		lblNewLabel_9.setFont(new Font("MICE고딕", Font.PLAIN, 17));

		//요청사항 라벨(일회용품 여부)
		JLabel label = new JLabel("요청사항");
		label.setBounds(0, 253, 60, 20);
		panel_3.add(label);
		label.setFont(new Font("MICE고딕", Font.PLAIN, 17));

		//값 패널
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(159, 321, 239, 260);
		panel_5.setBackground(new Color(243, 243, 237));
		panel.add(panel_5);
		panel_5.setLayout(null);

		

		JLabel lblNewLabel_10 = new JLabel(String.valueOf(pno));
		lblNewLabel_10.setBounds(70, 0, 169, 26);
		panel_5.add(lblNewLabel_10);
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_10.setFont(new Font("MICE고딕", Font.PLAIN, 17));

		//주문일시 값 라벨
		JLabel label_1 = new JLabel(pdate);
		label_1.setBounds(70, 39, 169, 26);
		panel_5.add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("MICE고딕", Font.PLAIN, 17));

		//총 결제금액 값 라벨
		JLabel label_2 = new JLabel(String.valueOf(psum));
		label_2.setBounds(70, 78, 169, 26);
		panel_5.add(label_2);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("MICE고딕", Font.PLAIN, 17));

		//결제수단 값 라벨	
		JLabel label_3 = new JLabel(pwith);
		label_3.setBounds(36, 117, 203, 26);
		panel_5.add(label_3);
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("MICE고딕", Font.PLAIN, 17));

		//픽업방법 값 라벨
		JLabel label_4 = new JLabel(dway);
		label_4.setBounds(0, 156, 239, 26);
		panel_5.add(label_4);
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("MICE고딕", Font.PLAIN, 17));

		//배달주소 값 라벨
		JLabel label_5 = new JLabel(addr);
		label_5.setBounds(0, 195, 239, 26);
		panel_5.add(label_5);
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("MICE고딕", Font.PLAIN, 17));

		//요청사항 값 라벨(일회용품 여부)
		JLabel label_6 = new JLabel(req);
		label_6.setBounds(0, 234, 239, 26);
		panel_5.add(label_6);
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setFont(new Font("MICE고딕", Font.PLAIN, 17));

		//하단 패널
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(42, 586, 476, 109);
		panel_1.setBackground(new Color(243, 243, 237));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		//이전 버튼
		
		//홈 버튼
		JButton button = new JButton("");
		button.setBounds(120, 0, 122, 109);
		panel_1.add(button);
		button.setIcon(new ImageIcon("./images/kmw_대지 108.png"));
		button.setPressedIcon(new ImageIcon("./images/kmw_대지 109.png"));
		button.setRolloverIcon(new ImageIcon("./images/kmw_대지 110.png"));		
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
		button.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				mdao.reRoll();
				new Home();
				new TextPopup();
				frame.dispose();
			}
			
		});

		
	}
}
