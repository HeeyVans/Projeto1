package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import basicas.Cliente;
import basicas.Instrutor;
import excecoes.CampoVazioException;
import sistema.Assistente;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AttPedido extends JFrame {

	private JPanel contentPane;
	public static AttPedido instance;
	private JTextField textFieldAlterar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AttPedido frame = new AttPedido();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static AttPedido getInstance() {
		if(instance == null) {
			instance = new AttPedido();
		}
		return instance;
	}

	/**
	 * Create the frame.
	 */
	public AttPedido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeseja = new JLabel("O que deve ser alterado?");
		lblDeseja.setBounds(51, 33, 165, 14);
		contentPane.add(lblDeseja);
		
		textFieldAlterar = new JTextField();
		textFieldAlterar.setBounds(51, 66, 245, 109);
		contentPane.add(textFieldAlterar);
		textFieldAlterar.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar Solicita\u00E7\u00E3o");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean confirm;
				String mensagem;
				Cliente cliente;
				Instrutor in;
				mensagem = textFieldAlterar.getText();
				cliente = TelaEntrar.cliente;
				in = TelaEntrar.instrutor;
				confirm = PopUps.ConfirmarEnvio();
				
				if(confirm == true) {
					if(textFieldAlterar.getText().equals("")) {
						PopUps.campoVazio(new CampoVazioException());
					}else {
						if(in == null) {
						Assistente.enviarEmailClienteparaADM(mensagem, cliente);
						PopUps.pedidoEnviado();
						}else {
							Assistente.enviarEmailInstrutorparaADM(mensagem, in);
							PopUps.pedidoEnviado();
						}
					}
				}				
				
			}
		});
		btnEnviar.setBounds(51, 199, 165, 23);
		contentPane.add(btnEnviar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean confirm;
				confirm = PopUps.ConfirmarVolta();
				
				if(confirm == true) {
					if(TelaEntrar.cliente == null) {
						TelaDadosInstrutor.getInstance().setVisible(true);
						TelaDadosInstrutor.getInstance().setLocationRelativeTo(null);
						dispose();	
					}else {
						TelaDadosCliente.getInstance().setVisible(true);
						TelaDadosCliente.getInstance().setLocationRelativeTo(null);
						dispose();	
					}
										
					
				}
			}
		});
		btnVoltar.setBounds(51, 235, 89, 23);
		contentPane.add(btnVoltar);
	}
}
