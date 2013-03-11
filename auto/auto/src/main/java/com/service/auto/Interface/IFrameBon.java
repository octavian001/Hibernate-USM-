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
import java.util.List;

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


import TModel.TableModelAuto;
import TModel.TableModelBon;
import TModel.TableModelMecanic;

import com.service.auto.AUTO;
import com.service.auto.BON;
import com.service.auto.Factory;
import com.service.auto.MARCA;
import com.service.auto.MECANIC;
import com.service.auto.MODEL;
import com.service.auto.PROPRIETAR;

public class IFrameBon extends JFrame {

	private static final long serialVersionUID = 1L;
	static JInternalFrame bonFrame = null;
	private static TableModelBon model = null;
	private static JTable t = null;
	private static JScrollPane scrollPane = null;
	private static JPanel panel_btn = null;
	private static JPanel panel_lb = null;
	private static JPanel panel_table = null;
	private static JPanel line = null;
	private static JLabel lbData = null;
	private static JLabel lbPret = null;
	private static JLabel lbNrInm = null;
	private static JLabel lbMecanic = null;

	//private static JButton btnAdd = null;
	private static JButton btnEdit = null;
	private static JButton btnDelete = null;
	//private static JButton btnSave = null;
	private static JButton btnCancel = null;
	private static JButton btnUpdate = null;
	private static JButton btnRefresh = null;
	private static JTextField tfData = null;
	private static JTextField tfPret = null;
	
	private static JComboBox cbNrInm = null;
	private static JComboBox cbMecanic = null;

	private static BON b;
	private static ArrayList<BON> bon = null;
	private static JComboBox cbSearch = null;
	private static JButton btnSearch = null;
	private static JTextField tfSearch = null;
	private static JPanel panel_search = null;
	private static JPanel panel = null;

	private static ArrayList<MECANIC> mecanic = null;
	private static MECANIC mec = null;

	private static ArrayList<AUTO> auto = null;
	private static AUTO a = null;

	private static JLabel lbMarca1;
	private static JComboBox cbMarca1;

	public static void comboboxLoad() {

		java.util.Iterator<AUTO> iter = auto.iterator();
		while (iter.hasNext()) {
			a = (AUTO) iter.next();
			cbNrInm.addItem(a.getNr_inmatr());
		}

		

		java.util.Iterator<MECANIC> iterator1 = mecanic.iterator();
		while (iterator1.hasNext()) {
			mec = (MECANIC) iterator1.next();
			cbMecanic.addItem(mec.getNume() + " " + mec.getPrenume() + "(" + mec.getCnm() + ")");
		}

	}

	// anuleaza textul din TextField daca s-au salvat datele in tabel
	public static boolean tfStatus(Boolean status) {
		if (status) {
			tfData.setText("");
			tfPret.setText("");
			
		}
		return status;
	}

	// anuleaza datele din TextField daca s-a apasat btnCancel
	public static void cancelText() {
		tfData.setText("");
		tfPret.setText("");
		
	}

