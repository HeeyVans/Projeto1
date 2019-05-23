package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import basicas.Administrador;
import sistema.Assistente;
import sistema.Fachada;
import sistema.Mensagem;
import sistema.ValidarDados;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame {

	private JPanel contentPane;
	public static TelaInicial instance;
	
	public static TelaInicial getInstance() {
		if(instance == null) {
			instance = new TelaInicial();
		}
		return instance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
					
					Assistente.gerarAdm();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.setBounds(46, 72, 89, 23);
		contentPane.add(btnCliente);
		
		JButton btnADM = new JButton("ADM");
		btnADM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cpf, matricula;
				do {
					
				cpf = JOptionPane.showInputDialog(Mensagem.INFORMACPF);
				
				if(!ValidarDados.isCPF(cpf)) {
					PopUps.cpfInvalido();
				}
				
			}while(cpf.equals("") || ValidarDados.isCPF(cpf) == false);
				
						Administrador adm;
						adm = Fachada.getInstance().procurarADM(cpf);
						if(adm != null) {
							do {
							matricula = JOptionPane.showInputDialog(Mensagem.INFORMAMATRICULA);
							
							if(matricula == null) {
								break;
							}else if(ValidarDados.validarLoginADM(cpf, matricula)) {
								TelaADM.getInstance().setVisible(true);
								dispose();
							}
								}while(matricula.equals("") || ValidarDados.validarLoginADM2(cpf, matricula) == false);
							}				
					
				
			}
		});
		btnADM.setBounds(149, 123, 89, 23);
		contentPane.add(btnADM);
		
		JButton btnInstrutor = new JButton("Instrutor");
		btnInstrutor.setBounds(235, 72, 89, 23);
		contentPane.add(btnInstrutor);
	}
}
