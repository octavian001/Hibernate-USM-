package TModel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import com.service.auto.BON;

public class TableModelBon extends AbstractTableModel {

	private List<BON> bon;

	public TableModelBon(List<BON> bon) {
		this.bon = bon;
	}

	public void addTableModelListener(TableModelListener listener) {

	}

	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public int getColumnCount() {
		return 5;
	}

	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "ID";
		case 1:
			return "Data bon";
		case 2:
			return "Nr. inmatriculare";
		case 3:
			return "Pret total";
		case 4:
			return "Nume mecanic";
		}
		return "";
	}

	public int getRowCount() {
		return bon.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		BON a = bon.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return bon.get(rowIndex).getId_bon();
		case 1:
			return bon.get(rowIndex).getData_bon();
		case 2:
			return bon.get(rowIndex).getId_auto().getNr_inmatr();
		case 3:
			return bon.get(rowIndex).getPret_total();
		case 4:
			return bon.get(rowIndex).getId_mecanic().getNume() + " "
					+ bon.get(rowIndex).getId_mecanic().getPrenume() + "("
					+ bon.get(rowIndex).getId_mecanic().getCnm() + ")";
		}
		return "";
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	public void removeTableModelListener(TableModelListener listener) {

	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

	}

}
