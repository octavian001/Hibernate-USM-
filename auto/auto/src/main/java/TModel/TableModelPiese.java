package TModel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import com.service.auto.*;

public class TableModelPiese extends AbstractTableModel {
	
	//private Set<TableModelListener> listeners = new HashSet<TableModelListener>();
    private List<PIESE> piese;
    
    public TableModelPiese(List<PIESE> piese){
    	this.piese = piese;
    }
    
    
	public void addTableModelListener(TableModelListener listener) {
	  //listeners.add(listener);	
		
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
		return "Denumire";
	case 2:
		return "Pret";
	case 3:
		return "Cantitate";
	}
		return "";
	}

	public int getRowCount() {
		return piese.size();
	}
	public Object getValueAt(int rowIndex, int columnIndex) {
	   PIESE p = piese.get(rowIndex);
	   switch (columnIndex) {
	case 0:
		return p.getId_piesa();
	case 1:
		return p.getDenumire();
	case 2:
		return p.getPret();
	case 3:
		return p.getCantitate();
		
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
