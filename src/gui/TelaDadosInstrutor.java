package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class TelaDadosInstrutor extends JFrame {

	private JPanel contentPane;
	private static TelaDadosInstrutor instance;
	private JTextField textFieldNome;
	private JTextField textFieldCPF;
	private JTextField textFieldMatricula;
	private JTextField textFieldEmail;
	
	public static TelaDadosInstrutor getInstance() {
		if(instance == null) {
			instance = new TelaDadosInstrutor();
		}
		return instance;
	}
	
	public void setDados() {
		TelaEntrar.getInstance();
		textFieldNome.setText(TelaEntrar.instrutor.getNome());
		textFieldCPF.setText(TelaEntrar.instrutor.getCpf());
		textFieldMatricula.setText(TelaEntrar.instrutor.getMatricula());
		textFieldEmail.setText(TelaEntrar.instrutor.getEmail());
        /*DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dataFormatada = dateFormat.format(TelaEntrar.instrutor.getDataDeNasc());
		textFieldData.setText(dataFormatada);		
		textFieldTelefone.setText(TelaEntrar.instrutor.getTelefone());
		textFieldSexo.setText(TelaEntrar.instrutor.getGenero());
		textFieldCidade.setText(TelaEntrar.instrutor.getEndereco().getCidade());
		textFieldRua.setText(TelaEntrar.instrutor.getEndereco().getRua());
		textFieldBairro.setText(TelaEntrar.instrutor.getEndereco().getBairro());
		textFieldNumero.setText(TelaEntrar.instrutor.getEndereco().getNumero());
		textFieldComplemento.setText(TelaEntrar.instrutor.getEndereco().getComplemento());
		textFieldPagamento.setText(TelaEntrar.instrutor.getPagamento());
		textFieldObjetivo.setText(TelaEntrar.instrutor.getObjetivo());*/
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDadosInstrutor frame = new TelaDadosInstrutor();
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
	public TelaDadosInstrutor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(25, 63, 86, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(25, 38, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(25, 120, 46, 14);
		contentPane.add(lblCPF);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setBounds(25, 165, 86, 20);
		contentPane.add(textFieldCPF);
		textFieldCPF.setColumns(10);
		
		JLabel lblMatricula = new JLabel("Matr\u00EDcula");
		lblMatricula.setBounds(25, 225, 46, 14);
		contentPane.add(lblMatricula);
		
		textFieldMatricula = new JTextField();
		textFieldMatricula.setBounds(25, 276, 86, 20);
		contentPane.add(textFieldMatricula);
		textFieldMatricula.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(196, 66, 46, 14);
		contentPane.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(196, 117, 86, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JButton btnDados = new JButton("Mostrar Dados");
		btnDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDados();				
			}
		});
		btnDados.setBounds(196, 199, 129, 23);
		contentPane.add(btnDados);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInstrutor.getInstance().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(196, 249, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnAtualizacao = new JButton("Solicitar Atualiza\u00E7\u00E3o");
		btnAtualizacao.setBounds(196, 299, 148, 23);
		contentPane.add(btnAtualizacao);
		
		JButton btnGerarPDF = new JButton("Gerar PDF");
		btnGerarPDF.setBounds(196, 340, 89, 23);
		contentPane.add(btnGerarPDF);
	}
}
