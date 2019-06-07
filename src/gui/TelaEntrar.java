package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import basicas.Administrador;
import basicas.Cliente;
import basicas.Endereco;
import basicas.Instrutor;
import basicas.Treino;
import sistema.Assistente;
import sistema.Fachada;
import sistema.Mensagem;
import sistema.ValidarDados;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class TelaEntrar extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame TelaDeEntrada;
	private JTextField textFieldMatricula;
	public static TelaEntrar instance;
	public static Cliente cliente;
	public static Instrutor instrutor;
	public static Administrador adm;
	
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
					window.TelaDeEntrada.setLocationRelativeTo(null);
					window.TelaDeEntrada.setResizable(false);
					
					//gerando user ADM
					Assistente.gerarAdm();
					
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
			public void actionPerformed(ActionEvent e) {
				
				String matricula;
				
				matricula = textFieldMatricula.getText();
				
				if(!ValidarDados.validarCampoVazio(matricula)) {					
					
				}else {					
					
						
						cliente = Fachada.getInstance().procurarClienteMatricula(matricula);
						instrutor = Fachada.getInstance().procurarInstrutorMatricula(matricula);
						adm = Fachada.getInstance().procurarADM(matricula);
						
						if(cliente != null) {
							if(cliente.getPagamento().equals("Não")) {
								PopUps.AcessoNegado();
							}else {
								TelaConsultaCliente.getInstance().setVisible(true);
								TelaConsultaCliente.getInstance().setLocationRelativeTo(null);
								TelaDeEntrada.dispose();	
							}		
						}else if(instrutor != null) {
							TelaInstrutor.getInstance().setVisible(true);
							TelaInstrutor.getInstance().setLocationRelativeTo(null);
							TelaDeEntrada.dispose();
						}else if(ValidarDados.validarLoginADM(matricula)) {
							TelaADM.getInstance().setVisible(true);
							TelaADM.getInstance().setLocationRelativeTo(null);
							TelaDeEntrada.dispose();
						}else {
							PopUps.UsuarioNaoExiste();
						}
					
				}
				
				limpar();
				
				
			
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
		textFieldMatricula.setBounds(310, 213, 187, 34);
		TelaDeEntrada.getContentPane().add(textFieldMatricula);
		
		JLabel lblMatrcula = new JLabel("Matr\u00EDcula:");
		lblMatrcula.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMatrcula.setBounds(231, 220, 90, 14);
		TelaDeEntrada.getContentPane().add(lblMatrcula);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TelaEntrar.class.getResource("/imagens/pessoas-saudaveis-carregando-icones-diferentes_53876-43069 novo.jpg")));
		lblNewLabel.setBounds(10, 114, 211, 255);
		TelaDeEntrada.getContentPane().add(lblNewLabel);
		
		JButton btnEsqueciSenha = new JButton("Esqueci minha matrícula");
		btnEsqueciSenha.setFont(new Font("Arial", Font.BOLD, 11));
		btnEsqueciSenha.setForeground(new Color(0, 191, 255));
		btnEsqueciSenha.setBackground(Color.WHITE);
		btnEsqueciSenha.addActionListener(new ActionListener() {
			private String email;

			public void actionPerformed(ActionEvent arg0) {
				
				String cpf = "";
				Cliente c;
				Instrutor in;
				
				do {
					cpf = JOptionPane.showInputDialog(Mensagem.INFORMACPF);
					if(ValidarDados.isCPF(cpf) == false) {
						PopUps.cpfInvalido();
					}
				}while(!ValidarDados.isCPF(cpf));
				
				
				if(ValidarDados.isCPF(cpf)) {
					c = Fachada.getInstance().procurarCliente(cpf);
					if(c == null) {
						in = Fachada.getInstance().procurarInstrutor(cpf);
						if(in == null) {
							PopUps.UsuarioNaoExiste();
						}else {
							
							String nome, matricula ="", telefone, genero, cargo, horaTrab, rua, bairro, numero, complemento, 
									cidade;
							Endereco end;
							Date data;
							    
							do {	
							 email = JOptionPane.showInputDialog(Mensagem.INFORMAEMAIL);
								
								if(email == null) {
									break;
								}else if(!email.equals("")){
									if(ValidarDados.validarEmail(email)) {
										 matricula = Assistente.gerarMatricula();										 
										 nome = in.getNome();									
										cpf = in.getCpf();									 
										telefone = in.getTelefone();									
										genero = in.getGenero();									 
										cargo = in.getCargo();								 
										horaTrab = in.getHoraTrab();									 
										rua = in.getEndereco().getRua();									
										bairro = in.getEndereco().getBairro();									
										numero = in.getEndereco().getNumero();									 
										complemento = in.getEndereco().getComplemento();									 
										cidade = in.getEndereco().getCidade();									
										data = in.getDataDeNasc();
										 end = new Endereco(rua, bairro, cidade, complemento, numero);
										 
										 Instrutor in1 = new Instrutor(nome, end, cpf, data, matricula, email,
												 telefone, genero, cargo, horaTrab);
										 
										 
											Fachada.getInstance().atualizar(in1);
											Assistente.enviarEmail(email, matricula);
											PopUps.matriculaAlterada();
											PopUps.emailEnviado();
										
									}
									
								}															
								
							}while(matricula.equals(""));
							
						}
					}else {
						String nome, matricula ="", telefone, genero, pagamento, objetivo, rua, bairro, numero, complemento, 
								cidade;
						Endereco end;
						Date data;
						    
						do {	
						 email = JOptionPane.showInputDialog(Mensagem.INFORMAEMAIL);
							
							if(email == null) {
								break;
							}else if(!email.equals("")){
								if(ValidarDados.validarEmail(email)) {
									
									 matricula = Assistente.gerarMatricula();										 
									 nome = c.getNome();									
									cpf = c.getCpf();									 
									telefone = c.getTelefone();									
									genero = c.getGenero();									 
									pagamento = c.getPagamento();									 
									objetivo = c.getObjetivo();									 
									rua = c.getEndereco().getRua();									
									bairro = c.getEndereco().getBairro();									
									numero = c.getEndereco().getNumero();									 
									complemento = c.getEndereco().getComplemento();									 
									cidade = c.getEndereco().getCidade();									
									data = c.getDataDeNasc();
									 end = new Endereco(rua, bairro, cidade, complemento, numero);
									 
										Treino treinoA = Fachada.getInstance().procurarClienteTreino(c.getMatricula(), "A");
										Treino treinoB = Fachada.getInstance().procurarClienteTreino(c.getMatricula(), "B");
										Treino treinoC = Fachada.getInstance().procurarClienteTreino(c.getMatricula(), "C");
									 
									 Cliente c1 = new Cliente(nome, end, cpf, data, matricula, email, telefone, genero,
											 pagamento, objetivo);
									 
										Fachada.getInstance().atualizar(c1);
									 
									 /*if(!(treinoA == null)) {
										 Treino treino1 = new Treino(treinoA.getInstrutor(), c1, treinoA.getRepExer(), 
												 "A", treinoA.getNumeroTreinos(), treinoA.getContadorTreino(), treinoA.getDataCriacao());
										 Fachada.getInstance().atualizarTreino(treino1);
									 }
									 if(!(treinoB == null)) {
										 Treino treino2 = new Treino(treinoB.getInstrutor(), c1, treinoB.getRepExer(), 
												 "B", treinoB.getNumeroTreinos(), treinoB.getContadorTreino(), treinoB.getDataCriacao());
										 Fachada.getInstance().atualizarTreino(treino2);
									 }
									 if(!(treinoC == null)) {
										 Treino treino3 = new Treino(treinoC.getInstrutor(), c1, treinoC.getRepExer(), 
												 "C", treinoC.getNumeroTreinos(), treinoC.getContadorTreino(), treinoC.getDataCriacao());
											Fachada.getInstance().atualizarTreino(treino3);
									 }		*/							 						 

										Assistente.enviarEmail(email, matricula);
										PopUps.matriculaAlterada();
										PopUps.emailEnviado();
									
								}
								
							}															
							
						}while(matricula.equals(""));
						
					}
					
				
				}else {
					PopUps.cpfInvalido();
				}
				
			}
		});
		btnEsqueciSenha.setBounds(310, 258, 187, 20);
		TelaDeEntrada.getContentPane().add(btnEsqueciSenha);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(383, 109, 46, 14);
		TelaDeEntrada.getContentPane().add(lblData);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(451, 109, 46, 14);
		TelaDeEntrada.getContentPane().add(lblHora);
		TelaDeEntrada.setBounds(100, 100, 535, 454);
		TelaDeEntrada.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
