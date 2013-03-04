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
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
import TModel.TableModelUser;

import com.service.auto.Factory;
import com.service.auto.MECANIC;
import com.service.auto.PIESE;
import com.service.auto.PROPRIETAR;
import com.service.auto.USERS;

public class IFrameUser extends JFrame {

	private static final long serialVersionUID = 1L;
	static JInternalFrame userFrame = null;
	private static TableModelUser model = null;
	private static JTable t = null;
	private static JScrollPane scrollPane = null;
	private static JPanel panel_btn = null;
	private static JPanel panel_lb = null;
	private static JPanel panel_table = null;
	private static JPanel line = null;
	private static JLabel lbUsername = null;
	private static JLabel lbPassword = null;
	private static JLabel lbpassVerification = null;
	private static JLabel lbRole = null;
	private static JButton btnAdd = null;
	private static JButton btnEdit = null;
	private static JButton btnDelete = null;
	private static JButton btnSave = null;
	private static JButton btnCancel = null;
	private static JButton btnUpdate = null;
	private static JButton btnRefresh = null;
	private static JTextField tfUsername = null;
	private static JPasswordField tfPassword = null;
	private static JPasswordField tfpassVerfication = null;
	private static JTextField tfRole = null;
	private static USERS user;
	private static ArrayList<USERS> users = null;
	private static JComboBox cbSearch = null;
	private static JButton btnSearch = null;
	private static JTextField tfSearch = null;
	private static JPanel panel_search = null;
	private static JPanel panel = null;

	// anuleaza textul din TextField daca s-au salvat datele in tabel
	public static boolean tfStatus(Boolean status) {
		if (status) {
			tfUsername.setText("");
			tfPassword.setText("");
			tfRole.setText("");
		}
		return status;
	}

	// anuleaza datele din TextField daca s-a apasat btnCancel
	public static void cancelText() {
		tfUsername.setText("");
		tfPassword.setText("");
		tfRole.setText("");
	}

