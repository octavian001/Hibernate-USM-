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
import TModel.TableModelPiese;
import TModel.TableModelProprietar;

import com.service.auto.Factory;
import com.service.auto.MECANIC;
import com.service.auto.PIESE;
import com.service.auto.PROPRIETAR;

public class IFramePiese extends JFrame {

	private static final long serialVersionUID = 1L;
	static JInternalFrame pieseFrame = null;
	private static TableModelPiese model = null;
	private static JTable t = null;
	private static JScrollPane scrollPane = null;
	private static JPanel panel_btn = null;
	private static JPanel panel_lb = null;
	private static JPanel panel_table = null;
	private static JPanel line = null;
	private static JLabel lbDenumire = null;
	private static JLabel lbPret = null;
	private static JLabel lbCantitate = null;
	private static JButton btnAdd = null;
	private static JButton btnEdit = null;
	private static JButton btnDelete = null;
	private static JButton btnSave = null;
	private static JButton btnCancel = null;
	private static JButton btnUpdate = null;
	private static JButton btnRefresh = null;
	private static JTextField tfDenumire = null;
	private static JTextField tfPret = null;
	private static JTextField tfCantitate = null;
	private static PIESE p;
	private static ArrayList<PIESE> piese = null;
	private static JComboBox cbSearch = null;
	private static JButton btnSearch = null;
	private static JTextField tfSearch = null;
	private static JPanel panel_search = null;
	private static JPanel panel = null;

	// anuleaza textul din TextField daca s-au salvat datele in tabel
	public static boolean tfStatus(Boolean status) {
		if (status) {
			tfDenumire.setText("");
			tfPret.setText("");
			tfCantitate.setText("");
		}
		return status;
	}

	// anuleaza datele din TextField daca s-a apasat btnCancel
	public static void cancelText() {
		tfDenumire.setText("");
		tfPret.setText("");
		tfCantitate.setText("");
	}

