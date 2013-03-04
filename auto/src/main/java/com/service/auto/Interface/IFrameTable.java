package com.service.auto.Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.hibernate.Session;

import com.service.auto.BON;
import com.service.auto.Factory;
import com.service.auto.HibernateUtil;
import com.service.auto.OPERATIE;

import TModel.TableModelAuto;
import TModel.TableModelForm;

public class IFrameTable extends JFrame {
		
	
	  static JInternalFrame tableForm;
	  private static ArrayList<BON> bon = null;
	  private static TableModelForm model = null;
	  private static JTable t = null;
	  private static JScrollPane scrollPane;
	  private static JPanel panel_table;
	  private static ArrayList<OPERATIE> oper =null;
	  
	public static JInternalFrame getTableForm() {
		

		if (tableForm == null || tableForm.isClosed()) {

			tableForm = new JInternalFrame("Table", false, true, false,
					true);

			tableForm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			tableForm.setSize(1000, 600);
			tableForm.setLocation(30, 20);
			tableForm.setVisible(true);
			
			bon = (ArrayList<BON>) Factory.getInstance().getBonDAO().getAllBon();
			
			model = new TableModelForm(bon);
			t = new JTable(model);
			
			/*panel_table = new JPanel(new BorderLayout());
			panel_table.setVisible(true);
			panel_table.setSize(new Dimension(300, 300));
			panel_table.setLocation(0, 0);
			// panel_table.setBackground(Color.white);
			panel_table.setPreferredSize(new Dimension(300, 300));*/
			scrollPane = new JScrollPane(t);
			
			//panel_table.add(scrollPane, BorderLayout.CENTER);
			JPanel searchPanel = new JPanel(new FlowLayout());
			JPanel panel = new JPanel();
			
			JTextField tfSearch = new JTextField();
			tfSearch.setPreferredSize(new Dimension(100,20));
			panel.add(tfSearch);
			
			JComboBox cbSearch = new JComboBox();
			cbSearch.setPreferredSize(new Dimension(150,20));
			panel.add(cbSearch);
			
			JButton btnSearch = new JButton("Cautare");
			btnSearch.setPreferredSize(new Dimension(100,20));
			panel.add(btnSearch);
			
			searchPanel.add(panel, FlowLayout.LEFT);
			searchPanel.setBackground(Color.black);
			tableForm.add(searchPanel, BorderLayout.PAGE_START);
			tableForm.add(scrollPane/*, BorderLayout.PAGE_START*/);
		
		}
		return tableForm;	
}
	
}