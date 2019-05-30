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

import basicas.Cliente;
import basicas.Exercicio;
import basicas.Treino;
import sistema.Assistente;
import sistema.Fachada;
import sistema.ModeloTabelaTreino;

import javax.swing.ListSelectionModel;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaConsultaCliente extends JFrame {
	
	//TELA PARA CLIENTE CONSULTAR SEUS TREINOS

	private JPanel contentPane;
	private JTable tableTreino;
	private ModeloTabelaTreino modeloTreino;
	public static TelaConsultaCliente instance;
	private JTable tableExercicios;
	
	public static TelaConsultaCliente getInstance() {
		if(instance == null) {
			instance = new TelaConsultaCliente();
		}
		return instance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException  ex) {
            System.err.println(ex);
        } 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaCliente frame = new TelaConsultaCliente();
					frame.setVisible(true);
					
					Assistente.gerarTreino();
					
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaConsultaCliente.class.getResource("/imagens/biceps png.png")));
		setTitle("Tela de Consulta de Treino");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 388);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblExercicios = new JLabel("Exerc\u00EDcios:");
		lblExercicios.setHorizontalAlignment(SwingConstants.CENTER);
		lblExercicios.setFont(new Font("Lucida Console", Font.BOLD, 15));
		lblExercicios.setBounds(24, 22, 136, 14);
		contentPane.add(lblExercicios);
		
		modeloTreino = new ModeloTabelaTreino();
		tableExercicios = new JTable(modeloTreino);
		tableExercicios.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tableExercicios.setBounds(68, 163, 100, 30);
		tableExercicios.setPreferredScrollableViewportSize(new Dimension(300, 50));
		tableExercicios.setFillsViewportHeight(true);
		
		JScrollPane scrollPaneTreino = new JScrollPane(tableExercicios);
		scrollPaneTreino.setBounds(34, 47, 464, 161);
		contentPane.add(scrollPaneTreino);
		
		JButton buttonMostrar = new JButton("Mostrar");
		buttonMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				while(modeloTreino.getRowCount()>0) {
					modeloTreino.removeTreinoAt(0);
				}			
					
				
				String matricula = TelaEntrar.getInstance().cliente.getMatricula();
						
				ArrayList<Exercicio> lista = new ArrayList();
				
				lista = (ArrayList<Exercicio>) Fachada.getInstance().listarTreino(matricula, "B");
						
					modeloTreino.addTreinoList(lista);
				}
			
		});
		buttonMostrar.setForeground(Color.WHITE);
		buttonMostrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonMostrar.setBackground(new Color(0, 128, 0));
		buttonMostrar.setBounds(371, 219, 127, 38);
		contentPane.add(buttonMostrar);
		
		JButton buttonVoltar = new JButton("Voltar");
		buttonVoltar.setIcon(new ImageIcon(TelaConsultaCliente.class.getResource("/imagens/gtkgobackltr_104397.png")));
		buttonVoltar.setForeground(Color.WHITE);
		buttonVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonVoltar.setBackground(new Color(0, 128, 0));
		buttonVoltar.setBounds(371, 270, 127, 38);
		contentPane.add(buttonVoltar);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(TelaConsultaCliente.class.getResource("/imagens/MFit logotipo redemensionada.jpg")));
		label_1.setBounds(0, 258, 229, 80);
		contentPane.add(label_1);
		
		JButton btnDados = new JButton("Dados");
		btnDados.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDados.setForeground(Color.WHITE);
		btnDados.setBackground(new Color(0, 128, 0));
		btnDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaDadosCliente.getInstance().setVisible(true);
				dispose();
			}
		});
		btnDados.setBounds(235, 219, 127, 38);
		contentPane.add(btnDados);
		
		JButton btnGerarTreino = new JButton("Gerar Treino");
		btnGerarTreino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String matricula = TelaEntrar.cliente.getMatricula();
				String categoria = "A";
				
				Assistente.gerarPDFTreino(matricula, categoria);
				
			}
		});
		btnGerarTreino.setForeground(new Color(255, 255, 255));
		btnGerarTreino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGerarTreino.setBackground(new Color(0, 128, 0));
		btnGerarTreino.setBounds(235, 270, 127, 38);
		contentPane.add(btnGerarTreino);
		
		JComboBox comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setModel(new DefaultComboBoxModel(new String[] {"", "A", "B", "C", "D", "E"}));
		comboBoxCategoria.setMaximumRowCount(5);
		comboBoxCategoria.setBounds(184, 219, 45, 28);
		contentPane.add(comboBoxCategoria);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(132, 219, 59, 14);
		contentPane.add(lblCategoria);
		
		
		
	}
}
