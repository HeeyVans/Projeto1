package sistema;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import basicas.Exercicio;

public class ModeloTabelaTreino extends AbstractTableModel{
	
	//TABELA PARA CLIENTE VISUALIZAR EXERCICIOS
			private ArrayList<Exercicio> dataList = new ArrayList();
			private String[] columns={"Nome", "Séries", "Descanso", "Obs"};
			Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, Object.class};
			boolean[] columnEditables = new boolean[] {false, false, false, false};

			
			public Class getColumnCount(int columnIndex) {
				
				return columnTypes[columnIndex];
			}
			
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
			
			public ModeloTabelaTreino() {
				
			}
			
			public ModeloTabelaTreino(List l) {
				dataList.addAll(l);
			} 
			
			public void addTreino(Exercicio t) {
				dataList.add(t);
				fireTableDataChanged();
			}
			
			public void addTreinoList(List l) {
				dataList.addAll(l);
				fireTableDataChanged();
			}
			
			public Exercicio getTreinoAt(int row) {
				return dataList.get(row);
			}
			
			public int getTreinoAt(Exercicio t){
				return dataList.lastIndexOf(t);
			}
			
			public Exercicio removeTreinoAt(int row) {
				Exercicio t;
				t = dataList.remove(row);
				fireTableDataChanged();
				return t;
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
				Exercicio t = dataList.get(row);
				switch(col) {
				case 0:
					return t.getNome();
				case 1:
					return t.getSerie();
				case 2:
					return t.getTempoDescanso();
				case 3:
					return t.getObs();
				default:
					return null;
				}
				
			}

}
