package com.service.auto.Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton btnLogin;
	private JButton btnCancel;
	private JLabel lbUser;
	private JLabel lbPassword;
	private JTextField tfUser;
	private JPasswordField tfPassword;
	private JPanel panel;
	private JRootPane jrp;

	public LoginFrame() {

		final JFrame frame = new JFrame("Login Window");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(560, 250);

		jrp = getRootPane();
		jrp.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
		jrp.setLayout(new BoxLayout(jrp, BoxLayout.Y_AXIS));

		tfUser = new JTextField();
		tfUser.setPreferredSize(new Dimension(150, 20));
		tfPassword = new JPasswordField();
		tfPassword.setPreferredSize(new Dimension(150, 20));

		lbUser = new JLabel("Username");
		lbUser.setPreferredSize(new Dimension(100, 20));
		lbPassword = new JLabel("Password");
		lbPassword.setPreferredSize(new Dimension(100, 20));

		btnLogin = new JButton("Login");
		btnCancel = new JButton("Cancel");

		panel = new JPanel(new FlowLayout());
		panel.add(lbUser);
		panel.add(tfUser);
		jrp.add(panel);

		panel = new JPanel(new FlowLayout());
		panel.add(lbPassword);
		panel.add(tfPassword);
		jrp.add(panel);

		panel = new JPanel();
		panel.add(btnLogin);
		panel.add(btnCancel);

		jrp.add(panel);
		setResizable(false);
		pack();
		setVisible(true);

		btnLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
	}
}
