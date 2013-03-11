package com.service.auto.Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import org.hibernate.Session;

import com.service.auto.BON;
import com.service.auto.Factory;
import com.service.auto.HibernateUtil;
import com.service.auto.MARCA;
import com.service.auto.MECANIC;
import com.service.auto.OPERATIE;
import com.service.auto.PIESE;

import TModel.TableModelAuto;
import TModel.TableModelForm;
import TModel.TableModelMecanic;

public class IFrameTable extends JFrame {
		
	
	  static JInternalFrame tableForm;
	  private static ArrayList<BON> bon = null;
	  private static TableModelForm model = null;
	  private static JTable t = null;
	  private static JScrollPane scrollPane;
	  private static JPanel panel_table;
	  private static ArrayList<OPERATIE> oper =null;
	  private static ArrayList<PIESE> piese = null;
	  private static List<String> operString = new ArrayList<String>();
	  private static List<String> pieseString = new ArrayList<String>();
	  private static String[] v = new String[100];
	  private static String str = "";
	  private static JComboBox cbSearch = null;
	  private static JButton btnSearch = null;
	  private static JTextField tfSearch = null;
	  
	  private static JPanel searchPanel = null;
	  private static JPanel btnPanel = null;
	  private static JButton btnRefresh = null;
	  
	public static JInternalFrame getTableForm() {
		

		if (tableForm == null || tableForm.isClosed()) {

			tableForm = new JInternalFrame("Table", false, true, false,
					true);

			tableForm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			tableForm.setSize(1000, 600);
			tableForm.setLocation(30, 20);
			tableForm.setVisible(true);
			
			
			completList();
						
			//System.out.println("Marimea" + pieseString.size());

			model = new TableModelForm(bon,operString,pieseString);
			t = new JTable(model);
			
			/*panel_table = new JPanel(new BorderLayout());
			panel_table.setVisible(true);
			panel_table.setSize(new Dimension(300, 300));
			panel_table.setLocation(0, 0);
			// panel_table.setBackground(Color.white);
			panel_table.setPreferredSize(new Dimension(300, 300));*/
			scrollPane = new JScrollPane(t);
			
			//panel_table.add(scrollPane, BorderLayout.CENTER);
			searchPanel = new JPanel();
			searchPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
			JPanel panel = new JPanel();
			
		    tfSearch = new JTextField();
			tfSearch.setPreferredSize(new Dimension(100,20));
			searchPanel.add(tfSearch);
			
			String[] items = {"--------",
					  "Data elib. bon",
					  "Marca"
						};
	
			cbSearch = new JComboBox(items);
			cbSearch.setPreferredSize(new Dimension(150,20));
			searchPanel.add(cbSearch);
			
		    btnSearch = new JButton("Cautare");
			btnSearch.setPreferredSize(new Dimension(100,20));
			searchPanel.add(btnSearch);
			
		    btnRefresh = new JButton("Actualizare");
			btnRefresh.setSize(new Dimension(200,20));
			btnPanel = new JPanel(new BorderLayout());
			btnPanel.add(btnRefresh, BorderLayout.EAST);
			
			
			tableForm.add(btnPanel, BorderLayout.PAGE_END);
			
			tableForm.add(searchPanel, BorderLayout.PAGE_START);
			tableForm.add(scrollPane/*, BorderLayout.PAGE_START*/);
			
			
			btnRefresh.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					Runnable r = new Runnable() {
						
						public void run() {
							completList();
							model = new TableModelForm(bon,operString,pieseString);
							t.setModel(model);
						}
					};
					(new Thread(r)).start();
				}
			});
			btnSearch.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					switch (cbSearch.getSelectedIndex()) {
					case 0:
						JOptionPane.showMessageDialog(null,
								"Selectati dupa ce cimp doriti sa cautati datele",
								" Eroare", JOptionPane.OK_OPTION);
						break;
					case 1:
						Runnable r = new Runnable() {

							public void run() {
								bon = (ArrayList<BON>) Factory
										.getInstance().getBonDAO()
										.searchByData(tfSearch.getText());
								model = new TableModelForm(bon,operString,pieseString);
								t.setModel(model);
								((AbstractTableModel) t.getModel())
										.fireTableDataChanged();
								t.repaint();

							}
						};
						(new Thread(r)).start();
						break;
					case 2:
						Runnable r1 = new Runnable() {
							
 							public void run() {
							
								
							}
						};
						(new Thread(r1)).start();
						break;
					default:
						break;
					}
					
				}
			});
		
		}
		return tableForm;	
}
	
	public static void completList(){
		bon = (ArrayList<BON>) Factory.getInstance().getBonDAO().getAllBon();
		
		for (int i = 0; i < bon.size(); i++) {
			oper = Factory.getInstance().getOperatieDAO()
					.getAllOperFK(bon.get(i).getId_bon());	
			System.out.println(oper.size());
			if (oper.size() != 0) {
				for (int j = 0; j < oper.size(); j++) {
				  str = str +" " + oper.get(j).getDen_oper();
					 }
						operString.add(str);
					str = "";
				}
			}
		
		for(int i = 0; i < bon.size(); i++){
			piese = Factory.getInstance().getPieseDAO().getAllPieseFK(bon.get(i).getId_bon());
			System.out.println(piese.size());
			if(piese.size() != 0) {
				for(int j = 0; j < piese.size(); j++){
					str = str + " " + piese.get(j).getDenumire();
				}
				pieseString.add(str);
				str = "";
			}
		}
	}
}