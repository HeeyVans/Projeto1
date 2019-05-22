package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import sistema.ModeloTabelaTreino;

import javax.swing.ListSelectionModel;

public class TelaConsultaCliente extends JFrame {

	private JPanel contentPane;
	private JTable tableTreino;
	private ModeloTabelaTreino modeloTreino;	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaCliente frame = new TelaConsultaCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaConsultaCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblExercicios = new JLabel("Exerc\u00EDcios:");
		lblExercicios.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblExercicios.setBounds(35, 31, 72, 14);
		contentPane.add(lblExercicios);
		
		JScrollPane scrollPaneTreino = new JScrollPane();
		scrollPaneTreino.setBounds(35, 60, 273, 99);
		contentPane.add(scrollPaneTreino);
		
		tableTreino = new JTable();
		tableTreino.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tableTreino.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "S\u00E9ries", "Descanso", "Observa\u00E7\u00F5es"
			}
		));
		tableTreino.getColumnModel().getColumn(3).setPreferredWidth(105);
		tableTreino.setFillsViewportHeight(true);
		scrollPaneTreino.setViewportView(tableTreino);
		
		modeloTreino = new ModeloTabelaTreino();
		tableTreino = new JTable(modeloTreino);
		tableTreino.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tableTreino.setBounds(68, 163, 100, 30);
		tableTreino.setPreferredScrollableViewportSize(new Dimension(300, 50));
		tableTreino.setFillsViewportHeight(true);
	}

}
