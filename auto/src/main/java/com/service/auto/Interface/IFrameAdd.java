package com.service.auto.Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.service.auto.MARCA;


public class IFrameAdd extends JFrame {
	
      static JInternalFrame addForm;

      
	public static JInternalFrame getAddForm() {

		if (addForm == null || addForm.isClosed()) {

			addForm = new JInternalFrame("Add", false, true, false,
					true);

			addForm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			addForm.setSize(550, 450);
			addForm.setLocation(30, 20);
			addForm.setVisible(true);
			
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			
			 JPanel panelMarca = new JPanel();
			 panelMarca.setBorder(BorderFactory.createTitledBorder("Auto"));
			 panelMarca.setLayout(new GridLayout(3,4));
			 
             
			 JPanel panelPropr = new JPanel();
			 panelPropr.setBorder(BorderFactory.createTitledBorder("Proprietar"));
			 panelPropr.setLayout(new GridLayout(3,4));
			 
			 JPanel panelMecanic = new JPanel();
			 panelMecanic.setBorder(BorderFactory.createTitledBorder("Mecanic"));
			 panelMecanic.setLayout(new GridLayout(1,4));
			 
			 JPanel panelPO = new JPanel();
			 panelPO.setBorder(BorderFactory.createTitledBorder("Piese & Operatii"));
			 panelPO.setLayout(new GridLayout(2, 4));
			
			 JPanel panelBon = new JPanel();
			 panelBon.setBorder(BorderFactory.createTitledBorder("Data & Pret"));
			panelBon.setLayout(new GridLayout(1,4));
			 
		/* Table Marca & Model */
			 JLabel lbMarca = new JLabel("Marca");
			 lbMarca.setPreferredSize(new Dimension(100,20));
			 panelMarca.add(lbMarca);
			 
			 JComboBox cbMarca = new JComboBox();
			 cbMarca.setPreferredSize(new Dimension(200,20));
			 panelMarca.add(cbMarca);
			 
			 JLabel lbModel = new JLabel("Model");
			 lbModel.setPreferredSize(new Dimension(100,20));
			 panelMarca.add(lbModel);
			 
			 JComboBox cbModel = new JComboBox();
			 cbModel.setPreferredSize(new Dimension(200,20));
			 panelMarca.add(cbModel);
			 JLabel lbAn = new JLabel("An fabricare");
			 lbAn.setPreferredSize(new Dimension(100,20));
			 panelMarca.add(lbAn);
			 
			 JTextField tfAn = new JTextField();
			 tfAn.setPreferredSize(new Dimension(200,20));
			 panelMarca.add(tfAn);
			 
			 JLabel lbNr = new JLabel("Nr. inmatriculare");
			 lbNr.setPreferredSize(new Dimension(100,20));
			 panelMarca.add(lbNr);
			 
			 JTextField tfNr = new JTextField();
			 tfNr.setPreferredSize(new Dimension(200,20));
			 panelMarca.add(tfNr);
			 
			 JLabel lbCna = new JLabel("Cod Auto");
			 lbCna.setPreferredSize(new Dimension(100,20));
			 panelMarca.add(lbCna);
			 
			 JTextField tfCna = new JTextField();
			 tfCna.setPreferredSize(new Dimension(200,20));
			 panelMarca.add(tfCna);
			 
			 /* Proprietar */
			 JLabel lbNumeP = new JLabel("Nume proprietar");
			 lbNumeP.setPreferredSize(new Dimension(100,20));
			 panelPropr.add(lbNumeP);
			 
			 JTextField tfNumeP = new JTextField();
			 tfNumeP.setPreferredSize(new Dimension(200,20));
			 panelPropr.add(tfNumeP);
			 
			 JLabel lbPrenumeP = new JLabel("Prenume proprietar");
			 lbPrenumeP.setPreferredSize(new Dimension(100,20));
			 panelPropr.add(lbPrenumeP);
			 
			 JTextField tfPrenumeP = new JTextField();
			 tfPrenumeP.setPreferredSize(new Dimension(200,20));
			 panelPropr.add(tfPrenumeP);
			 
			 JLabel lbCnp = new JLabel("Cod Proprietar");
			 lbCnp.setPreferredSize(new Dimension(100,20));
			 panelPropr.add(lbCnp);
			 
			 JTextField tfCnp = new JTextField();
			 tfCnp.setPreferredSize(new Dimension(200,20));
			 panelPropr.add(tfCnp);
			 
			 JLabel lbTelefon = new JLabel("Telefon");
			 lbTelefon.setPreferredSize(new Dimension(100,20));
			 panelPropr.add(lbTelefon);
			 
			 JTextField tfTelefon = new JTextField();
			 tfTelefon.setPreferredSize(new Dimension(200,20));
			 panelPropr.add(tfTelefon);
			 
			 JLabel lbAdresa  = new JLabel("Adresa");
			 lbAdresa.setPreferredSize(new Dimension(100,20));
			 panelPropr.add(lbAdresa);
			 
			 JTextField tfAdresa = new JTextField();
			 tfAdresa.setPreferredSize(new Dimension(200,20));
			 panelPropr.add(tfAdresa);
			 
			 /*MECANIC */
			 JLabel lbNumeM = new JLabel("Nume mecanic");
			 lbNumeM.setPreferredSize(new Dimension(100,20));
			 panelMecanic.add(lbNumeM);
			 
			 JTextField tfNumeM = new JTextField();
			 tfNumeM.setPreferredSize(new Dimension(200,20));
			 panelMecanic.add(tfNumeM);
			 
			 JLabel lbPrenumeM = new JLabel("Prenume mecanic");
			 lbPrenumeM.setPreferredSize(new Dimension(100,20));
			 panelMecanic.add(lbPrenumeM);
			 
			 JTextField tfPrenumeM = new JTextField();
			 tfPrenumeM.setPreferredSize(new Dimension(200,20));
			 panelMecanic.add(tfPrenumeM);
			 
			 /* PIESE & OPER */
			 JLabel lbDenP = new JLabel("Denumire piesa");
			 lbDenP.setPreferredSize(new Dimension(100,20));
			 panelPO.add(lbDenP);
			 
			 JTextField tfDenP = new JTextField();
			 tfDenP.setPreferredSize(new Dimension(200,20));
			 panelPO.add(tfDenP);
			 
			 JLabel lbCant = new JLabel("Cantitate");
			 lbCant.setPreferredSize(new Dimension(100,20));
			 panelPO.add(lbCant);
			 
			 JTextField tfCant = new JTextField();
			 tfCant.setPreferredSize(new Dimension(200,20));
			 panelPO.add(tfCant);
			 
			 JLabel lbDenO = new JLabel();
			 lbDenO.setPreferredSize(new Dimension(100,20));
			 panelPO.add(lbDenO);
			 
			 JTextField tfDenO =new JTextField();
			 tfDenO.setPreferredSize(new Dimension(200,20));
			 panelPO.add(tfDenO);
			 
			 /* BON */ 
			 JLabel lbData = new JLabel("Data");
			 lbData.setPreferredSize(new Dimension(100,20));
			 panelBon.add(lbData);
			 
			 JTextField tfData = new JTextField();
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
			 addForm.add(panel);
			 
			 
			

}
		return addForm;
} 
}