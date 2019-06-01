package sistema;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import basicas.Instrutor;

public class ModeloTabelaConsultaInstrutor extends AbstractTableModel {
	
	//TABELA PARA ADM VISUALIZAR INSTRUTORES
	private ArrayList<Instrutor> dataList = new ArrayList();
	private String[] columns={"Nome", "Cargo", "Data Nascimento", "Sexo", "Matricula"};
	Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class};
	boolean[] columnEditables = new boolean[] {false, false, false, false, false};
	
	public Class getColumnCount(int columnIndex) {
		
		return columnTypes[columnIndex];
	}
	
	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	}
	
	public ModeloTabelaConsultaInstrutor() {
		
	}
	
	public ModeloTabelaConsultaInstrutor(List l) {
		dataList.addAll(l);
	} 
	
	public void addInstrutor(Instrutor i) {
		dataList.add(i);
		fireTableDataChanged();
	}
	
	public void addInstrutorList(List l) {
		dataList.addAll(l);
		fireTableDataChanged();
	}
	
	public Instrutor getInstrutorAt(int row) {
		return dataList.get(row);
	}
	
	public int getInstrutorAt(Instrutor instrutor){
		return dataList.lastIndexOf(instrutor);
	}
	
	public Instrutor removeInstrutorAt(int row) {
		Instrutor i;
		i = dataList.remove(row);
		fireTableDataChanged();
		return i;
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
		Instrutor i = dataList.get(row);
		switch(col) {
		case 0:
			return i.getNome();
		case 1:
			return i.getCargo();
		case 2:
			return i.getDataDeNasc();
		case 3:
			return i.getGenero();
		case 4: 
			return i.getMatricula();
		default:
			return null;
		}
		
	}

}


