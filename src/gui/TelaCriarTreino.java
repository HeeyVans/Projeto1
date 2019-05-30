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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaCriarTreino extends JFrame {

	private JPanel contentPane;
	private static TelaCriarTreino instance;
	private JTextField textFieldSeries;
	private JTextField textFieldDescanso;
	private JTextField textFieldMatricula;
	private JTextField textFieldObs;
	private JTextField textFieldNome;
	private JTextField textFieldNome2;
	private JTextField textFieldSeries2;
	private JTextField textFieldDescanso2;
	private JTextField textFieldObs2;
	private JTextField textFieldNome3;
	private JTextField textFieldSeries3;
	private JTextField textFieldDescanso3;
	private JTextField textFieldObs3;
	private JTextField textFieldNome4;
	private JTextField textFieldSeries4;
	private JTextField textFieldDescanso4;
	private JTextField textFieldObs4;
	private JTextField textFieldNome5;
	private JTextField textFieldSeries5;
	private JTextField textFieldDescanso5;
	private JTextField textFieldObs5;
	private JTextField textFieldNome6;
	private JTextField textFieldSeries6;
	private JTextField textFieldDescanso6;
	private JTextField textFieldObs6;
	JComboBox comboBoxCategoria = new JComboBox();
	
	public static TelaCriarTreino getInstance() {
		if(instance == null) {
			instance = new TelaCriarTreino();
		}
		return instance;
	}
	
	public void limpar() {
		textFieldNome.setText("");
		textFieldSeries.setText("");
		textFieldDescanso.setText("");
		textFieldMatricula.setText("");
		textFieldObs.setText("");
		textFieldNome2.setText("");
		textFieldSeries2.setText("");
		textFieldDescanso2.setText("");
		textFieldObs2.setText("");
		textFieldNome3.setText("");
		textFieldSeries3.setText("");
		textFieldDescanso3.setText("");
		textFieldObs3.setText("");
		textFieldNome4.setText("");
		textFieldSeries4.setText("");
		textFieldDescanso4.setText("");
		textFieldObs4.setText("");
		textFieldNome5.setText("");
		textFieldSeries5.setText("");
		textFieldDescanso5.setText("");
		textFieldObs5.setText("");
		textFieldNome6.setText("");
		textFieldSeries6.setText("");
		textFieldDescanso6.setText("");
		textFieldObs6.setText("");
	}
	
private String comboSelecionado() {
		
		if(comboBoxCategoria.getSelectedIndex() == 0) {
			return "A";
		}else if(comboBoxCategoria.getSelectedIndex() == 1) {
			return "B";
		}else if(comboBoxCategoria.getSelectedIndex() == 2) {
			return "C";
		}else if(comboBoxCategoria.getSelectedIndex() == 3) {
			return "D";
		}else if(comboBoxCategoria.getSelectedIndex() == 4) {
			return "E";
		}else {
			return null;
		}
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
		setBounds(100, 100, 1301, 755);
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
				
				Instrutor instru = TelaEntrar.instrutor;
				Cliente cliente;
				Exercicio ex, ex1, ex2, ex3, ex4, ex5;
				RepositorioExercicioArray rep = new RepositorioExercicioArray();
				
				String matricula = textFieldMatricula.getText();
				
				cliente = Fachada.getInstance().procurarClienteMatricula(matricula);
				
				ex = new Exercicio(textFieldObs.getText(), textFieldNome.getText(), Integer.parseInt(textFieldSeries.getText()), 
						textFieldDescanso.getText());
				ex1 = new Exercicio(textFieldObs2.getText(), textFieldNome2.getText(), Integer.parseInt(textFieldSeries2.getText()), 
						textFieldDescanso2.getText());
				ex2 = new Exercicio(textFieldObs3.getText(), textFieldNome3.getText(), Integer.parseInt(textFieldSeries3.getText()), 
						textFieldDescanso3.getText());
				ex3 = new Exercicio(textFieldObs4.getText(), textFieldNome4.getText(), Integer.parseInt(textFieldSeries4.getText()), 
						textFieldDescanso4.getText());
				ex4 = new Exercicio(textFieldObs5.getText(), textFieldNome5.getText(), Integer.parseInt(textFieldSeries5.getText()), 
						textFieldDescanso5.getText());
				ex5 = new Exercicio(textFieldObs6.getText(), textFieldNome6.getText(), Integer.parseInt(textFieldSeries6.getText()), 
						textFieldDescanso6.getText());
				
				Fachada.getInstance().inserirExercicio(ex);
				
				rep.inserir(ex);
				rep.inserir(ex1);
				rep.inserir(ex2);
				rep.inserir(ex3);
				rep.inserir(ex4);
				rep.inserir(ex5);
				
				Treino t = new Treino(instru, cliente, rep, Assistente.gerarId(), comboSelecionado());
				Fachada.getInstance().inserirTreino(t);
				limpar();
				PopUps.treinoCriado();
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
				limpar();
			}
		});
		button_1.setIcon(new ImageIcon(TelaCriarTreino.class.getResource("/imagens/delete_remove_bin_icon-icons.com_72400.png")));
		button_1.setBackground(new Color(255, 99, 71));
		button_1.setBounds(275, 324, 143, 38);
		contentPane.add(button_1);
		
		JLabel lblExercicio2 = new JLabel("Exerc\u00EDcio 2:");
		lblExercicio2.setBounds(10, 390, 86, 14);
		contentPane.add(lblExercicio2);
		
		textFieldNome2 = new JTextField();
		textFieldNome2.setBounds(70, 415, 86, 20);
		contentPane.add(textFieldNome2);
		textFieldNome2.setColumns(10);
		
		textFieldSeries2 = new JTextField();
		textFieldSeries2.setBounds(70, 445, 86, 20);
		contentPane.add(textFieldSeries2);
		textFieldSeries2.setColumns(10);
		
		textFieldDescanso2 = new JTextField();
		textFieldDescanso2.setBounds(70, 479, 86, 20);
		contentPane.add(textFieldDescanso2);
		textFieldDescanso2.setColumns(10);
		
		textFieldObs2 = new JTextField();
		textFieldObs2.setBounds(70, 510, 86, 20);
		contentPane.add(textFieldObs2);
		textFieldObs2.setColumns(10);
		
		JLabel lblExercicio3 = new JLabel("Exerc\u00EDcio 3:");
		lblExercicio3.setBounds(222, 390, 71, 14);
		contentPane.add(lblExercicio3);
		
		textFieldNome3 = new JTextField();
		textFieldNome3.setBounds(275, 415, 86, 20);
		contentPane.add(textFieldNome3);
		textFieldNome3.setColumns(10);
		
		textFieldSeries3 = new JTextField();
		textFieldSeries3.setBounds(275, 456, 86, 20);
		contentPane.add(textFieldSeries3);
		textFieldSeries3.setColumns(10);
		
		textFieldDescanso3 = new JTextField();
		textFieldDescanso3.setBounds(275, 493, 86, 20);
		contentPane.add(textFieldDescanso3);
		textFieldDescanso3.setColumns(10);
		
		textFieldObs3 = new JTextField();
		textFieldObs3.setBounds(275, 532, 86, 20);
		contentPane.add(textFieldObs3);
		textFieldObs3.setColumns(10);
		
		JLabel lblExercicio4 = new JLabel("Exerc\u00EDcio 4:");
		lblExercicio4.setBounds(402, 390, 71, 14);
		contentPane.add(lblExercicio4);
		
		textFieldNome4 = new JTextField();
		textFieldNome4.setBounds(455, 415, 86, 20);
		contentPane.add(textFieldNome4);
		textFieldNome4.setColumns(10);
		
		textFieldSeries4 = new JTextField();
		textFieldSeries4.setBounds(455, 456, 86, 20);
		contentPane.add(textFieldSeries4);
		textFieldSeries4.setColumns(10);
		
		textFieldDescanso4 = new JTextField();
		textFieldDescanso4.setBounds(455, 493, 86, 20);
		contentPane.add(textFieldDescanso4);
		textFieldDescanso4.setColumns(10);
		
		textFieldObs4 = new JTextField();
		textFieldObs4.setBounds(455, 532, 86, 20);
		contentPane.add(textFieldObs4);
		textFieldObs4.setColumns(10);
		
		JLabel lblExercicio5 = new JLabel("Exerc\u00EDcio 5:");
		lblExercicio5.setBounds(592, 390, 71, 14);
		contentPane.add(lblExercicio5);
		
		textFieldNome5 = new JTextField();
		textFieldNome5.setBounds(647, 404, 86, 20);
		contentPane.add(textFieldNome5);
		textFieldNome5.setColumns(10);
		
		textFieldSeries5 = new JTextField();
		textFieldSeries5.setBounds(647, 445, 86, 20);
		contentPane.add(textFieldSeries5);
		textFieldSeries5.setColumns(10);
		
		textFieldDescanso5 = new JTextField();
		textFieldDescanso5.setBounds(647, 493, 86, 20);
		contentPane.add(textFieldDescanso5);
		textFieldDescanso5.setColumns(10);
		
		textFieldObs5 = new JTextField();
		textFieldObs5.setBounds(647, 532, 86, 20);
		contentPane.add(textFieldObs5);
		textFieldObs5.setColumns(10);
		
		JLabel lblExercicio6 = new JLabel("Exerc\u00EDcio 6:");
		lblExercicio6.setBounds(662, 196, 71, 14);
		contentPane.add(lblExercicio6);
		
		textFieldNome6 = new JTextField();
		textFieldNome6.setBounds(657, 218, 86, 20);
		contentPane.add(textFieldNome6);
		textFieldNome6.setColumns(10);
		
		textFieldSeries6 = new JTextField();
		textFieldSeries6.setBounds(667, 249, 86, 20);
		contentPane.add(textFieldSeries6);
		textFieldSeries6.setColumns(10);
		
		textFieldDescanso6 = new JTextField();
		textFieldDescanso6.setBounds(657, 280, 86, 20);
		contentPane.add(textFieldDescanso6);
		textFieldDescanso6.setColumns(10);
		
		textFieldObs6 = new JTextField();
		textFieldObs6.setBounds(657, 314, 86, 20);
		contentPane.add(textFieldObs6);
		textFieldObs6.setColumns(10);
		
		
		comboBoxCategoria.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D", "E"}));
		comboBoxCategoria.setBounds(483, 272, 58, 28);
		contentPane.add(comboBoxCategoria);
	}
}
