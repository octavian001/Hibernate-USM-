package com.service.auto.Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import javax.swing.text.JTextComponent;
import javax.swing.text.html.HTMLDocument.Iterator;

import org.hibernate.util.JDBCExceptionReporter;

import TModel.TableModelMarca;
import TModel.TableModelMecanic;
import TModel.TableModelMod;

import com.service.auto.Factory;
import com.service.auto.MARCA;
import com.service.auto.MECANIC;
import com.service.auto.MODEL;

public class IFrameModel extends JFrame {

	private static final long serialVersionUID = 1L;
	static JInternalFrame modelFrame = null;
	private static TableModelMod model = null;
	private static JTable t = null;
	private static JScrollPane scrollPane = null;
	private static JPanel panel_btn = null;
	private static JPanel panel_lb = null;
	private static JPanel panel_table = null;
	private static JPanel line = null;
	private static JLabel lbDenumire = null;
	private static JLabel lbMarca = null;
	private static JButton btnAdd = null;
	private static JButton btnEdit = null;
	private static JButton btnDelete = null;
	private static JButton btnSave = null;
	private static JButton btnCancel = null;
	private static JButton btnUpdate = null;
	private static JButton btnRefresh = null;
	private static JTextField tfDenumire = null;
	private static JComboBox cbMarca = null;
	private static MODEL m;
	private static ArrayList<MODEL> mod = null;
	private static JComboBox cbSearch = null;
	private static JButton btnSearch = null;
	private static JTextField tfSearch = null;
	private static JPanel panel_search = null;
	private static JPanel panel = null;
	private static ArrayList<MARCA> marca = null;
	private static MARCA m1 = null;

	// anuleaza textul din TextField daca s-au salvat datele in tabel
	public static boolean tfStatus(Boolean status) {
		if (status) {
			tfDenumire.setText("");
		}
		return status;
	}

	// anuleaza datele din TextField daca s-a apasat btnCancel
	public static void cancelText() {
		tfDenumire.setText("");
	}

