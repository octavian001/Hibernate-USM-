package com.service.auto.Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.service.auto.BON;
import com.service.auto.Factory;
import com.service.auto.MARCA;
import com.service.auto.MECANIC;


public class IFrameAdd extends JFrame {
	
      static JInternalFrame addForm;
	private static JPanel panel;
	private static JPanel panelMarca;
	private static JPanel panelPropr;
	private static JPanel panelMecanic;
	private static JPanel panelPO;
	private static JPanel panelBon;
	private static JLabel lbMarca;
	private static JComboBox cbMarca;
	private static JLabel lbModel;
	private static JComboBox cbModel;
	private static JLabel lbAn;
	private static JTextField tfAn;
	private static JLabel lbNr;
	private static JTextField tfNr;
	private static JLabel lbCna;
	private static JTextField tfCna;
	private static JLabel lbNumeP;
	private static JTextField tfNumeP;
	private static JLabel lbPrenumeP;
	private static JTextField tfPrenumeP;
	private static JLabel lbCnp;
	private static JTextField tfCnp;
	private static JLabel lbTelefon;
	private static JTextField tfTelefon;
	private static JLabel lbAdresa;
	private static JTextField tfAdresa;
	private static JLabel lbNumeM;
	private static JComboBox tfNumeM;
	private static JLabel lbCnM;
	private static JComboBox tfCnM;
	private static JLabel lbDenP;
	private static JTextField tfDenP;
	private static JLabel lbCant;
	private static JTextField tfCant;
	private static JLabel lbDenO;
	private static JTextField tfDenO;
	private static JLabel lbData;
	private static JTextField tfData;
	private static JPanel btnPanel;
	private static JButton btnAdd;
	private static JButton btnCancel;
     
      public static boolean tfStatus(Boolean status) {
			if (status) {
				tfAn.setText("");
				tfNr.setText("");
				tfCna.setText("");
				tfNumeP.setText("");
				tfPrenumeP.setText("");
				tfCnp.setText("");
				tfTelefon.setText("");
				tfAdresa.setText("");
				tfDenP.setText("");
				tfDenO.setText("");
				tfCant.setText("");
				tfData.setText("");
				//tfPret.setText("");
			}
			return status;
		}
      
