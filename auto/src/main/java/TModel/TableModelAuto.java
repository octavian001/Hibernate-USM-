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
		return 7;
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
			return "Marca";
		case 5:
			return "Nume";
		case 6:
			return "Prenume";
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
			return auto.get(rowIndex).getId_auto();
		case 1:
			return auto.get(rowIndex).getAn_fabr();
		case 2:
			return auto.get(rowIndex).getNr_inmatr();
		case 3:
			return auto.get(rowIndex).getSerie_motor();
		case 4:
			return  auto.get(rowIndex).getId_marca().getDen_marca();
		case 5:
			return  auto.get(rowIndex).getId_proprietar().getNume();
		case 6:
			return auto.get(rowIndex).getId_proprietar().getPrenume();
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
