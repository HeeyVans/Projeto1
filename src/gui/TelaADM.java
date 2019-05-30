package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class TelaADM extends JFrame {

	JFrame telaADM;
	private JPanel contentPane;
	public static TelaADM instance;
	
	public static TelaADM getInstance() {
		if(instance == null) {
			instance = new TelaADM();
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
					TelaADM frame = new TelaADM();
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
	public TelaADM() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaADM.class.getResource("/imagens/biceps png.png")));
		setTitle("Tela do Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 499);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Cadastrar Cliente");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroCliente inicial = new TelaCadastroCliente();
				inicial.frmTelaDeCadastro.setVisible(true);
				dispose();
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBackground(new Color(0, 128, 0));
		button.setBounds(51, 198, 176, 41);
		contentPane.add(button);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(0, 128, 0));
		panel.setBounds(0, 0, 496, 107);
		contentPane.add(panel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaADM.class.getResource("/imagens/MFit logotipo.png")));
		label.setBounds(79, 0, 340, 117);
		panel.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton button_1 = new JButton("Cadastrar Instrutor");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroInstrutor inicial = new TelaCadastroInstrutor();
				inicial.frmTelaDeCadastro.setVisible(true);
				dispose();
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1.setBackground(new Color(0, 128, 0));
		button_1.setBounds(51, 275, 176, 41);
		contentPane.add(button_1);
		
		JButton btnPginaInicial = new JButton("P\u00E1gina Inicial");
		btnPginaInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEntrar entrar = new TelaEntrar();
				entrar.TelaDeEntrada.setVisible(true);
				dispose();
				
			}
		});
		btnPginaInicial.setForeground(Color.WHITE);
		btnPginaInicial.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPginaInicial.setBackground(new Color(0, 128, 0));
		btnPginaInicial.setBounds(154, 345, 176, 41);
		contentPane.add(btnPginaInicial);
		
		JButton btnConsultarCliente = new JButton("Consultar Cliente");
		btnConsultarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaConsultaCliente.getInstance().setVisible(true);
				dispose();
			}
		});
		btnConsultarCliente.setForeground(Color.WHITE);
		btnConsultarCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarCliente.setBackground(new Color(0, 128, 0));
		btnConsultarCliente.setBounds(271, 198, 176, 41);
		contentPane.add(btnConsultarCliente);
		
		JButton btnConsultarInstrutor = new JButton("Consultar Instrutor");
		btnConsultarInstrutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInstrutor.getInstance().setVisible(true);
				dispose();
			}
		});
		btnConsultarInstrutor.setForeground(Color.WHITE);
		btnConsultarInstrutor.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarInstrutor.setBackground(new Color(0, 128, 0));
		btnConsultarInstrutor.setBounds(271, 275, 176, 41);
		contentPane.add(btnConsultarInstrutor);
		
		JLabel label_1 = new JLabel("Escolha uma das op\u00E7\u00F5es acima para que possa prosseguir");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		label_1.setBounds(70, 437, 355, 23);
		contentPane.add(label_1);
	}
}