	public static JInternalFrame getAddForm() {

		if (addForm == null || addForm.isClosed()) {

			addForm = new JInternalFrame("Add", false, true, false,
					true);

			addForm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			addForm.setSize(550, 400);
			addForm.setLocation(30, 20);
			addForm.setVisible(true);
			
			 panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			
			  panelMarca = new JPanel();
			 panelMarca.setBorder(BorderFactory.createTitledBorder("Auto"));
			 panelMarca.setLayout(new GridLayout(3,4));
			 
             
			  panelPropr = new JPanel();
			 panelPropr.setBorder(BorderFactory.createTitledBorder("Proprietar"));
			 panelPropr.setLayout(new GridLayout(3,4));
			 
			  panelMecanic = new JPanel();
			 panelMecanic.setBorder(BorderFactory.createTitledBorder("Mecanic"));
			 panelMecanic.setLayout(new GridLayout(1,4));
			 
			  panelPO = new JPanel();
			 panelPO.setBorder(BorderFactory.createTitledBorder("Piese & Operatii"));
			 panelPO.setLayout(new GridLayout(2, 4));
			 
			  panelBon = new JPanel();
			 panelBon.setBorder(BorderFactory.createTitledBorder("Data & Pret"));
			panelBon.setLayout(new GridLayout(1,4));
			 
		/* Table Marca & Model */
			  lbMarca = new JLabel("Marca");
			 lbMarca.setPreferredSize(new Dimension(100,20));
			 panelMarca.add(lbMarca);
			 
			  cbMarca = new JComboBox();
			 cbMarca.setPreferredSize(new Dimension(200,20));
			 panelMarca.add(cbMarca);
			 
			  lbModel = new JLabel("Model");
			 lbModel.setPreferredSize(new Dimension(100,20));
			 panelMarca.add(lbModel);
			 
			 cbModel = new JComboBox();
			 cbModel.setPreferredSize(new Dimension(200,20));
			 panelMarca.add(cbModel);
			 
			  lbAn = new JLabel("An fabricare");
			 lbAn.setPreferredSize(new Dimension(100,20));
			 panelMarca.add(lbAn);
			 
			  tfAn = new JTextField();
			 tfAn.setPreferredSize(new Dimension(200,20));
			 panelMarca.add(tfAn);
			 
			 lbNr = new JLabel("Nr. inmatriculare");
			 lbNr.setPreferredSize(new Dimension(100,20));
			 panelMarca.add(lbNr);
			 
			  tfNr = new JTextField();
			 tfNr.setPreferredSize(new Dimension(200,20));
			 panelMarca.add(tfNr);
			 
			  lbCna = new JLabel("Cod Auto");
			 lbCna.setPreferredSize(new Dimension(100,20));
			 panelMarca.add(lbCna);
			 
			  tfCna = new JTextField();
			 tfCna.setPreferredSize(new Dimension(200,20));
			 panelMarca.add(tfCna);
			 
			 /* Proprietar */
			  lbNumeP = new JLabel("Nume proprietar");
			 lbNumeP.setPreferredSize(new Dimension(100,20));
			 panelPropr.add(lbNumeP);
			 
			  tfNumeP = new JTextField();
			 tfNumeP.setPreferredSize(new Dimension(200,20));
			 panelPropr.add(tfNumeP);
			 
			  lbPrenumeP = new JLabel("Prenume proprietar");
			 lbPrenumeP.setPreferredSize(new Dimension(100,20));
			 panelPropr.add(lbPrenumeP);
			 
			  tfPrenumeP = new JTextField();
			 tfPrenumeP.setPreferredSize(new Dimension(200,20));
			 panelPropr.add(tfPrenumeP);
			 
			  lbCnp = new JLabel("Cod Proprietar");
			 lbCnp.setPreferredSize(new Dimension(100,20));
			 panelPropr.add(lbCnp);
			 
			  tfCnp = new JTextField();
			 tfCnp.setPreferredSize(new Dimension(200,20));
			 panelPropr.add(tfCnp);
			 
			  lbTelefon = new JLabel("Telefon");
			 lbTelefon.setPreferredSize(new Dimension(100,20));
			 panelPropr.add(lbTelefon);
			 
			  tfTelefon = new JTextField();
			 tfTelefon.setPreferredSize(new Dimension(200,20));
			 panelPropr.add(tfTelefon);
			 
			  lbAdresa  = new JLabel("Adresa");
			 lbAdresa.setPreferredSize(new Dimension(100,20));
			 panelPropr.add(lbAdresa);
			 
			  tfAdresa = new JTextField();
			 tfAdresa.setPreferredSize(new Dimension(200,20));
			 panelPropr.add(tfAdresa);
			 
			 /*MECANIC */
			  lbNumeM = new JLabel("Nume mecanic");
			 lbNumeM.setPreferredSize(new Dimension(100,20));
			 panelMecanic.add(lbNumeM);
			 
			  tfNumeM = new JComboBox();
			 tfNumeM.setPreferredSize(new Dimension(200,20));
			 panelMecanic.add(tfNumeM);
			 
			  lbCnM = new JLabel("Cod Mecanic");
			 lbCnM.setPreferredSize(new Dimension(100,20));
			 panelMecanic.add(lbCnM);
			 
			  tfCnM = new JComboBox();
			 tfCnM.setPreferredSize(new Dimension(200,20));
			 panelMecanic.add(tfCnM);
			 
		
			 
			 /* PIESE & OPER */
			  lbDenP = new JLabel("Denumire piesa");
			 lbDenP.setPreferredSize(new Dimension(100,20));
			 panelPO.add(lbDenP);
			 
			  tfDenP = new JTextField();
			 tfDenP.setPreferredSize(new Dimension(200,20));
			 panelPO.add(tfDenP);
			 
			  lbCant = new JLabel("Cantitate");
			 lbCant.setPreferredSize(new Dimension(100,20));
			 panelPO.add(lbCant);
			 
			  tfCant = new JTextField();
			 tfCant.setPreferredSize(new Dimension(200,20));
			 panelPO.add(tfCant);
			 
			  lbDenO = new JLabel("Denumire operatii");
			 lbDenO.setPreferredSize(new Dimension(100,20));
			 panelPO.add(lbDenO);
			 
			  tfDenO =new JTextField();
			 tfDenO.setPreferredSize(new Dimension(200,20));
			 panelPO.add(tfDenO);
			 
			 JLabel lb = new JLabel();
			 panelPO.add(lb);
			 /* BON */ 
			  lbData = new JLabel("Data");
			 lbData.setPreferredSize(new Dimension(100,20));
			 panelBon.add(lbData);
			 
			  tfData = new JTextField();
			 tfData.setPreferredSize(new Dimension(200,20));
			 panelBon.add(tfData);
			 
			 JLabel lbPret = new JLabel("Pret");
			 lbPret.setPreferredSize(new Dimension(100,20));
			 panelBon.add(lbPret);
			 
			 JTextField tfPret = new JTextField();
			 tfPret.setPreferredSize(new Dimension(200,20));
			 panelBon.add(tfPret);
			 
			 panel.add(panelMarca);
			 panel.add(panelPropr);
			 panel.add(panelMecanic);
			 panel.add(panelPO);
			 panel.add(panelBon);
			 
			  btnPanel = new JPanel();
			  btnAdd = new JButton("Add");
			 btnCancel = new JButton("Cancel");
			 
			 btnPanel.add(btnAdd);
			 btnPanel.add(btnCancel);
			 panel.add(btnPanel);
			 
			 addForm.add(panel);
			
			 btnCancel.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					Runnable r = new Runnable() {
						
						public void run() {
							
							addForm.dispose();
						}
					};
					(new Thread(r)).start();
				}
			});
			 
			 btnAdd.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					Runnable r = new Runnable() {
						
						public void run() {
							BON bon = new BON();
							try {
								bon.setId_bon(null);

							} catch (NumberFormatException e) {
							}
							try {
								boolean status = Factory.getInstance()
										.getBonDAO().addBon(bon);
								tfStatus(status);
							} catch (Exception e1) {
								JOptionPane
										.showMessageDialog(
												null,
												"Eroare cu serverul de date, incercati mai tirziu",
												" Eroare", JOptionPane.OK_OPTION);
							}
							
						}
					};
					(new Thread(r)).start();
					
				}
			});
	
			 
			

}
		//addForm.pack();
		return addForm;
} 
	
}