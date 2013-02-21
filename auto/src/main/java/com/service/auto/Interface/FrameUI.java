package com.service.auto.Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class FrameUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu addForm;
	
	
	
	public FrameUI(){
		
		final JDesktopPane jdesktopPane = new JDesktopPane();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("User Form");
		setSize(1000, 700);
		setLocation(150, 20);
		setName("Service-Auto");
		add(jdesktopPane);
		menuBar = new JMenuBar();
		addForm = new JMenu("Add");
		
		menuBar.add(addForm);
		
		JMenuItem add1 = new JMenuItem("AddForm");
	
		addForm.add(add1);
		
		setJMenuBar(menuBar);

		add1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Runnable r = new Runnable() {

					public void run() {
						// cream fereastra interioara
						jdesktopPane.add(IFrameAdd.getAddForm());
					}
				};
				(new Thread(r)).start();
			}

		});
		
		setVisible(true);
	}
}
