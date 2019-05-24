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
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class TelaConsultaCliente extends JFrame {

	private JPanel contentPane;
	private JTable tableTreino;
	private ModeloTabelaTreino modeloTreino;
	public static TelaConsultaCliente instance;
	private JTextField textField;
	
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
		
		JScrollPane scrollPaneTreino = new JScrollPane();
		scrollPaneTreino.setBounds(34, 47, 464, 161);
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
		
		JLabel label = new JLabel("Nome do Cliente:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(16, 219, 144, 25);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(155, 219, 174, 28);
		contentPane.add(textField);
		
		JButton button = new JButton("Buscar");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.setBackground(new Color(0, 128, 0));
		button.setBounds(356, 219, 116, 28);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Voltar");
		button_1.setIcon(new ImageIcon(TelaConsultaCliente.class.getResource("/imagens/gtkgobackltr_104397.png")));
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_1.setBackground(new Color(0, 128, 0));
		button_1.setBounds(356, 258, 116, 28);
		contentPane.add(button_1);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(TelaConsultaCliente.class.getResource("/imagens/MFit logotipo redemensionada.jpg")));
		label_1.setBounds(10, 266, 229, 80);
		contentPane.add(label_1);
		
		modeloTreino = new ModeloTabelaTreino();
		tableTreino = new JTable(modeloTreino);
		tableTreino.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tableTreino.setBounds(68, 163, 100, 30);
		tableTreino.setPreferredScrollableViewportSize(new Dimension(300, 50));
		tableTreino.setFillsViewportHeight(true);
		
	}
}
