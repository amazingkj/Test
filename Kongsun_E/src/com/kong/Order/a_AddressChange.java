package com.kong.Order;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class a_AddressChange extends JDialog {
	private static final long serialVersionUID = 1L;
	
	private String address = "";
	
	public a_AddressChange(JFrame frame) {
		super(frame, true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(243,243,237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC8FC\uC18C \uC124\uC815");
		lblNewLabel.setFont(new Font("배달의민족 주아", Font.BOLD, 30));
		lblNewLabel.setBounds(14, 12, 199, 46);
		contentPane.add(lblNewLabel);
		
		JTextField textField = new JTextField("address");
		textField.setBackground(UIManager.getColor("Button.background"));
		textField.setBounds(14, 76, 404, 89);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setFont(new Font("배달의민족 주아", Font.BOLD, 20));
		textField.setBorder(null);
		textField.setBackground(new Color(243,243,237));

		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("./images/ys_save1.png"));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setPressedIcon(new ImageIcon("./images/ys_save2.png"));
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog((Component) e.getSource(), "주소를 입력해주세요.", "주소입력", JOptionPane.WARNING_MESSAGE);
					return;
				}
				address = textField.getText();
				dispose();
			}
		});
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setBounds(120, 177, 191, 64);
		contentPane.add(btnNewButton);
		setVisible(true);
	}

	public String getAddress() {
		return address;
	}
}