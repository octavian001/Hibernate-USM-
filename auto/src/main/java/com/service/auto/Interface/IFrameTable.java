package com.service.auto.Interface;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.service.auto.BON;
import com.service.auto.Factory;

import TModel.TableModelAuto;
import TModel.TableModelForm;

public class IFrameTable extends JFrame {
		
	
	  static JInternalFrame tableForm;
	  private static ArrayList<BON> bon = null;
	  private static TableModelForm model = null;
	  private static JTable t = null;
	  private static JScrollPane scrollPane;
	  private static JPanel panel_table;
	
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
			
			tableForm.add(scrollPane/*, BorderLayout.PAGE_START*/);
		}
		return tableForm;	
}
	
}