package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import excecoes.CampoVazioException;
import sistema.Assistente;
import sistema.Mensagem;
import sistema.ValidarDados;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class TelaEntrar {

	JFrame TelaDeEntrada;
	private JTextField textFieldMatricula;
	private JTextField textFieldCPF;
	public static TelaEntrar instance;
	
	public static TelaEntrar getInstance() {
		if(instance == null) {
			instance = new TelaEntrar();
			return instance;
		}else {
			return instance;
		}
	}

	/**
	 * Launch the application.
	 */
	
	public void limpar() {
		textFieldMatricula.setText("");
		textFieldCPF.setText("");
	}
	
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
					TelaEntrar window = new TelaEntrar();
					window.TelaDeEntrada.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaEntrar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		TelaDeEntrada = new JFrame();
		TelaDeEntrada.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaEntrar.class.getResource("/imagens/biceps png.png")));
		TelaDeEntrada.setTitle("Sistema de Login da MFit");
		TelaDeEntrada.getContentPane().setBackground(Color.WHITE);
		TelaDeEntrada.getContentPane().setLayout(null);
		
		JTextPane txtpnCliqueEmUma = new JTextPane();
		txtpnCliqueEmUma.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		txtpnCliqueEmUma.setText("Insira suas informações acima para entrar no sistema");
		txtpnCliqueEmUma.setBounds(109, 391, 349, 34);
		TelaDeEntrada.getContentPane().add(txtpnCliqueEmUma);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		panel.setBounds(0, 0, 519, 98);
		TelaDeEntrada.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblBemvindoAMfit = new JLabel("Bem-vindo a MFit");
		lblBemvindoAMfit.setForeground(new Color(255, 255, 255));
		lblBemvindoAMfit.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemvindoAMfit.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblBemvindoAMfit.setBounds(157, 37, 209, 29);
		panel.add(lblBemvindoAMfit);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cpf, matricula;
				cpf = textFieldCPF.getText();
				matricula = textFieldMatricula.getText();
				
				if(ValidarDados.validarCampoVazio(cpf, matricula)) {
					if(ValidarDados.validarLoginCliente(cpf, matricula)) {
						limpar();
						switch(ValidarDados.identificadorLogin()) {
						
						case ValidarDados.Cliente:
							TelaConsultaCliente.getInstance().setVisible(true);
							System.exit(0);
							break;
							
						case ValidarDados.Instrutor:
							TelaInstrutor1.getInstance().setVisible(true);
							System.exit(0);
							break;
							
						case ValidarDados.ADM:
							
						default:
							System.exit(0);
							break;
						}
					}
				}
			}
		});
		btnEntrar.setBackground(new Color(0, 128, 0));
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setIcon(new ImageIcon(TelaEntrar.class.getResource("/imagens/login.png")));
		btnEntrar.setFont(new Font("Arial", Font.BOLD, 14));
		btnEntrar.setBounds(246, 304, 114, 34);
		TelaDeEntrada.getContentPane().add(btnEntrar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSair.setForeground(new Color(255, 255, 255));
		btnSair.setBackground(new Color(0, 128, 0));
		btnSair.setIcon(new ImageIcon(TelaEntrar.class.getResource("/imagens/sair-menu-2.png")));
		btnSair.setFont(new Font("Arial", Font.BOLD, 14));
		btnSair.setBounds(383, 304, 114, 34);
		TelaDeEntrada.getContentPane().add(btnSair);
		
		textFieldMatricula = new JTextField();
		textFieldMatricula.setColumns(10);
		textFieldMatricula.setBounds(310, 231, 187, 34);
		TelaDeEntrada.getContentPane().add(textFieldMatricula);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(310, 172, 187, 34);
		TelaDeEntrada.getContentPane().add(textFieldCPF);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCpf.setBounds(269, 169, 42, 34);
		TelaDeEntrada.getContentPane().add(lblCpf);
		
		JLabel lblMatrcula = new JLabel("Matr\u00EDcula:");
		lblMatrcula.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMatrcula.setBounds(231, 238, 90, 14);
		TelaDeEntrada.getContentPane().add(lblMatrcula);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TelaEntrar.class.getResource("/imagens/pessoas-saudaveis-carregando-icones-diferentes_53876-43069 novo.jpg")));
		lblNewLabel.setBounds(10, 114, 211, 255);
		TelaDeEntrada.getContentPane().add(lblNewLabel);
		
		JButton btnEsqueciSenha = new JButton("Esqueci minha senha");
		btnEsqueciSenha.setFont(new Font("Arial", Font.BOLD, 11));
		btnEsqueciSenha.setForeground(new Color(0, 191, 255));
		btnEsqueciSenha.setBackground(Color.WHITE);
		btnEsqueciSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String email, matricula = "";
				do {
					email = JOptionPane.showInputDialog(Mensagem.INFORMAEMAIL);
					
					if(email == null) {
						break;
					}else if(!email.equals("")){
						if(ValidarDados.validarEmail(email)) {
							matricula = Assistente.gerarMatricula();
							Assistente.enviarEmail(email, matricula);
							PopUps.emailEnviado();
							break;
						}
						email = "";
						continue;
					}
					PopUps.campoVazio(new CampoVazioException());
					
				}while(matricula.equals(""));
			}
		});
		btnEsqueciSenha.setBounds(320, 276, 145, 20);
		TelaDeEntrada.getContentPane().add(btnEsqueciSenha);
		TelaDeEntrada.setBounds(100, 100, 535, 454);
		TelaDeEntrada.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