	public static JInternalFrame getUserFrame() {

		if (userFrame == null || userFrame.isClosed()) {

			userFrame = new JInternalFrame("UTILIZATOR", false, true, false,
					true);

			userFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			userFrame.setSize(900, 600);
			userFrame.setLocation(30, 20);
			userFrame.setVisible(true);

			users = (ArrayList<USERS>) Factory.getInstance().getUserDAO()
					.getAllUser();

			model = new TableModelUser(users);
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

			userFrame.add(panel_btn, BorderLayout.PAGE_END);

			// panel for labels
			panel_lb = new JPanel();
			panel_lb.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
			panel_lb.setLayout(new BoxLayout(panel_lb, BoxLayout.Y_AXIS));
			// panel_lb.setBackground(Color.black);
			// add labels
			lbUsername = new JLabel("Nume utilizator");
			lbUsername.setPreferredSize(new Dimension(100, 20));
			lbPassword = new JLabel("Parola utilizator");
			lbPassword.setPreferredSize(new Dimension(100, 20));
			lbpassVerification = new JLabel("Verificare parola");
			lbpassVerification.setPreferredSize(new Dimension(100, 20));
			lbRole = new JLabel("Categorie utilizator");
			lbRole.setPreferredSize(new Dimension(100, 20));

			// add TextFields
			tfUsername = new JTextField();
			tfUsername.setPreferredSize(new Dimension(200, 20));
			tfPassword = new JPasswordField();
			tfPassword.setPreferredSize(new Dimension(200, 20));
			tfpassVerfication = new JPasswordField();
			tfpassVerfication.setPreferredSize(new Dimension(200, 20));
			tfRole = new JTextField();
			tfRole.setPreferredSize(new Dimension(200, 20));

			line = new JPanel(new FlowLayout());
			// line.setBackground(Color.black);
			line.add(lbUsername);
			line.add(tfUsername);
			panel_lb.add(line);

			line = new JPanel(new FlowLayout());
			// line.setBackground(Color.green);
			line.add(lbPassword);
			line.add(tfPassword);
			panel_lb.add(line);

			line = new JPanel(new FlowLayout());
			line.add(lbpassVerification);
			line.add(tfpassVerfication);
			panel_lb.add(line);

			line = new JPanel(new FlowLayout());
			// line.setBackground(Color.blue);
			line.add(lbRole);
			line.add(tfRole);
			panel_lb.add(line);

			panel_lb.setVisible(false);
			userFrame.add(panel_lb, BorderLayout.CENTER);

			// panel for JTable
			panel_table = new JPanel(new BorderLayout());
			panel_table.setVisible(true);
			panel_table.setSize(new Dimension(300, 300));
			panel_table.setLocation(0, 0);
			panel_table.setBackground(Color.white);
			panel_table.setPreferredSize(new Dimension(300, 300));
			scrollPane = new JScrollPane(t);

			btnRefresh = new JButton("Actualizare");
			btnRefresh.setPreferredSize(new Dimension(100, 25));
			// btnRefresh.setAlignmentX(btnRefresh.RIGHT_ALIGNMENT);

			JPanel panel_refresh = new JPanel(new BorderLayout());
			panel_refresh.add(btnRefresh, BorderLayout.EAST);
			panel_table.add(panel_refresh, BorderLayout.PAGE_END);
			panel_table.add(scrollPane, BorderLayout.CENTER);

			String[] searchNameCol = { "---------", "Nume utilizator",
					"Categorie" };
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

			userFrame.add(panel_table, BorderLayout.PAGE_START);

			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel_lb.setVisible(true);
					btnCancel.setEnabled(true);
					userFrame.pack();
				}
			});

		}

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_lb.setVisible(false);
				cancelText();
				btnCancel.setEnabled(false);
				btnUpdate.setEnabled(false);
				userFrame.pack();

			}
		});

		// adaugare date in DB
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Runnable r = new Runnable() {

					public void run() {
						USERS u = new USERS();
						try {
							u.setUser_id(null);
							u.setUser(tfUsername.getText());
							u.setPassword(Factory.getInstance().getUserDAO()
									.MD5(tfPassword.getText()));
							u.setRole(tfRole.getText());
						} catch (NumberFormatException e) {
						}
						try {
							if (tfPassword.getText().equals(
									tfpassVerfication.getText())) {
								boolean status = Factory.getInstance()
										.getUserDAO().addUser(u);
								tfStatus(status);
							} else {
								JOptionPane.showMessageDialog(null,
										"Parola nu coincide!", " Warning",
										JOptionPane.WARNING_MESSAGE);
							}
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
				userFrame.pack();

			}
		});

		btnDelete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				Runnable r = new Runnable() {

					public void run() {
						try {
							if (Factory
									.getInstance()
									.getUserDAO()
									.deleteUser(
											users.get(t.getSelectedRow())
													.getUser_id())) {
								// sterge rindul din JTable
								users.remove(users.get(t.getSelectedRow()));
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
				userFrame.pack();
			}

		});

		btnEdit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				try {
					user = users.get(t.getSelectedRow());
					tfUsername.setText(user.getUser());
					// tfPassword.setText(user.getPassword());
					tfRole.setText(user.getRole());

					panel_lb.setVisible(true);
					btnUpdate.setEnabled(true);
					btnCancel.setEnabled(true);
					userFrame.pack();

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
							if (tfPassword.getText().equals(
									tfpassVerfication.getText())) {
								status = Factory
										.getInstance()
										.getUserDAO()
										.updateUser(
												user.getUser_id(),
												tfUsername.getText(),
												Factory.getInstance()
														.getUserDAO()
														.MD5(tfPassword
																.getText()),
												tfRole.getText());
							} else
								JOptionPane.showMessageDialog(null,
										"Parola nu coincide!", " Warning",
										JOptionPane.WARNING_MESSAGE);
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
							users = (ArrayList<USERS>) Factory.getInstance()
									.getUserDAO()
									.searchByUsername(tfSearch.getText());
							model = new TableModelUser(users);
							t.setModel(model);
							((AbstractTableModel) t.getModel())
									.fireTableDataChanged();
							t.repaint();

						}
					};

					(new Thread(r)).start();
					userFrame.pack();

					break;

				case 2:
					r = new Runnable() {

						public void run() {
							users = (ArrayList<USERS>) Factory.getInstance()
									.getUserDAO()
									.searchByRole(tfRole.getText());
							model = new TableModelUser(users);
							t.setModel(model);
							((AbstractTableModel) t.getModel())
									.fireTableDataChanged();
							t.repaint();

						}
					};

					(new Thread(r)).start();
					userFrame.pack();
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
						users = (ArrayList<USERS>) Factory.getInstance()
								.getUserDAO().getAllUser();

						model = new TableModelUser(users);
						t.setModel(model);

					}
				};
				(new Thread(r)).start();
				userFrame.pack();

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
				if (tfUsername.getText().equals("")
						|| tfPassword.getText().equals("")
						|| tfRole.getText().equals("")) {
					btnSave.setEnabled(false);
					btnUpdate.setEnabled(false);
				} else {
					btnSave.setEnabled(true);
					btnUpdate.setEnabled(true);
				}
			}
		};

		tfUsername.getDocument().addDocumentListener(docListener);
		tfPassword.getDocument().addDocumentListener(docListener);
		tfRole.getDocument().addDocumentListener(docListener);

		userFrame.pack();
		return userFrame;
	}

}
