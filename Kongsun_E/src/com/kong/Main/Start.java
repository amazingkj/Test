package com.kong.Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.kong.JDBC.MemberDAO;
import com.kong.JDBC.MemberDTO;

public class Start extends JFrame{
	
	private static final long serialVersionUID = 1L;
	JPanel LoginPanel = new JPanel() {

		private static final long serialVersionUID = 1L;

		public void paint(Graphics g) {
			g.drawImage(background.getImage(), 0, 0, null);
			setOpaque(false);
			super.paint(g);
		}
	};
	JPanel newAccountPanel = new JPanel();
	JPanel findIDPanel = new JPanel(){

		private static final long serialVersionUID = 1L;

		public void paint(Graphics g) {
			g.drawImage(background2.getImage(), 0, 0, null);
			setOpaque(false);
			super.paint(g);
		}
	};
	JPanel findPWPanel = new JPanel(){

		private static final long serialVersionUID = 1L;

		public void paint(Graphics g) {
			g.drawImage(background2.getImage(), 0, 0, null);
			setOpaque(false);
			super.paint(g);
		}
	};
	JPanel CeoPanel = new JPanel() {		

		private static final long serialVersionUID = 1L;

		public void paint(Graphics g) {
			g.drawImage(background3.getImage(), 0, 0, null);
			g.drawLine(50, 105, 400, 105);
			setOpaque(false);
			super.paint(g);
		}
	};
	JPanel Ceo2Panel = new JPanel();
	JPanel Ceo3Panel = new JPanel();
	JPanel CustomerPanel = new JPanel(){		

		private static final long serialVersionUID = 1L;

		public void paint(Graphics g) {
			g.drawImage(background3.getImage(), 0, 0, null);
			g.drawLine(50, 105, 400, 105);
			setOpaque(false);
			super.paint(g);
		}
	};
	JPanel Customer2Panel = new JPanel();
	JPanel Customer3Panel = new JPanel();
	JPanel CreateSuccess = new JPanel();
	
	JTextField LO_logintxt;
	JPasswordField LO_password;
	JLabel LO_findID,LO_findPW,LO_border;
	JButton LO_loginbtn,LO_newaccountbtn,LO_exit;
	int lv = 0; 
	
	JLabel NA_custip,NA_ceotip;
	JButton NA_backspace,NA_customer,NA_ceo;
	
	JTextField FP_name,FP_idtxt,FP_phonetxt;
	JButton FP_backspace,FP_ok;
	JLabel FP_nametip,FP_idtip,FP_phonetip;
	
	JTextField FI_name,FI_phonetxt;
	JButton FI_backspace,FI_ok;
	JLabel FI_nametip,FI_phonetip;
	
	
	JLabel CEO_alllb,CEO_lb1,CEO_lb2,CEO_lb3,CEO_lb4,CEO_lb5;
	JCheckBox CEO_all;
	JCheckBox CEO_c1,CEO_c2,CEO_c3,CEO_c4,CEO_c5;
	JButton CEO_backspace,CEO_next;
	JTextArea CEO_c1ta,CEO_c2ta,CEO_c3ta,CEO_c4ta,CEO_c5ta;
	
	JScrollPane scrollbar = new JScrollPane();
	JTextField CEO2_idtxt,CEO2_nametxt,CEO2_addrtxt,CEO2_phonetxt;
	JPasswordField CEO2_pwtxt,CEO2_pwchecktxt;
	JLabel CEO2_idtip,CEO2_pwtip,CEO2_pwchecktip,CEO2_nametip,CEO2_phonetip,CEO2_addrtip,CEO2_idtag,CEO2_pwtag,CEO2_pwchecktag,CEO2_nametag,CEO2_addrtag,CEO2_phonetag;	
	JButton CEO2_backspace,CEO2_idexistcheck,CEO2_nextbtn;
	boolean CEO2_id,CEO2_pw,CEO2_name,CEO2_address,CEO2_phone,CEO2_crn,CEO2_bn;
	int CEO2_exist = 1;
	
	JTextField CEO3_crntxt,CEO3_bntxt,CEO3_menu1txt,CEO3_menu2txt,CEO3_menu3txt,CEO3_cost1txt,CEO3_cost2txt,CEO3_cost3txt,CEO3_tiptxt;
	JLabel CEO3_crntip,CEO3_bntip,CEO3_foodtip,CEO3_menutip,CEO3_costtip,CEO3_tiptip,CEO3_crntag,CEO3_bntag,CEO3_foodtag,CEO3_menutag,CEO3_costtag,CEO3_tiptag;
	JComboBox<String> CEO3_food;
	JButton CEO3_SignUpbtn,CEO3_backspace;
	
	
	JCheckBox CUS_all,CUS_c1,CUS_c2,CUS_c3,CUS_c4,CUS_c5;
	JLabel CUS_alllb,CUS_lb1,CUS_lb2,CUS_lb3,CUS_lb4,CUS_lb5;
	JButton CUS_backspace,CUS_next;
	JTextArea CUS_c1ta,CUS_c2ta,CUS_c3ta,CUS_c4ta,CUS_c5ta;
	
	JTextField CUS2_idtxt,CUS2_nametxt,CUS2_addrtxt;
	JPasswordField CUS2_pwtxt,CUS2_pwchecktxt;		
	JLabel CUS2_idtip,CUS2_pwtip,CUS2_pwchecktip,CUS2_nametip,CUS2_addrtip,CUS2_idtag,CUS2_pwtag,CUS2_pwchecktag,CUS2_nametag,CUS2_addrtag;
	JButton CUS2_backspace,CUS2_nextbtn,CUS2_idexistcheck;
	boolean CUS2_id,CUS2_pw,CUS2_name,CUS2_phone,CUS2_email,CUS2_gender,CUS2_address = false;
	int CUS2_exist = 1;
	
	JTextField CUS3_phonetxt,CUS3_emailtxt;
	JRadioButton CUS3_male,CUS3_female;
	JComboBox<Integer> CUS3_year,CUS3_month,CUS3_date;
	JLabel CUS3_phonetip,CUS3_emailtip,CUS3_gendertip,CUS3_birthtip,CUS3_phonetag,CUS3_emailtag,CUS3_gendertag,CUS3_birthtag;
	JButton CUS3_backspace,CUS3_SignUpbtn;
	
	Font kFont15 = new Font("배달의민족 주아",Font.PLAIN,16);
	Font kFont24 = new Font("배달의민족 주아",Font.PLAIN,24);
	
	Color c1 = new Color(243,243,237);
	ImageIcon background = new ImageIcon("./images/kmw_대지 126.png");
	ImageIcon background2 = new ImageIcon("./images/background2.png");
	ImageIcon background3 = new ImageIcon("./images/background3.png");
	ImageIcon new1 = new ImageIcon("./images/kmw_대지 75.png");
	ImageIcon new2 = new ImageIcon("./images/kmw_대지 77.png");
	ImageIcon login1 = new ImageIcon("./images/kmw_대지 76.png");
	ImageIcon login2 = new ImageIcon("./images/kmw_대지 78.png");
	ImageIcon LO_exitimg1 = new ImageIcon("./images/kmw_대지 112.png");
	ImageIcon LO_exitimg2 = new ImageIcon("./images/kmw_대지 113.png");
	ImageIcon LO_exitimg3 = new ImageIcon("./images/kmw_대지 114.png");
	ImageIcon backspaceimg1 = new ImageIcon("./images/kmw_대지 121.png");
	ImageIcon backspaceimg2 = new ImageIcon("./images/kmw_대지 122.png");
	ImageIcon backspaceimg3 = new ImageIcon("./images/kmw_대지 86.png");
	ImageIcon idexistcheck1 = new ImageIcon("./images/kmw_대지 100.png");
	ImageIcon idexistcheck2 = new ImageIcon("./images/kmw_대지 98.png");
	ImageIcon idexistcheck3 = new ImageIcon("./images/kmw_대지 99.png");
	ImageIcon findID1 = new ImageIcon("./images/kmw_대지 131.png");
	ImageIcon findID2 = new ImageIcon("./images/kmw_대지 132.png");
	ImageIcon findID3 = new ImageIcon("./images/kmw_대지 133.png");
	ImageIcon findPW1 = new ImageIcon("./images/kmw_대지 134.png");
	ImageIcon findPW2 = new ImageIcon("./images/kmw_대지 135.png");
	ImageIcon findPW3 = new ImageIcon("./images/kmw_대지 136.png");
	ImageIcon Customer1 = new ImageIcon("./images/kmw_대지 104.png");
	ImageIcon Customer2 = new ImageIcon("./images/kmw_대지 101.png");
	ImageIcon Customer3 = new ImageIcon("./images/kmw_대지 103.png");
	ImageIcon CEO1 = new ImageIcon("./images/kmw_대지 107.png");
	ImageIcon CEO2 = new ImageIcon("./images/kmw_대지 105.png");
	ImageIcon CEO3 = new ImageIcon("./images/kmw_대지 106.png");
	ImageIcon reg1 = new ImageIcon("./images/kmw_대지 90.png");
	ImageIcon reg2 = new ImageIcon("./images/kmw_대지 89.png");
	ImageIcon reg3 = new ImageIcon("./images/kmw_돼지 76.png");
	ImageIcon Next1 = new ImageIcon("./images/kmw_대지 129.png");
	ImageIcon Next2 = new ImageIcon("./images/kmw_대지 130.png");
	ImageIcon BigOK1 = new ImageIcon("./images/kmw_BigOk1.png");
	ImageIcon BigOK2 = new ImageIcon("./images/kmw_BigOk2.png");
	ImageIcon BigOK3 = new ImageIcon("./images/kmw_BigOk3.png");
	
		
	MemberDAO dao = new MemberDAO();
	MemberDTO dto = new MemberDTO();
	
		
	public Start(){
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(480,800);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);		
				
		//로그인화면
		add(LoginPanel);
		
				
		//--여기부터 set--//
		LO_logintxt = new JTextField(7);
		LO_logintxt.setFont(kFont24);
		LO_logintxt.setBorder(null);
				
		LO_password = new JPasswordField(7);
		LO_password.setBorder(null);
		
