package com.kong.CEO;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.kong.Home.Home;
import com.kong.JDBC.ReviewDAO;
import com.kong.JDBC.ReviewDTO;

public class TextPopup extends JFrame {
	
	private JPanel panel; 
	private JComboBox point;
	private JTextField tf;
	private JTextArea ta;
	private JButton ok;
	
	private JLabel count;
	
	ReviewDAO rdao = new ReviewDAO();
		
	String[] star={"★★★★★","★★★★☆","★★★☆☆","★★☆☆☆","★☆☆☆☆"};	
	
	public TextPopup() {
		setTitle("리뷰를 남겨주세요");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setSize(300,300);
		setLocationRelativeTo(null);
		
		
		//JPanel panel = new Panel();
		
		
		point = new JComboBox(star);
		add(point);
		
		JTextField tf1 = new JTextField(15);
		tf1.setText("닉네임을 입력하세요");
		tf1.setFont(new Font("MICE고딕", Font.PLAIN, 12));
		add(tf1);
		
		JTextField tf2 = new JTextField(23);
		tf2.setText("가게 이름을 입력하세요");
		tf2.setFont(new Font("MICE고딕", Font.PLAIN, 12));
		add(tf2);
		
	
		JTextArea ta = new JTextArea(11,23);
		ta.setText("리뷰를 남겨주세요");
		ta.setFont(new Font("MICE고딕", Font.PLAIN, 12));
		add(new JScrollPane(ta));
		
		
		JButton ok = new JButton("등록");
		add(ok);
		ok.addActionListener(new ActionListener() {
		

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==ok) {
					try {
					String r_point = (String) point.getSelectedItem();
					String r_id=tf1.getText();  //<<변경부분>>
					String r_store = tf2.getText();
					String r_cont = ta.getText();					
					
					rdao.insertReview(new ReviewDTO(r_store,r_id,r_point,r_cont)); //<<변경부분>>
					JOptionPane.showMessageDialog(null, "등록 되었습니다", "등록 확인", JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);	
					
					point.setActionCommand(""); //리뷰창 초기화
					tf1.setText(""); //<<변경부분>>
					tf2.setText(""); //<<변경부분>>
					ta.setText("");	//리뷰창 초기화
					
					}catch (Exception e1) { 
						e1.printStackTrace();					
					} 
					//rdao.reviewOff();
				}
			}
		});
	
		setVisible(true);	
		
	}
		
	public static void main(String[] args) {
		
		new TextPopup();
		
	}

}


