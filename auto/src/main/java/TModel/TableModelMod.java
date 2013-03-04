package TModel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import com.service.auto.*;

public class TableModelMod extends AbstractTableModel {

	private List<MODEL> model;
	private MODEL m;

	public TableModelMod(List<MODEL> model) {
		this.model = model;
	}

	public void addTableModelListener(TableModelListener listener) {

	}

	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public int getColumnCount() {
		return 3;
	}

	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "ID";
		case 1:
			return "Denumire model";
		case 2:
			return "Denumire marca";
		}
		return "";
	}

	public int getRowCount() {
		return model.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		 m = model.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return model.get(rowIndex).getId_model();
		case 1:
			return model.get(rowIndex).getDen_model();
		case 2:
			return   model.get(rowIndex).getMarca().getDen_marca();
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
