package TModel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import com.service.auto.*;

public class TableModelMarca extends AbstractTableModel {

	private Set<TableModelListener> listeners = new HashSet<TableModelListener>();
	private List<MARCA> marca;

	public TableModelMarca(List<MARCA> marca) {
		this.marca = marca;
	}

	public void addTableModelListener(TableModelListener listener) {
		listeners.add(listener);

	}

	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public int getColumnCount() {
		return 2;
	}

	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "ID";
		case 1:
			return "Denumire marca";
		}
		return "";
	}

	public int getRowCount() {
		return marca.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		MARCA m = marca.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return m.getId_marca();
		case 1:
			return m.getDen_marca();
				}
		return "";
	}

	// reeditarea coloanelor
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public void removeTableModelListener(TableModelListener listener) {
		listeners.remove(listener);

	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

	}
}
