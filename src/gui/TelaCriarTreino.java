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
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;

public class TelaCriarTreino extends JFrame {

	private JPanel contentPane;
	private static TelaCriarTreino instance;
	private JTextField textFieldSeries;
	private JTextField textFieldDescanso;
	private JTextField textFieldMatricula;
	private JTextField textFieldObs;
	private JTextField textFieldMatriculaInst;
	private JTextField textFieldNome;
	
	public static TelaCriarTreino getInstance() {
		if(instance == null) {
			instance = new TelaCriarTreino();
		}
		return instance;
	}
	
	public void limparCampos() {
		textFieldNome.setText("");
		textFieldSeries.setText("");
		textFieldDescanso.setText("");
		textFieldMatricula.setText("");
		textFieldObs.setText("");
		textFieldMatriculaInst.setText("");
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCriarTreino.class.getResource("/imagens/biceps png.png")));
		setTitle("Tela de Cria\u00E7\u00E3o de Treino");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 597, 429);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblExercicio = new JLabel("Exercicio 1");
		lblExercicio.setFont(new Font("Arial", Font.BOLD, 18));
		lblExercicio.setBounds(10, 27, 124, 20);
		contentPane.add(lblExercicio);
		
		JLabel lblMatricula = new JLabel("Matr\u00EDcula do Cliente:");
		lblMatricula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMatricula.setBounds(367, 62, 140, 17);
		contentPane.add(lblMatricula);
		
		textFieldMatricula = new JTextField();
		textFieldMatricula.setBounds(367, 90, 174, 28);
		contentPane.add(textFieldMatricula);
		textFieldMatricula.setColumns(10);
		
		JLabel lblMatriculaIns = new JLabel("Matr\u00EDcula do Instrutor:");
		lblMatriculaIns.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMatriculaIns.setBounds(367, 129, 157, 20);
		contentPane.add(lblMatriculaIns);
		
		textFieldMatriculaInst = new JTextField();
		textFieldMatriculaInst.setBounds(367, 160, 174, 28);
		contentPane.add(textFieldMatriculaInst);
		textFieldMatriculaInst.setColumns(10);
		
		JButton button = new JButton("P\u00E1gina Inicial");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEntrar window = new TelaEntrar();
				window.TelaDeEntrada.setVisible(true);
				dispose();
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBackground(new Color(0, 128, 0));
		button.setBounds(428, 324, 143, 38);
		contentPane.add(button);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Instrutor instru;
				Cliente cliente;
				Exercicio ex;
				RepositorioExercicioArray rep = new RepositorioExercicioArray();
				
				String categoria = "A";
				String matricula = textFieldMatricula.getText();
				String matriculaInst = textFieldMatriculaInst.getText();
				
				instru = Fachada.getInstance().procurarInstrutor(matriculaInst);
				
				cliente = Fachada.getInstance().procurarClienteMatricula(matricula);
				
				ex = new Exercicio(textFieldObs.getText(), textFieldNome.getText(), Integer.parseInt(textFieldSeries.getText()), 
						textFieldDescanso.getText());
				
				Fachada.getInstance().inserirExercicio(ex);
				
				rep.inserir(ex);
				
				Treino t = new Treino(instru, cliente, rep, Assistente.gerarId(), categoria);
				Fachada.getInstance().inserirTreino(t);
			}
		});
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCadastrar.setBackground(new Color(0, 128, 0));
		btnCadastrar.setBounds(428, 207, 143, 38);
		contentPane.add(btnCadastrar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Cria\u00E7\u00E3o de Treino", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 65, 314, 222);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(10, 45, 69, 17);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(64, 41, 174, 28);
		panel.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblSerie = new JLabel("S\u00E9ries:");
		lblSerie.setBounds(10, 85, 46, 20);
		panel.add(lblSerie);
		lblSerie.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textFieldSeries = new JTextField();
		textFieldSeries.setBounds(64, 83, 174, 28);
		panel.add(textFieldSeries);
		textFieldSeries.setColumns(10);
		
		JLabel lblDescanso = new JLabel("Descanso:");
		lblDescanso.setBounds(10, 130, 86, 14);
		panel.add(lblDescanso);
		lblDescanso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textFieldDescanso = new JTextField();
		textFieldDescanso.setBounds(86, 125, 152, 28);
		panel.add(textFieldDescanso);
		textFieldDescanso.setColumns(10);
		
		JLabel lblObs = new JLabel("Obs:");
		lblObs.setBounds(10, 168, 57, 20);
		panel.add(lblObs);
		lblObs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textFieldObs = new JTextField();
		textFieldObs.setBounds(86, 166, 152, 28);
		panel.add(textFieldObs);
		textFieldObs.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaCriarTreino.class.getResource("/imagens/MFit logotipo redemensionada.jpg")));
		lblNewLabel_1.setBounds(10, 314, 242, 65);
		contentPane.add(lblNewLabel_1);
		
		JButton button_1 = new JButton("Limpar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		button_1.setIcon(new ImageIcon(TelaCriarTreino.class.getResource("/imagens/delete_remove_bin_icon-icons.com_72400.png")));
		button_1.setBackground(new Color(255, 99, 71));
		button_1.setBounds(275, 324, 143, 38);
		contentPane.add(button_1);
	}
}