		LO_loginbtn = new JButton(login1);	
		LO_loginbtn.setPressedIcon(login2);
		LO_loginbtn.setContentAreaFilled(false);
		LO_loginbtn.setBorderPainted(false);
		LO_loginbtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				lv = dao.member_Login(LO_logintxt.getText(), new String(LO_password.getPassword()));
				//System.out.println(dao.member_Logincheck(LO_logintxt.getText()));
				
				/*
				 * if(dao.member_Logincheck(LO_logintxt.getText()) == 1){ dao.member_logout(); }
				 */
				if(lv >= 1 && lv <= 3) {
					new MainPage(lv);
					LO_logintxt.setText("");
					LO_password.setText("");
					dispose();
				}else {
					new LoginFail();
				}				
			}			
		});
		
		LO_newaccountbtn = new JButton(new1);
		LO_newaccountbtn.setPressedIcon(new2);
		LO_newaccountbtn.setBorderPainted(false);
		LO_newaccountbtn.setContentAreaFilled(false);
		LO_newaccountbtn.setBorderPainted(false);
		LO_newaccountbtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().removeAll();			
				repaint();
				add(newAccountPanel);
				newAccountPanel.setBounds(0,0,480,800);
				newAccountPanel.setVisible(true);
			}			
		});		
		
		LO_findID = new JLabel();
		LO_findID.setFont(kFont15);
		LO_findID.setText("아이디 찾기");
		LO_findID.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().removeAll();
				repaint();
				add(findIDPanel);
				findIDPanel.setBounds(0,0,480,800);
				findIDPanel.setVisible(true);
			}	
		});
		
		LO_border = new JLabel("|");
		LO_border.setFont(kFont15);
		
		LO_findPW = new JLabel();
		LO_findPW.setFont(kFont15);
		LO_findPW.setText("비밀번호 찾기");
		LO_findPW.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().removeAll();
				repaint();
				add(findPWPanel);
				findPWPanel.setBounds(0,0,480,800);
				findPWPanel.setVisible(true);
			}
			
		});
		
		LO_exit = new JButton(LO_exitimg1);
		LO_exit.setRolloverIcon(LO_exitimg2);
		LO_exit.setPressedIcon(LO_exitimg3);
		LO_exit.setContentAreaFilled(false);
		LO_exit.setBorderPainted(false);
		LO_exit.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
			
		});
		//--여기까지 set--//
		
		//--여기부터 init--//
		LoginPanel.add(LO_logintxt);
		LoginPanel.add(LO_password);
		LoginPanel.add(LO_loginbtn);
		LoginPanel.add(LO_newaccountbtn);
		LoginPanel.add(LO_findID);
		LoginPanel.add(LO_border);
		LoginPanel.add(LO_findPW);
		LoginPanel.add(LO_exit);
		//--여기부터 init--//
						
		//--여기부터 layouts--//
		LoginPanel.setLayout(null);
		LO_logintxt.setBounds(160,255,200,45);
		LO_password.setBounds(160,315,200,45);
		LO_loginbtn.setBounds(95,380,290,60);
		LO_newaccountbtn.setBounds(126,500,228,44);
		LO_findID.setBounds(150,450,100,50);
		LO_border.setBounds(240,450,100,50);
		LO_findPW.setBounds(255,450,100,50);
		LO_exit.setBounds(199,640,82,38);
		//--여기까지 layouts--//
		
		//로그인화면 끝
		
		//회원가입창
		
		
		
		
		//--여기부터 set--//
		NA_custip = new JLabel();
		NA_custip.setFont(kFont24);
		NA_custip.setText("음식을 배달받아서 먹고싶어요!");
		
		NA_ceotip = new JLabel();
		NA_ceotip.setFont(kFont24);
		NA_ceotip.setText("음식을 만드는 사장님이에요!");
		
		NA_backspace = new JButton(backspaceimg1);
		NA_backspace.setRolloverIcon(backspaceimg2);
		NA_backspace.setPressedIcon(backspaceimg3);
		NA_backspace.setContentAreaFilled(false);
		NA_backspace.setBorderPainted(false);
		NA_backspace.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().removeAll();
				repaint();
				add(LoginPanel);
				LoginPanel.setBounds(0,0,480,800);
				LoginPanel.setVisible(true);
			}
		});
		
		NA_customer = new JButton(Customer1);
		NA_customer.setRolloverIcon(Customer2);
		NA_customer.setPressedIcon(Customer3);
		NA_customer.setContentAreaFilled(false);
		NA_customer.setBorderPainted(false);
		NA_customer.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().removeAll();
				repaint();
				add(CustomerPanel);
				CustomerPanel.setBounds(0,0,480,800);
				CustomerPanel.setVisible(true);
			}
			
		});
		
		NA_ceo = new JButton(CEO1);
		NA_ceo.setRolloverIcon(CEO2);
		NA_ceo.setPressedIcon(CEO3);
		NA_ceo.setContentAreaFilled(false);
		NA_ceo.setBorderPainted(false);
		NA_ceo.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().removeAll();
				repaint();
				add(CeoPanel);
				CeoPanel.setBounds(0,0,480,800);
				CeoPanel.setVisible(true);
			}
			
		});
		//--여기까지 set--//
		
		
		//--여기부터 init--//
		newAccountPanel.setBackground(c1);
		newAccountPanel.add(NA_custip);
		newAccountPanel.add(NA_ceotip);
		newAccountPanel.add(NA_backspace);
		newAccountPanel.add(NA_customer);
		newAccountPanel.add(NA_ceo);
		//--여기까지 init--//
		
		
		//--여기부터 layouts--//
		newAccountPanel.setLayout(null);
		NA_backspace.setBounds(10,10,84,37);
		NA_custip.setBounds(110,150,300,25);
		NA_ceotip.setBounds(110,400,300,25);
		NA_customer.setBounds(128,200,228,101);
		NA_ceo.setBounds(128,450,228,101);
		//--여기까지 layouts--//
		//회원가입창 끝
		
		
		//아이디찾기
		findIDPanel.setVisible(true);
		
		//--여기부터 set--//
		
		FI_backspace = new JButton(backspaceimg1);
		FI_backspace.setRolloverIcon(backspaceimg2);
		FI_backspace.setPressedIcon(backspaceimg3);
		FI_backspace.setContentAreaFilled(false);
		FI_backspace.setBorderPainted(false);
		FI_backspace.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().removeAll();
				repaint();
				add(LoginPanel);
				LoginPanel.setBounds(0,0,480,800);
				LoginPanel.setVisible(true);
			}
			
		});
		
		FI_name = new JTextField();
		FI_name.setBorder(null);
		FI_name.setFont(kFont24);
		FI_nametip = new JLabel();
		FI_nametip.setFont(kFont24);
		FI_nametip.setText("이름");
		
		FI_phonetxt = new JTextField();
		FI_phonetxt.setBorder(null);
		FI_phonetxt.setFont(kFont24);
		FI_phonetxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(FI_phonetxt.getText().length() > 0) {
					if(e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
						if(FI_phonetxt.getText().length() == 3) {
							FI_phonetxt.setText(FI_phonetxt.getText()+"-");
						}else if(FI_phonetxt.getText().length() == 8) {
							FI_phonetxt.setText(FI_phonetxt.getText()+"-");
						}
					}
				}
			}
		});
		
		FI_phonetip = new JLabel();
		FI_phonetip.setFont(kFont24);
		FI_phonetip.setText("전화번호");
		
		FI_ok = new JButton(findID1);
		FI_ok.setRolloverIcon(findID2);
		FI_ok.setPressedIcon(findID3);
		FI_ok.setBorderPainted(false);
		FI_ok.setContentAreaFilled(false);
		FI_ok.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(FI_name.getText().length() > 0) {
					if(FI_phonetxt.getText().length() > 0) {
						new Popup_findID(1,dao.member_TakeId(FI_name.getText(), FI_phonetxt.getText()));
						//dao.member_TakeId(FI_name.getText(), FI_phonetxt.getText())는 id.
					}else {
						new Popup_findID(0,"내용을 입력해주세요.");
					}					
				}else {
					new Popup_findID(0,"내용을 입력해주세요.");
				}	
			}			
		});
		//--여기까지 set--//
		
		
		//--여기부터 init--//
		findIDPanel.add(FI_backspace);
		findIDPanel.add(FI_name);
		findIDPanel.add(FI_nametip);
		findIDPanel.add(FI_phonetxt);
		findIDPanel.add(FI_phonetip);
		findIDPanel.add(FI_ok);
		//--여기까지 init--//
		
		
		//--여기부터 layouts--//
		findIDPanel.setLayout(null);
		FI_backspace.setBounds(10,10,84,37);
		FI_name.setBounds(170,250,220,45);
		FI_nametip.setBounds(70,250,100,45);
		FI_phonetxt.setBounds(170,330,220,45);
		FI_phonetip.setBounds(70,330,100,45);
		FI_ok.setBounds(128,550,228,44);
		//--여기까지 layouts--//
		//아이디찾기 끝
		
		
		//비밀번호찾기
		findPWPanel.setVisible(true);
		
		//--여기부터 set--//
		
		FP_backspace = new JButton(backspaceimg1);
		FP_backspace.setRolloverIcon(backspaceimg2);
		FP_backspace.setPressedIcon(backspaceimg3);
		FP_backspace.setContentAreaFilled(false);
		FP_backspace.setBorderPainted(false);
		FP_backspace.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().removeAll();
				repaint();
				add(LoginPanel);
				LoginPanel.setBounds(0,0,480,800);
				LoginPanel.setVisible(true);
			}
			
		});
		
		FP_name = new JTextField();
		FP_name.setFont(kFont24);
		FP_name.setBorder(null);
		
		FP_nametip = new JLabel();
		FP_nametip.setFont(kFont24);
		FP_nametip.setText("이름");
		
		FP_idtxt = new JTextField();
		FP_idtxt.setFont(kFont24);
		FP_idtxt.setBorder(null);
		
		FP_idtip = new JLabel();
		FP_idtip.setFont(kFont24);
		FP_idtip.setText("아이디");
		
		FP_phonetxt = new JTextField();
		FP_phonetxt.setBorder(null);
		FP_phonetxt.setFont(kFont24);
		FP_phonetxt.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if(FP_phonetxt.getText().length() > 0) {
					if(e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
						if(FP_phonetxt.getText().length() == 3) {
							FP_phonetxt.setText(FP_phonetxt.getText()+"-");
						}else if(FP_phonetxt.getText().length() == 8) {
							FP_phonetxt.setText(FP_phonetxt.getText()+"-");
						}
					}
				}
			}
		});
		
		FP_phonetip = new JLabel();
		FP_phonetip.setFont(kFont24);
		FP_phonetip.setText("전화번호");
		
		FP_ok = new JButton(findPW1);
		FP_ok.setRolloverIcon(findPW2);
		FP_ok.setPressedIcon(findPW3);
		FP_ok.setBorderPainted(false);
		FP_ok.setContentAreaFilled(false);
		FP_ok.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(FP_name.getText().length() > 0) {
					if(FP_phonetxt.getText().length() > 0) {
						if(FP_idtxt.getText().length() > 0) {
							new Popup_findPW(1,dao.member_TakePw(FP_name.getText(), FP_idtxt.getText(), FP_phonetxt.getText()));
						}else {
							new Popup_findPW(0,"내용을 입력해주세요.");
						}
					}else {
						new Popup_findPW(0,"내용을 입력해주세요.");
					}					
				}else {
					new Popup_findPW(0,"내용을 입력해주세요.");
				}	
						
			}
			
		});
		//--여기까지 set--//
		
		
		//--여기부터 init--//
		findPWPanel.add(FP_backspace);
		findPWPanel.add(FP_name);
		findPWPanel.add(FP_nametip);
		findPWPanel.add(FP_idtxt);
		findPWPanel.add(FP_idtip);
		findPWPanel.add(FP_phonetxt);
		findPWPanel.add(FP_phonetip);
		findPWPanel.add(FP_ok);
		//--여기까지 init--//
		
		
		//--여기부터 layouts--//
		findPWPanel.setLayout(null);
		FP_backspace.setBounds(10,10,84,37);
		FP_name.setBounds(170,250,200,45);
		FP_nametip.setBounds(70,250,100,45);
		FP_idtxt.setBounds(170,330,200,45);
		FP_idtip.setBounds(70,330,100,45);
		FP_phonetxt.setBounds(170,410,200,45);
		FP_phonetip.setBounds(70,410,200,45);
		FP_ok.setBounds(128,550,228,44);
		//--여기부터 layouts--//
		//비밀번호찾기 끝
		
		
		//사업자
		CeoPanel.setVisible(true);
		
		//--여기부터 set--//
		CEO_backspace = new JButton(backspaceimg1);
		CEO_backspace.setRolloverIcon(backspaceimg2);
		CEO_backspace.setPressedIcon(backspaceimg3);
		CEO_backspace.setContentAreaFilled(false);
		CEO_backspace.setBorderPainted(false);
		CEO_backspace.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().removeAll();
				repaint();
				add(newAccountPanel);
				newAccountPanel.setBounds(0,0,480,800);
				newAccountPanel.setVisible(true);
			}
			
		});
		
		CEO_all = new JCheckBox();
		CEO_c1 = new JCheckBox();
		CEO_c2 = new JCheckBox();
		CEO_c3 = new JCheckBox();
		CEO_c4 = new JCheckBox();
		CEO_c5 = new JCheckBox();
		CEO_all.setBackground(c1);
		CEO_c1.setBackground(c1);
		CEO_c2.setBackground(c1);
		CEO_c3.setBackground(c1);
		CEO_c4.setBackground(c1);
		CEO_c5.setBackground(c1);
		
		CEO_all.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				//all.setSelected(true);
				CEO_c1.setSelected(true);
				CEO_c2.setSelected(true);
				CEO_c3.setSelected(true);
				CEO_c4.setSelected(true);
				CEO_c5.setSelected(true);
			}
			
		});
		
		CEO_c1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				CEO_all.setSelected(false);
			}
			
		});		
		
		CEO_c2.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				CEO_all.setSelected(false);
			}
			
		});
				
		CEO_c3.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				CEO_all.setSelected(false);
			}
			
		});
				
		CEO_c4.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				CEO_all.setSelected(false);
			}
			
		});
				
		CEO_c5.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				CEO_all.setSelected(false);
			}
			
		});
						
		CEO_alllb = new JLabel("모두 동의합니다.");
		CEO_alllb.setFont(kFont15);
		
		CEO_lb1 = new JLabel("약관1");
		CEO_lb1.setFont(kFont15);
		
		CEO_lb2 = new JLabel("약관2");
		CEO_lb2.setFont(kFont15);
		
		CEO_lb3 = new JLabel("약관3");
		CEO_lb3.setFont(kFont15);
		
		CEO_lb4 = new JLabel("약관4");
		CEO_lb4.setFont(kFont15);
		
		CEO_lb5 = new JLabel("약관5");
		CEO_lb5.setFont(kFont15);
		
		CEO_c1ta = new JTextArea();
		CEO_c1ta.setFont(kFont15);
		CEO_c1ta.setEnabled(false);
		CEO_c1ta.setText("콩순이배달은 갑의 위치에 있으며, 사용자의 개인정보를 모두 열람 가능합니다.");
		CEO_c1ta.setLineWrap(true);
		
		CEO_c2ta = new JTextArea();
		CEO_c2ta.setFont(kFont15);
		CEO_c2ta.setEnabled(false);
		CEO_c2ta.setText("어플 내의 모든 것은 개발자가 우선이 되며, 이용하는 고객의 의견은 무시될 수 있습니다.");
		CEO_c2ta.setLineWrap(true);
		
		CEO_c3ta = new JTextArea();
		CEO_c3ta.setFont(kFont15);
		CEO_c3ta.setEnabled(false);
		CEO_c3ta.setText("콩순이배달 내에 존재하는 모든 자료 및 개인정보는 콩순이배달에 입력된 순간부터 콩순이배달의 소유가 됩니다.");
		CEO_c3ta.setLineWrap(true);
		
		CEO_c4ta = new JTextArea();
		CEO_c4ta.setFont(kFont15);
		CEO_c4ta.setEnabled(false);
		CEO_c4ta.setText("콩순이배달의 조항에 이의 제기 시 계정이 정지될 수 있음을 알립니다.");
		CEO_c4ta.setLineWrap(true);
		
		CEO_c5ta = new JTextArea();
		CEO_c5ta.setFont(kFont15);
		CEO_c5ta.setEnabled(false);
		CEO_c5ta.setText("콩순이배달 사용 중 일어나는 모든 손해는 사용자의 과실임을 인지하시기 바랍니다.");
		CEO_c5ta.setLineWrap(true);
		
		
		CEO_next = new JButton(reg1);
		CEO_next.setRolloverIcon(reg2);
		CEO_next.setPressedIcon(reg3);
		CEO_next.setBorderPainted(false);
		CEO_next.setContentAreaFilled(false);
		CEO_next.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(CEO_c1.isSelected() && CEO_c2.isSelected() && CEO_c3.isSelected() && CEO_c4.isSelected() && CEO_c5.isSelected() ) {
					CEO_all.setSelected(false);
					CEO_c1.setSelected(false);
					CEO_c2.setSelected(false);
					CEO_c3.setSelected(false);
					CEO_c4.setSelected(false);
					CEO_c5.setSelected(false);
					getContentPane().removeAll();
					repaint();
					add(Ceo2Panel);
					Ceo2Panel.setBounds(0,0,480,800);
					Ceo2Panel.setVisible(true);
				}else {
					new Popup_Agree();
				}
				
			}
			
		});
		//--여기까지 set--//
		
		
		//--여기부터 init--//
		CeoPanel.setBackground(c1);
		
		CeoPanel.add(CEO_backspace);
		
		CeoPanel.add(CEO_all);
		CeoPanel.add(CEO_c1);
		CeoPanel.add(CEO_c2);
		CeoPanel.add(CEO_c3);
		CeoPanel.add(CEO_c4);
		CeoPanel.add(CEO_c5);
		
		CeoPanel.add(CEO_alllb);
		CeoPanel.add(CEO_lb1);
		CeoPanel.add(CEO_lb2);
		CeoPanel.add(CEO_lb3);
		CeoPanel.add(CEO_lb4);
		CeoPanel.add(CEO_lb5);
		
		CeoPanel.add(CEO_c1ta);
		CeoPanel.add(CEO_c2ta);
		CeoPanel.add(CEO_c3ta);
		CeoPanel.add(CEO_c4ta);
		CeoPanel.add(CEO_c5ta);
		
		CeoPanel.add(CEO_next);
		//--여기까지 init--//
		
		
		//--여기부터 layouts--//
		CeoPanel.setLayout(null);
		
		CEO_backspace.setBounds(10,10,84,37);
		
		CEO_all.setBounds(50,70,25,25);
		CEO_c1.setBounds(50,130,25,25);
		CEO_c2.setBounds(50,220,25,25);
		CEO_c3.setBounds(50,310,25,25);
		CEO_c4.setBounds(50,400,25,25);
		CEO_c5.setBounds(50,490,25,25);
		
		CEO_alllb.setBounds(100,70,200,25);
		CEO_lb1.setBounds(100,130,200,25);
		CEO_lb2.setBounds(100,220,200,25);
		CEO_lb3.setBounds(100,310,200,25);
		CEO_lb4.setBounds(100,400,200,25);
		CEO_lb5.setBounds(100,490,200,25);
		
		CEO_c1ta.setBounds(50,155,350,50);
		CEO_c2ta.setBounds(50,245,350,50);
		CEO_c3ta.setBounds(50,335,350,50);
		CEO_c4ta.setBounds(50,425,350,50);
		CEO_c5ta.setBounds(50,515,350,50);
		
		CEO_next.setBounds(163,610,153,68);
		//--여기까지 layouts--//
		//사업자 끝
		
		
		//사업자2
		Ceo2Panel.setVisible(true);
		
	
		//--여기부터 set--//
		CEO2_idtag = new JLabel("ID");
		CEO2_idtag.setFont(kFont15);

		CEO2_pwtag = new JLabel("PW");
		CEO2_pwtag.setFont(kFont15);
		
		CEO2_pwchecktag = new JLabel("PW확인");
		CEO2_pwchecktag.setFont(kFont15);
		
		CEO2_nametag = new JLabel("이름");
		CEO2_nametag.setFont(kFont15);
		
		CEO2_addrtag = new JLabel("주소");
		CEO2_addrtag.setFont(kFont15);
		
		CEO2_phonetag = new JLabel("전화번호");
		CEO2_phonetag.setFont(kFont15);
		
		
		CEO2_idtip = new JLabel();
		CEO2_idtip.setText("아이디를 입력하세요.");
		CEO2_idtip.setFont(kFont15);
		
		CEO2_pwtip = new JLabel();
		CEO2_pwtip.setText("비밀번호를 입력하세요.");
		CEO2_pwtip.setFont(kFont15);
		
		CEO2_pwchecktip = new JLabel();
		CEO2_pwchecktip.setText("비밀번호를 입력하세요.");
		CEO2_pwchecktip.setFont(kFont15);
		
		CEO2_nametip = new JLabel();
		CEO2_nametip.setText("이름을 입력하세요.");
		CEO2_nametip.setFont(kFont15);
		
		CEO2_addrtip = new JLabel();
		CEO2_addrtip.setText("주소를 입력하세요.");
		CEO2_addrtip.setFont(kFont15);
		
		CEO2_phonetip = new JLabel();
		CEO2_phonetip.setText("전화번호를 입력하세요.");
		CEO2_phonetip.setFont(kFont15);
		
		
		
		CEO2_backspace = new JButton(backspaceimg1);
		CEO2_backspace.setRolloverIcon(backspaceimg2);
		CEO2_backspace.setPressedIcon(backspaceimg3);
		CEO2_backspace.setContentAreaFilled(false);
		CEO2_backspace.setBorderPainted(false);
		CEO2_backspace.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().removeAll();
				repaint();
				add(CeoPanel);
				CeoPanel.setBounds(0,0,480,800);
				CeoPanel.setVisible(true);
			}
			
		});
		
		CEO2_idtxt = new JTextField();
		CEO2_idtxt.setFont(kFont15);
		CEO2_idtxt.setBorder(null);
		
		CEO2_nametxt = new JTextField();
		CEO2_nametxt.setFont(kFont15);
		CEO2_nametxt.setBorder(null);
		
		CEO2_addrtxt = new JTextField();
		CEO2_addrtxt.setFont(kFont15);
		CEO2_addrtxt.setBorder(null);
		
		CEO2_phonetxt = new JTextField();
		CEO2_phonetxt.setFont(kFont15);
		CEO2_phonetxt.setBorder(null);
		
		CEO2_pwtxt = new JPasswordField();
		CEO2_pwtxt.setBorder(null);
		
		CEO2_pwchecktxt = new JPasswordField();
		CEO2_pwchecktxt.setBorder(null);
		
		
		CEO2_idtxt.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if(CEO2_idtxt.getText().length() > 0) {
					if(!(CEO2_idtxt.getText().matches("^[a-zA-Z0-9]*$"))) {
						CEO2_idtip.setText("영어 혹은 숫자만 입력가능합니다.");
					}else {
						CEO2_idtip.setText("사용 가능한 아이디입니다.");
					}
				}else {
					CEO2_idtip.setText("아이디를 입력하세요.");
				}
			}
			
		});
		
		
		CEO2_nametxt.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if(CEO2_nametxt.getText().length() > 0) {
					if(!(CEO2_nametxt.getText().matches("^[ㄱ-ㅣ가-힣]*$"))) {
						CEO2_nametip.setText("한글만 입력 가능합니다.");
					}else {
						CEO2_nametip.setText("사용 가능한 이름입니다.");
					}
				}else {
					CEO2_nametip.setText("이름을 입력하세요.");
				}
			}
			
		});		
		
		CEO2_addrtxt.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if(CEO2_addrtxt.getText().length() > 0) {
				}else {
				}
			}
		});
		
		
		CEO2_phonetxt.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if(CEO2_phonetxt.getText().length() > 0) {
					if(e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
						if(CEO2_phonetxt.getText().length() == 3) {
							CEO2_phonetxt.setText(CEO2_phonetxt.getText()+"-");
						}else if(CEO2_phonetxt.getText().length() == 8) {
							CEO2_phonetxt.setText(CEO2_phonetxt.getText()+"-");
						}
					}
					if(!(CEO2_phonetxt.getText().matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$"))){
						CEO2_phonetip.setText("잘못된 번호입니다.");
					}else {
						CEO2_phonetip.setText("올바른 번호입니다.");
					}
				}else {
					CEO2_phonetip.setText("전화번호를 입력하세요.");
				}
			}
			
		});
				
		CEO2_pwtxt.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if(CEO2_pwtxt.getPassword().length > 0) {
					if(new String(CEO2_pwchecktxt.getPassword()).equals(new String(CEO2_pwtxt.getPassword()))) {
						CEO2_pwtip.setText("비밀번호가 일치합니다.");
						if(CEO2_pwtip.getText() == "비밀번호가 일치합니다.") {
							CEO2_pwchecktip.setText("비밀번호가 일치합니다.");
						}
					}else {
						CEO2_pwtip.setText("비밀번호가 일치하지 않습니다.");
					}
				}else {
					CEO2_pwtip.setText("비밀번호를 입력하세요.");
				}
			}
			
		});
				
		CEO2_pwchecktxt.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if(CEO2_pwchecktxt.getPassword().length > 0) {
					if(new String(CEO2_pwtxt.getPassword()).equals(new String(CEO2_pwchecktxt.getPassword()))) {
						CEO2_pwchecktip.setText("비밀번호가 일치합니다.");
						if(CEO2_pwchecktip.getText() == "비밀번호가 일치합니다.") {
							CEO2_pwtip.setText("비밀번호가 일치합니다.");
						}
					}else {
						CEO2_pwchecktip.setText("비밀번호가 일치하지 않습니다.");
					}
				}else {
					CEO2_pwchecktip.setText("비밀번호를 입력하세요.");
				}
			}
			
		});
		
		CEO2_idexistcheck = new JButton(idexistcheck1);
		CEO2_idexistcheck.setRolloverIcon(idexistcheck2);
		CEO2_idexistcheck.setPressedIcon(idexistcheck3);
		CEO2_idexistcheck.setBorderPainted(false);
		CEO2_idexistcheck.setContentAreaFilled(false);
		CEO2_idexistcheck.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(CEO2_idtxt.getText().length() == 0) {
					new Popup_idCreateAble(0);
				}else {
					CEO2_exist = dao.member_idExistCheck(CEO2_idtxt.getText()); //1=중복체크유도, 2=중복아이디 있음, 3=중복아이디 없음
					
					new Popup_idCreateAble(CEO2_exist);
				}				
			}
		});
				
		CEO2_nextbtn = new JButton(Next1);
		CEO2_nextbtn.setContentAreaFilled(false);
		CEO2_nextbtn.setBorderPainted(false);
		CEO2_nextbtn.setPressedIcon(Next2);
		CEO2_nextbtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(CEO2_exist == 1 || CEO2_exist == 2) {
					new Popup_idCreateAble(CEO2_exist);
				}else if(!(CEO2_idtip.getText().matches("사용 가능한 아이디입니다."))) {
					new Popup_CreateCheck();
				}else if(!(CEO2_pwtip.getText().matches("비밀번호가 일치합니다."))) {
					new Popup_CreateCheck();
				}else if(!(CEO2_nametip.getText().matches("사용 가능한 이름입니다."))) {
					new Popup_CreateCheck();
				}else if(!(CEO2_phonetip.getText().matches("올바른 번호입니다."))) {
					new Popup_CreateCheck();
				}else {
					getContentPane().removeAll();
					repaint();
					add(Ceo3Panel);
					Ceo3Panel.setBounds(0,0,480,800);
					Ceo3Panel.setVisible(true);
					Ceo3Panel.setBackground(c1);
				}
			}
			
		});		
		//--여기까지 set--//
		
		
		//--여기부터 init--//
		Ceo2Panel.setBackground(c1);
		
		Ceo2Panel.add(CEO2_idtag);
		Ceo2Panel.add(CEO2_pwtag);
		Ceo2Panel.add(CEO2_pwchecktag);
		Ceo2Panel.add(CEO2_nametag);
		Ceo2Panel.add(CEO2_addrtag);
		Ceo2Panel.add(CEO2_phonetag);
		
		Ceo2Panel.add(CEO2_backspace);
		Ceo2Panel.add(CEO2_idtxt);
		Ceo2Panel.add(CEO2_pwtxt);
		Ceo2Panel.add(CEO2_pwchecktxt);
		Ceo2Panel.add(CEO2_nametxt);
		Ceo2Panel.add(CEO2_addrtxt);
		Ceo2Panel.add(CEO2_phonetxt);
		
		
		Ceo2Panel.add(CEO2_idtip);
		Ceo2Panel.add(CEO2_pwtip);
		Ceo2Panel.add(CEO2_pwchecktip);
		Ceo2Panel.add(CEO2_nametip);
		Ceo2Panel.add(CEO2_addrtip);
		Ceo2Panel.add(CEO2_phonetip);
		
		Ceo2Panel.add(CEO2_nextbtn);
		
		Ceo2Panel.add(CEO2_idexistcheck);
		
		//--여기까지 init--//
		
		
		//--여기부터 layouts--//
		Ceo2Panel.setLayout(null);
		CEO2_backspace.setBounds(10,10,84,37);
		
		CEO2_idtag.setBounds(60,60,75,35);
		CEO2_pwtag.setBounds(60,150,75,35);
		CEO2_pwchecktag.setBounds(60,240,75,35);
		CEO2_nametag.setBounds(60,330,75,35);
		CEO2_addrtag.setBounds(60,420,75,35);
		CEO2_phonetag.setBounds(60,510,75,35);
		
		CEO2_idtxt.setBounds(140,60,200,35);
		CEO2_pwtxt.setBounds(140,150,200,35);
		CEO2_pwchecktxt.setBounds(140,240,200,35);
		CEO2_nametxt.setBounds(140,330,200,35);
		CEO2_addrtxt.setBounds(140,420,200,35);
		CEO2_phonetxt.setBounds(140,510,200,35);
		
		CEO2_idtip.setBounds(140,90,300,35);
		CEO2_pwtip.setBounds(140,180,300,35);
		CEO2_pwchecktip.setBounds(140,270,300,35);
		CEO2_nametip.setBounds(140,360,300,35);
		CEO2_addrtip.setBounds(140,450,300,35);
		CEO2_phonetip.setBounds(140,540,300,35);
		
		CEO2_nextbtn.setBounds(199,590,81,38);
		
		CEO2_idexistcheck.setBounds(350,60,76,68);
		
		//--여기까지 layouts--//
		
		
		//사업자2 끝
		
		
		//사업자3 시작
		
		//여기부터 set
		CEO3_crntag = new JLabel("사업자번호");
		CEO3_crntag.setFont(kFont15);
		CEO3_bntag = new JLabel("상호명");
		CEO3_bntag.setFont(kFont15);
		CEO3_foodtag = new JLabel("요리종류");
		CEO3_foodtag.setFont(kFont15);
		CEO3_menutag = new JLabel("세부메뉴");
		CEO3_menutag.setFont(kFont15);
		CEO3_costtag = new JLabel("메뉴 가격");
		CEO3_costtag.setFont(kFont15);
		CEO3_tiptag = new JLabel("배달팁");
		CEO3_tiptag.setFont(kFont15);
		
		
		CEO3_crntxt = new JTextField();
		CEO3_crntxt.setFont(kFont15);
		CEO3_crntxt.setBorder(null);
		
		CEO3_bntxt = new JTextField();
		CEO3_bntxt.setFont(kFont15);
		CEO3_bntxt.setBorder(null);
		
		CEO3_menu1txt = new JTextField();
		CEO3_menu1txt.setFont(kFont15);
		CEO3_menu1txt.setBorder(null);
		
		CEO3_menu2txt = new JTextField();
		CEO3_menu2txt.setFont(kFont15);
		CEO3_menu2txt.setBorder(null);
		
		CEO3_menu3txt = new JTextField();
		CEO3_menu3txt.setFont(kFont15);
		CEO3_menu3txt.setBorder(null);
		
		CEO3_cost1txt = new JTextField();
		CEO3_cost1txt.setFont(kFont15);
		CEO3_cost1txt.setBorder(null);
		
		CEO3_cost2txt = new JTextField();
		CEO3_cost2txt.setFont(kFont15);
		CEO3_cost2txt.setBorder(null);
		
		CEO3_cost3txt = new JTextField();
		CEO3_cost3txt.setFont(kFont15);
		CEO3_cost3txt.setBorder(null);
		
		CEO3_tiptxt = new JTextField();
		CEO3_tiptxt.setFont(kFont15);
		CEO3_tiptxt.setBorder(null);
		
		CEO3_backspace = new JButton(backspaceimg1);
		CEO3_backspace.setRolloverIcon(backspaceimg2);
		CEO3_backspace.setPressedIcon(backspaceimg3);
		CEO3_backspace.setContentAreaFilled(false);
		CEO3_backspace.setBorderPainted(false);
		CEO3_backspace.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().removeAll();
				repaint();
				add(Ceo2Panel);
				Ceo2Panel.setBounds(0,0,480,800);
				Ceo2Panel.setVisible(true);
			}
			
		});
								
		CEO3_crntxt.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if(CEO3_crntxt.getText().length() > 0) {
					if(e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
						if(CEO3_crntxt.getText().length() == 3) {
							CEO3_crntxt.setText(CEO3_crntxt.getText()+"-");
						}else if(CEO3_crntxt.getText().length() == 6){
							CEO3_crntxt.setText(CEO3_crntxt.getText()+"-");
						}
					if(!(CEO3_crntxt.getText().matches("([0-9]{3})-?([0-9]{2})-?([0-9]{5})"))) {
						CEO3_crntip.setText("잘못된 번호입니다.");
					}else {
						CEO3_crntip.setText("올바른 번호입니다.");
					}
					}
				}else {
					CEO3_crntip.setText("사업자등록번호를 입력하세요.");
				}
			}
			
		});
				
		CEO3_bntxt.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if(CEO3_bntxt.getText().length() > 0) {
					if(!(CEO3_bntxt.getText().matches("^[ㄱ-ㅎㅏ-ㅣ가-힣]*$"))) {
						CEO3_bntip.setText("한글만 입력 가능합니다.");
					}else {
						CEO3_bntip.setText("사용 가능한 상호명입니다.");
					}
				}else {
					CEO3_bntip.setText("상호명을 입력하세요.");
				}
			}
			
		});
		
		CEO3_food = new JComboBox<String>();
		CEO3_food.addItem("한식");
		CEO3_food.addItem("중식");
		CEO3_food.addItem("일식");
		CEO3_food.addItem("양식");
		CEO3_food.setFont(kFont15);
		CEO3_food.setBorder(null);
		
		CEO3_cost1txt.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if(CEO3_cost1txt.getText().length() > 0) {
					if(!(CEO3_cost1txt.getText().matches("^[0-9]*$"))){
						CEO3_costtip.setText("숫자만 입력 가능합니다.");
					}
				}else {
					CEO3_costtip.setText("메뉴 순서에 맞춰서 가격을 입력하세요.");
				}
			}
			
		});
		
		CEO3_cost2txt.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if(CEO3_cost2txt.getText().length() > 0) {
					if(!(CEO3_cost2txt.getText().matches("^[0-9]*$"))){
						CEO3_costtip.setText("숫자만 입력 가능합니다.");
					}
				}else {
					CEO3_costtip.setText("메뉴 순서에 맞춰서 가격을 입력하세요.");
				}
			}		
		});
		
		CEO3_cost3txt.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if(CEO3_cost3txt.getText().length() > 0) {
					if(!(CEO3_cost3txt.getText().matches("^[0-9]*$"))){
						CEO3_costtip.setText("숫자만 입력 가능합니다.");
					}
				}else {
					CEO3_costtip.setText("메뉴 순서에 맞춰서 가격을 입력하세요.");
				}
			}			
		});
		
		CEO3_tiptxt.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if(CEO3_tiptxt.getText().length() > 0) {
					if(!(CEO3_tiptxt.getText().matches("^[0-9]*$"))){
						CEO3_tiptip.setText("숫자만 입력 가능합니다.");
					}
				}else {
					CEO3_costtip.setText("배달팁을 책정하세요.");
				}
			}
			
		});
		
		CEO3_crntip = new JLabel();
		CEO3_crntip.setText("사업자등록번호를 입력하세요.");
		CEO3_crntip.setFont(kFont15);
		
		CEO3_bntip = new JLabel();
		CEO3_bntip.setText("상호명을 입력하세요.");
		CEO3_bntip.setFont(kFont15);
		
		CEO3_foodtip = new JLabel();
		CEO3_foodtip.setText("요리분야를 선택하세요.");
		CEO3_foodtip.setFont(kFont15);
		
		CEO3_menutip = new JLabel();
		CEO3_menutip.setText("세부메뉴를 입력하세요.");
		CEO3_menutip.setFont(kFont15);
		
		CEO3_costtip = new JLabel();
		CEO3_costtip.setText("메뉴 순서에 맞춰서 가격을 입력하세요.");
		CEO3_costtip.setFont(kFont15);
		
		CEO3_tiptip = new JLabel();
		CEO3_tiptip.setText("배달팁을 책정하세요.");
		CEO3_tiptip.setFont(kFont15);
		
		
		CEO3_SignUpbtn = new JButton(reg1);
		CEO3_SignUpbtn.setRolloverIcon(reg2);
		CEO3_SignUpbtn.setPressedIcon(reg3);
		CEO3_SignUpbtn.setContentAreaFilled(false);
		CEO3_SignUpbtn.setBorderPainted(false);
		CEO3_SignUpbtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(!(CEO3_crntip.getText().matches("올바른 번호입니다."))) {
					new Popup_CreateCheck();
				}else if(!(CEO3_bntip.getText().matches("사용 가능한 상호명입니다."))) {
					new Popup_CreateCheck();
				}else {
					CeoAdd();
				}				
				//데이터베이스에 입력한거 넣기 작업하기
			}
			
		});
		
		//여기까지 set
		
		
		//여기부터 add
		Ceo3Panel.add(CEO3_backspace);
		
		Ceo3Panel.add(CEO3_crntag);
		Ceo3Panel.add(CEO3_bntag);
		Ceo3Panel.add(CEO3_foodtag);
		Ceo3Panel.add(CEO3_menutag);
		Ceo3Panel.add(CEO3_costtag);
		Ceo3Panel.add(CEO3_tiptag);
		
		Ceo3Panel.add(CEO3_crntxt);
		Ceo3Panel.add(CEO3_bntxt);
		Ceo3Panel.add(CEO3_food);
		Ceo3Panel.add(CEO3_menu1txt);
		Ceo3Panel.add(CEO3_menu2txt);
		Ceo3Panel.add(CEO3_menu3txt);
		Ceo3Panel.add(CEO3_cost1txt);
		Ceo3Panel.add(CEO3_cost2txt);
		Ceo3Panel.add(CEO3_cost3txt);
		Ceo3Panel.add(CEO3_tiptxt);
		
		Ceo3Panel.add(CEO3_crntip);
		Ceo3Panel.add(CEO3_bntip);
		Ceo3Panel.add(CEO3_foodtip);
		Ceo3Panel.add(CEO3_menutip);
		Ceo3Panel.add(CEO3_costtip);
		Ceo3Panel.add(CEO3_tiptip);
		
		Ceo3Panel.add(CEO3_SignUpbtn);
		//여기까지 add
		
		
		//여기부터 init
		Ceo3Panel.setLayout(null);
		
		CEO3_backspace.setBounds(10,10,84,37);
		
		CEO3_crntag.setBounds(60,60,75,35);
		CEO3_bntag.setBounds(60,150,75,35);
		CEO3_foodtag.setBounds(60,240,75,35);
		CEO3_menutag.setBounds(60,330,75,35);
		CEO3_costtag.setBounds(60,420,75,35);
		CEO3_tiptag.setBounds(60,510,75,35);
		
		CEO3_crntxt.setBounds(140,60,200,35);
		CEO3_bntxt.setBounds(140,150,200,35);
		CEO3_food.setBounds(140,240,200,35);
		CEO3_menu1txt.setBounds(140,330,65,35);
		CEO3_menu2txt.setBounds(210,330,65,35);
		CEO3_menu3txt.setBounds(280,330,65,35);
		CEO3_cost1txt.setBounds(140,420,65,35);
		CEO3_cost2txt.setBounds(210,420,65,35);
		CEO3_cost3txt.setBounds(280,420,65,35);
		CEO3_tiptxt.setBounds(140,510,200,35);
		
		CEO3_crntip.setBounds(140,90,200,35);
		CEO3_bntip.setBounds(140,180,200,35);
		CEO3_foodtip.setBounds(140,270,200,35);
		CEO3_menutip.setBounds(140,360,200,35);
		CEO3_costtip.setBounds(140,450,200,35);
		CEO3_tiptip.setBounds(140,540,200,35);	
		
		CEO3_SignUpbtn.setBounds(163,600,153,68);
		//여기까지 init
		
		
		
		//손님
		CustomerPanel.setVisible(true);
		
		
		//--여기부터 set--//
		CUS_backspace = new JButton(backspaceimg1);
		CUS_backspace.setRolloverIcon(backspaceimg2);
		CUS_backspace.setPressedIcon(backspaceimg3);
		CUS_backspace.setContentAreaFilled(false);
		CUS_backspace.setBorderPainted(false);
		CUS_backspace.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().removeAll();
				repaint();
				add(newAccountPanel);
				newAccountPanel.setBounds(0,0,480,800);
				newAccountPanel.setVisible(true);
			}
		});
		
		CUS_all = new JCheckBox();
		CUS_c1 = new JCheckBox();
		CUS_c2 = new JCheckBox();
		CUS_c3 = new JCheckBox();
		CUS_c4 = new JCheckBox();
		CUS_c5 = new JCheckBox();
		CUS_all.setBackground(c1);
		CUS_c1.setBackground(c1);
		CUS_c2.setBackground(c1);
		CUS_c3.setBackground(c1);
		CUS_c4.setBackground(c1);
		CUS_c5.setBackground(c1);
		
		CUS_c1ta = new JTextArea();
		CUS_c1ta.setFont(kFont15);
		CUS_c1ta.setEnabled(false);
		CUS_c1ta.setText("콩순이배달은 갑의 위치에 있으며, 사용자의 개인정보를 모두 열람 가능합니다.");
		CUS_c1ta.setLineWrap(true);
		
		CUS_c2ta = new JTextArea();
		CUS_c2ta.setFont(kFont15);
		CUS_c2ta.setEnabled(false);
		CUS_c2ta.setText("어플 내의 모든 것은 개발자가 우선이 되며, 이용하는 고객의 의견은 무시될 수 있습니다.");
		CUS_c2ta.setLineWrap(true);
		
		CUS_c3ta = new JTextArea();
		CUS_c3ta.setFont(kFont15);
		CUS_c3ta.setEnabled(false);
		CUS_c3ta.setText("콩순이배달 내에 존재하는 모든 자료 및 개인정보는 콩순이배달에 입력된 순간부터 콩순이배달의 소유가 됩니다.");
		CUS_c3ta.setLineWrap(true);
		
		CUS_c4ta = new JTextArea();
		CUS_c4ta.setFont(kFont15);
		CUS_c4ta.setEnabled(false);
		CUS_c4ta.setText("콩순이배달의 조항에 이의 제기 시 계정이 정지될 수 있음을 알립니다.");
		CUS_c4ta.setLineWrap(true);
		
		CUS_c5ta = new JTextArea();
		CUS_c5ta.setFont(kFont15);
		CUS_c5ta.setEnabled(false);
		CUS_c5ta.setText("콩순이배달 사용 중 일어나는 모든 손해는 사용자의 과실임을 인지하시기 바랍니다.");
		CUS_c5ta.setLineWrap(true);
		
		CUS_all.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				//all.setSelected(true);
				CUS_c1.setSelected(true);
				CUS_c2.setSelected(true);
				CUS_c3.setSelected(true);
				CUS_c4.setSelected(true);
				CUS_c5.setSelected(true);
			}
			
		});
				
		CUS_c1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				CUS_all.setSelected(false);
			}
			
		});
				
		CUS_c2.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				CUS_all.setSelected(false);
			}
			
		});
				
		CUS_c3.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				CUS_all.setSelected(false);
			}
			
		});
				
		CUS_c4.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				CUS_all.setSelected(false);
			}
			
		});
				
		CUS_c5.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				CUS_all.setSelected(false);
			}
			
		});
		
		CUS_alllb = new JLabel("모두 동의합니다.");
		CUS_alllb.setFont(kFont15);
		
		CUS_lb1 = new JLabel("약관1");
		CUS_lb1.setFont(kFont15);
		
		CUS_lb2 = new JLabel("약관2");
		CUS_lb2.setFont(kFont15);
		
		CUS_lb3 = new JLabel("약관3");
		CUS_lb3.setFont(kFont15);
		
		CUS_lb4 = new JLabel("약관4");
		CUS_lb4.setFont(kFont15);
		
		CUS_lb5 = new JLabel("약관5");
		CUS_lb5.setFont(kFont15);
		
		CUS_next = new JButton(reg1);
		CUS_next.setRolloverIcon(reg2);
		CUS_next.setPressedIcon(reg3);
		CUS_next.setBorderPainted(false);
		CUS_next.setContentAreaFilled(false);
		CUS_next.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(CUS_c1.isSelected() && CUS_c2.isSelected() && CUS_c3.isSelected() && CUS_c4.isSelected() && CUS_c5.isSelected() ) {
					CUS_all.setSelected(false);
					CUS_c1.setSelected(false);
					CUS_c2.setSelected(false);
					CUS_c3.setSelected(false);
					CUS_c4.setSelected(false);
					CUS_c5.setSelected(false);
					getContentPane().removeAll();
					repaint();
					add(Customer2Panel);
					Customer2Panel.setBounds(0,0,480,800);
					Customer2Panel.setVisible(true);
				}else {
					new Popup_Agree();
				}
				
			}
			
		});
		//--여기까지 set--//
		
		
		//--여기부터 init--//
		CustomerPanel.setBackground(c1);
		
		CustomerPanel.add(CUS_backspace);
		
		CustomerPanel.add(CUS_all);
		CustomerPanel.add(CUS_c1);
		CustomerPanel.add(CUS_c2);
		CustomerPanel.add(CUS_c3);
		CustomerPanel.add(CUS_c4);
		CustomerPanel.add(CUS_c5);
		
		CustomerPanel.add(CUS_alllb);
		CustomerPanel.add(CUS_lb1);
		CustomerPanel.add(CUS_lb2);
		CustomerPanel.add(CUS_lb3);
		CustomerPanel.add(CUS_lb4);
		CustomerPanel.add(CUS_lb5);
		
		CustomerPanel.add(CUS_c1ta);
		CustomerPanel.add(CUS_c2ta);
		CustomerPanel.add(CUS_c3ta);
		CustomerPanel.add(CUS_c4ta);
		CustomerPanel.add(CUS_c5ta);
		
		CustomerPanel.add(CUS_next);
		//--여기까지 init--//
		
		
		//--여기부터 layouts--//
		CustomerPanel.setLayout(null);
		
		CUS_backspace.setBounds(10,10,84,37);
		
		CUS_all.setBounds(50,70,25,25);
		CUS_c1.setBounds(50,130,25,25);
		CUS_c2.setBounds(50,220,25,25);
		CUS_c3.setBounds(50,310,25,25);
		CUS_c4.setBounds(50,400,25,25);
		CUS_c5.setBounds(50,490,25,25);
		
		CUS_alllb.setBounds(100,70,200,25);
		CUS_lb1.setBounds(100,130,200,25);
		CUS_lb2.setBounds(100,220,200,25);
		CUS_lb3.setBounds(100,310,200,25);
		CUS_lb4.setBounds(100,400,200,25);
		CUS_lb5.setBounds(100,490,200,25);
		
		CUS_c1ta.setBounds(50,155,350,50);
		CUS_c2ta.setBounds(50,245,350,50);
		CUS_c3ta.setBounds(50,335,350,50);
		CUS_c4ta.setBounds(50,425,350,50);
		CUS_c5ta.setBounds(50,515,350,50);
		
		CUS_next.setBounds(163,610,153,68);
		//--여기까지 layouts--//
		//소비자 끝
		
		
		
		//소비자2 시작
			
		//여기부터 set
		CUS2_backspace = new JButton(backspaceimg1);
		CUS2_backspace.setRolloverIcon(backspaceimg2);
		CUS2_backspace.setPressedIcon(backspaceimg3);
		CUS2_backspace.setContentAreaFilled(false);
		CUS2_backspace.setBorderPainted(false);
		CUS2_backspace.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().removeAll();
				repaint();
				add(CustomerPanel);
				CustomerPanel.setBounds(0,0,480,800);
				CustomerPanel.setVisible(true);
			}
			
		});
		CUS2_idtag = new JLabel("ID");
		CUS2_idtag.setFont(kFont15);
		
		CUS2_pwtag = new JLabel("PW");
		CUS2_pwtag.setFont(kFont15);
		
		CUS2_pwchecktag = new JLabel("PW확인");
		CUS2_pwchecktag.setFont(kFont15);
		
		CUS2_nametag = new JLabel("이름");
		CUS2_nametag.setFont(kFont15);
		
		CUS2_addrtag = new JLabel("주소");
		CUS2_addrtag.setFont(kFont15);
		
		CUS2_idtxt = new JTextField();
		CUS2_idtxt.setFont(kFont15);
		CUS2_idtxt.setBorder(null);
		
		CUS2_pwtxt = new JPasswordField();
		CUS2_pwtxt.setBorder(null);
		
		CUS2_pwchecktxt = new JPasswordField();
		CUS2_pwchecktxt.setBorder(null);
		
		CUS2_nametxt = new JTextField();
		CUS2_nametxt.setFont(kFont15);
		CUS2_nametxt.setBorder(null);
		
		CUS2_addrtxt = new JTextField();
		CUS2_addrtxt.setFont(kFont15);
		CUS2_addrtxt.setBorder(null);
		
		CUS2_idtip = new JLabel();
		CUS2_idtip.setText("아이디를 입력하세요.");
		CUS2_idtip.setFont(kFont15);
		
		CUS2_pwtip = new JLabel();
		CUS2_pwtip.setText("비밀번호를 입력하세요.");
		CUS2_pwtip.setFont(kFont15);
		
		CUS2_pwchecktip = new JLabel();
		CUS2_pwchecktip.setText("비밀번호를 입력하세요.");
		CUS2_pwchecktip.setFont(kFont15);
		
		CUS2_nametip = new JLabel();
		CUS2_nametip.setText("이름을 입력하세요.");
		CUS2_nametip.setFont(kFont15);
		
		CUS2_addrtip = new JLabel();
		CUS2_addrtip.setText("주소를 입력하세요.");
		CUS2_addrtip.setFont(kFont15);
		
				
		CUS2_idtxt.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if(CUS2_idtxt.getText().length() > 0) {
					if(!(CUS2_idtxt.getText().matches("^[a-zA-Z0-9]*$"))) {
						CUS2_idtip.setText("영어 혹은 숫자만 입력가능합니다.");
					}else {
						CUS2_idtip.setText("사용 가능한 아이디입니다.");
					}
				}else {
					CUS2_idtip.setText("아이디를 입력하세요.");
				}	
			}			
		});
		
		CUS2_idexistcheck = new JButton(idexistcheck1);
		CUS2_idexistcheck.setRolloverIcon(idexistcheck2);
		CUS2_idexistcheck.setPressedIcon(idexistcheck3);
		CUS2_idexistcheck.setBorderPainted(false);
		CUS2_idexistcheck.setContentAreaFilled(false);
		CUS2_idexistcheck.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(CUS2_idtxt.getText().length() == 0) {
					new Popup_idCreateAble(0);
				}else {
					CUS2_exist = dao.member_idExistCheck(CUS2_idtxt.getText()); //1=중복체크유도, 2=중복아이디 있음, 3=중복아이디 없음
					
					new Popup_idCreateAble(CUS2_exist);
				}
				
			}
		});
		
		CUS2_pwtxt.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if(CUS2_pwtxt.getPassword().length > 0) {
					if(new String(CUS2_pwchecktxt.getPassword()).equals(new String(CUS2_pwtxt.getPassword()))) {
						CUS2_pwtip.setText("비밀번호가 일치합니다.");
						if(CUS2_pwtip.getText() == "비밀번호가 일치합니다.") {
							CUS2_pwchecktip.setText("비밀번호가 일치합니다.");
						}
					}else {
						CUS2_pwtip.setText("비밀번호가 일치하지 않습니다.");
					}
				}else {
					CUS2_pwtip.setText("비밀번호를 입력하세요.");
				}
			}
			
		});
		
		
		CUS2_pwchecktxt.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if(CUS2_pwchecktxt.getPassword().length > 0) {
					if(new String(CUS2_pwtxt.getPassword()).equals(new String(CUS2_pwchecktxt.getPassword()))) {
						CUS2_pwchecktip.setText("비밀번호가 일치합니다.");
						if(CUS2_pwchecktip.getText() == "비밀번호가 일치합니다.") {
							CUS2_pwtip.setText("비밀번호가 일치합니다.");
						}
					}else {
						CUS2_pwchecktip.setText("비밀번호가 일치하지 않습니다.");
					}
				}else {
					CUS2_pwchecktip.setText("비밀번호를 입력하세요.");
				}
			}
			
		});		
		
		CUS2_nametxt.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if(CUS2_nametxt.getText().length() > 0) {
					if(!(CUS2_nametxt.getText().matches("^[ㄱ-ㅎㅏ-ㅣ가-힣]*$"))) {
						CUS2_nametip.setText("한글만 입력 가능합니다.");
					}else {
						CUS2_nametip.setText("사용 가능한 이름입니다.");
					}
				}else {
					CUS2_nametip.setText("이름을 입력하세요.");
				}
			}			
		});
		
		
		CUS2_addrtxt.addKeyListener(new KeyAdapter() {

		});
		
		CUS2_nextbtn = new JButton(Next1);
		CUS2_nextbtn.setPressedIcon(Next2);
		CUS2_nextbtn.setContentAreaFilled(false);
		CUS2_nextbtn.setBorderPainted(false);
		CUS2_nextbtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(CUS2_exist == 1 || CUS2_exist == 2) {
					new Popup_idCreateAble(CUS2_exist);
				}else {
					if(!(CUS2_idtip.getText().matches("사용 가능한 아이디입니다."))) {
						new Popup_CreateCheck();
					}else if(!(CUS2_pwtip.getText().matches("비밀번호가 일치합니다."))) {
						new Popup_CreateCheck();
					}else if(!(CUS2_nametip.getText().matches("사용 가능한 이름입니다."))) {
						new Popup_CreateCheck();
					}else {
						getContentPane().removeAll();
						repaint();
						add(Customer3Panel);
						Customer3Panel.setBounds(0,0,480,800);
						Customer3Panel.setVisible(true);
					}
				}
				
			}
			
		});
		//여기까지 set
		
		
		//여기부터 init
		Customer2Panel.setBackground(c1);
		
		Customer2Panel.add(CUS2_backspace);
		
		Customer2Panel.add(CUS2_idtag);
		Customer2Panel.add(CUS2_pwtag);
		Customer2Panel.add(CUS2_pwchecktag);
		Customer2Panel.add(CUS2_nametag);
		Customer2Panel.add(CUS2_addrtag);
		
		Customer2Panel.add(CUS2_idtxt);
		Customer2Panel.add(CUS2_pwtxt);
		Customer2Panel.add(CUS2_pwchecktxt);
		Customer2Panel.add(CUS2_nametxt);
		Customer2Panel.add(CUS2_addrtxt);
		
		Customer2Panel.add(CUS2_idtip);
		Customer2Panel.add(CUS2_pwtip);
		Customer2Panel.add(CUS2_pwchecktip);
		Customer2Panel.add(CUS2_nametip);
		Customer2Panel.add(CUS2_addrtip);
		
		Customer2Panel.add(CUS2_nextbtn);
		
		Customer2Panel.add(CUS2_idexistcheck);
		//여기까지 init
		
		
		//여기부터 layout
		Customer2Panel.setLayout(null);
		
		CUS2_backspace.setBounds(10,10,84,37);
		
		CUS2_idtag.setBounds(50,60,75,35);
		CUS2_pwtag.setBounds(50,150,75,35);
		CUS2_pwchecktag.setBounds(50,240,75,35);
		CUS2_nametag.setBounds(50,330,75,35);
		CUS2_addrtag.setBounds(50,420,75,35);
		
		CUS2_idtxt.setBounds(140,60,200,35);
		CUS2_pwtxt.setBounds(140,150,200,35);
		CUS2_pwchecktxt.setBounds(140,240,200,35);
		CUS2_nametxt.setBounds(140,330,200,35);
		CUS2_addrtxt.setBounds(140,420,200,35);
		
		CUS2_idtip.setBounds(140,90,300,35);
		CUS2_pwtip.setBounds(140,180,300,35);
		CUS2_pwchecktip.setBounds(140,270,300,35);
		CUS2_nametip.setBounds(140,360,300,35);
		CUS2_addrtip.setBounds(140,450,300,35);
		
		CUS2_nextbtn.setBounds(199,590,81,38);
		
		CUS2_idexistcheck.setBounds(360,60,76,68);
		//팝업 - 회원가입 완료
		
		//소비자3
		
		//--여기부터 set--//
		
		CUS3_backspace = new JButton(backspaceimg1);
		CUS3_backspace.setRolloverIcon(backspaceimg2);
		CUS3_backspace.setPressedIcon(backspaceimg3);
		CUS3_backspace.setContentAreaFilled(false);
		CUS3_backspace.setBorderPainted(false);
		CUS3_backspace.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().removeAll();
				repaint();
				add(Customer2Panel);
				Customer2Panel.setBounds(0,0,480,800);
				Customer2Panel.setVisible(true);
			}			
		});
		
		CUS3_phonetag = new JLabel("전화번호");
		CUS3_phonetag.setFont(kFont15);
		
		CUS3_emailtag = new JLabel("이메일");
		CUS3_emailtag.setFont(kFont15);
		
		CUS3_gendertag = new JLabel("성별");
		CUS3_gendertag.setFont(kFont15);
		
		CUS3_birthtag = new JLabel("생년월일");
		CUS3_birthtag.setFont(kFont15);
		
						
		CUS3_phonetxt = new JTextField();
		CUS3_phonetxt.setFont(kFont15);
		CUS3_phonetxt.setBorder(null);
		
		CUS3_emailtxt = new JTextField();
		CUS3_emailtxt.setFont(kFont15);
		CUS3_emailtxt.setBorder(null);
						
		CUS3_male = new JRadioButton("남자");
		CUS3_male.setFont(kFont15);
		
		CUS3_female = new JRadioButton("여자");
		CUS3_female.setFont(kFont15);
						
		CUS3_phonetip = new JLabel();
		CUS3_phonetip.setText("전화번호를 입력하세요.");
		CUS3_phonetip.setFont(kFont15);
		
		CUS3_emailtip = new JLabel();
		CUS3_emailtip.setText("이메일을 입력하세요.");
		CUS3_emailtip.setFont(kFont15);
				
		CUS3_gendertip = new JLabel();
		CUS3_gendertip.setText("성별을 선택하세요.");
		CUS3_gendertip.setFont(kFont15);
		
		CUS3_birthtip = new JLabel();
		CUS3_birthtip.setText("생년월일을 선택하세요.");
		CUS3_birthtip.setFont(kFont15);
			
		CUS3_phonetxt.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if(CUS3_phonetxt.getText().length() > 0) {
					if(e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
						if(CUS3_phonetxt.getText().length() == 3) {
							CUS3_phonetxt.setText(CUS3_phonetxt.getText()+"-");
						}else if(CUS3_phonetxt.getText().length() == 8) {
							CUS3_phonetxt.setText(CUS3_phonetxt.getText()+"-");
						}
					}
					if(!(CUS3_phonetxt.getText().matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$"))){
						CUS3_phonetip.setText("잘못된 번호입니다.");
					}else {
						CUS3_phonetip.setText("올바른 번호입니다.");
					}
				}else {
					CUS3_phonetip.setText("전화번호를 입력하세요.");
				}
			}
			
		});
				
		CUS3_emailtxt.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if(CUS3_emailtxt.getText().length() > 0) {
					if(!(CUS3_emailtxt.getText().matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"))) {
						CUS3_emailtip.setText("잘못된 이메일 양식입니다.");
					}else {
						CUS3_emailtip.setText("올바른 이메일 양식입니다.");
					}
				}else {
					CUS3_emailtip.setText("이메일을 입력하세요.");
				}
			}
			
		});
		
		CUS3_male.setBackground(c1);	
		CUS3_male.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				CUS3_female.setSelected(false);
			}			
		});		
		
		CUS3_female.setBackground(c1);
		CUS3_female.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				CUS3_male.setSelected(false);
			}			
		});
		
		CUS3_year = new JComboBox<>();
		for(int i=1900 ; i<2020 ; ++i) {
			CUS3_year.addItem(i);
		}
		
		CUS3_month = new JComboBox<>();
		for(int i=1 ; i<13 ; ++i) {
			CUS3_month.addItem(i);
		}
		
		CUS3_date = new JComboBox<>();
		for(int i=1 ; i<32 ; ++i) {
			CUS3_date.addItem(i);
		}
			
		CUS3_SignUpbtn = new JButton(reg1);
		CUS3_SignUpbtn.setRolloverIcon(reg2);
		CUS3_SignUpbtn.setPressedIcon(reg3);
		CUS3_SignUpbtn.setContentAreaFilled(false);
		CUS3_SignUpbtn.setBorderPainted(false);
		CUS3_SignUpbtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(CUS2_exist == 1 || CUS2_exist == 2) {
					new Popup_idCreateAble(CUS2_exist);
				}else {
					if(!(CUS3_phonetip.getText().matches("올바른 번호입니다."))) {
						new Popup_CreateCheck();
					}else if(!(CUS3_emailtip.getText().matches("올바른 이메일 양식입니다."))) {
						new Popup_CreateCheck();
					}else if(!(CUS3_male.isSelected()) && !(CUS3_female.isSelected())){
						new Popup_CreateCheck();
					}else {
						CustomerAdd();
					}
					
				}
				//데이터베이스에 입력한거 넣기 작업하기
			}
			
		});
		//--여기까지 set--//
		
		
		//--여기부터 init--//
		Customer3Panel.setBackground(c1);
		
		Customer3Panel.add(CUS3_backspace);
		
		Customer3Panel.add(CUS3_phonetag);
		Customer3Panel.add(CUS3_emailtag);
		Customer3Panel.add(CUS3_gendertag);
		Customer3Panel.add(CUS3_birthtag);
		
		Customer3Panel.add(CUS3_phonetxt);
		Customer3Panel.add(CUS3_emailtxt);
		Customer3Panel.add(CUS3_male);
		Customer3Panel.add(CUS3_female);
		Customer3Panel.add(CUS3_year);
		Customer3Panel.add(CUS3_month);
		Customer3Panel.add(CUS3_date);
		
		Customer3Panel.add(CUS3_phonetip);
		Customer3Panel.add(CUS3_emailtip);
		Customer3Panel.add(CUS3_gendertip);
		Customer3Panel.add(CUS3_birthtip);
		
		Customer3Panel.add(CUS3_SignUpbtn);
		//--여기까지 init--//
		
		
		
		//--여기부터 layouts--//
		Customer3Panel.setLayout(null);
		CUS3_backspace.setBounds(10,10,84,37);
		
		CUS3_phonetag.setBounds(50,60,75,35);
		CUS3_emailtag.setBounds(50,150,75,35);
		CUS3_gendertag.setBounds(50,240,75,35);
		CUS3_birthtag.setBounds(50,330,75,35);
		
		CUS3_phonetxt.setBounds(140,60,200,35);
		CUS3_emailtxt.setBounds(140,150,200,35);
		CUS3_male.setBounds(140,240,100,35);
		CUS3_female.setBounds(240,240,100,35);
		CUS3_year.setBounds(140,330,80,35);
		CUS3_month.setBounds(230,330,80,35);
		CUS3_date.setBounds(320,330,80,35);
		
		
		CUS3_phonetip.setBounds(140,90,300,35);
		CUS3_emailtip.setBounds(140,180,300,35);
		CUS3_gendertip.setBounds(140,270,300,35);
		CUS3_birthtip.setBounds(140,360,300,35);
		
		CUS3_SignUpbtn.setBounds(163,560,153,68);
		//--여기까지 layouts--//
		
		//소비자3 끝		
	}
	
	public void CustomerAdd() {
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();
		
		dto.setM_id(CUS2_idtxt.getText());
		dto.setM_pw(new String(CUS2_pwtxt.getPassword()));
		dto.setM_name(CUS2_nametxt.getText());
		dto.setM_addr(CUS2_addrtxt.getText());
		dto.setM_phone(CUS3_phonetxt.getText());
		dto.setM_email(CUS3_emailtxt.getText());
		if(CUS3_male.isSelected()) {
			dto.setM_gender("남자");
		}else if(CUS3_female.isSelected()) {
			dto.setM_gender("여자");
		}
		dto.setM_birth(CUS3_year.getSelectedItem().toString()+"년 "
		+CUS3_month.getSelectedItem().toString()+"월 "+CUS3_date.getSelectedItem().toString()+"일");
		
		int re = dao.Member_InsertCustomer(dto);
		if(re == 1) {
			getContentPane().removeAll();
			repaint();
			
			Success();
			System.out.println("성공_소비자");
		}
	}
	
	public void CeoAdd() {
				
		dto.setM_id(CEO2_idtxt.getText());
		dto.setM_pw(new String(CEO2_pwtxt.getPassword()));
		dto.setM_name(CEO2_nametxt.getText());
		dto.setM_addr(CEO2_addrtxt.getText());
		dto.setM_phone(CEO2_phonetxt.getText());
		dto.setM_crn(CEO3_crntxt.getText());
		dto.setM_bn(CEO3_bntxt.getText());
		dto.setM_food(CEO3_food.getSelectedItem().toString());
		dto.setM_menu_1(CEO3_menu1txt.getText());
		dto.setM_menu_2(CEO3_menu2txt.getText());
		dto.setM_menu_3(CEO3_menu3txt.getText());
		dto.setM_cost_1(CEO3_cost1txt.getText());
		dto.setM_cost_2(CEO3_cost2txt.getText());
		dto.setM_cost_3(CEO3_cost3txt.getText());
		dto.setM_tip(CEO3_tiptxt.getText());
		
		int re = dao.Member_InsertCeo(dto);
		if(re == 1) {
			getContentPane().removeAll();
			repaint();
			
			Success();
			System.out.println("성공_사업자");
		}
	}
	
	public void Success() {
		JLabel CS_announce;
		JButton CS_ok;
		
		add(CreateSuccess);
		CreateSuccess.setBounds(0,0,480,800);
		CreateSuccess.setVisible(true);
		CreateSuccess.setBackground(c1);
		
		CS_announce = new JLabel("축하합니다! 회원가입이 완료되었습니다.");
		CS_announce.setFont(kFont24);
		CS_ok = new JButton(BigOK1);
		CS_ok.setRolloverIcon(BigOK2);
		CS_ok.setPressedIcon(BigOK3);
		CS_ok.setBorderPainted(false);
		CS_ok.setContentAreaFilled(false);
		CS_ok.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				CUS2_idtxt.setText(null);
				CUS2_nametxt.setText(null);
				CUS2_addrtxt.setText(null);
				CUS3_phonetxt.setText(null);
				CUS3_emailtxt.setText(null);
				
				CUS2_pwtxt.setText(null);
				CUS2_pwchecktxt.setText(null);
				
				CUS3_male.setSelected(false);
				CUS3_female.setSelected(false);
				
				CUS2_idtip.setText("아이디를 입력하세요.");
				CUS2_pwtip.setText("비밀번호를 입력하세요.");
				CUS2_pwchecktip.setText("비밀번호를 입력하세요.");
				CUS2_nametip.setText("이름을 입력하세요.");
				CUS3_phonetip.setText("전화번호를 입력하세요.");
				CUS3_emailtip.setText("이메일을 입력하세요.");
				CUS2_addrtip.setText("주소를 입력하세요.");
				CUS3_gendertip.setText("성별을 선택하세요.");
				CUS3_birthtip.setText("생년월일을 선택하세요.");

				CUS2_exist = 1;
				
				CEO2_idtxt.setText(null);
				CEO2_nametxt.setText(null);
				CEO2_addrtxt.setText(null);
				CEO2_phonetxt.setText(null);
				CEO2_pwtxt.setText(null);
				CEO2_pwchecktxt.setText(null);
				
				CEO3_crntxt.setText(null);
				CEO3_bntxt.setText(null);
				CEO3_menu1txt.setText(null);
				CEO3_menu2txt.setText(null);
				CEO3_menu3txt.setText(null);
				CEO3_cost1txt.setText(null);
				CEO3_cost2txt.setText(null);
				CEO3_cost3txt.setText(null);
				CEO3_tiptxt.setText(null);
				
				CEO2_idtip.setText("아이디를 입력하세요.");
				CEO2_pwtip.setText("비밀번호를 입력하세요.");
				CEO2_pwchecktip.setText("비밀번호를 입력하세요.");
				CEO2_nametip.setText("이름을 입력하세요.");
				CEO2_addrtip.setText("주소를 입력하세요.");
				CEO2_phonetip.setText("전화번호를 입력하세요.");
				CEO3_crntip.setText("사업자등록번호를 입력하세요.");
				CEO3_bntip.setText("상호명을 입력하세요.");
				CEO3_foodtip.setText("요리분야를 선택하세요.");
				CEO3_menutip.setText("세부메뉴를 입력하세요.");
				CEO3_costtip.setText("메뉴 순서에 맞춰서 가격을 입력하세요.");
				CEO3_tiptip.setText("배달팁을 책정하세요.");
				
				CEO2_exist = 1;
				
				getContentPane().removeAll();
				repaint();
				add(LoginPanel);
				LoginPanel.setBounds(0,0,480,800);
				LoginPanel.setVisible(true);
			}			
		});
		
		CreateSuccess.add(CS_announce);
		CreateSuccess.add(CS_ok);
		
		setLayout(null);
		CS_announce.setBounds(50,140,400,50);
		CS_ok.setBounds(164,480,152,67);
	}
	
	public static void main(String[] args) {
		new Start();
	}
}
