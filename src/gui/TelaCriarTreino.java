package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import basicas.Cliente;
import basicas.Exercicio;
import basicas.Instrutor;
import basicas.Treino;
import repositorios.RepositorioExercicioArray;
import sistema.Assistente;
import sistema.Fachada;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCriarTreino extends JFrame {

	private JPanel contentPane;
	private static TelaCriarTreino instance;
	private JTextField textFieldNome;
	private JTextField textFieldSeries;
	private JTextField textFieldDescanso;
	private JTextField textFieldMatricula;
	private JTextField textFieldObs;
	private JTextField textFieldMatriculaInst;
	
	public static TelaCriarTreino getInstance() {
		if(instance == null) {
			instance = new TelaCriarTreino();
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
					TelaCriarTreino frame = new TelaCriarTreino();
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
	public TelaCriarTreino() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblExercicio = new JLabel("Exercicio1");
		lblExercicio.setBounds(28, 30, 57, 14);
		contentPane.add(lblExercicio);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(28, 81, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSerie = new JLabel("S\u00E9ries:");
		lblSerie.setBounds(28, 132, 46, 14);
		contentPane.add(lblSerie);
		
		JLabel lblDescanso = new JLabel("Descanso:");
		lblDescanso.setBounds(28, 184, 69, 14);
		contentPane.add(lblDescanso);
		
		JLabel lblMatricula = new JLabel("Matr\u00EDcula do Cliente:");
		lblMatricula.setBounds(28, 237, 103, 14);
		contentPane.add(lblMatricula);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(84, 78, 86, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldSeries = new JTextField();
		textFieldSeries.setBounds(84, 129, 86, 20);
		contentPane.add(textFieldSeries);
		textFieldSeries.setColumns(10);
		
		textFieldDescanso = new JTextField();
		textFieldDescanso.setBounds(84, 181, 86, 20);
		contentPane.add(textFieldDescanso);
		textFieldDescanso.setColumns(10);
		
		textFieldMatricula = new JTextField();
		textFieldMatricula.setBounds(141, 234, 86, 20);
		contentPane.add(textFieldMatricula);
		textFieldMatricula.setColumns(10);
		
		JButton btnCadastrarTreino = new JButton("Cadastrar");
		btnCadastrarTreino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Instrutor instru;
				Cliente cliente;
				Exercicio ex;
				RepositorioExercicioArray rep = new RepositorioExercicioArray();
				
				String matricula = textFieldMatricula.getText();
				String matriculaInst = textFieldMatriculaInst.getText();
				
				instru = Fachada.getInstance().procurarInstrutor(matriculaInst);
				
				cliente = Fachada.getInstance().procurarClienteMatricula(matricula);
				
				ex = new Exercicio(textFieldObs.getText(), textFieldNome.getText(), Integer.parseInt(textFieldSeries.getText()), 
						textFieldDescanso.getText());
				
				Fachada.getInstance().inserirExercicio(ex);
				
				rep.inserir(ex);
				
				Treino t = new Treino(instru, cliente, rep, Assistente.gerarId());
				Fachada.getInstance().inserirTreino(t);
				
			}
		});
		btnCadastrarTreino.setBounds(210, 276, 89, 23);
		contentPane.add(btnCadastrarTreino);
		
		JLabel lblObs = new JLabel("Obs:");
		lblObs.setBounds(206, 81, 46, 14);
		contentPane.add(lblObs);
		
		textFieldObs = new JTextField();
		textFieldObs.setBounds(263, 78, 86, 20);
		contentPane.add(textFieldObs);
		textFieldObs.setColumns(10);
		
		JButton btnHome = new JButton("HomePage");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEntrar window = new TelaEntrar();
				window.TelaDeEntrada.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(294, 233, 89, 23);
		contentPane.add(btnHome);
		
		JLabel lblMatriculaIns = new JLabel("Matr\u00EDcula do Instrutor");
		lblMatriculaIns.setBounds(210, 132, 124, 14);
		contentPane.add(lblMatriculaIns);
		
		textFieldMatriculaInst = new JTextField();
		textFieldMatriculaInst.setBounds(263, 157, 86, 20);
		contentPane.add(textFieldMatriculaInst);
		textFieldMatriculaInst.setColumns(10);
	}

}
