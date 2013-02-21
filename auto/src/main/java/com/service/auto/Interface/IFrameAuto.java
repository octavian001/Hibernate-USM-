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

import TModel.TableModelAuto;
import TModel.TableModelMecanic;

import com.service.auto.AUTO;
import com.service.auto.Factory;
import com.service.auto.MARCA;
import com.service.auto.MECANIC;
import com.service.auto.PROPRIETAR;

public class IFrameAuto extends JFrame {

	private static final long serialVersionUID = 1L;
	static JInternalFrame autoFrame = null;
	private static TableModelAuto model = null;
	private static JTable t = null;
	private static JScrollPane scrollPane = null;
	private static JPanel panel_btn = null;
	private static JPanel panel_lb = null;
	private static JPanel panel_table = null;
	private static JPanel line = null;
	private static JLabel lbAn = null;
	private static JLabel lbNr = null;
	private static JLabel lbSerie = null;
	private static JLabel lbMarca = null;
	private static JLabel lbProprietar = null;

	private static JButton btnAdd = null;
	private static JButton btnEdit = null;
	private static JButton btnDelete = null;
	private static JButton btnSave = null;
	private static JButton btnCancel = null;
	private static JButton btnUpdate = null;
	private static JButton btnRefresh = null;
	private static JTextField tfAn = null;
	private static JTextField tfNr = null;
	private static JTextField tfSerie = null;
	private static JComboBox cbMarca = null;
	private static JComboBox cbProprietar = null;

	private static AUTO a;
	private static ArrayList<AUTO> auto = null;
	private static JComboBox cbSearch = null;
	private static JButton btnSearch = null;
	private static JTextField tfSearch = null;
	private static JPanel panel_search = null;
	private static JPanel panel = null;

	private static ArrayList<MARCA> marca = null;
	private static MARCA m1 = null;

	private static ArrayList<PROPRIETAR> proprietar = null;
	private static PROPRIETAR p = null;

	// anuleaza textul din TextField daca s-au salvat datele in tabel
	public static boolean tfStatus(Boolean status) {
		if (status) {
			tfAn.setText("");
			tfNr.setText("");
			tfSerie.setText("");
		}
		return status;
	}

	// anuleaza datele din TextField daca s-a apasat btnCancel
	public static void cancelText() {
		tfAn.setText("");
		tfNr.setText("");
		tfSerie.setText("");
	}

