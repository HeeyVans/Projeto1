package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;

public class TelaEscolhaEntrada extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEscolhaEntrada frame = new TelaEscolhaEntrada();
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
	public TelaEscolhaEntrada() {
		setTitle("Tela de entrada - MFit");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaEscolhaEntrada.class.getResource("/imagens/biceps png.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		panel.setBounds(0, 0, 488, 107);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMFit = new JLabel("");
		lblMFit.setIcon(new ImageIcon(TelaEscolhaEntrada.class.getResource("/imagens/MFit logotipo.png")));
		lblMFit.setBounds(79, 0, 340, 117);
		panel.add(lblMFit);
		
		JLabel lblEscolha = new JLabel("Escolha uma das op\u00E7\u00F5es acima para que possa prosseguir");
		lblEscolha.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblEscolha.setBounds(76, 424, 355, 23);
		contentPane.add(lblEscolha);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.setForeground(new Color(255, 255, 255));
		btnCliente.setBackground(new Color(0, 128, 0));
		btnCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCliente.setBounds(154, 142, 176, 41);
		contentPane.add(btnCliente);
		
		JButton btnInstrutor = new JButton("Instrutor");
		btnInstrutor.setForeground(new Color(255, 255, 255));
		btnInstrutor.setBackground(new Color(0, 128, 0));
		btnInstrutor.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInstrutor.setBounds(154, 220, 176, 41);
		contentPane.add(btnInstrutor);
		
		JButton btnAdm = new JButton("ADM");
		btnAdm.setForeground(new Color(255, 255, 255));
		btnAdm.setBackground(new Color(0, 128, 0));
		btnAdm.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdm.setBounds(154, 296, 176, 41);
		contentPane.add(btnAdm);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(TelaEscolhaEntrada.class.getResource("/imagens/gtkgobackltr_104397.png")));
		btnVoltar.setBounds(22, 378, 108, 29);
		contentPane.add(btnVoltar);
	}
}
