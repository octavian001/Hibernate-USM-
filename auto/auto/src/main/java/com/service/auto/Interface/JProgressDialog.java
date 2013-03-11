package com.service.auto.Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JRootPane;

	public class JProgressDialog extends JDialog {

		private JRootPane main_pane = null;

		public JProgressDialog(JFrame owner, String title, String message) {

			super(owner);
			this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			this.setBounds((int) owner.getBounds().getCenterX() - 225, (int) owner
					.getBounds().getCenterY() - 50, 450, 100);
			main_pane = new JRootPane();
			main_pane.setPreferredSize(new Dimension(450, 20));
			main_pane.setLayout(new BorderLayout());
			this.setTitle(message);
			JProgressBar progress = new JProgressBar();
			//progress.setSize(new Dimension(100,100));
			progress.setIndeterminate(true);
			main_pane.add(progress);
			this.add(main_pane);
			this.pack();
		}
	}


