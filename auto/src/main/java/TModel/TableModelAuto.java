package TModel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.service.auto.AUTO;
import com.service.auto.MECANIC;

public class TableModelAuto implements TableModel {
	
	private Set<TableModelListener> listeners = new HashSet<TableModelListener>();
    private List<AUTO> auto;
  
      public TableModelAuto(List<AUTO> auto) {
		this.auto = auto;
	}

	public void addTableModelListener(TableModelListener listener) {
		listeners.add(listener);
	}

	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public int getColumnCount() {
		return 6;
	}

	public String getColumnName(int columnIndex) {
		switch(columnIndex){
		case 0:
			return "ID";
		case 1:
			return "An fabricare";
		case 2:
			return "Nr. inmatriculare";
		case 3:
			return "Serie motor";
		case 4:
			return "ID marca";
		case 5:
			return "ID proprietar";
		}
		return "";
	}

	public int getRowCount() {
		return auto.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		AUTO a = auto.get(rowIndex);
		switch(columnIndex){
		case 0:
			return a.getId_marca();
		case 1:
			return a.getAn_fabr();
		case 2:
			return a.getNr_inmatr();
		case 3:
			return a.getSerie_motor();
		case 4:
			return a.getId_marca();
		case 5:
			return a.getId_proprietar();
		}
		return "";
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	public void removeTableModelListener(TableModelListener listener) {
		listeners.add(listener);
				
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		
	}

}
