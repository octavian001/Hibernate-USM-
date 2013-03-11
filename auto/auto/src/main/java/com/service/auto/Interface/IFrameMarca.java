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

import TModel.TableModelMarca;
import TModel.TableModelMecanic;
import TModel.TableModelPiese;
import TModel.TableModelProprietar;

import com.service.auto.Factory;
import com.service.auto.MARCA;
import com.service.auto.MECANIC;
import com.service.auto.PIESE;
import com.service.auto.PROPRIETAR;

public class IFrameMarca extends JFrame {

	private static final long serialVersionUID = 1L;
	static JInternalFrame marcaFrame = null;
	private static TableModelMarca model = null;
	private static JTable t = null;
	private static JScrollPane scrollPane = null;
	private static JPanel panel_btn = null;
	private static JPanel panel_lb = null;
	private static JPanel panel_table = null;
	private static JPanel line = null;
	private static JLabel lbDen_marca = null;
	private static JButton btnAdd = null;
	private static JButton btnEdit = null;
	private static JButton btnDelete = null;
	private static JButton btnSave = null;
	private static JButton btnCancel = null;
	private static JButton btnUpdate = null;
	private static JButton btnRefresh = null;
	private static JTextField tfDen_marca = null;
	private static MARCA m;
	private static ArrayList<MARCA> marca = null;
	private static JComboBox cbSearch = null;
	private static JButton btnSearch = null;
	private static JTextField tfSearch = null;
	private static JPanel panel_search = null;
	private static JPanel panel = null;

	// anuleaza textul din TextField daca s-au salvat datele in tabel
	public static boolean tfStatus(Boolean status) {
		if (status) {
			tfDen_marca.setText("");
		}
		return status;
	}

	// anuleaza datele din TextField daca s-a apasat btnCancel
	public static void cancelText() {
		tfDen_marca.setText("");
		}

