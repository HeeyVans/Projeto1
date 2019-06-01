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
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ImageIcon;

public class AttPedido extends JFrame {

	private JPanel contentPane;
	public static AttPedido instance;
	private JTextField textFieldAlterar;

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
					AttPedido frame = new AttPedido();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(AttPedido.class.getResource("/imagens/biceps png.png")));
		setTitle("Tela de Pedido - MFit");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 348);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeseja = new JLabel("O que deve ser alterado?");
		lblDeseja.setFont(new Font("Arial", Font.BOLD, 18));
		lblDeseja.setBounds(51, 33, 245, 22);
		contentPane.add(lblDeseja);
		
		textFieldAlterar = new JTextField();
		textFieldAlterar.setBounds(51, 66, 311, 127);
		contentPane.add(textFieldAlterar);
		textFieldAlterar.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar Solicita\u00E7\u00E3o");
		btnEnviar.setBackground(new Color(0, 128, 0));
		btnEnviar.setForeground(new Color(255, 255, 255));
		btnEnviar.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
		btnEnviar.setBounds(51, 224, 143, 38);
		contentPane.add(btnEnviar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(AttPedido.class.getResource("/imagens/gtkgobackltr_104397.png")));
		btnVoltar.setBackground(new Color(0, 128, 0));
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
		btnVoltar.setBounds(219, 224, 143, 38);
		contentPane.add(btnVoltar);
	}
}
