package sistema;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import basicas.AtividadeDiaria;

public class ModeloTabelaDataString extends AbstractTableModel{
	
	private ArrayList<String> dataList = new ArrayList<String>();
	private String[] columns={"Data"};
	Class[] columnTypes = new Class[] { Object.class};
	boolean[] columnEditables = new boolean[] {false};
	
	public Class getColumnCount(int columnIndex) {
		
		return columnTypes[columnIndex];
	}
	
	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	}
	
	public ModeloTabelaDataString() {
		
	}
	
	public ModeloTabelaDataString(List l) {
		dataList.addAll(l);
	} 
	
	public void addData(String i) {
		dataList.add(i);
		fireTableDataChanged();
	}
	
	public void addDataList(List l) {
		dataList.addAll(l);
		fireTableDataChanged();
	}
	
	public String getDataAt(int row) {
		return dataList.get(row);
	}
	
	public int getDataAt(String atividade){
		return dataList.lastIndexOf(atividade);
	}
	
	public String removeDataAt(int row) {
		String i;
		i = dataList.remove(row);
		fireTableDataChanged();
		return i;
	}
	
	public void onRemoveAll() {
        dataList.clear();
        fireTableDataChanged();
	}

	@Override
	public int getRowCount() {
		
		return dataList.size();
	}
	
	public int getColumnCount() {
		return columns.length;
	}

	public String getColumnName(int col) {
		return columns[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		String i = dataList.get(row);
		switch(col) {
		case 0:
			return i;
		default:
			return null;
		}
		
	}

}
