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
import java.awt.Font;
import javax.swing.JTextPane;

public class Entrar {

	private JFrame TelaDeEntrada;

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
					Entrar window = new Entrar();
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
	public Entrar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		TelaDeEntrada = new JFrame();
		TelaDeEntrada.setTitle("Tela de Entrada");
		TelaDeEntrada.getContentPane().setBackground(Color.WHITE);
		TelaDeEntrada.getContentPane().setLayout(null);
		
		JTextPane txtpnCliqueEmUma = new JTextPane();
		txtpnCliqueEmUma.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		txtpnCliqueEmUma.setText("Clique em uma das op\u00E7\u00F5es acima para entrar no sistema");
		txtpnCliqueEmUma.setBounds(20, 399, 349, 34);
		TelaDeEntrada.getContentPane().add(txtpnCliqueEmUma);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 369, 92);
		TelaDeEntrada.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Instrutor");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(118, 241, 135, 40);
		TelaDeEntrada.getContentPane().add(btnNewButton);
		
		JButton btnAdministrador = new JButton("Administrador");
		btnAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAdministrador.setBounds(118, 168, 135, 40);
		TelaDeEntrada.getContentPane().add(btnAdministrador);
		
		JButton btnAluno = new JButton("Aluno");
		btnAluno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAluno.setBounds(118, 310, 135, 40);
		TelaDeEntrada.getContentPane().add(btnAluno);
		TelaDeEntrada.setBounds(100, 100, 385, 472);
		TelaDeEntrada.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
