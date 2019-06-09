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
import excecoes.MatriculaNaoEncontradaException;
import sistema.Assistente;
import sistema.Fachada;
import sistema.ValidarDados;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

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
	private JLabel lblExercicio3;
	private JPanel panel_2;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel lblExercicio4;
	private JPanel panel_3;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel lblExercicio5;
	private JPanel panel_4;
	private JLabel label_12;
	private JLabel label_13;
	private JLabel label_14;
	private JLabel label_15;
	private JLabel lblExercicio_1;
	private JPanel panel_5;
	private JLabel label_16;
	private JLabel label_17;
	private JLabel label_18;
	private JLabel label_19;
	private JLabel lblCategoriaDoTreino;
	private JTextField textFieldVezes;
	
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
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
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
		setBounds(100, 100, 1086, 753);
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
		lblMatricula.setBounds(338, 581, 140, 17);
		contentPane.add(lblMatricula);
		
		textFieldMatricula = new JTextField();
		textFieldMatricula.setBounds(339, 609, 174, 28);
		contentPane.add(textFieldMatricula);
		textFieldMatricula.setColumns(10);
		
		JButton button = new JButton("P\u00E1gina Inicial");
		button.setToolTipText("Voltar para a p\u00E1gina inicial");
		button.setIcon(null);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean confirm;
				confirm = PopUps.ConfirmarIdaHomePage();
				
				if(confirm == true) {
						TelaEntrar window = new TelaEntrar();
						window.TelaDeEntrada.setVisible(true);
						window.TelaDeEntrada.setLocationRelativeTo(null);
						dispose();
										
				}
				
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBackground(new Color(0, 128, 0));
		button.setBounds(887, 609, 143, 38);
		contentPane.add(button);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setToolTipText("Cadastramento do treino");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean confirm;
				confirm = PopUps.ConfirmarCadastro();
				
				if(confirm == true && textFieldMatricula.getText() != "") {
						
					if(ValidarDados.validarCampoVazio(textFieldDescanso3.getText(),textFieldDescanso4.getText(), 
							textFieldDescanso5.getText(), textFieldDescanso6.getText(), textFieldNome.getText(),
							textFieldNome2.getText(), textFieldNome3.getText(), textFieldNome4.getText(), textFieldNome5.getText(), 
							textFieldNome6.getText(), textFieldSeries.getText(), textFieldSeries2.getText(), textFieldSeries3.getText(), 
							textFieldSeries4.getText(), textFieldSeries5.getText(), textFieldSeries6.getText(),
							textFieldDescanso.getText(), textFieldDescanso2.getText())) {
						
						try {
							Instrutor instru = TelaEntrar.instrutor;
							Cliente cliente;
							Exercicio ex, ex1, ex2, ex3, ex4, ex5;
							
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
													
							ArrayList<Exercicio> categoria = new ArrayList<Exercicio>();
							
							categoria.add(ex);
							categoria.add(ex1);
							categoria.add(ex2);
							categoria.add(ex3);
							categoria.add(ex4);
							categoria.add(ex5);
							
							LocalDateTime localDate = LocalDateTime.now();
							
							Treino t = new Treino(instru, cliente, categoria, comboSelecionado()
									,Integer.parseInt(textFieldVezes.getText()), 0, localDate, Assistente.gerarID());
							Fachada.getInstance().inserirTreino(t);
							limpar();
							PopUps.treinoCriado();
							
						}catch(MatriculaNaoEncontradaException mnee) {
							PopUps.matriculaInvalida(mnee);
						}
						
					}					
				}
				
				
				
			}
		});
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCadastrar.setBackground(new Color(0, 128, 0));
		btnCadastrar.setBounds(727, 655, 143, 38);
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
		textFieldSeries.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				String caracteres="0987654321";
			       if(!caracteres.contains(arg0.getKeyChar()+"")){
			              arg0.consume();

			       }
			}
		});
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
		lblNewLabel_1.setBounds(10, 581, 274, 112);
		contentPane.add(lblNewLabel_1);
		
		JButton button_1 = new JButton("Limpar");
		button_1.setToolTipText("Limpar todos os campos de texto");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		button_1.setIcon(new ImageIcon(TelaCriarTreino.class.getResource("/imagens/delete_remove_bin_icon-icons.com_72400.png")));
		button_1.setBackground(new Color(255, 99, 71));
		button_1.setBounds(566, 655, 143, 38);
		contentPane.add(button_1);
		comboBoxCategoria.setBackground(new Color(0, 128, 0));
		comboBoxCategoria.setForeground(Color.WHITE);
		
		
		comboBoxCategoria.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C"}));
		comboBoxCategoria.setBounds(338, 677, 58, 28);
		contentPane.add(comboBoxCategoria);
		
		JLabel lblExercicio2 = new JLabel("Exercicio 2");
		lblExercicio2.setFont(new Font("Arial", Font.BOLD, 18));
		lblExercicio2.setBounds(362, 27, 124, 20);
		contentPane.add(lblExercicio2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Cria\u00E7\u00E3o de Treino", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(362, 65, 314, 222);
		contentPane.add(panel_1);
		
		JLabel label = new JLabel("Nome:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(10, 45, 69, 17);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("S\u00E9ries:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(10, 85, 46, 20);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Descanso:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(10, 130, 86, 14);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Obs:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(10, 168, 57, 20);
		panel_1.add(label_3);
		
		textFieldNome2 = new JTextField();
		textFieldNome2.setBounds(64, 41, 174, 28);
		panel_1.add(textFieldNome2);
		textFieldNome2.setColumns(10);
		
		textFieldSeries2 = new JTextField();
		textFieldSeries2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres="0987654321";
			       if(!caracteres.contains(e.getKeyChar()+"")){
			              e.consume();

			       }
			}
		});
		textFieldSeries2.setBounds(66, 83, 174, 28);
		panel_1.add(textFieldSeries2);
		textFieldSeries2.setColumns(10);
		
		textFieldDescanso2 = new JTextField();
		textFieldDescanso2.setBounds(86, 125, 152, 28);
		panel_1.add(textFieldDescanso2);
		textFieldDescanso2.setColumns(10);
		
		textFieldObs2 = new JTextField();
		textFieldObs2.setBounds(86, 166, 152, 28);
		panel_1.add(textFieldObs2);
		textFieldObs2.setColumns(10);
		
		lblExercicio3 = new JLabel("Exercicio 3");
		lblExercicio3.setFont(new Font("Arial", Font.BOLD, 18));
		lblExercicio3.setBounds(716, 27, 124, 20);
		contentPane.add(lblExercicio3);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Cria\u00E7\u00E3o de Treino", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(716, 65, 314, 222);
		contentPane.add(panel_2);
		
		label_4 = new JLabel("Nome:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(10, 45, 69, 17);
		panel_2.add(label_4);
		
		label_5 = new JLabel("S\u00E9ries:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(10, 85, 46, 20);
		panel_2.add(label_5);
		
		label_6 = new JLabel("Descanso:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBounds(10, 130, 86, 14);
		panel_2.add(label_6);
		
		label_7 = new JLabel("Obs:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_7.setBounds(10, 168, 57, 20);
		panel_2.add(label_7);
		
		textFieldNome3 = new JTextField();
		textFieldNome3.setBounds(66, 41, 174, 28);
		panel_2.add(textFieldNome3);
		textFieldNome3.setColumns(10);
		
		textFieldSeries3 = new JTextField();
		textFieldSeries3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres="0987654321";
			       if(!caracteres.contains(e.getKeyChar()+"")){
			              e.consume();

			       }
			}
		});
		textFieldSeries3.setBounds(66, 83, 174, 28);
		panel_2.add(textFieldSeries3);
		textFieldSeries3.setColumns(10);
		
		textFieldDescanso3 = new JTextField();
		textFieldDescanso3.setBounds(88, 125, 152, 28);
		panel_2.add(textFieldDescanso3);
		textFieldDescanso3.setColumns(10);
		
		textFieldObs3 = new JTextField();
		textFieldObs3.setBounds(88, 166, 152, 28);
		panel_2.add(textFieldObs3);
		textFieldObs3.setColumns(10);
		
		lblExercicio4 = new JLabel("Exercicio 4");
		lblExercicio4.setFont(new Font("Arial", Font.BOLD, 18));
		lblExercicio4.setBounds(10, 317, 124, 20);
		contentPane.add(lblExercicio4);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(null, "Cria\u00E7\u00E3o de Treino", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 348, 314, 222);
		contentPane.add(panel_3);
		
		label_8 = new JLabel("Nome:");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_8.setBounds(10, 45, 69, 17);
		panel_3.add(label_8);
		
		label_9 = new JLabel("S\u00E9ries:");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_9.setBounds(10, 85, 46, 20);
		panel_3.add(label_9);
		
		label_10 = new JLabel("Descanso:");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_10.setBounds(10, 130, 86, 14);
		panel_3.add(label_10);
		
		label_11 = new JLabel("Obs:");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_11.setBounds(10, 168, 57, 20);
		panel_3.add(label_11);
		
		textFieldNome4 = new JTextField();
		textFieldNome4.setBounds(66, 41, 174, 28);
		panel_3.add(textFieldNome4);
		textFieldNome4.setColumns(10);
		
		textFieldSeries4 = new JTextField();
		textFieldSeries4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres="0987654321";
			       if(!caracteres.contains(e.getKeyChar()+"")){
			              e.consume();

			       }
			}
		});
		textFieldSeries4.setBounds(66, 83, 174, 28);
		panel_3.add(textFieldSeries4);
		textFieldSeries4.setColumns(10);
		
		textFieldDescanso4 = new JTextField();
		textFieldDescanso4.setBounds(88, 125, 152, 28);
		panel_3.add(textFieldDescanso4);
		textFieldDescanso4.setColumns(10);
		
		textFieldObs4 = new JTextField();
		textFieldObs4.setBounds(88, 166, 152, 28);
		panel_3.add(textFieldObs4);
		textFieldObs4.setColumns(10);
		
		lblExercicio5 = new JLabel("Exercicio 5");
		lblExercicio5.setFont(new Font("Arial", Font.BOLD, 18));
		lblExercicio5.setBounds(362, 317, 124, 20);
		contentPane.add(lblExercicio5);
		
		panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(null, "Cria\u00E7\u00E3o de Treino", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(362, 348, 314, 222);
		contentPane.add(panel_4);
		
		label_12 = new JLabel("Nome:");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_12.setBounds(10, 45, 69, 17);
		panel_4.add(label_12);
		
		label_13 = new JLabel("S\u00E9ries:");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_13.setBounds(10, 85, 46, 20);
		panel_4.add(label_13);
		
		label_14 = new JLabel("Descanso:");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_14.setBounds(10, 130, 86, 14);
		panel_4.add(label_14);
		
		label_15 = new JLabel("Obs:");
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_15.setBounds(10, 168, 57, 20);
		panel_4.add(label_15);
		
		textFieldNome5 = new JTextField();
		textFieldNome5.setBounds(66, 41, 174, 28);
		panel_4.add(textFieldNome5);
		textFieldNome5.setColumns(10);
		
		textFieldSeries5 = new JTextField();
		textFieldSeries5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres="0987654321";
			       if(!caracteres.contains(e.getKeyChar()+"")){
			              e.consume();

			       }
			}
		});
		textFieldSeries5.setBounds(66, 83, 174, 28);
		panel_4.add(textFieldSeries5);
		textFieldSeries5.setColumns(10);
		
		textFieldDescanso5 = new JTextField();
		textFieldDescanso5.setBounds(88, 125, 152, 28);
		panel_4.add(textFieldDescanso5);
		textFieldDescanso5.setColumns(10);
		
		textFieldObs5 = new JTextField();
		textFieldObs5.setBounds(88, 166, 152, 28);
		panel_4.add(textFieldObs5);
		textFieldObs5.setColumns(10);
		
		lblExercicio_1 = new JLabel("Exercicio 6");
		lblExercicio_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblExercicio_1.setBounds(716, 317, 124, 20);
		contentPane.add(lblExercicio_1);
		
		panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(null, "Cria\u00E7\u00E3o de Treino", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(716, 348, 314, 222);
		contentPane.add(panel_5);
		
		label_16 = new JLabel("Nome:");
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_16.setBounds(10, 45, 69, 17);
		panel_5.add(label_16);
		
		label_17 = new JLabel("S\u00E9ries:");
		label_17.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_17.setBounds(10, 85, 46, 20);
		panel_5.add(label_17);
		
		label_18 = new JLabel("Descanso:");
		label_18.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_18.setBounds(10, 130, 86, 14);
		panel_5.add(label_18);
		
		label_19 = new JLabel("Obs:");
		label_19.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_19.setBounds(10, 168, 57, 20);
		panel_5.add(label_19);
		
		textFieldNome6 = new JTextField();
		textFieldNome6.setBounds(66, 41, 174, 28);
		panel_5.add(textFieldNome6);
		textFieldNome6.setColumns(10);
		
		textFieldSeries6 = new JTextField();
		textFieldSeries6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres="0987654321";
			       if(!caracteres.contains(e.getKeyChar()+"")){
			              e.consume();

			       }
			}
		});
		textFieldSeries6.setBounds(66, 83, 174, 28);
		panel_5.add(textFieldSeries6);
		textFieldSeries6.setColumns(10);
		
		textFieldDescanso6 = new JTextField();
		textFieldDescanso6.setBounds(88, 125, 152, 28);
		panel_5.add(textFieldDescanso6);
		textFieldDescanso6.setColumns(10);
		
		textFieldObs6 = new JTextField();
		textFieldObs6.setBounds(88, 166, 152, 28);
		panel_5.add(textFieldObs6);
		textFieldObs6.setColumns(10);
		
		lblCategoriaDoTreino = new JLabel("Categoria do Treino:");
		lblCategoriaDoTreino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCategoriaDoTreino.setBounds(338, 648, 140, 17);
		contentPane.add(lblCategoriaDoTreino);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setToolTipText("Voltar para tela anterior");
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.setIcon(new ImageIcon(TelaCriarTreino.class.getResource("/imagens/gtkgobackltr_104397.png")));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setBackground(new Color(0, 128, 0));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean confirm;
				confirm = PopUps.ConfirmarVolta();
				
				if(confirm == true) {
						TelaInstrutor.getInstance().setVisible(true);
						TelaInstrutor.getInstance().setLocationRelativeTo(null);
						dispose();
				}
			}
		});
		btnVoltar.setBounds(887, 657, 143, 38);
		contentPane.add(btnVoltar);
		
		textFieldVezes = new JTextField();
		textFieldVezes.setBounds(549, 609, 174, 28);
		contentPane.add(textFieldVezes);
		textFieldVezes.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total de Treinos:");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotal.setBounds(549, 582, 114, 14);
		contentPane.add(lblTotal);
	}
}
