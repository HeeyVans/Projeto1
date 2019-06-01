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
		
		JButton btnPginaInicial = new JButton("P\u00E1gina Inicial");
		btnPginaInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEntrar entrar = new TelaEntrar();
				entrar.TelaDeEntrada.setVisible(true);
				entrar.TelaDeEntrada.setLocationRelativeTo(null);
				dispose();
				
			}
		});
		btnPginaInicial.setForeground(Color.WHITE);
		btnPginaInicial.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPginaInicial.setBackground(new Color(0, 128, 0));
		btnPginaInicial.setBounds(154, 345, 176, 41);
		contentPane.add(btnPginaInicial);
		
		JLabel label_1 = new JLabel("Escolha uma das op\u00E7\u00F5es acima para que possa prosseguir");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		label_1.setBounds(70, 437, 355, 23);
		contentPane.add(label_1);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaInstrutor.getInstance().setVisible(true);
				TelaInstrutor.getInstance().setLocationRelativeTo(null);
				dispose();
			}
		});
		btnCliente.setBounds(91, 183, 89, 23);
		contentPane.add(btnCliente);
		
		JButton btnInstrutor = new JButton("Instrutor");
		btnInstrutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaInstrutor.getInstance().setVisible(true);
				TelaConsultaInstrutor.getInstance().setLocationRelativeTo(null);
				dispose();
			}
		});
		btnInstrutor.setBounds(223, 183, 89, 23);
		contentPane.add(btnInstrutor);
	}
}
