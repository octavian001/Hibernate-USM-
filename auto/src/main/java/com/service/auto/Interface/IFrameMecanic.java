package com.service.auto.Interface;

import java.awt.BorderLayout;
import java.awt.Color;
<<<<<<< HEAD
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
=======
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
>>>>>>> ddc63eaf39d3b631d5daa822c71796a89dfae39b
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
<<<<<<< HEAD
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
=======
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
>>>>>>> ddc63eaf39d3b631d5daa822c71796a89dfae39b
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
<<<<<<< HEAD
=======
import javax.swing.table.TableModel;
import javax.swing.text.Document;

>>>>>>> ddc63eaf39d3b631d5daa822c71796a89dfae39b
import TModel.TableModelMecanic;

import com.service.auto.Factory;
import com.service.auto.MECANIC;
<<<<<<< HEAD

public class IFrameMecanic extends JFrame {

	private static final long serialVersionUID = 1L;


=======
import com.service.auto.MECANICImplDAO;

public class IFrameMecanic extends JFrame {

>>>>>>> ddc63eaf39d3b631d5daa822c71796a89dfae39b
	// anuleaza textul din TextField daca s-au salvat datele in tabel
	public static boolean tfStatus(Boolean status) {
		if (status) {
			tfNume.setText("");
			tfPrenume.setText("");
			tfCnm.setText("");
			tfTelefon.setText("");
			tfEmail.setText("");
			tfAdresa.setText("");
		}
		return status;
	}

	// anuleaza datele din TextField daca s-a apasat btnCancel
	public static void cancelText() {
		tfNume.setText("");
		tfPrenume.setText("");
		tfCnm.setText("");
		tfTelefon.setText("");
		tfEmail.setText("");
		tfAdresa.setText("");
	}

	static JInternalFrame mecanicFrame = null;
	private static TableModelMecanic model = null;
	private static JTable t = null;
	private static JScrollPane scrollPane = null;
	private static JPanel panel_btn = null;
	private static JPanel panel_lb = null;
	private static JPanel panel_table = null;
	private static JPanel line = null;
	private static JLabel lbNume = null;
	private static JLabel lbPrenume = null;
	private static JLabel lbCnm = null;
	private static JLabel lbTelefon = null;
	private static JLabel lbEmail = null;
	private static JLabel lbAdresa = null;
	private static JButton btnAdd = null;
	private static JButton btnEdit = null;
	private static JButton btnDelete = null;
	private static JButton btnSave = null;
	private static JButton btnCancel = null;
	private static JTextField tfNume = null;
	private static JTextField tfPrenume = null;
	private static JTextField tfCnm = null;
	private static JTextField tfTelefon = null;
	private static JTextField tfEmail = null;
	private static JTextField tfAdresa = null;
	private static MECANIC mec;
<<<<<<< HEAD
	
	private static ArrayList<MECANIC> mecanic = null;


