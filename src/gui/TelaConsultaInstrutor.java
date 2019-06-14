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

import basicas.Administrador;
import basicas.Cliente;
import basicas.Instrutor;
import excecoes.MatriculaNaoEncontradaException;
import sistema.Fachada;
import sistema.Mensagem;
import sistema.ModeloTabelaConsultaInstrutor;

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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaConsultaInstrutor extends JFrame {

	JFrame TelaConsultaDeInstrutor;
	private JPanel contentPane;
	private JTable tableCliente;
	public static TelaConsultaInstrutor instance;
	private ModeloTabelaConsultaInstrutor modeloConsultaInstrutor;	
	private JTextField textFieldNome;
	
	public static TelaConsultaInstrutor getInstance() {
		if(instance == null) {
			instance = new TelaConsultaInstrutor();
			}
		return instance;
	}

	public void limpar() {
		textFieldNome.setText("");
	}
	/**
	 * 
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
					TelaConsultaInstrutor frame = new TelaConsultaInstrutor();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaConsultaInstrutor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaInstrutor.class.getResource("/imagens/biceps png.png")));
		setTitle("Consulta de Instrutores - MFit");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 417);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabelInstrutor = new JLabel("Instrutores:");
		lblNewLabelInstrutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelInstrutor.setFont(new Font("Lucida Console", Font.BOLD, 15));
		lblNewLabelInstrutor.setBounds(-22, 32, 203, 25);
		contentPane.add(lblNewLabelInstrutor);
		
		modeloConsultaInstrutor = new ModeloTabelaConsultaInstrutor();
		tableCliente = new JTable(modeloConsultaInstrutor);
		tableCliente.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tableCliente.setBounds(68, 163, 100, 30);
		tableCliente.setPreferredScrollableViewportSize(new Dimension(300, 50));
		tableCliente.setFillsViewportHeight(true);
		
		JScrollPane scrollPaneInstrutor = new JScrollPane(tableCliente);
		scrollPaneInstrutor.setBounds(10, 76, 566, 119);
		contentPane.add(scrollPaneInstrutor);
		
		JLabel lblNome = new JLabel("Nome do Instrutor:");
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
				while(modeloConsultaInstrutor.getRowCount()>0) {
					modeloConsultaInstrutor.removeInstrutorAt(0);
				}
				
				String nome = textFieldNome.getText();
				
				ArrayList<Instrutor> lista = new ArrayList();
				
				lista = (ArrayList<Instrutor>) Fachada.getInstance().listarInstrutor(nome);
						
					modeloConsultaInstrutor.addInstrutorList(lista);
				}
			
				
			
		});
		btnBuscar.setBounds(306, 206, 129, 38);
		contentPane.add(btnBuscar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaInstrutor.class.getResource("/imagens/MFit logotipo redemensionada.jpg")));
		label.setBounds(10, 291, 229, 80);
		contentPane.add(label);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean confirm;
				confirm = PopUps.ConfirmarVolta();
				
				if(confirm == true) {
					if(TelaEntrar.instrutor == null) {
						TelaADM.getInstance().setVisible(true);
						TelaADM.getInstance().setLocationRelativeTo(null);
						modeloConsultaInstrutor.onRemoveAll();
						dispose();
					}else {
						
					TelaEntrar window = new TelaEntrar();
					window.TelaDeEntrada.setVisible(true);
					window.TelaDeEntrada.setLocationRelativeTo(null);
					modeloConsultaInstrutor.onRemoveAll();
					dispose();
					}
				}
				
			}
		});
		btnVoltar.setIcon(new ImageIcon(TelaInstrutor.class.getResource("/imagens/gtkgobackltr_104397.png")));
		btnVoltar.setBackground(new Color(0, 128, 0));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBounds(447, 255, 129, 38);
		contentPane.add(btnVoltar);
		
		JButton button = new JButton("Limpar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
				modeloConsultaInstrutor.onRemoveAll();
			}
		});
		button.setIcon(new ImageIcon(TelaInstrutor.class.getResource("/imagens/delete_remove_bin_icon-icons.com_72400.png")));
		button.setBackground(new Color(255, 99, 71));
		button.setBounds(123, 242, 116, 28);
		contentPane.add(button);
		
		JButton btnExibirTodos = new JButton("Exibir Todos ");
		btnExibirTodos.setBackground(new Color(0, 128, 0));
		btnExibirTodos.setForeground(new Color(255, 255, 255));
		btnExibirTodos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnExibirTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				while(modeloConsultaInstrutor.getRowCount()>0) {
					modeloConsultaInstrutor.removeInstrutorAt(0);
				}
								
				ArrayList<Instrutor> lista = new ArrayList();
				
				lista = (ArrayList<Instrutor>) Fachada.getInstance().listarInstrutorVoid();
						
					modeloConsultaInstrutor.addInstrutorList(lista);
			}
		});
		btnExibirTodos.setBounds(447, 206, 129, 38);
		contentPane.add(btnExibirTodos);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setForeground(new Color(255, 255, 255));
		menuBar.setFont(new Font("Arial", Font.BOLD, 14));
		menuBar.setBounds(0, 0, 74, 21);
		contentPane.add(menuBar);
		
		JMenu mnInstrutor = new JMenu("Op\u00E7\u00F5es");
		mnInstrutor.setHorizontalAlignment(SwingConstants.CENTER);
		mnInstrutor.setFont(new Font("Arial", Font.BOLD, 14));
		menuBar.add(mnInstrutor);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(TelaEntrar.adm == null) {
					PopUps.AcessoNegado();
				}else {
				
				TelaCadastroInstrutor window = new TelaCadastroInstrutor();
				window.frmTelaDeCadastro.setVisible(true);
				window.frmTelaDeCadastro.setLocationRelativeTo(null);
				modeloConsultaInstrutor.onRemoveAll();
				dispose();
				}
			}
		});
		mnInstrutor.add(mntmCadastrar);
		
		JMenuItem mntmAtualizar = new JMenuItem("Atualizar");
		mntmAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(TelaEntrar.adm == null) {
					PopUps.AcessoNegado();
				} else {
				TelaDadosInstrutor.getInstance().setVisible(true);
				TelaDadosInstrutor.getInstance().setLocationRelativeTo(null);
				dispose();
				}
			}
		});
		mnInstrutor.add(mntmAtualizar);
		
		JMenuItem mntmRemover = new JMenuItem("Remover");
		mntmRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String matriculaInstrutor;
				
				if(TelaEntrar.adm != null) {
					matriculaInstrutor = JOptionPane.showInputDialog(Mensagem.INFORMAMATRICULAINSTRUTOR);
					Instrutor instrutor = Fachada.getInstance().procurarInstrutorMatricula(matriculaInstrutor);
					
					if(instrutor != null) {
						boolean confirm;
						confirm = PopUps.ConfirmarExclusao();
						
						if(confirm == true) {
						Fachada.getInstance().removerInstrutor(instrutor.getCpf());
						PopUps.instrutorRemovido();
						}
					}else {
						PopUps.UsuarioNaoExiste();
					}
				}else {
					PopUps.matriculaInvalida(new MatriculaNaoEncontradaException());
				}
			
		}
				
		});
		mnInstrutor.add(mntmRemover);
		
		JLabel label_1 = new JLabel("D\u00FAvidas?");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PopUps.InformacaoDuvida();
			}
		});
		label_1.setForeground(new Color(0, 128, 0));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(498, 14, 78, 28);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PopUps.InformacaoDuvida();
			}
		});
		label_2.setIcon(new ImageIcon(TelaConsultaInstrutor.class.getResource("/imagens/Bot\u00E3o d\u00FAvidas.png")));
		label_2.setBounds(428, 0, 71, 62);
		contentPane.add(label_2);
		
	}
}