	public static JInternalFrame getPieseFrame() {

		if (pieseFrame == null || pieseFrame.isClosed()) {

			pieseFrame = new JInternalFrame("PROPRIETAR", false, true, false,
					true);

			pieseFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			pieseFrame.setSize(900, 600);
			pieseFrame.setLocation(30, 20);
			pieseFrame.setVisible(true);

			piese = (ArrayList<PIESE>) Factory.getInstance().getPieseDAO()
					.getAllPIESE();

			model = new TableModelPiese(piese);
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

			pieseFrame.add(panel_btn, BorderLayout.PAGE_END);

			// panel for labels
			panel_lb = new JPanel();
			panel_lb.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
			panel_lb.setLayout(new BoxLayout(panel_lb, BoxLayout.Y_AXIS));
			panel_lb.setBackground(Color.black);
			// add labels
			lbDenumire = new JLabel("Denumire");
			lbDenumire.setPreferredSize(new Dimension(100, 20));
			lbPret = new JLabel("Pret");
			lbPret.setPreferredSize(new Dimension(100, 20));
			lbCantitate = new JLabel("Cantitate");
			lbCantitate.setPreferredSize(new Dimension(100, 20));

			// add TextFields
			tfDenumire = new JTextField();
			tfDenumire.setPreferredSize(new Dimension(200, 20));
			tfPret = new JTextField();
			tfPret.setPreferredSize(new Dimension(200, 20));
			tfCantitate = new JTextField();
			tfCantitate.setPreferredSize(new Dimension(200, 20));

			line = new JPanel(new FlowLayout());
			line.setBackground(Color.black);
			line.add(lbDenumire);
			line.add(tfDenumire);
			panel_lb.add(line);

			line = new JPanel(new FlowLayout());
			line.setBackground(Color.green);
			line.add(lbPret);
			line.add(tfPret);
			panel_lb.add(line);

			line = new JPanel(new FlowLayout());
			line.setBackground(Color.blue);
			line.add(lbCantitate);
			line.add(tfCantitate);
			panel_lb.add(line);

			panel_lb.setVisible(false);
			pieseFrame.add(panel_lb, BorderLayout.CENTER);

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

			String[] searchNameCol = { "---------", "Denumire", "Pret",
					"Cantitate" };
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

			pieseFrame.add(panel_table, BorderLayout.PAGE_START);

			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel_lb.setVisible(true);
					btnCancel.setEnabled(true);
					pieseFrame.pack();
				}
			});

		}

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_lb.setVisible(false);
				cancelText();
				btnCancel.setEnabled(false);
				btnUpdate.setEnabled(false);
				pieseFrame.pack();

			}
		});

		// adaugare date in DB
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Runnable r = new Runnable() {

					public void run() {
						PIESE p = new PIESE();
						try {
							p.setId_piesa(null);
							p.setDenumire(tfDenumire.getText());
							p.setPret(Integer.valueOf(tfPret.getText()
									.toString()));
							p.setCantitate(Integer.valueOf(tfCantitate
									.getText().toString()));
						} catch (NumberFormatException e) {
						}
						try {
							boolean status = Factory.getInstance()
									.getPieseDAO().addPiese(p);
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
				pieseFrame.pack();

			}
		});

		btnDelete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				Runnable r = new Runnable() {

					public void run() {
						try {
							if (Factory
									.getInstance()
									.getPieseDAO()
									.deletePiese(
											piese.get(t.getSelectedRow())
													.getId_piesa())) {
								// sterge rindul din JTable
								piese.remove(piese.get(t.getSelectedRow()));
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
				pieseFrame.pack();
			}

		});

		btnEdit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				try {
					p = piese.get(t.getSelectedRow());
					tfDenumire.setText(p.getDenumire());
					tfPret.setText(String.valueOf(p.getPret().toString()));
					tfCantitate.setText(String.valueOf(p.getCantitate()
							.toString()));

					panel_lb.setVisible(true);
					btnUpdate.setEnabled(true);
					btnCancel.setEnabled(true);
					pieseFrame.pack();

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
									.getPieseDAO()
									.updatePiese(
											p.getId_piesa(),
											tfDenumire.getText(),
											Integer.valueOf(tfPret.getText()
													.toString()),
											Integer.valueOf(tfCantitate
													.getText().toString()));
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
							piese = (ArrayList<PIESE>) Factory.getInstance()
									.getPieseDAO()
									.searchByDenumire(tfSearch.getText());
							model = new TableModelPiese(piese);
							t.setModel(model);
							((AbstractTableModel) t.getModel())
									.fireTableDataChanged();
							t.repaint();

						}
					};

					(new Thread(r)).start();
					pieseFrame.pack();

					break;

				case 2:
					r = new Runnable() {

						public void run() {
							piese = (ArrayList<PIESE>) Factory
									.getInstance()
									.getPieseDAO()
									.searchByPret(
											Integer.valueOf(Integer
													.valueOf(tfSearch.getText())));
							model = new TableModelPiese(piese);
							t.setModel(model);
							((AbstractTableModel) t.getModel())
									.fireTableDataChanged();
							t.repaint();

						}
					};

					(new Thread(r)).start();
					pieseFrame.pack();
					break;
				case 3:

					r = new Runnable() {

						public void run() {
							piese = (ArrayList<PIESE>) Factory
									.getInstance()
									.getPieseDAO()
									.searchByCantitate(
											Integer.valueOf(Integer
													.valueOf(tfSearch.getText())));
							model = new TableModelPiese(piese);
							t.setModel(model);
							((AbstractTableModel) t.getModel())
									.fireTableDataChanged();
							t.repaint();

						}
					};
					(new Thread(r)).start();
					pieseFrame.pack();
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
						piese = (ArrayList<PIESE>) Factory.getInstance()
								.getPieseDAO().getAllPIESE();

						model = new TableModelPiese(piese);
						t.setModel(model);

					}
				};
				(new Thread(r)).start();
				pieseFrame.pack();

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
				if (tfDenumire.getText().equals("")
						|| tfPret.getText().equals("")
						|| tfCantitate.getText().equals("")) {
					btnSave.setEnabled(false);
					btnUpdate.setEnabled(false);
				} else {
					btnSave.setEnabled(true);
					btnUpdate.setEnabled(true);
				}
			}
		};

		tfDenumire.getDocument().addDocumentListener(docListener);
		tfPret.getDocument().addDocumentListener(docListener);
		tfCantitate.getDocument().addDocumentListener(docListener);

		pieseFrame.pack();
		return pieseFrame;
	}

}
