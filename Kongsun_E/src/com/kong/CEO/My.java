package com.kong.CEO;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.kong.JDBC.MemberDAO;
import com.kong.JDBC.MemberDTO;
import com.kong.Main.Popup_CreateCheck;
import com.kong.Main.Popup_idCreateAble;
import com.kong.Main.Start;
class   My1 extends JFrame{

	
	Font kFont15 = new Font("배달의민족 주아",Font.PLAIN,15);
	Font kFont24 = new Font("배달의민족 주아",Font.PLAIN,24);
	
	Color c1 = new Color(243,243,237);//오트밀
	Color c2 = new Color(107,119,114);//회색

	JTextField tf = new JTextField ();
	JTextField tf1 = new JTextField ();
	
	JLabel announce;
	JButton ok,no;

	JButton Button1 =new JButton();
	JButton Button2 =new JButton();
	JButton Button3 =new JButton();
	JButton Button4 =new JButton();
	JButton Button5 =new JButton();
	JButton Button6 =new JButton();
	JButton Button7 =new JButton();
	JButton Button8 =new JButton();
	
	JPanel   jpanel = new JPanel();
	JPanel Delete = new JPanel();
	JPanel Submit = new JPanel();
	JPanel customerfix1 = new JPanel();
	JPanel customerfix2 = new JPanel();
	JPanel Ceofix1 = new JPanel();
	JPanel Ceofix2 = new JPanel();
	JPanel FixSuccess = new JPanel();
	
	JLabel lblJoin =new  JLabel(); 
	JTextField   My_nametxt=new JTextField();
	
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
	
	ImageIcon okbtn1 = new ImageIcon("./images/kmw_대지 108.png");
	ImageIcon okbtn2 = new ImageIcon("./images/kmw_대지 109.png");
	ImageIcon okbtn3 = new ImageIcon("./images/kmw_대지 110.png");
	
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
	ImageIcon Cancel1 = new ImageIcon("./images/kmw_Cancel1.png");
	ImageIcon Cancel2 = new ImageIcon("./images/kmw_Cancel2.png");
	ImageIcon Cancel3 = new ImageIcon("./images/kmw_Cancel3.png");
	
	MemberDAO dao = new MemberDAO();
	MemberDTO dto = new MemberDTO();
	
