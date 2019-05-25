package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import basicas.Administrador;
import basicas.Cliente;
import basicas.Instrutor;
import sistema.Assistente;
import sistema.Fachada;
import sistema.Mensagem;
import sistema.ValidarDados;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaEscolha extends JFrame{

	 JFrame frmTelaDeEntrada;
	 private static TelaEscolha instance;
	 public static Cliente cliente;
	 public static Instrutor instrutor;
	 
	 public static TelaEscolha getInstance() {
		 if(instance == null) {
			 instance = new TelaEscolha();
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
					TelaEscolha window = new TelaEscolha();
					window.frmTelaDeEntrada.setVisible(true);
					
					Assistente.gerarAdm();
					Assistente.gerarInstCliente();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaEscolha() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaDeEntrada = new JFrame();
		frmTelaDeEntrada.setTitle("Tela de Entrada - MFit");
		frmTelaDeEntrada.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaEscolha.class.getResource("/imagens/biceps png.png")));
		frmTelaDeEntrada.getContentPane().setBackground(new Color(255, 255, 255));
		frmTelaDeEntrada.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(0, 128, 0));
		panel.setBounds(0, 0, 496, 107);
		frmTelaDeEntrada.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(79, 0, 340, 117);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(TelaEscolha.class.getResource("/imagens/MFit logotipo.png")));
		
		JLabel lblEscolhaUmaDas = new JLabel("Escolha uma das op\u00E7\u00F5es acima para que possa prosseguir");
		lblEscolhaUmaDas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscolhaUmaDas.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblEscolhaUmaDas.setBounds(79, 418, 355, 23);
		frmTelaDeEntrada.getContentPane().add(lblEscolhaUmaDas);
		
		JButton btnCadastrarCliente = new JButton("Cliente");
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				TelaConsultaCliente.getInstance().setVisible(true);
				frmTelaDeEntrada.dispose();
			}
		});
		btnCadastrarCliente.setForeground(new Color(255, 255, 255));
		btnCadastrarCliente.setBackground(new Color(0, 128, 0));
		btnCadastrarCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCadastrarCliente.setBounds(159, 160, 176, 41);
		frmTelaDeEntrada.getContentPane().add(btnCadastrarCliente);
		
		JButton btnCadastrarInstrutor = new JButton("Instrutor");
		btnCadastrarInstrutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInstrutor.getInstance().setVisible(true);
				frmTelaDeEntrada.dispose();
			}
		});
		btnCadastrarInstrutor.setForeground(new Color(255, 255, 255));
		btnCadastrarInstrutor.setBackground(new Color(0, 128, 0));
		btnCadastrarInstrutor.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCadastrarInstrutor.setBounds(159, 229, 176, 41);
		frmTelaDeEntrada.getContentPane().add(btnCadastrarInstrutor);
		
		JButton button = new JButton("Voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaEntrar telaEntrar = new TelaEntrar();
				telaEntrar.TelaDeEntrada.setVisible(true);
				frmTelaDeEntrada.dispose();
			}
		});
		button.setIcon(new ImageIcon(TelaEscolha.class.getResource("/imagens/gtkgobackltr_104397.png")));
		button.setBackground(new Color(255, 250, 240));
		button.setBounds(22, 378, 108, 29);
		frmTelaDeEntrada.getContentPane().add(button);
		
		JButton btnAdm = new JButton("ADM");
		btnAdm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cpf, matricula;
				Administrador cpfCad;
				boolean sair = false;
				do {
					
				cpf = JOptionPane.showInputDialog(Mensagem.INFORMACPF);
				
				if(!ValidarDados.isCPF(cpf)) {
					PopUps.cpfInvalido();
				}else{
					cpfCad = Fachada.getInstance().procurarADM(cpf);
					if(cpfCad == null) {
						PopUps.UsuarioNaoExiste();
					}else {
						sair = true;
					}
				}
				
			}while(!sair);
				
						Administrador adm;
						adm = Fachada.getInstance().procurarADM(cpf);
						if(adm != null) {
							do {
							matricula = JOptionPane.showInputDialog(Mensagem.INFORMAMATRICULA);
							
							if(matricula == null) {
								break;
							}else if(ValidarDados.validarLoginADM(cpf, matricula)) {
								TelaADM.getInstance().setVisible(true);
								frmTelaDeEntrada.dispose();
							}
								}while(matricula.equals("") || ValidarDados.validarLoginADM2(cpf, matricula) == false);
							}				
			}
		});
		btnAdm.setForeground(Color.WHITE);
		btnAdm.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdm.setBackground(new Color(0, 128, 0));
		btnAdm.setBounds(159, 296, 176, 41);
		frmTelaDeEntrada.getContentPane().add(btnAdm);
		frmTelaDeEntrada.setBounds(100, 100, 512, 491);
		frmTelaDeEntrada.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