	public static JInternalFrame getAutoFrame() {

		if (autoFrame == null || autoFrame.isClosed()) {

			autoFrame = new JInternalFrame("AUTO", false, true, false, true);

			autoFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			autoFrame.setSize(900, 600);
			autoFrame.setLocation(30, 20);
			autoFrame.setVisible(true);

			auto = (ArrayList<AUTO>) Factory.getInstance().getAutoDAO()
					.getAllAuto();

			marca = (ArrayList<MARCA>) Factory.getInstance().getMarcaDAO()
					.getAllMarca();

			proprietar = (ArrayList<PROPRIETAR>) Factory.getInstance()
					.getProprietarDAO().getAllProprietar();

			model = new TableModelAuto(auto);
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

			autoFrame.add(panel_btn, BorderLayout.PAGE_END);

			// panel for labels
			panel_lb = new JPanel();
			panel_lb.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
			panel_lb.setLayout(new BoxLayout(panel_lb, BoxLayout.Y_AXIS));
			// panel_lb.setBackground(Color.black);
			// add labels
			lbAn = new JLabel("An fabricare");
			lbAn.setPreferredSize(new Dimension(100, 20));
			lbNr = new JLabel("Numar inmatriculare");
			lbNr.setPreferredSize(new Dimension(100, 20));
			lbSerie = new JLabel("Serie motor");
			lbSerie.setPreferredSize(new Dimension(100, 20));
			lbMarca = new JLabel("Marca");
			lbMarca.setPreferredSize(new Dimension(100, 20));
			lbProprietar = new JLabel("Proprietar");
			lbProprietar.setPreferredSize(new Dimension(100, 20));

			// add TextFields
			tfAn = new JTextField();
			tfAn.setPreferredSize(new Dimension(200, 20));
			tfNr = new JTextField();
			tfNr.setPreferredSize(new Dimension(200, 20));
			tfSerie = new JTextField();
			tfSerie.setPreferredSize(new Dimension(200, 20));
			cbMarca = new JComboBox();
			cbMarca.setPreferredSize(new Dimension(200, 20));
			cbProprietar = new JComboBox();
			cbProprietar.setPreferredSize(new Dimension(200, 20));

			line = new JPanel(new FlowLayout());
			// line.setBackground(Color.black);
			line.add(lbAn);
			line.add(tfAn);
			panel_lb.add(line);

			line = new JPanel(new FlowLayout());
			// line.setBackground(Color.green);
			line.add(lbNr);
			line.add(tfNr);
			panel_lb.add(line);

			line = new JPanel(new FlowLayout());
			// line.setBackground(Color.blue);
			line.add(lbSerie);
			line.add(tfSerie);
			panel_lb.add(line);

			line = new JPanel(new FlowLayout());
			// line.setBackground(Color.cyan);
			line.add(lbMarca);
			line.add(cbMarca);
			panel_lb.add(line);

			line = new JPanel(new FlowLayout());
			// line.setBackground(Color.darkGray);
			line.add(lbProprietar);
			line.add(cbProprietar);
			panel_lb.add(line);
			panel_lb.setVisible(false);
			autoFrame.add(panel_lb, BorderLayout.CENTER);

			// panel for JTable
			panel_table = new JPanel(new BorderLayout());
			panel_table.setVisible(true);
			panel_table.setSize(new Dimension(300, 300));
			panel_table.setLocation(0, 0);
			// panel_table.setBackground(Color.white);
			panel_table.setPreferredSize(new Dimension(300, 300));
			scrollPane = new JScrollPane(t);

			btnRefresh = new JButton("Refresh");
			btnRefresh.setPreferredSize(new Dimension(100, 25));
			// btnRefresh.setAlignmentX(btnRefresh.RIGHT_ALIGNMENT);

			JPanel panel_refresh = new JPanel(new BorderLayout());
			panel_refresh.add(btnRefresh, BorderLayout.EAST);
			panel_table.add(panel_refresh, BorderLayout.PAGE_END);
			panel_table.add(scrollPane, BorderLayout.CENTER);

			String[] searchNameCol = { "---------", "An fabricare",
					"Nr. inmatriculare", "Serie motor", "Marca", "Proprietar" };

			java.util.Iterator<MARCA> iterator = marca.iterator();
			while (iterator.hasNext()) {
				m1 = (MARCA) iterator.next();
				cbMarca.addItem(m1.getDen_marca());
			}

			java.util.Iterator<PROPRIETAR> iterator1 = proprietar.iterator();
			while (iterator1.hasNext()) {
				p = (PROPRIETAR) iterator1.next();
				cbProprietar.addItem(p.getNume());
			}
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

			autoFrame.add(panel_table, BorderLayout.PAGE_START);

			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel_lb.setVisible(true);
					btnCancel.setEnabled(true);
					autoFrame.pack();
				}
			});

		}

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_lb.setVisible(false);
				cancelText();
				btnCancel.setEnabled(false);
				btnUpdate.setEnabled(false);
				autoFrame.pack();

			}
		});

		// adaugare date in DB
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Runnable r = new Runnable() {

					public void run() {
						AUTO a = new AUTO();
						try {
							a.setId_auto(null);
							a.setAn_fabr(Integer.valueOf(tfAn.getText()
									.toString()));
							a.setNr_inmatr(tfNr.getText());
							a.setSerie_motor(tfSerie.getText());
							a.setId_marca(marca.get(cbMarca.getSelectedIndex()));
							a.setId_proprietar(proprietar.get(cbProprietar
									.getSelectedIndex()));

						} catch (NumberFormatException e) {
						}
						try {
							boolean status = Factory.getInstance().getAutoDAO()
									.addAuto(a);
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
				autoFrame.pack();

			}
		});

		btnDelete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				Runnable r = new Runnable() {

					public void run() {
						try {
							if (Factory
									.getInstance()
									.getAutoDAO()
									.deleteAuto(
											auto.get(t.getSelectedRow())
													.getId_auto())) {
								// sterge rindul din JTable
								auto.remove(auto.get(t.getSelectedRow()));
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
				autoFrame.pack();
			}

		});

		btnEdit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				try {
					a = auto.get(t.getSelectedRow());
					tfAn.setText(Integer.valueOf(a.getAn_fabr()).toString());
					tfNr.setText(a.getNr_inmatr());
					tfSerie.setText(a.getSerie_motor());
					cbMarca.setSelectedItem(a.getId_marca().getDen_marca());
					cbProprietar
							.setSelectedItem(a.getId_proprietar().getNume());

					panel_lb.setVisible(true);
					btnUpdate.setEnabled(true);
					btnCancel.setEnabled(true);
					autoFrame.pack();

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
									.getAutoDAO()
									.updateModel(
											a.getId_auto(),
											Integer.valueOf(tfAn.getText()
													.toString()),
											tfNr.getText(),
											tfSerie.getText(),
											marca.get(cbMarca
													.getSelectedIndex()),
											proprietar.get(cbProprietar
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
							auto = (ArrayList<AUTO>) Factory
									.getInstance()
									.getAutoDAO()
									.searchByAn(
											Integer.valueOf(tfSearch.getText()));

						}
					};

					(new Thread(r)).start();
					autoFrame.pack();

					break;
				case 2:
					r = new Runnable() {

						public void run() {
							auto = (ArrayList<AUTO>) Factory.getInstance()
									.getAutoDAO()
									.searchByNr(tfSearch.getText());
						}
					};
					(new Thread(r)).start();
					autoFrame.pack();

					break;
				case 3:
					r = new Runnable() {

						public void run() {
							auto = (ArrayList<AUTO>) Factory.getInstance()
									.getAutoDAO()
									.searchBySerie(tfSearch.getText());
						}
					};
					(new Thread(r)).start();
					autoFrame.pack();

					break;
				case 4:
					r = new Runnable() {

						public void run() {

						}
					};

					(new Thread(r)).start();
					autoFrame.pack();

					break;
				case 5:

					r = new Runnable() {

						public void run() {

						}
					};
					(new Thread(r)).start();
					autoFrame.pack();

					break;
				case 6:
					r = new Runnable() {

						public void run() {

						}
					};
					(new Thread(r)).start();
					autoFrame.pack();
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

						model = new TableModelAuto(auto);
						t.setModel(model);

					}
				};
				(new Thread(r)).start();
				autoFrame.pack();

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
				if (tfAn.getText().equals("") || tfNr.getText().equals("")
						|| tfSerie.getText().equals("")) {
					btnSave.setEnabled(false);
					btnUpdate.setEnabled(false);
				} else {
					btnSave.setEnabled(true);
					btnUpdate.setEnabled(true);
				}
			}
		};

		tfAn.getDocument().addDocumentListener(docListener);
		tfNr.getDocument().addDocumentListener(docListener);
		tfSerie.getDocument().addDocumentListener(docListener);

		autoFrame.pack();
		return autoFrame;
	}

}
