package sistema;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import basicas.AtividadeDiaria;
import basicas.Instrutor;

public class ModeloTabelaData extends AbstractTableModel{
	
	//TABELA PARA ADM VISUALIZAR INSTRUTORES
		private ArrayList<AtividadeDiaria> dataList = new ArrayList();
		private String[] columns={"CPF", "Data"};
		Class[] columnTypes = new Class[] { Object.class, Object.class};
		boolean[] columnEditables = new boolean[] {false, false};
		
		public Class getColumnCount(int columnIndex) {
			
			return columnTypes[columnIndex];
		}
		
		public boolean isCellEditable(int row, int column) {
			return columnEditables[column];
		}
		
		public ModeloTabelaData() {
			
		}
		
		public ModeloTabelaData(List l) {
			dataList.addAll(l);
		} 
		
		public void addData(AtividadeDiaria i) {
			dataList.add(i);
			fireTableDataChanged();
		}
		
		public void addDataList(List l) {
			dataList.addAll(l);
			fireTableDataChanged();
		}
		
		public AtividadeDiaria getDataAt(int row) {
			return dataList.get(row);
		}
		
		public int getDataAt(AtividadeDiaria atividade){
			return dataList.lastIndexOf(atividade);
		}
		
		public AtividadeDiaria removeDataAt(int row) {
			AtividadeDiaria i;
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
			AtividadeDiaria i = dataList.get(row);
			switch(col) {
			case 0:
				return i.getCpf();
			case 1:
				return i.getData();
		
			default:
				return null;
			}
			
		}

}
