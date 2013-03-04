package com.service.auto.Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.print.attribute.standard.Media;
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

import net.sf.cglib.transform.impl.AddPropertyTransformer;

import com.service.auto.AUTO;
import com.service.auto.BON;
import com.service.auto.Factory;
import com.service.auto.MARCA;
import com.service.auto.MECANIC;
import com.service.auto.MODEL;
import com.service.auto.OPERATIE;
import com.service.auto.PIESE;
import com.service.auto.PROPRIETAR;

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
	private static JComboBox cbNumeM;
	private static JLabel lbCnM;
	private static JTextField tfCnM;
	private static JLabel lbDenP;
	private static JComboBox cbDenP;
	private static JLabel lbCant;
	private static JTextField tfCant;
	private static JLabel lbDenO;
	private static JComboBox cbDenO;
	private static JLabel lbData;
	private static JTextField tfData;
	private static JPanel btnPanel;
	private static JButton btnAdd;
	private static JButton btnCancel;
	private static JTextField tfPret;

	private static ArrayList<PIESE> piese;
	private static ArrayList<OPERATIE> operatie;
	private static ArrayList<MECANIC> mecanic;
	private static ArrayList<MODEL> model;
	private static ArrayList<MARCA> marca;

	private static PIESE p;
	private static OPERATIE oper;
	private static MECANIC mec;
	private static MODEL mod;
	private static MARCA m;

	private static Set<OPERATIE> addOper = new HashSet<OPERATIE>();
	private static Set<PIESE> addPiesa = new HashSet<PIESE>();
	private static int sumOper = 0;
	
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
			// tfDenP.setText("");
			// tfDenO.setText("");
			tfCant.setText("");
			tfData.setText("");
			// tfPret.setText("");
		}
		return status;
	}

	public static JInternalFrame getAddForm() {

		if (addForm == null || addForm.isClosed()) {

			addForm = new JInternalFrame("Adauga", false, true, false, true);

			piese = (ArrayList<PIESE>) Factory.getInstance().getPieseDAO()
					.getAllPIESE();
			operatie = (ArrayList<OPERATIE>) Factory.getInstance()
					.getOperatieDAO().getAllOperatie();
			mecanic = (ArrayList<MECANIC>) Factory.getInstance()
					.getMecanicDAO().getAllMecanic();
			marca = (ArrayList<MARCA>) Factory.getInstance().getMarcaDAO()
					.getAllMarca();
			model = (ArrayList<MODEL>) Factory.getInstance().getModelDAO()
					.getAllModel();

			addForm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			addForm.setSize(550, 400);
			addForm.setLocation(30, 20);
			addForm.setVisible(true);

			panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

			panelMarca = new JPanel();
			panelMarca.setBorder(BorderFactory.createTitledBorder("Auto"));
			panelMarca.setLayout(new GridLayout(3, 4));

			panelPropr = new JPanel();
			panelPropr
					.setBorder(BorderFactory.createTitledBorder("Proprietar"));
			panelPropr.setLayout(new GridLayout(3, 4));

			panelMecanic = new JPanel();
			panelMecanic.setBorder(BorderFactory.createTitledBorder("Mecanic"));
			panelMecanic.setLayout(new GridLayout(1, 4));

			panelPO = new JPanel();
			panelPO.setBorder(BorderFactory
					.createTitledBorder("Piese & Operatii"));
			panelPO.setLayout(new GridLayout(2, 4));

			panelBon = new JPanel();
			panelBon.setBorder(BorderFactory.createTitledBorder("Data & Pret"));
			panelBon.setLayout(new GridLayout(1, 4));

			/* Table Marca & Model */
			lbMarca = new JLabel("Marca");
			lbMarca.setPreferredSize(new Dimension(100, 20));
			panelMarca.add(lbMarca);

			cbMarca = new JComboBox();
			cbMarca.setPreferredSize(new Dimension(200, 20));
			panelMarca.add(cbMarca);

			lbModel = new JLabel("Model");
			lbModel.setPreferredSize(new Dimension(100, 20));
			panelMarca.add(lbModel);

			cbModel = new JComboBox();
			cbModel.setPreferredSize(new Dimension(200, 20));
			cbModel.setEnabled(false);
			panelMarca.add(cbModel);

			lbAn = new JLabel("An fabricare");
			lbAn.setPreferredSize(new Dimension(100, 20));
			panelMarca.add(lbAn);

			tfAn = new JTextField();
			tfAn.setPreferredSize(new Dimension(200, 20));
			panelMarca.add(tfAn);

			lbNr = new JLabel("Nr. inmatriculare");
			lbNr.setPreferredSize(new Dimension(100, 20));
			panelMarca.add(lbNr);

			tfNr = new JTextField();
			tfNr.setPreferredSize(new Dimension(200, 20));
			panelMarca.add(tfNr);

			lbCna = new JLabel("Cod Auto");
			lbCna.setPreferredSize(new Dimension(100, 20));
			panelMarca.add(lbCna);

			tfCna = new JTextField();
			tfCna.setPreferredSize(new Dimension(200, 20));
			panelMarca.add(tfCna);

			/* Proprietar */
			lbNumeP = new JLabel("Nume proprietar");
			lbNumeP.setPreferredSize(new Dimension(100, 20));
			panelPropr.add(lbNumeP);

			tfNumeP = new JTextField();
			tfNumeP.setPreferredSize(new Dimension(200, 20));
			panelPropr.add(tfNumeP);

			lbPrenumeP = new JLabel("Prenume proprietar");
			lbPrenumeP.setPreferredSize(new Dimension(100, 20));
			panelPropr.add(lbPrenumeP);

			tfPrenumeP = new JTextField();
			tfPrenumeP.setPreferredSize(new Dimension(200, 20));
			panelPropr.add(tfPrenumeP);

			lbCnp = new JLabel("Cod Proprietar");
			lbCnp.setPreferredSize(new Dimension(100, 20));
			panelPropr.add(lbCnp);

			tfCnp = new JTextField();
			tfCnp.setPreferredSize(new Dimension(200, 20));
			panelPropr.add(tfCnp);

			lbTelefon = new JLabel("Telefon");
			lbTelefon.setPreferredSize(new Dimension(100, 20));
			panelPropr.add(lbTelefon);

			tfTelefon = new JTextField();
			tfTelefon.setPreferredSize(new Dimension(200, 20));
			panelPropr.add(tfTelefon);

			lbAdresa = new JLabel("Adresa");
			lbAdresa.setPreferredSize(new Dimension(100, 20));
			panelPropr.add(lbAdresa);

			tfAdresa = new JTextField();
			tfAdresa.setPreferredSize(new Dimension(200, 20));
			panelPropr.add(tfAdresa);

			/* MECANIC */
			lbNumeM = new JLabel("Nume mecanic");
			lbNumeM.setPreferredSize(new Dimension(100, 20));
			panelMecanic.add(lbNumeM);

			cbNumeM = new JComboBox();
			cbNumeM.setPreferredSize(new Dimension(200, 20));
			panelMecanic.add(cbNumeM);

			lbCnM = new JLabel("Cod Mecanic");
			lbCnM.setPreferredSize(new Dimension(100, 20));
			panelMecanic.add(lbCnM);

			tfCnM = new JTextField();
			tfCnM.setPreferredSize(new Dimension(200, 20));
			tfCnM.setEnabled(false);
			panelMecanic.add(tfCnM);

			/* PIESE & OPER */
			lbDenP = new JLabel("Denumire piesa");
			lbDenP.setPreferredSize(new Dimension(100, 20));
			panelPO.add(lbDenP);

			cbDenP = new JComboBox();
			cbDenP.setPreferredSize(new Dimension(200, 20));
			panelPO.add(cbDenP);

			lbCant = new JLabel("Cantitate");
			lbCant.setPreferredSize(new Dimension(100, 20));
			panelPO.add(lbCant);

			tfCant = new JTextField();
			tfCant.setPreferredSize(new Dimension(200, 20));
			panelPO.add(tfCant);

			lbDenO = new JLabel("Denumire operatii");
			lbDenO.setPreferredSize(new Dimension(100, 20));
			panelPO.add(lbDenO);

			cbDenO = new JComboBox();
			cbDenO.setPreferredSize(new Dimension(200, 20));
			panelPO.add(cbDenO);

			JLabel lb = new JLabel();
			panelPO.add(lb);
			/* BON */
			lbData = new JLabel("Data");
			lbData.setPreferredSize(new Dimension(100, 20));
			panelBon.add(lbData);

			tfData = new JTextField();
			tfData.setPreferredSize(new Dimension(200, 20));
			panelBon.add(tfData);

			JLabel lbPret = new JLabel("Pret");
			lbPret.setPreferredSize(new Dimension(100, 20));
			panelBon.add(lbPret);

			tfPret = new JTextField();
			tfPret.setPreferredSize(new Dimension(200, 20));
			tfPret.setEnabled(false);
			panelBon.add(tfPret);

			panel.add(panelMarca);
			panel.add(panelPropr);
			panel.add(panelMecanic);
			panel.add(panelPO);
			panel.add(panelBon);

			btnPanel = new JPanel();
			btnAdd = new JButton("Adauga");
			btnCancel = new JButton("Anuleaza");

			btnPanel.add(btnAdd);
			btnPanel.add(btnCancel);
			panel.add(btnPanel);

			addForm.add(panel);

			java.util.Iterator<PIESE> iter = piese.iterator();
			while (iter.hasNext()) {
				p = (PIESE) iter.next();
				cbDenP.addItem(p.getDenumire());
			}

			java.util.Iterator<OPERATIE> iter1 = operatie.iterator();
			while (iter1.hasNext()) {
				oper = (OPERATIE) iter1.next();
				cbDenO.addItem(oper.getDen_oper());
			}

			java.util.Iterator<MECANIC> iter2 = mecanic.iterator();
			while (iter2.hasNext()) {
				mec = (MECANIC) iter2.next();
				cbNumeM.addItem(mec.getNume() + " " + mec.getPrenume());
			}

			cbNumeM.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					java.util.Iterator<MECANIC> iterator = mecanic.iterator();
					while (iterator.hasNext()) {
						mec = (MECANIC) iterator.next();
						if (mecanic.get(cbNumeM.getSelectedIndex())
								.getId_mecanic().equals(mec.getId_mecanic())) {

							tfCnM.setText(mec.getCnm());
						}
					}
				}
			});

			java.util.Iterator<MARCA> iter3 = marca.iterator();
			while (iter3.hasNext()) {
				m = (MARCA) iter3.next();
				cbMarca.addItem(m.getDen_marca());
			}

			cbMarca.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					cbModel.setEnabled(true);
					if (!cbModel.equals(0)) {
						cbModel.removeAllItems();
					}

					java.util.Iterator<MODEL> iterator = model.iterator();
					while (iterator.hasNext()) {
						mod = (MODEL) iterator.next();
						if (marca.get(cbMarca.getSelectedIndex()).getId_marca()
								.equals(mod.getMarca().getId_marca())) {

							cbModel.addItem(mod.getDen_model());
						}
					}

				}
			});

			cbDenO.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					Object[] var = { "Da", "Nu" };
					int n = JOptionPane.showOptionDialog(null,
							"Adauga operatie ?", "Confirmare",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, var, var[0]);
					if (n == 0) {
						addOper.add(operatie.get(cbDenO.getSelectedIndex()));
						 sumOper += (operatie.get(cbDenO.getSelectedIndex()).getPret_oper());
						 tfPret.setText(Integer.valueOf(sumOper).toString());
					}
				}
			});

			cbDenP.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					Object[] var = { "Da", "Nu" };
					int n = JOptionPane.showOptionDialog(null,
							"Adauga piesa ?", "Confirmare",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, var, var[0]);
					if (n == 0) {
						addPiesa.add(piese.get(cbDenP.getSelectedIndex()));
					
					}
				}
			});

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
							BON bonObj = new BON();
							MARCA marcaObj = new MARCA();
							MODEL modelObj = new MODEL();
							PROPRIETAR proprObj = new PROPRIETAR();
							PIESE pieseObj = new PIESE();
							OPERATIE operObj = new OPERATIE();
							AUTO autoObj = new AUTO();
							try {
								bonObj.setId_bon(null);
								// marcaObj.setDen_marca(marca.get(cbMarca.getSelectedIndex()).getDen_marca().toString());
								// modelObj.setDen_model(model.get(cbModel.getSelectedIndex()).getDen_model().toString());

							/*	autoObj.setAn_fabr(Integer.valueOf(tfAn
										.getText()));
								autoObj.setNr_inmatr(tfNr.getText());
								autoObj.setSerie_motor(tfCna.getText());
								*/

								proprObj.setNume(tfNumeP.getText());
								proprObj.setPrenume(tfPrenumeP.getText());
								proprObj.setCnp(tfCnp.getText());
								proprObj.setTelefon(Integer.valueOf(tfTelefon
										.getText()));
								proprObj.setAdresa(tfAdresa.getText());

								// bonObj.setData_bon(tfData.getText());
								// bonObj.setPret_total(Integer.valueOf(tfPret.getText()));
								
								autoObj  = new AUTO(tfNr.getText(), tfCna.getText(), Integer.valueOf(tfAn.getText()),
										model.get(cbModel.getSelectedIndex()), proprObj);
								
								bonObj = new BON(tfData.getText(), mecanic
										.get(cbNumeM.getSelectedIndex()),
										autoObj, Integer.valueOf(tfPret.getText()), addOper, addPiesa);

							} catch (NumberFormatException e) {
							}
							try {
								boolean status = Factory.getInstance()
										.getBonDAO().addBon(bonObj);
								tfStatus(status);
							} catch (Exception e1) {
								JOptionPane
										.showMessageDialog(
												null,
												"Eroare cu serverul de date, incercati mai tirziu",
												" Eroare",
												JOptionPane.OK_OPTION);
							}

						}
					};
					(new Thread(r)).start();

				}
			});

		}
		// addForm.pack();
		return addForm;
	}

}