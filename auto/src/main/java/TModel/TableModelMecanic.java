package TModel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.service.auto.*;

public class TableModelMecanic implements TableModel {
	
	private Set<TableModelListener> listeners = new HashSet<TableModelListener>();
    private List<MECANIC> mec;
    
    public TableModelMecanic(List<MECANIC> mec){
    	this.mec = mec;
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
      switch (columnIndex) {
	case 0:
		return "ID";
	case 1:
		return "Nume";
	case 2:
		return "Prenume";
	case 3:
		return "Cod Personal";
	case 4:
		return "Telefon";
	case 5:
		return "Email";
	case 6:
		return "Adresa";
	}
		return "";
	}

	public int getRowCount() {
		return mec.size();
	}
	public Object getValueAt(int rowIndex, int columnIndex) {
	   MECANIC m = mec.get(rowIndex);
	   switch (columnIndex) {
	case 0:
		return m.getId_mecanic();
	case 1:
		return m.getNume();
	case 2:
		return m.getPrenume();
	case 3:
		return m.getCnm();
	case 4:
		return m.getTelefon();
	case 5: 
		return m.getEmail();
	case 6:
		return m.getAdresa();
		
	   }
		return "";
	}

	//reeditarea coloanelor
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public void removeTableModelListener(TableModelListener listener) {
		listeners.remove(listener);
		
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

	}
}
