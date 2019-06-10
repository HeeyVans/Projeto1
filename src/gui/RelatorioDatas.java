package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import sistema.Fachada;
import sistema.ModeloTabelaData;
import sistema.ModeloTabelaInstrutor;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import basicas.AtividadeDiaria;

public class RelatorioDatas extends JFrame {

	private JPanel contentPane;
	private ModeloTabelaData modeloData;
	private static RelatorioDatas instance;
	private JTable tableCliente;
	private JTextField textFieldExibir;
	private JButton btnVoltar;
	
	public static RelatorioDatas getInstance() {
		if(instance == null) {
			instance =  new RelatorioDatas();
		}
		return instance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioDatas frame = new RelatorioDatas();
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
	public RelatorioDatas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		modeloData = new ModeloTabelaData();
		contentPane.setLayout(null);
		tableCliente = new JTable(modeloData);
		tableCliente.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tableCliente.setBounds(68, 163, 50, 30);
		tableCliente.setPreferredScrollableViewportSize(new Dimension(300, 50));
		tableCliente.setFillsViewportHeight(true);
		
		JScrollPane scrollPaneCliente = new JScrollPane(tableCliente);
		scrollPaneCliente.setBounds(5, 5, 384, 370);
		contentPane.add(scrollPaneCliente);
		
		JButton btnExibir = new JButton("Exibir");
		btnExibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				while(modeloData.getRowCount()>0) {
					modeloData.removeDataAt(0);
				}
				
				String cpf = textFieldExibir.getText();
				
				ArrayList<AtividadeDiaria> atividade = new ArrayList<AtividadeDiaria>();
				
				atividade = (ArrayList<AtividadeDiaria>) Fachada.getInstance().listarAtividade(cpf);
				
				modeloData.addDataList(atividade);
			}
		});
		btnExibir.setBounds(10, 386, 89, 23);
		contentPane.add(btnExibir);
		
		textFieldExibir = new JTextField();
		textFieldExibir.setBounds(109, 387, 220, 20);
		contentPane.add(textFieldExibir);
		textFieldExibir.setColumns(10);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 420, 89, 23);
		contentPane.add(btnVoltar);
	}
}
