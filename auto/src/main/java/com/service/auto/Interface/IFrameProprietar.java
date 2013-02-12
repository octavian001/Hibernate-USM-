package com.service.auto.Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.HTMLDocument.Iterator;

import TModel.TableModelMecanic;
import TModel.TableModelProprietar;

import com.service.auto.Factory;
import com.service.auto.MECANIC;
import com.service.auto.PROPRIETAR;

public class IFrameProprietar extends JFrame {

	private static final long serialVersionUID = 1L;
	static JInternalFrame proprietarFrame = null;
	private static TableModelProprietar model = null;
	private static JTable t = null;
	private static JScrollPane scrollPane = null;
	private static JPanel panel_btn = null;
	private static JPanel panel_lb = null;
	private static JPanel panel_table = null;
	private static JPanel line = null;
	private static JLabel lbNume = null;
	private static JLabel lbPrenume = null;
	private static JLabel lbCnp = null;
	private static JLabel lbTelefon = null;
	private static JLabel lbAdresa = null;
	private static JButton btnAdd = null;
	private static JButton btnEdit = null;
	private static JButton btnDelete = null;
	private static JButton btnSave = null;
	private static JButton btnCancel = null;
	private static JButton btnUpdate = null;
	private static JButton btnRefresh = null;
	private static JTextField tfNume = null;
	private static JTextField tfPrenume = null;
	private static JTextField tfCnp = null;
	private static JTextField tfTelefon = null;
	private static JTextField tfAdresa = null;
	private static PROPRIETAR propr;
	private static ArrayList<PROPRIETAR> proprietar = null;
	private static JComboBox cbSearch = null;
	private static JButton btnSearch = null;
	private static JTextField tfSearch = null;
	private static JPanel panel_search = null;
	private static JPanel panel = null;

	// anuleaza textul din TextField daca s-au salvat datele in tabel
	public static boolean tfStatus(Boolean status) {
		if (status) {
			tfNume.setText("");
			tfPrenume.setText("");
			tfCnp.setText("");
			tfTelefon.setText("");
			tfAdresa.setText("");
		}
		return status;
	}

	// anuleaza datele din TextField daca s-a apasat btnCancel
	public static void cancelText() {
		tfNume.setText("");
		tfPrenume.setText("");
		tfCnp.setText("");
		tfTelefon.setText("");
		tfAdresa.setText("");
	}

