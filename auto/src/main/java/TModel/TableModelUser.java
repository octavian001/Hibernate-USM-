package TModel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import com.service.auto.*;

public class TableModelUser extends AbstractTableModel {

	private List<USERS> user;
	private USERS m;

	public TableModelUser(List<USERS> user) {
		this.user = user;
	}

	public void addTableModelListener(TableModelListener listener) {

	}

	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public int getColumnCount() {
		return 4;
	}

	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "ID";
		case 1:
			return "Nume utilizator";
		case 2:
			return "Parola utilizator";
		case 3:
			return "Categorie utilizator";
		}
		return "";
	}

	public int getRowCount() {
		return user.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		 m = user.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return user.get(rowIndex).getUser_id();
		case 1:
			return user.get(rowIndex).getUser();
		case 2:
			return   user.get(rowIndex).getPassword();
		case 3:
			return user.get(rowIndex).getRole();
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
