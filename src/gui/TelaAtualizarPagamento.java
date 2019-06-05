package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import basicas.Cliente;
import basicas.Endereco;
import sistema.Fachada;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class TelaAtualizarPagamento extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldMatricula;
	private JTextField textFieldCPF;
	JComboBox comboBox = new JComboBox();
	private static TelaAtualizarPagamento instance;
	
	public static TelaAtualizarPagamento getInstance() {
		if(instance == null) {
			instance = new TelaAtualizarPagamento();
		}
		return instance;
	}

	public void setDados(Cliente c) {
		textFieldNome.setText(c.getNome());
		textFieldCPF.setText(c.getCpf());
		textFieldMatricula.setText(c.getMatricula());
	}
	
	public String comboSelecionado() {
		if(comboBox.getSelectedIndex() == 0) {
			return "Sim";
		}else if(comboBox.getSelectedIndex() == 1) {
			return "Não";
		}else {
			return null;
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtualizarPagamento frame = new TelaAtualizarPagamento();
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
	public TelaAtualizarPagamento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome do Cliente:");
		lblNome.setBounds(281, 25, 82, 14);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(281, 50, 86, 29);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblMatricula = new JLabel("Matr\u00EDcula:");
		lblMatricula.setBounds(281, 128, 82, 14);
		contentPane.add(lblMatricula);
		
		textFieldMatricula = new JTextField();
		textFieldMatricula.setBounds(281, 153, 86, 29);
		contentPane.add(textFieldMatricula);
		textFieldMatricula.setColumns(10);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(281, 81, 46, 14);
		contentPane.add(lblCPF);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setBounds(281, 97, 86, 29);
		contentPane.add(textFieldCPF);
		textFieldCPF.setColumns(10);
		
		JLabel lblPagamento = new JLabel("Pagamento:");
		lblPagamento.setBounds(32, 25, 82, 14);
		contentPane.add(lblPagamento);
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sim", "N\u00E3o"}));
		comboBox.setBounds(32, 50, 60, 29);
		contentPane.add(comboBox);
		
		JButton btnVerificar = new JButton("Verificar");
		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String matricula = textFieldMatricula.getText();
				Cliente cliente = Fachada.getInstance().procurarClienteMatricula(matricula);
				
				if(cliente == null) {
					PopUps.UsuarioNaoExiste();
				}else {
					setDados(cliente);
				}
			}
		});
		btnVerificar.setBounds(278, 190, 89, 23);
		contentPane.add(btnVerificar);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String matricula = textFieldMatricula.getText();
				Cliente cliente = Fachada.getInstance().procurarClienteMatricula(matricula);
				
				if(cliente == null) {
					PopUps.UsuarioNaoExiste();
				}else {
					String nome, rua, bairro, cidade, complemento, numero, cpf, email, telefone, genero, objetivo;
					Date data;
					nome = cliente.getNome();
					rua = cliente.getEndereco().getRua();
					bairro = cliente.getEndereco().getBairro();
					cidade = cliente.getEndereco().getCidade();
					complemento = cliente.getEndereco().getComplemento();
					numero = cliente.getEndereco().getNumero();
					telefone = cliente.getTelefone();
					cpf = cliente.getCpf();
					email = cliente.getEmail();
					genero = cliente.getGenero();
					objetivo = cliente.getObjetivo();
					data = cliente.getDataDeNasc();
					Endereco end = new Endereco(rua, bairro, cidade, complemento, numero);
					
					Cliente c = new Cliente(nome, end, cpf, data, matricula, email, telefone, genero, 
							comboSelecionado(), objetivo);
					
					Fachada.getInstance().atualizar(c);
					JOptionPane.showMessageDialog(null, "Done");
				}
			}
		});
		btnConcluir.setBounds(32, 97, 89, 23);
		contentPane.add(btnConcluir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInstrutor.getInstance().setVisible(true);
				TelaInstrutor.getInstance().setLocationRelativeTo(null);
				dispose();
			}
		});
		btnVoltar.setBounds(32, 156, 89, 23);
		contentPane.add(btnVoltar);
	}
}
