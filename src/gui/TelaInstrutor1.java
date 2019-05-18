package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import basicas.Cliente;
import sistema.ModeloTabelaInstrutor;

import javax.swing.ListSelectionModel;

public class TelaInstrutor1 extends JFrame {

	private JPanel contentPane;
	private JTable tableCliente;
	private static TelaInstrutor1 instance;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private ModeloTabelaInstrutor modeloInstrutor;
	private Cliente cliente;
	private ArrayList<Cliente> produtoVendido = new ArrayList();
	
	public static TelaInstrutor1 getInstance() {
		if(instance == null) {
			instance = new TelaInstrutor1();
			return instance;
		}else {
			return instance;
		}
	}
	
	public void limparCampos() {
		dispose();
		TelaInstrutor1.getInstance().setVisible(true);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInstrutor1 frame = new TelaInstrutor1();
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
	public TelaInstrutor1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabelCliente = new JLabel("Clientes:");
		lblNewLabelCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabelCliente.setBounds(10, 46, 79, 19);
		contentPane.add(lblNewLabelCliente);
		
		modeloInstrutor = new ModeloTabelaInstrutor();
		tableCliente = new JTable(modeloInstrutor);
		tableCliente.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tableCliente.setBounds(68, 163, 100, 30);
		tableCliente.setPreferredScrollableViewportSize(new Dimension(300, 50));
		tableCliente.setFillsViewportHeight(true);
		
		JScrollPane scrollPaneCliente = new JScrollPane(tableCliente);
		scrollPaneCliente.setBounds(10, 76, 414, 110);
		contentPane.add(scrollPaneCliente);
	}
}