	public static JInternalFrame getMecanicFrame() {

		
=======

	public static JInternalFrame getMecanicFrame() {

>>>>>>> ddc63eaf39d3b631d5daa822c71796a89dfae39b
		if (mecanicFrame == null) {
			mecanicFrame = new JInternalFrame("MECANIC", false, true, false,
					true);
			mecanicFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			mecanicFrame.setSize(900, 600);
			// mecanicFrame.setLocation(30, 20);
			mecanicFrame.setVisible(true);

<<<<<<< HEAD
			 mecanic = (ArrayList<MECANIC>) Factory
=======
			ArrayList<MECANIC> mecanic = (ArrayList<MECANIC>) Factory
>>>>>>> ddc63eaf39d3b631d5daa822c71796a89dfae39b
					.getInstance().getMecanicDAO().getAllMecanic();

			model = new TableModelMecanic(mecanic);
			t = new JTable(model);

			// panel for buttons
			JPanel leftPanel = new JPanel();
			btnAdd = new JButton("Adaugare");
			btnEdit = new JButton("Editare");
			btnDelete = new JButton("Sterge");
			leftPanel.add(btnAdd);
			leftPanel.add(btnEdit);
			leftPanel.add(btnDelete);

			JPanel rightPanel = new JPanel();
			btnSave = new JButton("Save");
			btnSave.setEnabled(false);
			btnCancel = new JButton("Cancel");
			btnCancel.setEnabled(false);

			rightPanel.add(btnSave);
			rightPanel.add(btnCancel);
			panel_btn = new JPanel(new BorderLayout());

			panel_btn.add(leftPanel, BorderLayout.WEST);
			panel_btn.add(rightPanel, BorderLayout.EAST);

			mecanicFrame.add(panel_btn, BorderLayout.PAGE_END);

			// panel for labels
			panel_lb = new JPanel();
			panel_lb.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
			panel_lb.setLayout(new BoxLayout(panel_lb, BoxLayout.Y_AXIS));
			panel_lb.setBackground(Color.black);
			// add labels
			lbNume = new JLabel("Nume");
			lbNume.setPreferredSize(new Dimension(100, 20));
			lbPrenume = new JLabel("Prenume");
			lbPrenume.setPreferredSize(new Dimension(100, 20));
			lbCnm = new JLabel("Cod Personal");
			lbCnm.setPreferredSize(new Dimension(100, 20));
			lbTelefon = new JLabel("Telefon");
			lbTelefon.setPreferredSize(new Dimension(100, 20));
			lbEmail = new JLabel("Email");
			lbEmail.setPreferredSize(new Dimension(100, 20));
			lbAdresa = new JLabel("Adresa");
			lbAdresa.setPreferredSize(new Dimension(100, 20));

			// add TextFields
			tfNume = new JTextField();
			tfNume.setPreferredSize(new Dimension(200, 20));
			tfPrenume = new JTextField();
			tfPrenume.setPreferredSize(new Dimension(200, 20));
			tfCnm = new JTextField();
			tfCnm.setPreferredSize(new Dimension(200, 20));
			tfTelefon = new JTextField();
			tfTelefon.setPreferredSize(new Dimension(200, 20));
			tfEmail = new JTextField();
			tfEmail.setPreferredSize(new Dimension(200, 20));
			tfAdresa = new JTextField();
			tfAdresa.setPreferredSize(new Dimension(200, 20));

			line = new JPanel(new FlowLayout());
			line.setBackground(Color.black);
			line.add(lbNume);
			line.add(tfNume);
			panel_lb.add(line);

			line = new JPanel(new FlowLayout());
			line.setBackground(Color.green);
			line.add(lbPrenume);
			line.add(tfPrenume);
			panel_lb.add(line);

			line = new JPanel(new FlowLayout());
			line.setBackground(Color.blue);
			line.add(lbCnm);
			line.add(tfCnm);
			panel_lb.add(line);

			line = new JPanel(new FlowLayout());
			line.setBackground(Color.cyan);
			line.add(lbTelefon);
			line.add(tfTelefon);
			panel_lb.add(line);

			line = new JPanel(new FlowLayout());
			line.setBackground(Color.darkGray);
			line.add(lbEmail);
			line.add(tfEmail);
			panel_lb.add(line);

			line = new JPanel(new FlowLayout());
			line.setBackground(Color.GRAY);
			line.add(lbAdresa);
			line.add(tfAdresa);
			panel_lb.add(line);
			panel_lb.setVisible(false);
			mecanicFrame.add(panel_lb, BorderLayout.CENTER);

			// panel for JTable
			panel_table = new JPanel(new BorderLayout());
			panel_table.setVisible(true);
			panel_table.setSize(new Dimension(300, 300));
			panel_table.setLocation(0, 0);
			panel_table.setBackground(Color.white);
			panel_table.setPreferredSize(new Dimension(300, 300));
			scrollPane = new JScrollPane(t);
			panel_table.add(scrollPane);
			mecanicFrame.add(panel_table, BorderLayout.PAGE_START);

			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel_lb.setVisible(true);
					btnCancel.setEnabled(true);
<<<<<<< HEAD
					mecanicFrame.pack();
=======
>>>>>>> ddc63eaf39d3b631d5daa822c71796a89dfae39b
				}
			});

		}

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_lb.setVisible(false);
				cancelText();
				btnCancel.setEnabled(false);
<<<<<<< HEAD
				mecanicFrame.pack();
=======
>>>>>>> ddc63eaf39d3b631d5daa822c71796a89dfae39b

			}
		});

		// adaugare date in DB
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MECANIC mec = new MECANIC();
<<<<<<< HEAD
				try{
=======
>>>>>>> ddc63eaf39d3b631d5daa822c71796a89dfae39b
				mec.setId_mecanic(null);
				mec.setNume(tfNume.getText());
				mec.setPrenume(tfPrenume.getText());
				mec.setCnm(tfCnm.getText());
				mec.setTelefon(Integer.valueOf(tfTelefon.getText().toString()));
				mec.setEmail(tfEmail.getText());
				mec.setAdresa(tfAdresa.getText());
<<<<<<< HEAD
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null,"Nu ati introdus corect datele"," Eroare", JOptionPane.OK_OPTION);
				}
=======

>>>>>>> ddc63eaf39d3b631d5daa822c71796a89dfae39b
				boolean status = Factory.getInstance().getMecanicDAO()
						.addMecanic(mec);
				tfStatus(status);

				/*
				 * ArrayList<MECANIC> mecanic = (ArrayList<MECANIC>)
				 * Factory.getInstance() .getMecanicDAO().getAllMecanic(); model
				 * = new TableModelMecanic(mecanic); t = new JTable(model);
				 * scrollPane = new JScrollPane(t); panel_table.add(scrollPane);
				 * mecanicFrame.add(panel_table,BorderLayout.PAGE_START);
				 */

			}
		});
<<<<<<< HEAD
		
		
        
		btnDelete.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
					
				Factory.getInstance().getMecanicDAO().deleteMecanic(mecanic.get(t.getSelectedRow()).getId_mecanic());
			}
		});
		
=======

>>>>>>> ddc63eaf39d3b631d5daa822c71796a89dfae39b
		// verific daca toate JTextField sunt completate atunci activez btnSave
		DocumentListener docListener = new DocumentListener() {

			public void removeUpdate(DocumentEvent arg0) {
				verify();
			}

			public void insertUpdate(DocumentEvent arg0) {
				verify();
			}

			public void changedUpdate(DocumentEvent arg0) {
				verify();
			}

			void verify() {
				if (tfNume.getText().equals("")
						|| tfPrenume.getText().equals("")
						|| tfCnm.getText().equals("")
						|| tfTelefon.getText().equals("")
						|| tfEmail.getText().equals("")
						|| tfAdresa.getText().equals("")) {
					btnSave.setEnabled(false);
				} else {
					btnSave.setEnabled(true);
				}
			}
		};

		tfNume.getDocument().addDocumentListener(docListener);
		tfPrenume.getDocument().addDocumentListener(docListener);
		tfCnm.getDocument().addDocumentListener(docListener);
		tfTelefon.getDocument().addDocumentListener(docListener);
		tfEmail.getDocument().addDocumentListener(docListener);
		tfAdresa.getDocument().addDocumentListener(docListener);

<<<<<<< HEAD
	mecanicFrame.pack();	
		return mecanicFrame;
	}
	
=======
		return mecanicFrame;
	}

>>>>>>> ddc63eaf39d3b631d5daa822c71796a89dfae39b
}
