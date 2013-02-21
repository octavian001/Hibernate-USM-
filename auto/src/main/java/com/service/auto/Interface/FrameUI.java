package com.service.auto.Interface;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class FrameUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	
	
	
	public FrameUI(){
		
		final JDesktopPane jdesktopPane = new JDesktopPane();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("User Form");
		setSize(1000, 700);
		setLocation(150, 20);
		setName("Service-Auto");
		add(jdesktopPane);
		menuBar = new JMenuBar();
		
		setVisible(true);
	}
}