	public static JInternalFrame getModelFrame() {

		if (modelFrame == null || modelFrame.isClosed()) {

			modelFrame = new JInternalFrame("MODEL", false, true, false, true);

			modelFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			modelFrame.setSize(900, 600);
			modelFrame.setLocation(30, 20);
			modelFrame.setVisible(true);

			mod = (ArrayList<MODEL>) Factory.getInstance().getModelDAO()
					.getAllModel();
			marca = (ArrayList<MARCA>) Factory.getInstance().getMarcaDAO()
					.getAllMarca();

			model = new TableModelMod(mod);
			t = new JTable(model);
			// panel for buttons

			// panel for JTable
			panel_table = new JPanel(new BorderLayout());
			panel_table.setVisible(true);
			panel_table.setSize(new Dimension(300, 300));
			panel_table.setLocation(0, 0);
			panel_table.setPreferredSize(new Dimension(300, 300));
			scrollPane = new JScrollPane(t);
			panel_table.add(scrollPane, BorderLayout.CENTER);

			String[] searchNameCol = { "---------", "Model", "Marca" };
			cbSearch = new JComboBox(searchNameCol);
			cbSearch.setPreferredSize(new Dimension(100, 20));
			btnSearch = new JButton("Cautare");
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

			modelFrame.add(panel_table, BorderLayout.PAGE_START);

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
			
			btnRefresh = new JButton("Actualizare");
			btnRefresh.setPreferredSize(new Dimension(100, 25));
			// btnRefresh.setAlignmentX(btnRefresh.RIGHT_ALIGNMENT);

			JPanel panel_refresh = new JPanel(new BorderLayout());
			panel_refresh.add(btnRefresh, BorderLayout.EAST);
			panel_table.add(panel_refresh, BorderLayout.PAGE_END);
			panel_table.add(scrollPane, BorderLayout.CENTER);

			modelFrame.add(panel_btn, BorderLayout.PAGE_END);

			// panel for labels
			panel_lb = new JPanel();
			panel_lb.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
			panel_lb.setLayout(new BoxLayout(panel_lb, BoxLayout.Y_AXIS));
			//panel_lb.setBackground(Color.black);
			panel_lb.setVisible(false);

			// add labels
			lbDenumire = new JLabel("Denumire model");
			lbDenumire.setPreferredSize(new Dimension(100, 20));
			lbMarca = new JLabel("Denumire marca");
			lbMarca.setPreferredSize(new Dimension(100, 20));

			tfDenumire = new JTextField();
			tfDenumire.setPreferredSize(new Dimension(200, 20));
			String[] searchMarca = { "---------", "Model", "Marca" };

			cbMarca = new JComboBox();
			java.util.Iterator<MARCA> iterator = marca.iterator();
			while (iterator.hasNext()) {
				m1 = (MARCA) iterator.next();
				cbMarca.addItem(m1.getDen_marca());
			}
			cbMarca.setPreferredSize(new Dimension(200, 20));

			line = new JPanel(new FlowLayout());
			//line.setBackground(Color.black);
			line.add(lbDenumire);
			line.add(tfDenumire);
			panel_lb.add(line);

			line = new JPanel(new FlowLayout());
			//line.setBackground(Color.green);
			line.add(lbMarca);
			line.add(cbMarca);
			panel_lb.add(line);

			modelFrame.add(panel_lb, BorderLayout.CENTER);

			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel_lb.setVisible(true);
					btnCancel.setEnabled(true);
					modelFrame.pack();
				}
			});

			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel_lb.setVisible(false);
					cancelText();
					btnCancel.setEnabled(false);
					btnUpdate.setEnabled(false);
					modelFrame.pack();

				}
			});

			btnSave.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					Runnable r = new Runnable() {

						public void run() {
							MODEL m = new MODEL();
							try {
								m.setId_model(null);
								m.setDen_model(tfDenumire.getText());
								m.setMarca(marca.get(cbMarca.getSelectedIndex()));
							} catch (Exception e) {
							}
							try {
								boolean status = Factory.getInstance()
										.getModelDAO().addModel(m);
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
		
		btnDelete.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
					Runnable r = new Runnable() {
						
						public void run() {
							try {
								if (Factory
										.getInstance()
										.getModelDAO()
										.deleteMODEL(
												mod.get(t.getSelectedRow())
														.getId_model())) {
									// sterge rindul din JTable
									mod.remove(mod.get(t.getSelectedRow()));
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
			}
		});
		
		btnRefresh.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Runnable r =  new Runnable() {
					
					public void run() {
						mod = (ArrayList<MODEL>) Factory.getInstance()
								.getModelDAO().getAllModel();

						model = new TableModelMod(mod);
						t.setModel(model);
						
					}
				};
			(new Thread(r)).start();	
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
									.getModelDAO()
									.updateModel(
											m.getId_model(),
											tfDenumire.getText(),
											marca.get(cbMarca.getSelectedIndex()));
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
		
		btnEdit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Runnable r = new Runnable() {
					
					public void run() {
						try {
							m = mod.get(t.getSelectedRow());
							tfDenumire.setText(m.getDen_model());
							cbMarca.setSelectedItem(m.getMarca().getDen_marca());
							panel_lb.setVisible(true);
							btnUpdate.setEnabled(true);
							btnCancel.setEnabled(true);
							modelFrame.pack();

						} catch (ArrayIndexOutOfBoundsException e) {
							JOptionPane.showMessageDialog(null,
									"Nu ati selectat rindul", " Eroare",
									JOptionPane.OK_OPTION);
						}
					}
				};
				(new Thread(r)).start();
			}
		});
		
		btnSearch.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				switch (cbSearch.getSelectedIndex()) {
				case 0:
					JOptionPane.showMessageDialog(null,
							"Selectati dupa ce cimp doriti sa cautati datele",
							" Eroare", JOptionPane.OK_OPTION);
					break;
				case 1:
					Runnable r  = new Runnable() {
						
						public void run() {
							mod = (ArrayList<MODEL>) Factory.getInstance()
									.getModelDAO()
									.searchByDen_model(tfSearch.getText());
							model = new TableModelMod(mod);
							t.setModel(model);
							((AbstractTableModel) t.getModel())
									.fireTableDataChanged();
							t.repaint();

							
						}
					};
				(new Thread(r)).start();
					break;
				case 2:
						Runnable r1 = new Runnable() {
							
							public void run() {
								mod = (ArrayList<MODEL>) Factory.getInstance()
										.getModelDAO()
										.searchByFkMarca(tfSearch.getText(), mod);
								model = new TableModelMod(mod);
								t.setModel(model);
								((AbstractTableModel) t.getModel())
										.fireTableDataChanged();
								t.repaint();
								
							}
						};
						(new Thread(r1)).start();
					break;
				default:
					break;
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
				if (tfDenumire.getText().equals("")) {
					btnSave.setEnabled(false);
					btnUpdate.setEnabled(false);
				} else {
					btnSave.setEnabled(true);
					btnUpdate.setEnabled(true);
				}
			}
		};

		tfDenumire.getDocument().addDocumentListener(docListener);

		modelFrame.pack();
		return modelFrame;
	}
}
