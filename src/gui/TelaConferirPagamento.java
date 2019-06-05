package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import basicas.Cliente;
import sistema.Assistente;
import sistema.Fachada;
import sistema.ModeloTabelaInstrutor;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class TelaConferirPagamento extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox = new JComboBox();
	private JTable tableCliente;
	private ModeloTabelaInstrutor modeloInstrutor;
	private JButton btnExibir;
	private static TelaConferirPagamento instance;
	private JButton btnPDFAtrasados;
	private JLabel lblGerarPDF;
	private JButton btnEmDia;
	private JButton btnTodos;
	
	public static TelaConferirPagamento getInstance() {
		if(instance == null) {
			instance = new TelaConferirPagamento();
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
					TelaConferirPagamento frame = new TelaConferirPagamento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public int comboSelecionado() {
		if(comboBox.getSelectedIndex() == 0) {
			return 1;
		}else if(comboBox.getSelectedIndex() == 1) {
			return 2;
		}else {
			return 0;
		}
	}

	/**
	 * Create the frame.
	 */
	public TelaConferirPagamento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		modeloInstrutor = new ModeloTabelaInstrutor();
		tableCliente = new JTable(modeloInstrutor);
		tableCliente.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tableCliente.setBounds(68, 163, 100, 30);
		tableCliente.setPreferredScrollableViewportSize(new Dimension(300, 50));
		tableCliente.setFillsViewportHeight(true);
		
		JScrollPane scrollPaneCliente = new JScrollPane(tableCliente);
		scrollPaneCliente.setBounds(10, 33, 393, 112);
		contentPane.add(scrollPaneCliente);
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Clientes em dia", "Clientes atrasados"}));
		comboBox.setBounds(10, 156, 133, 20);
		contentPane.add(comboBox);
		
		btnExibir = new JButton("Exibir");
		btnExibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				while(modeloInstrutor.getRowCount()>0) {
					modeloInstrutor.removeClienteAt(0);
				}
				
				if(comboSelecionado() == 1) {
					ArrayList<Cliente> lista = new ArrayList();
					
					lista = (ArrayList<Cliente>) Fachada.getInstance().listarClienteEmDia("Sim");
							
						modeloInstrutor.addClienteList(lista);
						
				}else if(comboSelecionado() == 2) {
					ArrayList<Cliente> lista = new ArrayList();
					
					lista = (ArrayList<Cliente>) Fachada.getInstance().listarClienteAtrasado("Não");
							
						modeloInstrutor.addClienteList(lista);
				}
			}
		});
		btnExibir.setBounds(10, 187, 89, 23);
		contentPane.add(btnExibir);
		
		btnPDFAtrasados = new JButton("Atrasados");
		btnPDFAtrasados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Assistente.gerarPDFClientesAtrasados();
			}
		});
		btnPDFAtrasados.setBounds(198, 181, 89, 23);
		contentPane.add(btnPDFAtrasados);
		
		lblGerarPDF = new JLabel("Gerar PDF:");
		lblGerarPDF.setBounds(265, 156, 81, 14);
		contentPane.add(lblGerarPDF);
		
		btnEmDia = new JButton("Em Dia");
		btnEmDia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Assistente.gerarPDFClientesEmDia();
			}
		});
		btnEmDia.setBounds(301, 181, 89, 23);
		contentPane.add(btnEmDia);
		
		btnTodos = new JButton("Todos");
		btnTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Assistente.gerarPDFTodosClientes();
			}
		});
		btnTodos.setBounds(257, 213, 89, 23);
		contentPane.add(btnTodos);
	}
}
