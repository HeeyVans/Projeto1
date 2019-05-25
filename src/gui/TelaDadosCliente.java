package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaDadosCliente extends JFrame {

	private JPanel contentPane;
	private static TelaDadosCliente instance;
	private JTextField textFieldNome;
	private JTextField textFieldCPF;
	private JTextField textFieldData;
	private JTextField textFieldMatricula;
	private JTextField textFieldEmail;
	private JTextField textFieldTelefone;
	private JTextField textFieldSexo;
	private JTextField textFieldCidade;
	private JTextField textFieldRua;
	private JTextField textFieldBairro;
	private JTextField textFieldNumero;
	private JTextField textFieldComplemento;
	private JTextField textFieldPagamento;
	private JTextField textFieldObjetivo;
	
	public static TelaDadosCliente getInstance() {
		if(instance == null) {
			instance = new TelaDadosCliente();
		}
		return instance;
	}
	
	public void setDados() {
		TelaEntrar.getInstance();
		textFieldNome.setText(TelaEntrar.cliente.getNome());
		textFieldCPF.setText(TelaEntrar.cliente.getCpf());
		//textFieldData.setText(TelaEntrar.cliente.getDataDeNasc());
		textFieldMatricula.setText(TelaEntrar.cliente.getMatricula());
		textFieldEmail.setText(TelaEntrar.cliente.getEmail());
		textFieldTelefone.setText(TelaEntrar.cliente.getTelefone());
		textFieldSexo.setText(TelaEntrar.cliente.getGenero());
		textFieldCidade.setText(TelaEntrar.cliente.getEndereco().getCidade());
		textFieldRua.setText(TelaEntrar.cliente.getEndereco().getRua());
		textFieldBairro.setText(TelaEntrar.cliente.getEndereco().getBairro());
		textFieldNumero.setText(TelaEntrar.cliente.getEndereco().getNumero());
		textFieldComplemento.setText(TelaEntrar.cliente.getEndereco().getComplemento());
		textFieldPagamento.setText(TelaEntrar.cliente.getPagamento());
		textFieldObjetivo.setText(TelaEntrar.cliente.getObjetivo());
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDadosCliente frame = new TelaDadosCliente();
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
	public TelaDadosCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(40, 37, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblInformacoes = new JLabel("Informa\u00E7\u00F5es do cliente:");
		lblInformacoes.setToolTipText("");
		lblInformacoes.setBounds(245, 0, 125, 14);
		contentPane.add(lblInformacoes);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(219, 97, 46, 14);
		contentPane.add(lblRua);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(219, 151, 46, 14);
		contentPane.add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(219, 37, 46, 14);
		contentPane.add(lblCidade);
		
		JLabel lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setBounds(219, 213, 46, 14);
		contentPane.add(lblNumero);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(219, 261, 78, 14);
		contentPane.add(lblComplemento);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(40, 84, 46, 14);
		contentPane.add(lblCPF);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(40, 131, 46, 14);
		contentPane.add(lblData);
		
		JLabel lblMatricula = new JLabel("Matr\u00EDcula:");
		lblMatricula.setBounds(40, 184, 60, 14);
		contentPane.add(lblMatricula);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(40, 240, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(40, 297, 46, 14);
		contentPane.add(lblTelefone);
		
		JLabel lblGenero = new JLabel("Sexo:");
		lblGenero.setBounds(40, 348, 46, 14);
		contentPane.add(lblGenero);
		
		JLabel lblPagamento = new JLabel("Pagamento:");
		lblPagamento.setBounds(411, 37, 65, 14);
		contentPane.add(lblPagamento);
		
		JLabel lblObjetivo = new JLabel("Objetivo:");
		lblObjetivo.setBounds(411, 97, 46, 14);
		contentPane.add(lblObjetivo);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(40, 53, 86, 28);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setBounds(40, 100, 86, 28);
		contentPane.add(textFieldCPF);
		textFieldCPF.setColumns(10);
		
		textFieldData = new JTextField();
		textFieldData.setBounds(40, 148, 86, 35);
		contentPane.add(textFieldData);
		textFieldData.setColumns(10);
		
		textFieldMatricula = new JTextField();
		textFieldMatricula.setBounds(40, 210, 86, 28);
		contentPane.add(textFieldMatricula);
		textFieldMatricula.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(40, 266, 86, 28);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(40, 317, 86, 28);
		contentPane.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		textFieldSexo = new JTextField();
		textFieldSexo.setBounds(40, 366, 86, 31);
		contentPane.add(textFieldSexo);
		textFieldSexo.setColumns(10);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(219, 62, 86, 28);
		contentPane.add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		textFieldRua = new JTextField();
		textFieldRua.setBounds(219, 120, 86, 25);
		contentPane.add(textFieldRua);
		textFieldRua.setColumns(10);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setBounds(219, 174, 86, 28);
		contentPane.add(textFieldBairro);
		textFieldBairro.setColumns(10);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(219, 230, 86, 28);
		contentPane.add(textFieldNumero);
		textFieldNumero.setColumns(10);
		
		textFieldComplemento = new JTextField();
		textFieldComplemento.setBounds(219, 286, 86, 28);
		contentPane.add(textFieldComplemento);
		textFieldComplemento.setColumns(10);
		
		textFieldPagamento = new JTextField();
		textFieldPagamento.setBounds(411, 62, 86, 28);
		contentPane.add(textFieldPagamento);
		textFieldPagamento.setColumns(10);
		
		textFieldObjetivo = new JTextField();
		textFieldObjetivo.setBounds(411, 128, 86, 37);
		contentPane.add(textFieldObjetivo);
		textFieldObjetivo.setColumns(10);
		
		JButton btnAtualizar = new JButton("Solicitar Atualiza\u00E7\u00E3o");
		btnAtualizar.setBounds(408, 180, 142, 35);
		contentPane.add(btnAtualizar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(411, 236, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnMostrarDados = new JButton("Mostrar Dados");
		btnMostrarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setDados();
			}
		});
		btnMostrarDados.setBounds(411, 270, 142, 23);
		contentPane.add(btnMostrarDados);
	}
}
