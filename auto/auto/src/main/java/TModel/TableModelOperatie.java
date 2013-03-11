package TModel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import com.service.auto.*;

public class TableModelOperatie extends AbstractTableModel {
	
	//private Set<TableModelListener> listeners = new HashSet<TableModelListener>();
    private List<OPERATIE> oper;
    
    public TableModelOperatie(List<OPERATIE> oper){
    	this.oper = oper;
    }
    
    
	public void addTableModelListener(TableModelListener listener) {
	  //listeners.add(listener);	
		
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
		return "Denumire";
	case 2:
		return "Pret";
	}
		return "";
	}

	public int getRowCount() {
		return oper.size();
	}
	public Object getValueAt(int rowIndex, int columnIndex) {
	   OPERATIE o = oper.get(rowIndex);
	   switch (columnIndex) {
	case 0:
		return o.getId_oper();
	case 1:
		return o.getDen_oper();
	case 2:
		return o.getPret_oper();	
	   }
		return "";
	}

	//reeditarea coloanelor
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public void removeTableModelListener(TableModelListener listener) {
		//listeners.remove(listener);
		
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

	}
}
