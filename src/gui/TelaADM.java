package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaADM extends JFrame {

	private JPanel contentPane;
	private static TelaADM instance;
	
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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaADM frame = new TelaADM();
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
	public TelaADM() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadCliente = new JButton("Cad Cliente");
		btnCadCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			TelaCadastroCliente.getInstance().setVisible(true);
			dispose();
			}
		});
		btnCadCliente.setBounds(100, 60, 89, 23);
		contentPane.add(btnCadCliente);
		
		JButton btnCadInstru = new JButton("Cad Instru");
		btnCadInstru.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroInstrutor.getInstance().setVisible(true);
				dispose();
			}
		});
		btnCadInstru.setBounds(100, 138, 89, 23);
		contentPane.add(btnCadInstru);
		
		JButton btnConsultaCliente = new JButton("Cons Client");
		btnConsultaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaCliente.getInstance().setVisible(true);
				dispose();
			}
		});
		btnConsultaCliente.setBounds(233, 60, 89, 23);
		contentPane.add(btnConsultaCliente);
		
		JButton btnConsultaInstrutor = new JButton("Cons Instr");
		btnConsultaInstrutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInstrutor1.getInstance().setVisible(true);
				dispose();
			}
		});
		btnConsultaInstrutor.setBounds(233, 138, 89, 23);
		contentPane.add(btnConsultaInstrutor);
		
		JButton btnPrincipal = new JButton("Home Page");
		btnPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEntrar.getInstance().setVisible(true);
				dispose();
			}
		});
		btnPrincipal.setBounds(170, 196, 89, 23);
		contentPane.add(btnPrincipal);
	}
}