	public   My1() {


		setSize(480, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		//setUndecorated(true);
		
		
		jpanel.setBounds(0,0, 480, 674);
		jpanel.setBackground(c1);
		jpanel.setLayout(null);
		add(jpanel);
		
		

		lblJoin =new  JLabel("님!반갑습니다."); 
		Font f1 = new Font("배달의민족 주아", Font.BOLD, 39);
		lblJoin.setForeground(c2);
		lblJoin.setFont(f1); 
		lblJoin.setBounds(224, 219, 350, 40);
		jpanel.add(lblJoin);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		 My_nametxt = new JTextField();
		 My_nametxt.setFont(f1); 
		 My_nametxt.setForeground(c2);
		 My_nametxt.setBackground(c1);
		 My_nametxt.setBounds(43,221, 180, 39);
		 My_nametxt.setEnabled(false);
		 My_nametxt.setText(dao.Ceo_Takename());
		 jpanel.add(My_nametxt);
		

		//회원선택버튼
		Button1 = new JButton();//로그아웃
		Button1.setBounds(42,290, 228, 49);
		ImageIcon icon5=new ImageIcon("./images/jh_대지 148.png");//이미지 아이콘객체 생성
		Button1.setIcon(icon5);
		Button1.setRolloverIcon(new ImageIcon("./images/jh_대지 151.png"));
		Button1.setPressedIcon(new ImageIcon("./images/jh_대지 142.png"));
		jpanel.add(Button1);
		Button1.setBorderPainted(false);;
		Button1.setContentAreaFilled(false);
		Button1.setFocusPainted(false);
		Button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dao.ceo_logout();
				new Start();
				dispose();
				
			}
			
		});
		
		/*Button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {    	  
				new K_Pud();
				jpanel.setVisible(false);
				
			}
		});

        */

		Button2 = new JButton();//회원정보 수정
		Button2.setBounds(42, 345, 228,49);
	
		ImageIcon icon6=new ImageIcon("./images/jh_대지 149.png");//이미지 아이콘객체 생성
		Button2.setIcon(icon6);
		Button2.setRolloverIcon(new ImageIcon("./images/jh_대지 152.png"));
		Button2.setPressedIcon(new ImageIcon("./images/jh_대지 143.png"));
		jpanel.add(Button2);
		Button2.setBorderPainted(false);;
		Button2.setContentAreaFilled(false);
		Button2.setFocusPainted(false);
		Button2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().removeAll();
				repaint();
				if(dao.member_TakeLV() == 2) {  //사업자
					add(Ceofix1);
					Ceofix1.setBounds(0,0,480,800);
					Ceofix1.setVisible(true);
				}else if(dao.member_TakeLV() == 3){  //개인
					add(customerfix1);
					customerfix1.setBounds(0,0,480,800);
					customerfix1.setVisible(true);
				}
			}
			
		});
		
		//여기부터 Ceofix
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
				add(jpanel);
				jpanel.setBounds(0,0,480,800);
				jpanel.setVisible(true);
			}
			
		});
		
		CEO2_idtxt = new JTextField();
		CEO2_idtxt.setFont(kFont15);
		//CEO2_idtxt.setBorder(null);
		CEO2_idtxt.setEnabled(false);
		CEO2_idtxt.setBackground(c1);
		
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
						//id = false;
					}else {
						CEO2_idtip.setText("사용 가능한 아이디입니다.");
						//id = true;
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
					if(!(CEO2_nametxt.getText().matches("^[ㄱ-ㅎㅏ-ㅣ가-힣]*$"))) {
						CEO2_nametip.setText("한글만 입력 가능합니다.");
						//name = false;
					}else {
						CEO2_nametip.setText("사용 가능한 이름입니다.");
						//name = true;
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
					//address = true;
				}else {
					//address = false;
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
						//phone = false;
					}else {
						CEO2_phonetip.setText("올바른 번호입니다.");
						//phone = true;
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
						//pw = true;
					}else {
						CEO2_pwchecktip.setText("비밀번호가 일치하지 않습니다.");
						//pw = false;
					}
				}else {
					CEO2_pwchecktip.setText("비밀번호를 입력하세요.");
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
				if(!(CEO2_pwtip.getText().matches("비밀번호가 일치합니다."))) {
					new Popup_CreateCheck();
				}else if(!(CEO2_nametip.getText().matches("사용 가능한 이름입니다."))) {
					new Popup_CreateCheck();
				}else if(!(CEO2_phonetip.getText().matches("올바른 번호입니다."))) {
					new Popup_CreateCheck();
				}else {
					getContentPane().removeAll();
					repaint();
					add(Ceofix2);
					Ceofix2.setBounds(0,0,480,800);
					Ceofix2.setVisible(true);
					Ceofix2.setBackground(c1);
				}
			}
			
		});		
		//--여기까지 set--//
		
		
		//--여기부터 init--//
		Ceofix1.setBackground(c1);
		
		Ceofix1.add(CEO2_idtag);
		Ceofix1.add(CEO2_pwtag);
		Ceofix1.add(CEO2_pwchecktag);
		Ceofix1.add(CEO2_nametag);
		Ceofix1.add(CEO2_addrtag);
		Ceofix1.add(CEO2_phonetag);
		
		Ceofix1.add(CEO2_backspace);
		Ceofix1.add(CEO2_idtxt);
		Ceofix1.add(CEO2_pwtxt);
		Ceofix1.add(CEO2_pwchecktxt);
		Ceofix1.add(CEO2_nametxt);
		Ceofix1.add(CEO2_addrtxt);
		Ceofix1.add(CEO2_phonetxt);
		
		
		Ceofix1.add(CEO2_idtip);
		Ceofix1.add(CEO2_pwtip);
		Ceofix1.add(CEO2_pwchecktip);
		Ceofix1.add(CEO2_nametip);
		Ceofix1.add(CEO2_addrtip);
		Ceofix1.add(CEO2_phonetip);
		
		Ceofix1.add(CEO2_nextbtn);
		
		//--여기까지 init--//
		
		
		//--여기부터 layouts--//
		Ceofix1.setLayout(null);
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
	
		//--Ceofix2
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
				add(Ceofix1);
				Ceofix1.setBounds(0,0,480,800);
				Ceofix1.setVisible(true);
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
						//crn = false;
					}else {
						CEO3_crntip.setText("올바른 번호입니다.");
						//crn = true;
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
						//bn = false;
					}else {
						CEO3_bntip.setText("사용 가능한 상호명입니다.");
						//bn = true;
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
		Ceofix2.add(CEO3_backspace);
		
		Ceofix2.add(CEO3_crntag);
		Ceofix2.add(CEO3_bntag);
		Ceofix2.add(CEO3_foodtag);
		Ceofix2.add(CEO3_menutag);
		Ceofix2.add(CEO3_costtag);
		Ceofix2.add(CEO3_tiptag);
		
		Ceofix2.add(CEO3_crntxt);
		Ceofix2.add(CEO3_bntxt);
		Ceofix2.add(CEO3_food);
		Ceofix2.add(CEO3_menu1txt);
		Ceofix2.add(CEO3_menu2txt);
		Ceofix2.add(CEO3_menu3txt);
		Ceofix2.add(CEO3_cost1txt);
		Ceofix2.add(CEO3_cost2txt);
		Ceofix2.add(CEO3_cost3txt);
		Ceofix2.add(CEO3_tiptxt);
		
		Ceofix2.add(CEO3_crntip);
		Ceofix2.add(CEO3_bntip);
		Ceofix2.add(CEO3_foodtip);
		Ceofix2.add(CEO3_menutip);
		Ceofix2.add(CEO3_costtip);
		Ceofix2.add(CEO3_tiptip);
		
		Ceofix2.add(CEO3_SignUpbtn);
		//여기까지 add
		
		
		//여기부터 init
		Ceofix2.setLayout(null);
		
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
		
		//여기까지 Ceofix
		
		
		
		//여기부터 customerfix
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
				add(jpanel);
				jpanel.setBounds(0,0,480,800);
				jpanel.setVisible(true);
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
		//CUS2_idtxt.setBorder(null);
		CUS2_idtxt.setEnabled(false);
		CUS2_idtxt.setBackground(c1);
		
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
						//id = false;
					}else {
						CUS2_idtip.setText("사용 가능한 아이디입니다.");
						//id = true;
					}
				}else {
					CUS2_idtip.setText("아이디를 입력하세요.");
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
						//pw = true;
					}else {
						CUS2_pwchecktip.setText("비밀번호가 일치하지 않습니다.");
						//pw = false;
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
						//name = false;
					}else {
						CUS2_nametip.setText("사용 가능한 이름입니다.");
						//name = true;
					}
				}else {
					CUS2_nametip.setText("이름을 입력하세요.");
				}
			}			
		});
		
		
		CUS2_addrtxt.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if(CUS2_addrtxt.getText().length() > 0) {
					//address = true;
				}else {
					//address = false;
					
				}
			}
		});
		
		CUS2_nextbtn = new JButton(Next1);
		CUS2_nextbtn.setPressedIcon(Next2);
		CUS2_nextbtn.setContentAreaFilled(false);
		CUS2_nextbtn.setBorderPainted(false);
		CUS2_nextbtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(!(CUS2_pwtip.getText().matches("비밀번호가 일치합니다."))) {
					new Popup_CreateCheck();
				}else if(!(CUS2_nametip.getText().matches("사용 가능한 이름입니다."))) {
					new Popup_CreateCheck();
				}else {
					getContentPane().removeAll();
					repaint();
					add(customerfix2);
					customerfix2.setBounds(0,0,480,800);
					customerfix2.setVisible(true);
				}
			}
			
		});
		//여기까지 set
		
		
		//여기부터 init
		customerfix1.setBackground(c1);
		
		customerfix1.add(CUS2_backspace);
		
		customerfix1.add(CUS2_idtag);
		customerfix1.add(CUS2_pwtag);
		customerfix1.add(CUS2_pwchecktag);
		customerfix1.add(CUS2_nametag);
		customerfix1.add(CUS2_addrtag);
		
		customerfix1.add(CUS2_idtxt);
		customerfix1.add(CUS2_pwtxt);
		customerfix1.add(CUS2_pwchecktxt);
		customerfix1.add(CUS2_nametxt);
		customerfix1.add(CUS2_addrtxt);
		
		customerfix1.add(CUS2_idtip);
		customerfix1.add(CUS2_pwtip);
		customerfix1.add(CUS2_pwchecktip);
		customerfix1.add(CUS2_nametip);
		customerfix1.add(CUS2_addrtip);
		
		customerfix1.add(CUS2_nextbtn);
		//여기까지 init
		
		
		//여기부터 layout
		customerfix1.setLayout(null);
		
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
	
		//--customerfix2
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
				add(customerfix1);
				customerfix1.setBounds(0,0,480,800);
				customerfix1.setVisible(true);
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
						//phone = false;
					}else {
						CUS3_phonetip.setText("올바른 번호입니다.");
						//phone = true;
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
						//email = false;
					}else {
						CUS3_emailtip.setText("올바른 이메일 양식입니다.");
						//email = true;
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
				//gender = true;
			}			
		});		
		
		CUS3_female.setBackground(c1);
		CUS3_female.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				CUS3_male.setSelected(false);
				//gender = true;
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
				if(!(CUS3_phonetip.getText().matches("올바른 번호입니다."))) {
					new Popup_CreateCheck();
				}else if(!(CUS3_emailtip.getText().matches("올바른 이메일 양식입니다."))) {
					new Popup_CreateCheck();
				}else if(!(CUS3_male.isSelected()) && !(CUS3_female.isSelected())){
					new Popup_CreateCheck();
				}else {
					CustomerAdd();
				}
				//데이터베이스에 입력한거 넣기 작업하기
			}
			
		});
		//--여기까지 set--//
		
		
		//--여기부터 init--//
		customerfix2.setBackground(c1);
		
		customerfix2.add(CUS3_backspace);
		
		customerfix2.add(CUS3_phonetag);
		customerfix2.add(CUS3_emailtag);
		customerfix2.add(CUS3_gendertag);
		customerfix2.add(CUS3_birthtag);
		
		customerfix2.add(CUS3_phonetxt);
		customerfix2.add(CUS3_emailtxt);
		customerfix2.add(CUS3_male);
		customerfix2.add(CUS3_female);
		customerfix2.add(CUS3_year);
		customerfix2.add(CUS3_month);
		customerfix2.add(CUS3_date);
		
		customerfix2.add(CUS3_phonetip);
		customerfix2.add(CUS3_emailtip);
		customerfix2.add(CUS3_gendertip);
		customerfix2.add(CUS3_birthtip);
		
		customerfix2.add(CUS3_SignUpbtn);
		//--여기까지 init--//
		
		
		
		//--여기부터 layouts--//
		customerfix2.setLayout(null);
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
		
		
		//여기까지 customerfix

		
		Button3 = new JButton();//회원탈퇴
		Button3.setBounds(42, 400, 228,49);
		ImageIcon icon7=new ImageIcon("./images/jh_대지 150.png");//이미지 아이콘객체 생성
		Button3.setIcon(icon7);
		Button3.setRolloverIcon(new ImageIcon("./images/jh_대지 153.png"));
		Button3.setPressedIcon(new ImageIcon("./images/jh_대지 144.png"));
		jpanel.add(Button3);
		Button3.setBorderPainted(false);;
		Button3.setContentAreaFilled(false);
		Button3.setFocusPainted(false);
		Button3.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().removeAll();			
				repaint();
				add(Delete);
				Delete.setBounds(0,0,480,800);
				Delete.setVisible(true);
				
			}
			
		});
		

		Delete.setLayout(null);
		announce = new JLabel();
		announce.setText("정말 탈퇴하시겠습니까?");
		announce.setFont(kFont24);
		ok = new JButton(okbtn1);
		ok.setRolloverIcon(okbtn2);
		ok.setPressedIcon(okbtn3);
		ok.setBorderPainted(false);
		ok.setContentAreaFilled(false);
		ok.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				dao.member_Delete();
				getContentPane().removeAll();
				repaint();
				add(Submit);
				Submit.setBounds(0,0,480,800);
				Submit.setVisible(true);
				Submit.setLayout(null);
				Submit.add(ok);
				Submit.add(announce);
				announce.setText("탈퇴하였습니다.");
				ok.setBounds(199,420,81,38);
				ok.addMouseListener(new MouseAdapter() {
					
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();	
						new Start();
					}
					
				});					
				
			}
			
		});
		no = new JButton(Cancel1);
		no.setRolloverIcon(Cancel2);
		no.setPressedIcon(Cancel3);
		no.setBorderPainted(false);
		no.setContentAreaFilled(false);
		no.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().removeAll();			
				repaint();
				add(jpanel);
				jpanel.setBounds(0,0,480,800);
				jpanel.setVisible(true);	
			}
			
		});
				
		Delete.add(announce);
		Delete.add(ok);
		Delete.add(no);
		
		announce.setBounds(20,350,430,25);
		ok.setBounds(149,420,81,38);
		no.setBounds(249,420,81,38);
		

	

		//하단부 선택창
		Button5 = new JButton("");//이전버튼
		Button5.setBounds(-1, 672, 120, 105);
		ImageIcon icon1=new ImageIcon("./images/jin_pre1.png");//이미지 아이콘객체 생성
		Button5.setIcon(icon1);
		Button5.setRolloverIcon(new ImageIcon("./images/jin_pre2.png"));
		Button5.setPressedIcon(new ImageIcon("./images/jin_pre3.png"));
		jpanel.add(Button5);
		Button5.setBorderPainted(false);;
		Button5.setContentAreaFilled(false);
		Button5.setFocusPainted(false);

		Button6 = new JButton("");//홈버튼

		Button6.setBounds(119,672,120,105);
		ImageIcon icon2=new ImageIcon("./images/jin_home1.png");//이미지 아이콘객체 생성
		Button6.setIcon(icon2);
		Button6.setRolloverIcon(new ImageIcon("./images/jin_home2.png"));
		Button6.setPressedIcon(new ImageIcon("./images/jin_home3.png"));
		jpanel.add(Button6);
		Button6.setBorderPainted(false);
		Button6.setContentAreaFilled(false);
		Button6.setFocusPainted(false);
		
		Button6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {  
				new StoreUIBasic();  
				dispose();
				jpanel.setVisible(false);
			}
			});

		Button7 = new JButton("");//주문내역
		Button7.setBounds(239,672,120,105);
		ImageIcon icon3=new ImageIcon("./images/jin_OrderList1.png");//이미지 아이콘객체 생성
		Button7.setIcon(icon3);
		Button7.setRolloverIcon(new ImageIcon("./images/jin_OrderList2.png"));
		Button7.setPressedIcon(new ImageIcon("./images/jin_OrderList3.png"));
		jpanel.add(Button7);
		Button7.setBorderPainted(false);;
		Button7.setContentAreaFilled(false);
		Button7.setFocusPainted(false);
		Button7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {  
				new StoreUIOrderList();  
				dispose();
			}
		});

		Button8 = new JButton("");//마이페이지
		Button8.setBounds(359,672,120,105);
		ImageIcon icon4=new ImageIcon("./images/jin_Mypage1.png");//이미지 아이콘객체 생성
		Button8.setIcon(icon4);
		Button8.setRolloverIcon(new ImageIcon("./images/jin_Mypage2.png"));
		Button8.setPressedIcon(new ImageIcon("./images/jin_Mypage3.png"));
		jpanel.add(Button8);
		Button8.setBorderPainted(false);;
		Button8.setContentAreaFilled(false);
		Button8.setFocusPainted(false);
		
		
		Button8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {  
				new My1();  
				dispose();
				jpanel.setVisible(false);
			}
			});

		setVisible(true);
		
		
		
		
	
		
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
		
		int re = dao.member_Customerfix(dto);
		if(re == 1) {
			getContentPane().removeAll();
			repaint();
			
			Success();
			System.out.println("성공_소비자");
		}
	}
	
	public void CeoAdd() {
		
		//dto.setM_id(CEO2_idtxt.getText());
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
		
		int re = dao.member_Ceofix(dto);
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
		
		add(FixSuccess);
		FixSuccess.setBounds(0,0,480,800);
		FixSuccess.setVisible(true);
		FixSuccess.setBackground(c1);
		
		CS_announce = new JLabel("정보 수정이 완료되었습니다.");
		CS_announce.setFont(kFont24);
		CS_ok = new JButton(BigOK1);
		CS_ok.setRolloverIcon(BigOK2);
		CS_ok.setPressedIcon(BigOK3);
		CS_ok.setBorderPainted(false);
		CS_ok.setContentAreaFilled(false);
		CS_ok.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				dispose();
				new My1();
				
			}			
		});
		
		FixSuccess.add(CS_announce);
		FixSuccess.add(CS_ok);
		
		setLayout(null);
		CS_announce.setBounds(50,140,400,50);
		CS_ok.setBounds(164,480,152,67);
	}
	
}


public class My {
	public My() {
		new My1();
	}
	public static void main(String[] args) {

		
		new My1();
	}
}
