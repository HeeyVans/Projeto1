package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import basicas.Cliente;
import basicas.Endereco;
import sistema.Assistente;
import sistema.Fachada;
import sistema.Mensagem;
import sistema.ValidarDados;

import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class TelaDadosCliente extends JFrame {

	private JPanel contentPane;
	private static TelaDadosCliente instance;
	private JTextField textFieldNome;
	private JTextField textFieldCPF;
	private JTextField textFieldData;
	private JTextField textFieldMatricula;
	private JTextField textFieldEmail;
	private JTextField textFieldTelefone;
	private JTextField textFieldSexo;
	private JTextField textFieldCidade;
	private JTextField textFieldRua;
	private JTextField textFieldBairro;
	private JTextField textFieldNumero;
	private JTextField textFieldComplemento;
	private JTextField textFieldPagamento;
	private JTextField textFieldObjetivo;
	JDateChooser dataNascimento = new JDateChooser();
	
	public static TelaDadosCliente getInstance() {
		if(instance == null) {
			instance = new TelaDadosCliente();
		}
		return instance;
	}
	
	public void setDados(Cliente c) {
		textFieldNome.setText(c.getNome());
		textFieldCPF.setText(c.getCpf());
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dataFormatada = dateFormat.format(c.getDataDeNasc());
		textFieldData.setText(dataFormatada);
		textFieldMatricula.setText(c.getMatricula());
		textFieldEmail.setText(c.getEmail());
		textFieldTelefone.setText(c.getTelefone());
		textFieldSexo.setText(c.getGenero());
		textFieldCidade.setText(c.getEndereco().getCidade());
		textFieldRua.setText(c.getEndereco().getRua());
		textFieldBairro.setText(c.getEndereco().getBairro());
		textFieldNumero.setText(c.getEndereco().getNumero());
		textFieldComplemento.setText(c.getEndereco().getComplemento());
		textFieldPagamento.setText(c.getPagamento());
		textFieldObjetivo.setText(c.getObjetivo());
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
					TelaDadosCliente frame = new TelaDadosCliente();
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
	public TelaDadosCliente() {		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaDadosCliente.class.getResource("/imagens/biceps png.png")));
		setTitle("Informa\u00E7\u00F5es do Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 466);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(40, 37, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblInformacoes = new JLabel("Informa\u00E7\u00F5es ");
		lblInformacoes.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformacoes.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblInformacoes.setToolTipText("");
		lblInformacoes.setBounds(247, 11, 125, 25);
		contentPane.add(lblInformacoes);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(40, 84, 46, 14);
		contentPane.add(lblCPF);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(40, 359, 46, 14);
		contentPane.add(lblData);
		
		JLabel lblMatricula = new JLabel("Matr\u00EDcula:");
		lblMatricula.setBounds(40, 139, 60, 14);
		contentPane.add(lblMatricula);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(40, 195, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(40, 252, 60, 14);
		contentPane.add(lblTelefone);
		
		JLabel lblGenero = new JLabel("Sexo:");
		lblGenero.setBounds(40, 307, 46, 14);
		contentPane.add(lblGenero);
		
		JLabel lblPagamento = new JLabel("Pagamento:");
		lblPagamento.setBounds(247, 274, 84, 14);
		contentPane.add(lblPagamento);
		
		JLabel lblObjetivo = new JLabel("Objetivo:");
		lblObjetivo.setBounds(453, 274, 69, 14);
		contentPane.add(lblObjetivo);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(40, 53, 170, 28);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setBounds(40, 100, 170, 28);
		contentPane.add(textFieldCPF);
		textFieldCPF.setColumns(10);
		
		textFieldData = new JTextField();
		textFieldData.setBounds(40, 381, 170, 28);
		contentPane.add(textFieldData);
		textFieldData.setColumns(10);
		
		textFieldMatricula = new JTextField();
		textFieldMatricula.setBounds(40, 156, 170, 28);
		contentPane.add(textFieldMatricula);
		textFieldMatricula.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(40, 213, 170, 28);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(40, 267, 170, 28);
		contentPane.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		textFieldSexo = new JTextField();
		textFieldSexo.setBounds(40, 321, 170, 28);
		contentPane.add(textFieldSexo);
		textFieldSexo.setColumns(10);
		
		textFieldPagamento = new JTextField();
		textFieldPagamento.setBounds(247, 293, 170, 28);
		contentPane.add(textFieldPagamento);
		textFieldPagamento.setColumns(10);
		
		textFieldObjetivo = new JTextField();
		textFieldObjetivo.setBounds(455, 293, 170, 28);
		contentPane.add(textFieldObjetivo);
		textFieldObjetivo.setColumns(10);
		
		JButton btnAtualizar = new JButton("Solicitar Atualiza\u00E7\u00E3o");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean confirm;
				confirm = PopUps.ConfirmarIda();
				
				if(confirm == true) {		
						AttPedido.getInstance().setVisible(true);
						AttPedido.getInstance().setLocationRelativeTo(null);
						dispose();					
					
				}
			}
		});
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAtualizar.setBackground(new Color(0, 128, 0));
		btnAtualizar.setForeground(new Color(255, 255, 255));
		btnAtualizar.setBounds(331, 382, 142, 35);
		contentPane.add(btnAtualizar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean confirm;
				confirm = PopUps.ConfirmarVolta();
				
				if(confirm == true) {
					if(TelaEntrar.cliente != null) {
						TelaConsultaCliente.getInstance().setVisible(true);
						TelaConsultaCliente.getInstance().setLocationRelativeTo(null);
						dispose();
					}else if(TelaEntrar.adm != null) {
						TelaADM.getInstance().setVisible(true);
						TelaADM.getInstance().setLocationRelativeTo(null);
						dispose();
					}
					
				}
				
			}
		});
		btnVoltar.setIcon(new ImageIcon(TelaDadosCliente.class.getResource("/imagens/gtkgobackltr_104397.png")));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVoltar.setBackground(new Color(0, 128, 0));
		btnVoltar.setBounds(483, 381, 142, 35);
		contentPane.add(btnVoltar);
		
		JButton btnMostrarDados = new JButton("Mostrar Dados");
		btnMostrarDados.setForeground(new Color(255, 255, 255));
		btnMostrarDados.setBackground(new Color(0, 128, 0));
		btnMostrarDados.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnMostrarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaEntrar.getInstance();
				setDados(TelaEntrar.cliente);
			}
		});
		btnMostrarDados.setBounds(483, 338, 142, 35);
		contentPane.add(btnMostrarDados);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Endere\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(293, 47, 332, 219);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(10, 21, 46, 14);
		panel.add(lblRua);
		
		textFieldRua = new JTextField();
		textFieldRua.setBounds(10, 43, 170, 28);
		panel.add(textFieldRua);
		textFieldRua.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 79, 46, 14);
		panel.add(lblBairro);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setBounds(10, 104, 170, 28);
		panel.add(textFieldBairro);
		textFieldBairro.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(10, 143, 101, 14);
		panel.add(lblComplemento);
		
		textFieldComplemento = new JTextField();
		textFieldComplemento.setBounds(10, 168, 170, 28);
		panel.add(textFieldComplemento);
		textFieldComplemento.setColumns(10);
		
		JLabel lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setBounds(219, 21, 53, 14);
		panel.add(lblNumero);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(219, 43, 86, 28);
		panel.add(textFieldNumero);
		textFieldNumero.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(219, 79, 46, 14);
		panel.add(lblCidade);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(219, 104, 86, 28);
		panel.add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		JButton btnGerarPDF = new JButton("Gerar PDF");
		btnGerarPDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Assistente.gerarPDFCliente(TelaEntrar.cliente);
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
			}
		});
		btnGerarPDF.setForeground(new Color(255, 255, 255));
		btnGerarPDF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGerarPDF.setBackground(new Color(0, 128, 0));
		btnGerarPDF.setBounds(331, 338, 142, 35);
		contentPane.add(btnGerarPDF);
		
		dataNascimento = new JDateChooser();
		dataNascimento.setBounds(177, 380, 60, 29);
		contentPane.add(dataNascimento);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 97, 21);
		contentPane.add(menuBar);
		
		JMenu mnAtt = new JMenu("Att");
		menuBar.add(mnAtt);
		
		JMenuItem mntmIniciarMatricula = new JMenuItem("Iniciar Matricula");
		mntmIniciarMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(TelaEntrar.adm != null) {
					String matricula;
					Cliente c;
					matricula = JOptionPane.showInputDialog(Mensagem.INFORMAMATRICULA);
					c = Fachada.getInstance().procurarClienteMatricula(matricula);
					if(c == null) {
						PopUps.UsuarioNaoExiste();
					}else {
						TelaDadosCliente.getInstance().setDados(c);
					}
				}		
			}
		});
		mnAtt.add(mntmIniciarMatricula);
		
		JMenuItem mntmAtualizar = new JMenuItem("Atualizar");
		mntmAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textFieldNome.getText(), matricula = textFieldMatricula.getText(),
						telefone = textFieldTelefone.getText(), genero = textFieldSexo.getText(),
						pagamento = textFieldPagamento.getText(), objetivo = textFieldObjetivo.getText(),
						rua = textFieldRua.getText(), bairro = textFieldBairro.getText(), 
						numero = textFieldNumero.getText(), complemento = textFieldComplemento.getText(), 
						cidade = textFieldCidade.getText(), cpf = textFieldCPF.getText(), email = textFieldEmail.getText();
				Endereco end = new Endereco(rua, bairro, cidade, complemento, numero);
				
				Cliente c = new Cliente(nome, end, cpf, dataNascimento.getDate(), matricula, email, telefone, 
						genero, pagamento, objetivo);
				
				Fachada.getInstance().atualizar(c);
			}
		});
		mnAtt.add(mntmAtualizar);
	}
}
