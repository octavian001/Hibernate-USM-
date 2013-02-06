package com.service.auto.Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;

import TModel.TableModelMecanic;

import com.service.auto.Factory;
import com.service.auto.MECANIC;

public class IFrameMecanic extends JFrame {

	private static final long serialVersionUID = 1L;

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

	private static ArrayList<MECANIC> mecanic = null;

	public static JInternalFrame getMecanicFrame() {

		if (mecanicFrame == null) {
			mecanicFrame = new JInternalFrame("MECANIC", false, true, false,
					true);
			mecanicFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			mecanicFrame.setSize(900, 600);
			mecanicFrame.setLocation(30, 20);
			mecanicFrame.setVisible(true);

			mecanic = (ArrayList<MECANIC>) Factory.getInstance()
					.getMecanicDAO().getAllMecanic();

			model = new TableModelMecanic(mecanic);
			t = new JTable(model);

			// panel for buttons
			JPanel leftPanel = new JPanel();
			btnAdd = new JButton("Add");
			btnEdit = new JButton("Edit");
			leftPanel.add(btnAdd);
			leftPanel.add(btnEdit);

			JPanel rightPanel = new JPanel();
			btnDelete = new JButton("Delete");
			rightPanel.add(btnDelete);
			btnSave = new JButton("Save");
			btnSave.setEnabled(false);
			btnCancel = new JButton("Cancel");
			btnCancel.setEnabled(false);

			JButton btnUpdate = new JButton("Update");
			rightPanel.add(btnUpdate);

			btnUpdate.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {

					try {

						Factory.getInstance()
								.getMecanicDAO()
								.updateMecanic(
										mec.getId_mecanic(),
										tfNume.getText(),
										tfPrenume.getText(),
										tfCnm.getText(),
										Integer.valueOf(tfTelefon.getText()
												.toString()),
										tfEmail.getText(), tfAdresa.getText());
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null,
								"Nu ati introdus corect datele", " Eroare",
								JOptionPane.OK_OPTION);
						e.printStackTrace();
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Eroare! ",
								" Eroare", JOptionPane.OK_OPTION);
					}
				}
			});

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
					mecanicFrame.pack();
				}
			});

		}

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_lb.setVisible(false);
				cancelText();
				btnCancel.setEnabled(false);
				mecanicFrame.pack();

			}
		});

		// adaugare date in DB
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MECANIC mec = new MECANIC();
				try {
					mec.setId_mecanic(null);
					mec.setNume(tfNume.getText());
					mec.setPrenume(tfPrenume.getText());
					mec.setCnm(tfCnm.getText());
					mec.setTelefon(Integer.valueOf(tfTelefon.getText()
							.toString()));
					mec.setEmail(tfEmail.getText());
					mec.setAdresa(tfAdresa.getText());
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null,
							"Nu ati introdus corect datele", " Eroare",
							JOptionPane.OK_OPTION);
				}
				boolean status = Factory.getInstance().getMecanicDAO()
						.addMecanic(mec);
				tfStatus(status);

				mecanicFrame.pack();

			}
		});

		btnDelete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				Factory.getInstance()
						.getMecanicDAO()
						.deleteMecanic(
								mecanic.get(t.getSelectedRow()).getId_mecanic());

				// sterge rindul din JTable
				mecanic.remove(mecanic.get(t.getSelectedRow()));
				((AbstractTableModel) t.getModel()).fireTableDataChanged();
				t.repaint();
				mecanicFrame.pack();

			}
		});

		btnEdit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				try {
					mec = mecanic.get(t.getSelectedRow());
					tfNume.setText(mec.getNume());
					tfPrenume.setText(mec.getPrenume());
					tfCnm.setText(mec.getCnm());
					tfTelefon.setText(String.valueOf(mec.getTelefon()
							.toString()));
					tfEmail.setText(mec.getEmail());
					tfAdresa.setText(mec.getAdresa());

					panel_lb.setVisible(true);
					btnCancel.setEnabled(true);
				} catch (ArrayIndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(null,
							"Nu ati selectat rindul", " Eroare",
							JOptionPane.OK_OPTION);
				}

			}

		});

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

		mecanicFrame.pack();
		return mecanicFrame;
	}
}