	public static JInternalFrame getBonFrame() {

		if (bonFrame == null || bonFrame.isClosed()) {

			bonFrame = new JInternalFrame("BON", false, true, false, true);

			bonFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			bonFrame.setSize(900, 600);
			bonFrame.setLocation(30, 20);
			bonFrame.setVisible(true);

			auto = (ArrayList<AUTO>) Factory.getInstance().getAutoDAO()
					.getAllAuto();

			mecanic = (ArrayList<MECANIC>) Factory.getInstance().getMecanicDAO()
					.getAllMecanic();

			bon = (ArrayList<BON>) Factory.getInstance()
					.getBonDAO().getAllBon();

			
			model = new TableModelBon(bon);
			t = new JTable(model);
			// panel for buttons
			JPanel leftPanel = new JPanel();
			//btnAdd = new JButton("Adaugare");
			btnEdit = new JButton("Editare");
			//leftPanel.add(btnAdd);
			leftPanel.add(btnEdit);

			JPanel rightPanel = new JPanel();
			btnDelete = new JButton("Stergere");
			rightPanel.add(btnDelete);
			//btnSave = new JButton(" Salvare ");
			//btnSave.setEnabled(false);
			btnCancel = new JButton("Anulare");
			btnCancel.setEnabled(false);
			btnUpdate = new JButton("Reinoire");
			btnUpdate.setEnabled(false);

			rightPanel.add(btnUpdate);

			//rightPanel.add(btnSave);
			rightPanel.add(btnCancel);
			panel_btn = new JPanel(new BorderLayout());

			panel_btn.add(leftPanel, BorderLayout.WEST);
			panel_btn.add(rightPanel, BorderLayout.EAST);

			bonFrame.add(panel_btn, BorderLayout.PAGE_END);

			// panel for labels
			panel_lb = new JPanel();
			panel_lb.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
			panel_lb.setLayout(new BoxLayout(panel_lb, BoxLayout.Y_AXIS));
			// panel_lb.setBackground(Color.black);
			// add labels
			lbData = new JLabel("Data elib. bon");
			lbData.setPreferredSize(new Dimension(100, 20));
			lbPret = new JLabel("Pret");
			lbPret.setPreferredSize(new Dimension(100, 20));
			lbNrInm = new JLabel("Numar inmatriculare");
			lbNrInm.setPreferredSize(new Dimension(100, 20));
			lbMecanic = new JLabel("Mecanic");
			lbMecanic.setPreferredSize(new Dimension(100, 20));

			// add TextFields
			tfData = new JTextField();
			tfData.setPreferredSize(new Dimension(200, 20));
			tfPret = new JTextField();
			tfPret.setEnabled(false);
			tfPret.setPreferredSize(new Dimension(200, 20));
			cbNrInm = new JComboBox();
			cbNrInm.setPreferredSize(new Dimension(200, 20));
			cbMecanic = new JComboBox();
			cbMecanic.setPreferredSize(new Dimension(200, 20));
			
			line = new JPanel(new FlowLayout());
			// line.setBackground(Color.black);
			line.add(lbData);
			line.add(tfData);
			panel_lb.add(line);

			line = new JPanel(new FlowLayout());
			// line.setBackground(Color.green);
			line.add(lbPret);
			line.add(tfPret);
			panel_lb.add(line);

			line = new JPanel(new FlowLayout());
			// line.setBackground(Color.blue);
			line.add(lbNrInm);
			line.add(cbNrInm);
			panel_lb.add(line);

			line = new JPanel(new FlowLayout());
			line.add(lbMecanic);
			line.add(cbMecanic);

			panel_lb.add(line);
			panel_lb.add(line);
			panel_lb.setVisible(false);
			bonFrame.add(panel_lb, BorderLayout.CENTER);

			// panel for JTable
			panel_table = new JPanel(new BorderLayout());
			panel_table.setVisible(true);
			panel_table.setSize(new Dimension(300, 300));
			panel_table.setLocation(0, 0);
			// panel_table.setBackground(Color.white);
			panel_table.setPreferredSize(new Dimension(300, 300));
			scrollPane = new JScrollPane(t);

			btnRefresh = new JButton("Actualizare");
			btnRefresh.setPreferredSize(new Dimension(100, 25));
			// btnRefresh.setAlignmentX(btnRefresh.RIGHT_ALIGNMENT);

			JPanel panel_refresh = new JPanel(new BorderLayout());
			panel_refresh.add(btnRefresh, BorderLayout.EAST);
			panel_table.add(panel_refresh, BorderLayout.PAGE_END);
			panel_table.add(scrollPane, BorderLayout.CENTER);

			comboboxLoad();

			String[] searchNameCol = { "---------", "Data elib. bon",
					"Pret total" };

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

			bonFrame.add(panel_table, BorderLayout.PAGE_START);


		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_lb.setVisible(false);
				cancelText();
				btnCancel.setEnabled(false);
				btnUpdate.setEnabled(false);
				bonFrame.pack();

			}
		});

		btnDelete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				Runnable r = new Runnable() {

					public void run() {
						try {
							if (Factory
									.getInstance()
									.getBonDAO()
									.deleteBon(
											bon.get(t.getSelectedRow())
													.getId_bon())) {
								// sterge rindul din JTable
								bon.remove(bon.get(t.getSelectedRow()));
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
				bonFrame.pack();
			}

		});

		btnEdit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				try {
					b = bon.get(t.getSelectedRow());
					tfData.setText(b.getData_bon().toString());
					tfPret.setText(Integer.valueOf(b.getPret_total()).toString());
					cbNrInm.setSelectedItem(b.getId_auto().getNr_inmatr());
					cbMecanic.setSelectedItem(b.getId_mecanic().getCnm());
					
					panel_lb.setVisible(true);
					btnUpdate.setEnabled(true);
					btnCancel.setEnabled(true);
					bonFrame.pack();

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
									.getBonDAO()
									.updateBonHalf(
											b.getId_bon(),
											tfData.getText(),
											Integer.valueOf(tfPret.getText()
													.toString()),
											auto.get(cbNrInm.getSelectedIndex()),
											mecanic.get(cbMecanic
													.getSelectedIndex()));
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
							bon = (ArrayList<BON>) Factory
									.getInstance()
									.getBonDAO()
									.searchByData(
											tfSearch.getText().toString());
							model = new TableModelBon(bon);
							t.setModel(model);
							((AbstractTableModel) t.getModel())
									.fireTableDataChanged();
							t.repaint();

						}
					};

					(new Thread(r)).start();
					bonFrame.pack();

					break;
				case 2:
					r = new Runnable() {

						public void run() {
							
						}
					};
					(new Thread(r)).start();
					bonFrame.pack();

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
						auto = (ArrayList<AUTO>) Factory.getInstance()
								.getAutoDAO().getAllAuto();

						model = new TableModelBon(bon);
						t.setModel(model);

					}
				};
				(new Thread(r)).start();
				bonFrame.pack();

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
				if (tfData.getText().equals("") || tfPret.getText().equals("")) {
					//btnSave.setEnabled(false);
					btnUpdate.setEnabled(false);
				} else {
				//	btnSave.setEnabled(true);
					btnUpdate.setEnabled(true);
				}
			}
		};

		tfData.getDocument().addDocumentListener(docListener);
		tfPret.getDocument().addDocumentListener(docListener);
	//	tfSerie.getDocument().addDocumentListener(docListener);

		bonFrame.pack();
		
	}
		return bonFrame;
	}
}