	public static JInternalFrame getProprietarFrame() {

		if (proprietarFrame == null || proprietarFrame.isClosed()) {

			proprietarFrame = new JInternalFrame("PROPRIETAR", false, true, false,
					true);

			proprietarFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			proprietarFrame.setSize(900, 600);
			proprietarFrame.setLocation(30, 20);
			proprietarFrame.setVisible(true);

			proprietar = (ArrayList<PROPRIETAR>) Factory.getInstance()
					.getProprietarDAO().getAllProprietar();

			model = new TableModelProprietar(proprietar);
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
			btnUpdate = new JButton("Update");
			btnUpdate.setEnabled(false);
			rightPanel.add(btnUpdate);

			rightPanel.add(btnSave);
			rightPanel.add(btnCancel);
			panel_btn = new JPanel(new BorderLayout());

			panel_btn.add(leftPanel, BorderLayout.WEST);
			panel_btn.add(rightPanel, BorderLayout.EAST);

			proprietarFrame.add(panel_btn, BorderLayout.PAGE_END);

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
			lbCnp = new JLabel("Cod Personal");
			lbCnp.setPreferredSize(new Dimension(100, 20));
			lbTelefon = new JLabel("Telefon");
			lbTelefon.setPreferredSize(new Dimension(100, 20));
			lbAdresa = new JLabel("Adresa");
			lbAdresa.setPreferredSize(new Dimension(100, 20));

			// add TextFields
			tfNume = new JTextField();
			tfNume.setPreferredSize(new Dimension(200, 20));
			tfPrenume = new JTextField();
			tfPrenume.setPreferredSize(new Dimension(200, 20));
			tfCnp = new JTextField();
			tfCnp.setPreferredSize(new Dimension(200, 20));
			tfTelefon = new JTextField();
			tfTelefon.setPreferredSize(new Dimension(200, 20));
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
			line.add(lbCnp);
			line.add(tfCnp);
			panel_lb.add(line);

			line = new JPanel(new FlowLayout());
			line.setBackground(Color.cyan);
			line.add(lbTelefon);
			line.add(tfTelefon);
			panel_lb.add(line);

			line = new JPanel(new FlowLayout());
			line.setBackground(Color.GRAY);
			line.add(lbAdresa);
			line.add(tfAdresa);
			panel_lb.add(line);
			panel_lb.setVisible(false);
			proprietarFrame.add(panel_lb, BorderLayout.CENTER);

			// panel for JTable
			panel_table = new JPanel(new BorderLayout());
			panel_table.setVisible(true);
			panel_table.setSize(new Dimension(300, 300));
			panel_table.setLocation(0, 0);
			panel_table.setBackground(Color.white);
			panel_table.setPreferredSize(new Dimension(300, 300));
			scrollPane = new JScrollPane(t);

			btnRefresh = new JButton("Refresh");
			btnRefresh.setPreferredSize(new Dimension(100, 25));
			// btnRefresh.setAlignmentX(btnRefresh.RIGHT_ALIGNMENT);

			JPanel panel_refresh = new JPanel(new BorderLayout());
			panel_refresh.add(btnRefresh, BorderLayout.EAST);
			panel_table.add(panel_refresh, BorderLayout.PAGE_END);
			panel_table.add(scrollPane, BorderLayout.CENTER);

			String[] searchNameCol = { "---------", "Nume", "Prenume",
					"Cod Personal", "Telefon", "Adresa" };
			cbSearch = new JComboBox(searchNameCol);
			cbSearch.setPreferredSize(new Dimension(100, 20));

			btnSearch = new JButton("Search");
			// btnSearch.setPreferredSize(new Dimension(100, 20));

			tfSearch = new JTextField();
			tfSearch.setPreferredSize(new Dimension(100, 20));
			panel_search = new JPanel();

			panel_search.add(tfSearch);
			panel_search.add(cbSearch);
			panel_search.add(btnSearch);

			panel = new JPanel(new BorderLayout());
			panel.add(panel_search, BorderLayout.CENTER);

			panel_table.add(panel, BorderLayout.PAGE_START);

			proprietarFrame.add(panel_table, BorderLayout.PAGE_START);

			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel_lb.setVisible(true);
					btnCancel.setEnabled(true);
					proprietarFrame.pack();
				}
			});

		}

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_lb.setVisible(false);
				cancelText();
				btnCancel.setEnabled(false);
				btnUpdate.setEnabled(false);
				proprietarFrame.pack();

			}
		});

		// adaugare date in DB
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Runnable r = new Runnable() {

					public void run() {
						PROPRIETAR prop = new PROPRIETAR();
						try {
							prop.setId_proprietar(null);
						    prop.setNume(tfNume.getText());
							prop.setPrenume(tfPrenume.getText());
							prop.setCnp(tfCnp.getText());
							prop.setTelefon(Integer.valueOf(tfTelefon.getText()
									.toString()));
							prop.setAdresa(tfAdresa.getText());
						} catch (NumberFormatException e) {
						   }
						try {
							boolean status = Factory.getInstance()
									.getProprietarDAO().addProprietar(prop);
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
				proprietarFrame.pack();

			}
		});

		btnDelete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				Runnable r = new Runnable() {

					public void run() {
						try {
							if (Factory
									.getInstance()
									.getProprietarDAO()
									.deleteProprietar(
											proprietar.get(t.getSelectedRow())
													.getId_proprietar())) {
								// sterge rindul din JTable
								proprietar.remove(proprietar.get(t.getSelectedRow()));
								((AbstractTableModel) t.getModel())
										.fireTableDataChanged();
								t.repaint();
							}
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null,
									"Selectati un rind!", " Eroare",
									JOptionPane.OK_OPTION);
						}

					}
				};
				(new Thread(r)).start();
				proprietarFrame.pack();
			}

		});

		btnEdit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				try {
					propr = proprietar.get(t.getSelectedRow());
					tfNume.setText(propr.getNume());
					tfPrenume.setText(propr.getPrenume());
					tfCnp.setText(propr.getCnp());
					tfTelefon.setText(String.valueOf(propr.getTelefon()
							.toString()));
					tfAdresa.setText(propr.getAdresa());

					panel_lb.setVisible(true);
					btnUpdate.setEnabled(true);
					btnCancel.setEnabled(true);
					proprietarFrame.pack();

				} catch (ArrayIndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(null,
							"Nu ati selectat rindul", " Eroare",
							JOptionPane.OK_OPTION);
				}

			}

		});
		btnUpdate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				Runnable r = new Runnable() {

					public void run() {
						boolean status = false;
						try {

							status = Factory
									.getInstance()
									.getProprietarDAO()
									.updateProprietar(
											propr.getId_proprietar(),
											tfNume.getText(),
											tfPrenume.getText(),
											tfCnp.getText(),
											Integer.valueOf(tfTelefon.getText()
													.toString()),
											tfAdresa.getText());
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(null,
									"Nu ati introdus corect datele", " Eroare",
									JOptionPane.OK_OPTION);
							e.printStackTrace();
						} catch (SQLException e) {
							JOptionPane.showMessageDialog(null, "Eroare! ",
									" Eroare", JOptionPane.OK_OPTION);
						}
						tfStatus(status);

					}
				};
				(new Thread(r)).start();
			}
		});

		btnSearch.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				switch (cbSearch.getSelectedIndex()) {
				case 0:
					JOptionPane.showMessageDialog(null,
							"Selectati dupa ce cimp doriti sa cautati datele",
							" Eroare", JOptionPane.OK_OPTION);
					break;
				case 1:
					Runnable r = new Runnable() {

						public void run() {
							proprietar = (ArrayList<PROPRIETAR>) Factory
									.getInstance().getProprietarDAO()
									.searchByNume(tfSearch.getText());
							model = new TableModelProprietar(proprietar);
							t.setModel(model);

						}
					};

					(new Thread(r)).start();
					proprietarFrame.pack();

					break;
				case 2:
					r = new Runnable() {

						public void run() {
							proprietar = (ArrayList<PROPRIETAR>) Factory
									.getInstance().getProprietarDAO()
									.searchByPrenume(tfSearch.getText());
							model = new TableModelProprietar(proprietar);
							t.setModel(model);

						}
					};
					(new Thread(r)).start();
					proprietarFrame.pack();

					break;
				case 3:
					r = new Runnable() {

						public void run() {
							proprietar = (ArrayList<PROPRIETAR>) Factory
									.getInstance().getProprietarDAO()
									.searchByCnp(tfSearch.getText());
							model = new TableModelProprietar(proprietar);
							t.setModel(model);
						}
					};
					(new Thread(r)).start();
					proprietarFrame.pack();

					break;
				case 4:
					r = new Runnable() {

						public void run() {
							proprietar = (ArrayList<PROPRIETAR>) Factory
									.getInstance()
									.getProprietarDAO()
									.searchByTelefon(
											Integer.valueOf(Integer
													.valueOf(tfSearch.getText())));
							model = new TableModelProprietar(proprietar);
							t.setModel(model);
						}
					};

					(new Thread(r)).start();
						proprietarFrame.pack();

					break;
				case 5:

					r = new Runnable() {

						public void run() {
							proprietar = (ArrayList<PROPRIETAR>) Factory
									.getInstance().getProprietarDAO()
									.searchByAdresa(tfSearch.getText());
							model = new TableModelProprietar(proprietar);
							t.setModel(model);

						}
					};
					(new Thread(r)).start();
					proprietarFrame.pack();

					break;
								default:
					break;
				}

			}
		});

		// reinoirea datelor
		btnRefresh.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				Runnable r = new Runnable() {

					public void run() {
						proprietar = (ArrayList<PROPRIETAR>) Factory.getInstance()
								.getProprietarDAO().getAllProprietar();

						model = new TableModelProprietar(proprietar);
						t.setModel(model);

					}
				};
				(new Thread(r)).start();
				proprietarFrame.pack();

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
						|| tfCnp.getText().equals("")
						|| tfTelefon.getText().equals("")
						||  tfAdresa.getText().equals("")) {
					btnSave.setEnabled(false);
					btnUpdate.setEnabled(false);
				} else {
					btnSave.setEnabled(true);
					btnUpdate.setEnabled(true);
				}
			}
		};

		tfNume.getDocument().addDocumentListener(docListener);
		tfPrenume.getDocument().addDocumentListener(docListener);
		tfCnp.getDocument().addDocumentListener(docListener);
		tfTelefon.getDocument().addDocumentListener(docListener);
		tfAdresa.getDocument().addDocumentListener(docListener);

		proprietarFrame.pack();
		return proprietarFrame;
	}

}
