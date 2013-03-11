package com.service.auto.Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.hibernate.Session;

import com.service.auto.Factory;
import com.service.auto.HibernateUtil;
import com.service.auto.OPERATIE;
import com.service.auto.USERS;

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
	public static Boolean state = false;

	public LoginFrame() {
				Factory.getInstance().getUserDAO().getAllUser();
	
		
		

		final JFrame frame = new JFrame("Fereastra de logare");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(560, 250);

		jrp = getRootPane();
		jrp.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
		jrp.setLayout(new BoxLayout(jrp, BoxLayout.Y_AXIS));

		tfUser = new JTextField();
		tfUser.setPreferredSize(new Dimension(150, 20));
		tfPassword = new JPasswordField();
		tfPassword.setPreferredSize(new Dimension(150, 20));

		lbUser = new JLabel("Nume utilizator");
		lbUser.setPreferredSize(new Dimension(100, 20));
		lbPassword = new JLabel("Parola utilizator");
		lbPassword.setPreferredSize(new Dimension(100, 20));

		btnLogin = new JButton("Autentificare");
		btnCancel = new JButton("   Anulare   ");

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
				Runnable r = new Runnable() {

					public void run() {

						String user = tfUser.getText().trim();
						String password = tfPassword.getText().trim();

						
						String strHash =  Factory.getInstance().getUserDAO().MD5(password);
						
						ArrayList<USERS> users = Factory.getInstance()
								.getUserDAO()
								.getUserByNameAndPass(user, strHash);
						System.out.println(users.size());
						
						
						
						Iterator iterator = users.iterator();
						while(iterator.hasNext()){
							USERS m = (USERS) iterator.next();
							if (user.equals(m.getUser()) && strHash.equals(m.getPassword()) && m.getRole().trim().equals("administrator")){
				
								state = true;
								SwingUtilities.invokeLater(new Runnable() {
									public void run() {
										
										new MainFrame(LoginFrame.state);
										dispose();
									}
								});
							}
							if (user.equals(m.getUser()) && strHash.equals(m.getPassword()) && m.getRole().trim().equals("user")){
									state = true;
								SwingUtilities.invokeLater(new Runnable() {
									public void run() {
										dispose();
										new FrameUI(LoginFrame.state);
									}
								});
							}/*else 
								JOptionPane.showMessageDialog(null,
										"Nu exista asa utilizator!", " Warning",
										JOptionPane.WARNING_MESSAGE);*/
						}
						
						
					}
				};

				(new Thread(r)).start();
			}
		});

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		

	}

}
