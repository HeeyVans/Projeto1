package gui;


import java.awt.Dimension;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;


import javax.swing.JScrollPane;
import javax.swing.JTable;

import basicas.Administrador;
import basicas.Cliente;
import basicas.Instrutor;
import excecoes.MatriculaNaoEncontradaException;
import sistema.Fachada;
import sistema.Mensagem;
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

public class TelaInstrutor extends JFrame {

	JFrame TelaDeInstrutor;
	private JPanel contentPane;
	private JTable tableCliente;
	public static TelaInstrutor instance;
	private ModeloTabelaInstrutor modeloInstrutor;	
	private JTextField textFieldNome;
	
	public static TelaInstrutor getInstance() {
		if(instance == null) {
			instance = new TelaInstrutor();
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
					TelaInstrutor frame = new TelaInstrutor();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaInstrutor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaInstrutor.class.getResource("/imagens/biceps png.png")));
		setTitle("Consulta de Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 442);
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
		scrollPaneCliente.setBounds(10, 76, 566, 119);
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
				
				lista = (ArrayList<Cliente>) Fachada.getInstance().listarCliente(nome);
						
					modeloInstrutor.addClienteList(lista);
				}
			
				
			
		});
		btnBuscar.setBounds(306, 206, 129, 38);
		contentPane.add(btnBuscar);
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaInstrutor.class.getResource("/imagens/MFit logotipo redemensionada.jpg")));
		label.setBounds(10, 312, 229, 80);
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
						dispose();
					}else {
						
					TelaEntrar window = new TelaEntrar();
					window.TelaDeEntrada.setVisible(true);
					window.TelaDeEntrada.setLocationRelativeTo(null);
					dispose();
					}
				}
				
			}
		});
		btnVoltar.setIcon(new ImageIcon(TelaInstrutor.class.getResource("/imagens/gtkgobackltr_104397.png")));
		btnVoltar.setBackground(new Color(0, 128, 0));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBounds(447, 354, 129, 38);
		contentPane.add(btnVoltar);
		
		JButton button = new JButton("Limpar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		button.setIcon(new ImageIcon(TelaInstrutor.class.getResource("/imagens/delete_remove_bin_icon-icons.com_72400.png")));
		button.setBackground(new Color(255, 99, 71));
		button.setBounds(123, 242, 116, 28);
		contentPane.add(button);
		
		JButton btnCriarTreino = new JButton("Criar treino");
		btnCriarTreino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean confirm;
				confirm = PopUps.ConfirmarIda();
				
				if(confirm == true) {
					TelaCriarTreino.getInstance().setVisible(true);
					TelaCriarTreino.getInstance().setLocationRelativeTo(null);
					dispose();
				}
				
			}
		});
		btnCriarTreino.setForeground(Color.WHITE);
		btnCriarTreino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCriarTreino.setBackground(new Color(0, 128, 0));
		btnCriarTreino.setBounds(445, 206, 129, 38);
		contentPane.add(btnCriarTreino);
		
		JButton btnMeusDados = new JButton("Meus Dados");
		btnMeusDados.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnMeusDados.setBackground(new Color(0, 128, 0));
		btnMeusDados.setForeground(Color.WHITE);
		btnMeusDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean confirm;
				confirm = PopUps.ConfirmarIda();
				
				if(confirm == true) {
					TelaDadosInstrutor.getInstance().setVisible(true);
					TelaDadosInstrutor.getInstance().setLocationRelativeTo(null);
					dispose();
				}
				
			}
		});
		btnMeusDados.setBounds(447, 256, 129, 38);
		contentPane.add(btnMeusDados);
		
		JButton btnExibirTodos = new JButton("Exibir Todos");
		btnExibirTodos.setBackground(new Color(0, 128, 0));
		btnExibirTodos.setForeground(new Color(255, 255, 255));
		btnExibirTodos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnExibirTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				while(modeloInstrutor.getRowCount()>0) {
					modeloInstrutor.removeClienteAt(0);
				}
				
				
				ArrayList<Cliente> lista = new ArrayList();
				
				lista = (ArrayList<Cliente>) Fachada.getInstance().listarClienteVoid();
						
					modeloInstrutor.addClienteList(lista);
			}
		});
		btnExibirTodos.setBounds(306, 306, 129, 38);
		contentPane.add(btnExibirTodos);
		
		JButton btnRemoverCliente = new JButton("Remover");
		btnRemoverCliente.setBackground(new Color(0, 128, 0));
		btnRemoverCliente.setForeground(Color.WHITE);
		btnRemoverCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRemoverCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Instrutor instrutor = TelaEntrar.instrutor;
				String matricula, matriculaCliente;
				
				if(instrutor == null) {
					matricula = JOptionPane.showInputDialog(Mensagem.INFORMAMATRICULA);
					Administrador adm;
					adm = Fachada.getInstance().procurarADM(matricula);
					
					if(adm != null) {
						matriculaCliente = JOptionPane.showInputDialog(Mensagem.INFORMAMATRICULACLIENTE);
						Cliente cliente = Fachada.getInstance().procurarClienteMatricula(matriculaCliente);
						
						if(cliente != null) {
							boolean confirm;
							confirm = PopUps.ConfirmarExclusao();
							
							if(confirm == true) {
							Fachada.getInstance().removerCliente(cliente.getCpf());
							PopUps.clienteRemovido();
							}
						}else {
							PopUps.UsuarioNaoExiste();
						}
					}else {
						PopUps.matriculaInvalida(new MatriculaNaoEncontradaException());
					}
				}else {
					PopUps.AcessoNegado();
				}
			}
		});
		btnRemoverCliente.setBounds(306, 255, 129, 38);
		contentPane.add(btnRemoverCliente);
		
		JButton btnAlterarCliente = new JButton("Alterar");
		btnAlterarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AttPedido.getInstance().setVisible(true);
				AttPedido.getInstance().setLocationRelativeTo(null);
				dispose();
			}
		});
		btnAlterarCliente.setForeground(Color.WHITE);
		btnAlterarCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAlterarCliente.setBackground(new Color(0, 128, 0));
		btnAlterarCliente.setBounds(447, 305, 129, 38);
		contentPane.add(btnAlterarCliente);
		
	}
}
