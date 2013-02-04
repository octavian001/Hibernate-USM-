package com.service.auto.Interface;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import org.omg.PortableInterceptor.INACTIVE;

import com.service.auto.Factory;
import com.service.auto.MECANIC;

public class MainFrame extends JFrame {

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
	private JTable table;
	private JScrollPane scrollPane;

	public MainFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 700);
		setName("Service-Auto");

		// cream fereastra JDesktopPane
		final JDesktopPane desktopPane = new JDesktopPane();

		// adaugam desktopPane
		add(desktopPane);

		// adaugam un meniu
		menuBar = new JMenuBar();

		// dam font meniului
		font = new Font("Times New Roman", Font.BOLD, 16);
		fontOptionMenu = new Font("Times New Roman", Font.ITALIC,12);

		// adaugam o categorie meniului
		tableMenu = new JMenu("Table");
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
		modelTable.setFont(fontOptionMenu);
		tableMenu.add(modelTable);
		
		pieseTable = new JMenuItem("PIESE");
		pieseTable.setFont(fontOptionMenu);
		tableMenu.add(pieseTable);
		
		proprietarTable = new JMenuItem("PROPRIETAR");
		proprietarTable.setFont(fontOptionMenu);
		tableMenu.add(proprietarTable);
	   

		menuBar.add(tableMenu);
		setJMenuBar(menuBar);
 
		mecanicTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// cream fereastra interioara
				desktopPane.add(IFrameMecanic.getMecanicFrame());
			if(!IFrameMecanic.mecanicFrame.isVisible()){
			    	mecanicTable.setEnabled(false);
			    } else if(IFrameMecanic.mecanicFrame.isVisible()){
			    	mecanicTable.setEnabled(true); 
			       }
			    }
		});
	
		autoTable.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				desktopPane.add(IFrameAuto.getAutoFrame());
			}
		});
		setVisible(true);
	}
}

