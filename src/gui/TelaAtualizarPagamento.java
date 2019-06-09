package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import basicas.Cliente;
import basicas.Endereco;
import sistema.Fachada;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaAtualizarPagamento extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldMatricula;
	private JTextField textFieldCPF;
	JComboBox comboBox = new JComboBox();
	private static TelaAtualizarPagamento instance;
	
	public static TelaAtualizarPagamento getInstance() {
		if(instance == null) {
			instance = new TelaAtualizarPagamento();
		}
		return instance;
	}

	public void setDados(Cliente c) {
		textFieldNome.setText(c.getNome());
		textFieldCPF.setText(c.getCpf());
		textFieldMatricula.setText(c.getMatricula());
	}
	
	public String comboSelecionado() {
		if(comboBox.getSelectedIndex() == 0) {
			return "Sim";
		}else if(comboBox.getSelectedIndex() == 1) {
			return "Não";
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
					TelaAtualizarPagamento frame = new TelaAtualizarPagamento();
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
	public TelaAtualizarPagamento() {
		setTitle("Atualizar Pagamentos - MFit");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaAtualizarPagamento.class.getResource("/imagens/biceps png.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 309);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome do Cliente:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(19, 34, 127, 14);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(19, 51, 173, 29);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblMatricula = new JLabel("Matr\u00EDcula:");
		lblMatricula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMatricula.setBounds(19, 159, 82, 14);
		contentPane.add(lblMatricula);
		
		textFieldMatricula = new JTextField();
		textFieldMatricula.setBounds(19, 176, 173, 29);
		contentPane.add(textFieldMatricula);
		textFieldMatricula.setColumns(10);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCPF.setBounds(19, 94, 46, 14);
		contentPane.add(lblCPF);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setBounds(19, 110, 173, 29);
		contentPane.add(textFieldCPF);
		textFieldCPF.setColumns(10);
		
		JLabel lblPagamento = new JLabel("Pagamento Realizado:");
		lblPagamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPagamento.setBounds(265, 73, 165, 23);
		contentPane.add(lblPagamento);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sim", "N\u00E3o"}));
		comboBox.setBounds(301, 100, 60, 29);
		contentPane.add(comboBox);
		
		JButton btnVerificar = new JButton("Verificar");
		btnVerificar.setBackground(new Color(0, 128, 0));
		btnVerificar.setForeground(new Color(255, 255, 255));
		btnVerificar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String matricula = textFieldMatricula.getText();
				Cliente cliente = Fachada.getInstance().procurarClienteMatricula(matricula);
				
				if(cliente == null) {
					PopUps.UsuarioNaoExiste();
				}else {
					setDados(cliente);
				}
			}
		});
		btnVerificar.setBounds(19, 218, 124, 41);
		contentPane.add(btnVerificar);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.setBackground(new Color(0, 128, 0));
		btnConcluir.setForeground(new Color(255, 255, 255));
		btnConcluir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String matricula = textFieldMatricula.getText();
				Cliente cliente = Fachada.getInstance().procurarClienteMatricula(matricula);
				
				if(cliente == null) {
					PopUps.UsuarioNaoExiste();
				}else {
					String nome, rua, bairro, cidade, complemento, numero, cpf, email, telefone, genero, objetivo;
					Date data;
					nome = cliente.getNome();
					rua = cliente.getEndereco().getRua();
					bairro = cliente.getEndereco().getBairro();
					cidade = cliente.getEndereco().getCidade();
					complemento = cliente.getEndereco().getComplemento();
					numero = cliente.getEndereco().getNumero();
					telefone = cliente.getTelefone();
					cpf = cliente.getCpf();
					email = cliente.getEmail();
					genero = cliente.getGenero();
					objetivo = cliente.getObjetivo();
					data = cliente.getDataDeNasc();
					Endereco end = new Endereco(rua, bairro, cidade, complemento, numero);
					
					Cliente c = new Cliente(nome, end, cpf, data, matricula, email, telefone, genero, 
							comboSelecionado(), objetivo);
					
					Fachada.getInstance().atualizar(c);
					JOptionPane.showMessageDialog(null, "Done");
				}
			}
		});
		btnConcluir.setBounds(272, 139, 124, 41);
		contentPane.add(btnConcluir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(TelaAtualizarPagamento.class.getResource("/imagens/gtkgobackltr_104397.png")));
		btnVoltar.setBackground(new Color(0, 128, 0));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean confirm;
				confirm = PopUps.ConfirmarIda();
				
				if(confirm == true) {
				TelaInstrutor.getInstance().setVisible(true);
				TelaInstrutor.getInstance().setLocationRelativeTo(null);
				dispose();
				}
			}
		});
		btnVoltar.setBounds(272, 218, 124, 41);
		contentPane.add(btnVoltar);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PopUps.InformacaoDuvida(); //Alterar esse PopUps depois
			}
		});
		label.setIcon(new ImageIcon(TelaAtualizarPagamento.class.getResource("/imagens/Bot\u00E3o d\u00FAvidas.png")));
		label.setBounds(298, 0, 71, 62);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("D\u00FAvidas?");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PopUps.InformacaoDuvida(); //Alterar esse PopUps depois
			}
		});
		label_1.setForeground(new Color(0, 128, 0));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(368, 14, 78, 28);
		contentPane.add(label_1);
	}
}
