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
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class TelaInstrutor1 extends JFrame {

	private JPanel contentPane;
	private JTable tableCliente;
	public static TelaInstrutor1 instance;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaInstrutor1.class.getResource("/imagens/biceps png.png")));
		setTitle("Consulta de Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 375);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabelCliente = new JLabel("Clientes:");
		lblNewLabelCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelCliente.setFont(new Font("Lucida Console", Font.BOLD, 15));
		lblNewLabelCliente.setBounds(-43, 32, 203, 25);
		contentPane.add(lblNewLabelCliente);
		
		modeloInstrutor = new ModeloTabelaInstrutor();
		tableCliente = new JTable(modeloInstrutor);
		tableCliente.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tableCliente.setBounds(68, 163, 100, 30);
		tableCliente.setPreferredScrollableViewportSize(new Dimension(300, 50));
		tableCliente.setFillsViewportHeight(true);
		
		JScrollPane scrollPaneCliente = new JScrollPane(tableCliente);
		scrollPaneCliente.setBounds(10, 76, 485, 119);
		contentPane.add(scrollPaneCliente);
		
		JLabel lblNome = new JLabel("Nome do Cliente:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setBounds(-8, 206, 144, 25);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(122, 206, 174, 28);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBuscar.setBackground(new Color(0, 128, 0));
		btnBuscar.setForeground(new Color(255, 255, 255));
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
		btnBuscar.setBounds(311, 206, 116, 28);
		contentPane.add(btnBuscar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaInstrutor1.class.getResource("/imagens/MFit logotipo redemensionada.jpg")));
		label.setBounds(10, 256, 229, 80);
		contentPane.add(label);
	}
}
