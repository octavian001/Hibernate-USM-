package TModel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import com.service.auto.*;

public class TableModelProprietar extends AbstractTableModel {
	
	private Set<TableModelListener> listeners = new HashSet<TableModelListener>();
    private List<PROPRIETAR> proprietar;
    
    public TableModelProprietar(List<PROPRIETAR> proprietar){
    	this.proprietar = proprietar;
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
		return "Adresa";
	}
		return "";
	}

	public int getRowCount() {
		return proprietar.size();
	}
	public Object getValueAt(int rowIndex, int columnIndex) {
	   PROPRIETAR p = proprietar.get(rowIndex);
	   switch (columnIndex) {
	case 0:
		return p.getId_proprietar();
	case 1:
		return p.getNume();
	case 2:
		return p.getPrenume();
	case 3:
		return p.getCnp();
	case 4:
		return p.getTelefon();
	case 5:
		return p.getAdresa();
		
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
