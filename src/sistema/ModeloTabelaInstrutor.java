package sistema;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import basicas.Cliente;

public class ModeloTabelaInstrutor extends AbstractTableModel{
	//TABELA PARA INSTRUTOR VISUALIZAR CLIENTES
	private ArrayList<Cliente> dataList = new ArrayList();
	private String[] columns={"Nome", "Objetivo","Data Nascimento", "Sexo"};
	Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, Object.class};
	boolean[] columnEditables = new boolean[] {false, false, false};

	
	public Class getColumnCount(int columnIndex) {
		
		return columnTypes[columnIndex];
	}
	
	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	}
	
	public ModeloTabelaInstrutor() {
		
	}
	
	public ModeloTabelaInstrutor(List l) {
		dataList.addAll(l);
	} 
	
	public void addCliente(Cliente c) {
		dataList.add(c);
		fireTableDataChanged();
	}
	
	public void addClienteList(List l) {
		dataList.addAll(l);
		fireTableDataChanged();
	}
	
	public Cliente getClienteAt(int row) {
		return dataList.get(row);
	}
	
	public int getClienteAt(Cliente cliente){
		return dataList.lastIndexOf(cliente);
	}
	
	public Cliente removeClienteAt(int row) {
		Cliente c;
		c = dataList.remove(row);
		fireTableDataChanged();
		return c;
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
		Cliente c = dataList.get(row);
		switch(col) {
		case 0:
			return c.getNome();
		case 1:
			return c.getObjetivo();
		case 2:
			return c.getDataDeNasc();
		case 3:
			return c.getGenero();
		default:
			return null;
		}
		
	}

}
