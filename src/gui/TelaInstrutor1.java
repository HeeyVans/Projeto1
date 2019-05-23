package gui;


import java.awt.Dimension;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;


import javax.swing.JScrollPane;
import javax.swing.JTable;

import basicas.Cliente;
import sistema.Fachada;
import sistema.ModeloTabelaInstrutor;

import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class TelaInstrutor1 extends JFrame {

	private JPanel contentPane;
	private JTable tableCliente;
	private static TelaInstrutor1 instance;
	private ModeloTabelaInstrutor modeloInstrutor;	
	private JTextField textFieldNome;
	
	public static TelaInstrutor1 getInstance() {
		if(instance == null) {
			instance = new TelaInstrutor1();
			return instance;
		}else {
			return instance;
		}
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
		
		JLabel lblNome = new JLabel("Nome do Cliente:");
		lblNome.setBounds(10, 209, 92, 14);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(98, 206, 86, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				while(modeloInstrutor.getRowCount()>0) {
					modeloInstrutor.removeClienteAt(0);
				}
				
				String nome = textFieldNome.getText();
				
				ArrayList<Cliente> lista = new ArrayList();
				List relatorio = new ArrayList();
				
				lista = (ArrayList<Cliente>) Fachada.getInstance().listarCliente(nome);
				
				if(!lista.isEmpty()) {
					for(Cliente c:lista) {
						c.getNome();
						c.getObjetivo();
						c.getDataDeNasc();
						relatorio.add(c);
					}
					modeloInstrutor.addClienteList(relatorio);
				}
				
			}
		});
		btnBuscar.setBounds(194, 205, 89, 23);
		contentPane.add(btnBuscar);
	}
}
