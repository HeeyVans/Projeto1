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
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;

public class TelaConferirPagamento extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox = new JComboBox();
	private JTable tableCliente;
	private ModeloTabelaInstrutor modeloInstrutor;
	private JButton btnExibir;
	private static TelaConferirPagamento instance;
	private JButton btnPDFAtrasados;
	private JButton btnEmDia;
	private JButton btnTodos;
	private JTabbedPane tabbedPane;
	private JPanel panel_1;
	
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
					TelaConferirPagamento frame = new TelaConferirPagamento();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
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
		setTitle("Consulta de Pagamentos - MFit");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaConferirPagamento.class.getResource("/imagens/biceps png.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 387);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
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
		scrollPaneCliente.setBounds(10, 33, 595, 138);
		contentPane.add(scrollPaneCliente);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"     Clientes em dia", "     Clientes atrasados"}));
		comboBox.setBounds(24, 193, 166, 39);
		contentPane.add(comboBox);
		
		btnExibir = new JButton("Exibir");
		btnExibir.setBackground(new Color(0, 128, 0));
		btnExibir.setForeground(Color.WHITE);
		btnExibir.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
		btnExibir.setBounds(45, 243, 119, 39);
		contentPane.add(btnExibir);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Gerar relat\u00F3rios", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(290, 182, 290, 138);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnPDFAtrasados = new JButton("Atrasados");
		btnPDFAtrasados.setBackground(new Color(0, 128, 0));
		btnPDFAtrasados.setForeground(Color.WHITE);
		btnPDFAtrasados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPDFAtrasados.setBounds(15, 31, 119, 39);
		panel.add(btnPDFAtrasados);
		
		btnEmDia = new JButton("Em Dia");
		btnEmDia.setBackground(new Color(0, 128, 0));
		btnEmDia.setForeground(Color.WHITE);
		btnEmDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEmDia.setBounds(151, 31, 119, 39);
		panel.add(btnEmDia);
		
		btnTodos = new JButton("Todos");
		btnTodos.setBackground(new Color(0, 128, 0));
		btnTodos.setForeground(Color.WHITE);
		btnTodos.setBounds(82, 81, 119, 39);
		panel.add(btnTodos);
		btnTodos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean confirm;
				confirm = PopUps.ConfirmarVolta();
				
				if(confirm == true) {
				TelaADM.getInstance().setVisible(true);
				TelaADM.getInstance().setLocationRelativeTo(null);
				dispose();
				}
			}
		});
		btnVoltar.setIcon(new ImageIcon(TelaConferirPagamento.class.getResource("/imagens/gtkgobackltr_104397.png")));
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBackground(new Color(0, 128, 0));
		btnVoltar.setBounds(45, 298, 119, 39);
		contentPane.add(btnVoltar);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 0, 100, 30);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(0, 0, 100, 30);
		panel_1.add(tabbedPane);
		tabbedPane.setToolTipText("Relat\u00F3rio dos hor\u00E1rios");
		tabbedPane.setFont(new Font("Arial", Font.BOLD, 14));
		tabbedPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Hor\u00E1rios", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tabbedPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					RelatorioDatas.getInstance().setVisible(true);
					RelatorioDatas.getInstance().setLocationRelativeTo(null);
					dispose();
			}
		});
		btnTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Assistente.gerarPDFTodosClientes();
			}
		});
		btnEmDia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Assistente.gerarPDFClientesEmDia();
			}
		});
		btnPDFAtrasados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Assistente.gerarPDFClientesAtrasados();
			}
		});
	}
}