	public static JInternalFrame getMarcaFrame() {

		if (marcaFrame== null || marcaFrame.isClosed()) {

			marcaFrame = new JInternalFrame("PROPRIETAR", false, true, false,
					true);

			marcaFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			marcaFrame.setSize(900, 600);
			marcaFrame.setLocation(30, 20);
			marcaFrame.setVisible(true);

			marca = (ArrayList<MARCA>) Factory.getInstance().getMarcaDAO()
					.getAllMarca();

			model = new TableModelMarca(marca);
			t = new JTable(model);

			// panel for buttons
			JPanel leftPanel = new JPanel();
			btnAdd = new JButton("Adaugare");
			btnEdit = new JButton("Editare");
			leftPanel.add(btnAdd);
			leftPanel.add(btnEdit);

			JPanel rightPanel = new JPanel();
			btnDelete = new JButton("Stergere");
			rightPanel.add(btnDelete);
			btnSave = new JButton("Salvare");
			btnSave.setEnabled(false);
			btnCancel = new JButton("Anulare");
			btnCancel.setEnabled(false);
			btnUpdate = new JButton("Reinoire");
			btnUpdate.setEnabled(false);
			rightPanel.add(btnUpdate);

			rightPanel.add(btnSave);
			rightPanel.add(btnCancel);
			panel_btn = new JPanel(new BorderLayout());

			panel_btn.add(leftPanel, BorderLayout.WEST);
			panel_btn.add(rightPanel, BorderLayout.EAST);

			marcaFrame.add(panel_btn, BorderLayout.PAGE_END);

			// panel for labels
			panel_lb = new JPanel();
			panel_lb.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
			panel_lb.setLayout(new BoxLayout(panel_lb, BoxLayout.Y_AXIS));
			//panel_lb.setBackground(Color.black);
			// add labels
			lbDen_marca = new JLabel("Denumire");
			lbDen_marca.setPreferredSize(new Dimension(100, 20));
			
			// add TextFields
			tfDen_marca = new JTextField();
			tfDen_marca.setPreferredSize(new Dimension(200, 20));
			
			line = new JPanel(new FlowLayout());
			//line.setBackground(Color.black);
			line.add(lbDen_marca);
			line.add(tfDen_marca);
			panel_lb.add(line);

			panel_lb.setVisible(false);
			marcaFrame.add(panel_lb, BorderLayout.CENTER);

			// panel for JTable
			panel_table = new JPanel(new BorderLayout());
			panel_table.setVisible(true);
			panel_table.setSize(new Dimension(300, 300));
			panel_table.setLocation(0, 0);
			//panel_table.setBackground(Color.white);
			panel_table.setPreferredSize(new Dimension(300, 300));
			scrollPane = new JScrollPane(t);

			btnRefresh = new JButton("Actualizare");
			btnRefresh.setPreferredSize(new Dimension(100, 20));
			// btnRefresh.setAlignmentX(btnRefresh.RIGHT_ALIGNMENT);

			JPanel panel_refresh = new JPanel(new BorderLayout());
			panel_refresh.add(btnRefresh, BorderLayout.EAST);
			panel_table.add(panel_refresh, BorderLayout.PAGE_END);
			panel_table.add(scrollPane, BorderLayout.CENTER);

			String[] searchNameCol = { "---------", "Denumire marca" };
			cbSearch = new JComboBox(searchNameCol);
			cbSearch.setPreferredSize(new Dimension(100, 20));

			btnSearch = new JButton("Cautare");
			// btnSearch.setPreferredSize(new Dimension(100, 20));

			tfSearch = new JTextField();
			tfSearch.setPreferredSize(new Dimension(100, 20));
			panel_search = new JPanel(new FlowLayout(FlowLayout.RIGHT));

			panel_search.add(tfSearch);
			panel_search.add(cbSearch);
			panel_search.add(btnSearch);

			panel = new JPanel(new BorderLayout());
			panel.add(panel_search, BorderLayout.CENTER);

			panel_table.add(panel, BorderLayout.PAGE_START);

			marcaFrame.add(panel_table, BorderLayout.PAGE_START);

			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel_lb.setVisible(true);
					btnCancel.setEnabled(true);
					marcaFrame.pack();
				}
			});

		}

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_lb.setVisible(false);
				cancelText();
				btnCancel.setEnabled(false);
				btnUpdate.setEnabled(false);
				marcaFrame.pack();

			}
		});

		// adaugare date in DB
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Runnable r = new Runnable() {

					public void run() {
						MARCA m = new MARCA();
						try {
							m.setId_marca(null);
							m.setDen_marca(tfDen_marca.getText());
							} catch (NumberFormatException e) {
						}
						try {
							boolean status = Factory.getInstance()
									.getMarcaDAO().addMarca(m);
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
				marcaFrame.pack();

			}
		});

		btnDelete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				Runnable r = new Runnable() {

					public void run() {
						try {
							if (Factory
									.getInstance()
									.getMarcaDAO()
									.deleteMarca(
											marca.get(t.getSelectedRow())
													.getId_marca())) {
								// sterge rindul din JTable
								marca.remove(marca.get(t.getSelectedRow()));
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
				marcaFrame.pack();
			}

		});

		btnEdit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
			   Runnable r = new Runnable() {
				
				public void run() {
					
					
				}
			};
				try {
					m = marca.get(t.getSelectedRow());
					tfDen_marca.setText(m.getDen_marca());
					
					panel_lb.setVisible(true);
					btnUpdate.setEnabled(true);
					btnCancel.setEnabled(true);
					marcaFrame.pack();

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
									.getMarcaDAO()
									.updateMarca(
											m.getId_marca(),
											tfDen_marca.getText());
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
							marca = (ArrayList<MARCA>) Factory.getInstance()
									.getMarcaDAO()
									.searchByDen_marca(tfSearch.getText());
							model = new TableModelMarca(marca);
							t.setModel(model);
							((AbstractTableModel) t.getModel())
									.fireTableDataChanged();
							t.repaint();

						}
					};

					(new Thread(r)).start();
					marcaFrame.pack();

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
						marca = (ArrayList<MARCA>) Factory.getInstance()
								.getMarcaDAO().getAllMarca();

						model = new TableModelMarca(marca);
						t.setModel(model);
					}
				};
				(new Thread(r)).start();
				marcaFrame.pack();
				

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
				if (tfDen_marca.getText().equals("")) {
					btnSave.setEnabled(false);
					btnUpdate.setEnabled(false);
				} else {
					btnSave.setEnabled(true);
					btnUpdate.setEnabled(true);
				}
			}
		};

		tfDen_marca.getDocument().addDocumentListener(docListener);
		marcaFrame.pack();
		return marcaFrame;
	}

}
