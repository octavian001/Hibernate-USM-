package TModel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import org.hibernate.hql.ast.tree.OperatorNode;

import com.service.auto.*;

public class TableModelForm extends AbstractTableModel {

	
	private List<MODEL> model;
	private List<MARCA> marca;
	private List<AUTO> auto;
	private List<PROPRIETAR> proprietar;
	private List<MECANIC> mecanic;
	private List<PIESE> piese;
	private List<OPERATIE> operatie;
	private List<BON> bon;
	private List<String> operString;

	private BON m;
	
	public TableModelForm(/*
						  List<MODEL> model, List<MARCA> marca, List<AUTO>
						  auto, List<PROPRIETAR> proprietar, List<MECANIC>
						  mecanic, List<PIESE> piese, List<OPERATIE> operatie,
						 */List<BON> bon,List<String> operString) {
		/*
		 * this.model = model; this.marca = marca; this.auto = auto;
		 * this.proprietar = proprietar; this.mecanic = mecanic; this.piese =
		 * piese; this.operatie = operatie;
		 */
		this.bon = bon;
		this.operString = operString;
	}

	public void addTableModelListener(TableModelListener listener) {

	}

	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public int getColumnCount() {
		return 16;
	}

	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "Marca";
		case 1:
			return "Model";
		case 2:
			return "An";
		case 3:
			return "Nr. inmatr.";
		case 4:
			return "Cod auto";
		case 5:
			return "Nume proprietar";
		case 6:
			return "Prenume proprietar";
		case 7:
			return "Cod propr.";
		case 8:
			return "Telefon";
		case 9:
			return "Adresa";
		case 10:
			return "Nume mecanic";
		case 11:
			return "Prenume mecanic";
		case 12:
			return "Piese";
			/*
			 * case 13: return "Cantitate";
			 */
		case 13:
			return "Den operatie";
		case 14:
			return "Data";
		case 15:
			return "Pret Total";
		}
		return "";
	}

	public int getRowCount() {
		return bon.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		m = bon.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return bon.get(rowIndex).getId_auto().getId_model().getMarca()
					.getDen_marca();
		case 1:
			return bon.get(rowIndex).getId_auto().getId_model().getDen_model();
		case 2:
			return bon.get(rowIndex).getId_auto().getAn_fabr();
		case 3:
			return bon.get(rowIndex).getId_auto().getNr_inmatr();
		case 4:
			return bon.get(rowIndex).getId_auto().getSerie_motor();
		case 5:
			return bon.get(rowIndex).getId_auto().getId_proprietar().getNume();
		case 6:
			return bon.get(rowIndex).getId_auto().getId_proprietar()
					.getPrenume();
		case 7:
			return bon.get(rowIndex).getId_auto().getId_proprietar().getCnp();
		case 8:
			return bon.get(rowIndex).getId_auto().getId_proprietar()
					.getTelefon();
		case 9:
			return bon.get(rowIndex).getId_auto().getId_proprietar()
					.getAdresa();
		case 10:
			return bon.get(rowIndex).getId_mecanic().getNume();
		case 11:
			return bon.get(rowIndex).getId_mecanic().getPrenume();
		case 12:
			return "";
		case 13:
			return operString.get(rowIndex).toString();
		case 14:
			return bon.get(rowIndex).getData_bon();
		case 15:
			return "";
		}
		return "";
	}

	// reeditarea coloanelor
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public void removeTableModelListener(TableModelListener listener) {

	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

	}
}
