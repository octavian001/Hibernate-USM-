package com.service.auto.Interface;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import com.service.auto.MECANIC;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	ArrayList<MECANIC> mecanic = new ArrayList<MECANIC>();
	private JMenuBar menuBar;
	private Font font;
	private Font fontOptionMenu;
	private JMenu tableMenu;
	private JMenuItem mecanicTable;
	private JMenuItem autoTable;
	private JMenuItem proprietarTable;
	private JMenuItem bonTable;
	private JMenuItem marcaTable;
	private JMenuItem modelTable;
	private JMenuItem operatieTable;
	private JMenuItem pieseTable;
	private JMenuItem userTable;

	JProgressDialog jpd = null;
	private JFrame me = this;

	public MainFrame(Boolean state) {
		if(state == false){
			dispose();
			
		}
		else{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Pagina de administrare");
		setSize(1000, 700);
		setLocation(150, 20);
		setName("Service-Auto");

		// cream fereastra JDesktopPane
		final JDesktopPane desktopPane = new JDesktopPane();

		// adaugam desktopPane
		add(desktopPane);

		// adaugam un meniu
		menuBar = new JMenuBar();

		// dam font meniului
		font = new Font("Times New Roman", Font.BOLD, 16);
		fontOptionMenu = new Font("Times New Roman", Font.ITALIC, 12);

		// adaugam o categorie meniului
		tableMenu = new JMenu("Tabele");
		tableMenu.setFont(font);
		
		// adaugam o optiune meniului
		mecanicTable = new JMenuItem("MECANIC");
		mecanicTable.setFont(fontOptionMenu);
		tableMenu.add(mecanicTable);

		autoTable = new JMenuItem("AUTO");
		autoTable.setFont(fontOptionMenu);
		tableMenu.add(autoTable);

		bonTable = new JMenuItem("BON");
		bonTable.setFont(fontOptionMenu);
		tableMenu.add(bonTable);

		marcaTable = new JMenuItem("MARCA");
		marcaTable.setFont(fontOptionMenu);
		tableMenu.add(marcaTable);

		modelTable = new JMenuItem("MODEL");
		modelTable.setFont(fontOptionMenu);
		tableMenu.add(modelTable);

		operatieTable = new JMenuItem("OPERATIE");
		operatieTable.setFont(fontOptionMenu);
		tableMenu.add(operatieTable);

		pieseTable = new JMenuItem("PIESE");
		pieseTable.setFont(fontOptionMenu);
		tableMenu.add(pieseTable);

		proprietarTable = new JMenuItem("PROPRIETAR");
		proprietarTable.setFont(fontOptionMenu);
		tableMenu.add(proprietarTable);

		userTable = new JMenuItem("User detalii");
		userTable.setFont(fontOptionMenu);
		tableMenu.add(userTable);

		
		menuBar.add(tableMenu);
		setJMenuBar(menuBar);
		
		jpd = new JProgressDialog(me, "Please Wait",
				"Stabilirea conexiunii cu BD.");

		userTable.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Runnable r = new Runnable() {
					public void run() {
						
						desktopPane.add(IFrameUser.getUserFrame());
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
		
		
		mecanicTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Runnable r = new Runnable() {
					public void run() {
						// cream fereastra interioara
						desktopPane.add(IFrameMecanic.getMecanicFrame());
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

		proprietarTable.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				Runnable r = new Runnable() {
					public void run() {
						// cream fereastra interioara
						desktopPane.add(IFrameProprietar.getProprietarFrame());
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

		pieseTable.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				Runnable r = new Runnable() {
					public void run() {
						desktopPane.add(IFramePiese.getPieseFrame());
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

		marcaTable.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				Runnable r = new Runnable() {

					public void run() {
						desktopPane.add(IFrameMarca.getMarcaFrame());
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

		operatieTable.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				Runnable r = new Runnable() {
					public void run() {
						desktopPane.add(IFrameOperatie.getOperatieFrame());
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

		autoTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Runnable r = new Runnable() {
					public void run() {
						desktopPane.add(IFrameAuto.getAutoFrame());
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

		modelTable.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				jpd = new JProgressDialog(me, "Please Wait",
						"Stabilirea conexiunii cu BD.");
				Runnable r = new Runnable() {
					public void run() {
						desktopPane.add(IFrameModel.getModelFrame());
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
		
		bonTable.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				jpd = new JProgressDialog(me, "Please Wait",
						"Stabilirea conexiunii cu BD.");
				Runnable r = new Runnable() {
					public void run() {
						desktopPane.add(IFrameBon.getBonFrame());
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
