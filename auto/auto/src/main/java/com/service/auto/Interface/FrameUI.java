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
	JProgressDialog jpd = null;
	private JFrame me = this;


	public FrameUI(Boolean state) {
		if (LoginFrame.state == false) {
			dispose();
		} else {
			final JDesktopPane jdesktopPane = new JDesktopPane();

			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setTitle("User Form");
			setSize(1100, 700);
			setLocation(150, 20);
			setName("Service-Auto");
			add(jdesktopPane);
			menuBar = new JMenuBar();
			addForm = new JMenu("Add");

			menuBar.add(addForm);

			JMenuItem add1 = new JMenuItem("AddForm");

			addForm.add(add1);

			JMenuItem add2 = new JMenuItem("Table");
			addForm.add(add2);

			setJMenuBar(menuBar);
			
			jpd = new JProgressDialog(me, "Please Wait",
					"Stabilirea conexiunii cu BD.");


			add2.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					Runnable r = new Runnable() {

						public void run() {
							jdesktopPane.add(IFrameTable.getTableForm());
							jpd.setVisible(false);
							setEnabled(true);
							me.setEnabled(true);
						}
					};
					jpd.setVisible(true);
					setEnabled(true);
					me.setEnabled(true);
					(new Thread(r)).start();
				}
			});

			add1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Runnable r = new Runnable() {

						public void run() {
							// cream fereastra interioara
							jdesktopPane.add(IFrameAdd.getAddForm());
							jpd.setVisible(false);
							setEnabled(true);
							me.setEnabled(true);
						}
					};
					jpd.setVisible(true);
					setEnabled(true);
					me.setEnabled(true);
					(new Thread(r)).start();
				}

			});

			setVisible(true);
		}
	}
}
