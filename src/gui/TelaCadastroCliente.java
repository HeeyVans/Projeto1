package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.Choice;
import java.awt.Label;
import javax.swing.JSeparator;
import javax.swing.JEditorPane;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.ScrollPane;
import javax.swing.border.TitledBorder;
import java.awt.Panel;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.TextField;
import javax.swing.JTextArea;
import java.awt.Canvas;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import com.toedter.calendar.JDateChooser;

import basicas.Cliente;
import basicas.Endereco;
import sistema.Assistente;
import sistema.Fachada;
import sistema.ValidarDados;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroCliente extends JFrame{

    JFrame frmTelaDeCadastro;
	private JTextField textFieldTelefone;
	private JTextField textFieldNome;
	private JTextField textFieldCPF;
	private JTextField textFieldEmail;
	private JTextField textFieldRua;
	private JTextField textFieldNumero;
	private JTextField textFieldBairro;
	private JTextField textFieldComplemento;
	private JTextField textFieldCidade;
	private JTextField textFieldObjetivo;
	private JTextField textFieldPagamento;
	JDateChooser dataNascimento = new JDateChooser();
	JRadioButton rdbtnMasculino = new JRadioButton();
	JRadioButton rdbtnFeminino = new JRadioButton();
	public static TelaCadastroCliente instance;
	
	public static TelaCadastroCliente getInstance() {
		if(instance == null) {
			instance = new TelaCadastroCliente();
		}
		return instance;
	}

	/**
	 * Launch the application.
	 */
	
	public void limpar() {
		textFieldTelefone.setText("");
		textFieldNome.setText("");
		textFieldCPF.setText("");
		textFieldEmail.setText("");
		textFieldRua.setText("");
		textFieldNumero.setText("");
		textFieldBairro.setText("");
		textFieldComplemento.setText("");
		textFieldCidade.setText("");
		textFieldObjetivo.setText("");
		textFieldPagamento.setText("");
	}
	
	public String radioSelect() {
		
		if(rdbtnMasculino.isSelected()) {
			return "Masculino";
		}else if(rdbtnFeminino.isSelected()) {
			return "Feminino";
		}else {
			return null;
		}
		
	}
	
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
					TelaCadastroCliente window = new TelaCadastroCliente();
					window.frmTelaDeCadastro.setVisible(true);
					window.frmTelaDeCadastro.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaDeCadastro = new JFrame();
		frmTelaDeCadastro.getContentPane().setBackground(new Color(255, 255, 255));
		frmTelaDeCadastro.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroCliente.class.getResource("/imagens/biceps png.png")));
		frmTelaDeCadastro.setTitle("Tela de Cadastro de Cliente - MFit");
		frmTelaDeCadastro.setBounds(100, 100, 755, 412);
		frmTelaDeCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaDeCadastro.getContentPane().setLayout(null);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 15, 59, 14);
		frmTelaDeCadastro.getContentPane().add(lblTelefone);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(62, 8, 108, 29);
		frmTelaDeCadastro.getContentPane().add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		/*
		------------Código para a formatação de telefone------------
		
		Scanner ler = new Scanner(System.in);
		System.out.println("informe seu numero: ");
		String phone = ler.nextLine();
		try {
		MaskFormatter phoneFormatter = new MaskFormatter("(##) ####-####");
		JFormattedTextField txtPhone = new JFormattedTextField(phoneFormatter);
		txtPhone.setText(phone);

				System.out.println("Seu numero eh: " + txtPhone.getText());
			} catch (ParseException e) {
				e.printStackTrace();
				return;
			} 
		
	}*/
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(180, 15, 47, 14);
		frmTelaDeCadastro.getContentPane().add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(219, 8, 186, 29);
		frmTelaDeCadastro.getContentPane().add(textFieldNome);
		
		JLabel lblNascimento = new JLabel("Nascimento:");
		lblNascimento.setBounds(10, 107, 83, 14);
		frmTelaDeCadastro.getContentPane().add(lblNascimento);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 61, 59, 14);
		frmTelaDeCadastro.getContentPane().add(lblCpf);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(62, 54, 108, 29);
		frmTelaDeCadastro.getContentPane().add(textFieldCPF);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(180, 61, 59, 14);
		frmTelaDeCadastro.getContentPane().add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(219, 58, 186, 29);
		frmTelaDeCadastro.getContentPane().add(textFieldEmail);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaCadastroCliente.class.getResource("/imagens/foto perfil cadastro cliente novo novo.jpg")));
		label.setBounds(572, 8, 157, 186);
		frmTelaDeCadastro.getContentPane().add(label);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ValidarDados.validarCampoVazio(textFieldTelefone.getText(), textFieldNome.getText(), 
						textFieldEmail.getText(), textFieldCPF.getText(), textFieldRua.getText(), 
						textFieldBairro.getText(), textFieldCidade.getText(),(textFieldNumero.getText()),
						textFieldObjetivo.getText(), textFieldPagamento.getText())) {
					try {
						
						Endereco end = new Endereco(textFieldRua.getText(), textFieldBairro.getText()
								, textFieldCidade.getText(), textFieldComplemento.getText(), textFieldNumero.getText());
												
						String matricula = Assistente.gerarMatricula();
						Cliente clienteCadastrar;
						Cliente cliente = new Cliente(textFieldNome.getText(), end, textFieldCPF.getText(),
								dataNascimento.getDate() , matricula, textFieldEmail.getText(), 
								textFieldTelefone.getText(), radioSelect(), textFieldPagamento.getText(),
								textFieldObjetivo.getText());
						
						clienteCadastrar = Fachada.getInstance().procurarCliente(textFieldCPF.getText());
						
						if(clienteCadastrar == null) {
							
							Fachada.getInstance().cadastrarCliente(cliente);
							Assistente.enviarEmail(textFieldEmail.getText(), matricula);
							PopUps.clienteCadastrado();
							limpar();
							
						}else {
							PopUps.ErroCadastro();
						}
						
					}catch(NumberFormatException nfe) {
						PopUps.ErroCadastro();
					}
						
					
					
				}
			}
		});
		btnCadastrar.setIcon(new ImageIcon(TelaCadastroCliente.class.getResource("/imagens/btn-novo.png")));
		btnCadastrar.setBackground(new Color(152, 251, 152));
		btnCadastrar.setBounds(621, 333, 108, 29);
		frmTelaDeCadastro.getContentPane().add(btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setIcon(new ImageIcon(TelaCadastroCliente.class.getResource("/imagens/delete_remove_bin_icon-icons.com_72400.png")));
		btnLimpar.setBackground(new Color(255, 99, 71));
		btnLimpar.setBounds(505, 333, 108, 29);
		frmTelaDeCadastro.getContentPane().add(btnLimpar);
		
		JLabel lblObjetivo = new JLabel("Objetivo:");
		lblObjetivo.setBounds(10, 143, 59, 14);
		frmTelaDeCadastro.getContentPane().add(lblObjetivo);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setToolTipText("");
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Endere\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(235, 107, 327, 215);
		frmTelaDeCadastro.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(10, 25, 46, 14);
		panel.add(lblRua);
		
		textFieldRua = new JTextField();
		textFieldRua.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldRua.setColumns(10);
		textFieldRua.setBounds(10, 42, 186, 29);
		panel.add(textFieldRua);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setBounds(214, 25, 71, 14);
		panel.add(lblNmero);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(214, 42, 86, 29);
		panel.add(textFieldNumero);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 82, 46, 14);
		panel.add(lblBairro);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(10, 100, 186, 29);
		panel.add(textFieldBairro);
		
		JLabel lblCidade = new JLabel("Complemento:");
		lblCidade.setBounds(10, 140, 86, 14);
		panel.add(lblCidade);
		
		textFieldComplemento = new JTextField();
		textFieldComplemento.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldComplemento.setColumns(10);
		textFieldComplemento.setBounds(10, 160, 186, 29);
		panel.add(textFieldComplemento);
		
		JLabel lblComplemento = new JLabel("Cidade:");
		lblComplemento.setBounds(214, 82, 76, 14);
		panel.add(lblComplemento);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setColumns(10);
		textFieldCidade.setBounds(214, 100, 86, 29);
		panel.add(textFieldCidade);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new TitledBorder(null, "Sexo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(415, 8, 145, 79);
		frmTelaDeCadastro.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(6, 23, 109, 23);
		panel_1.add(rdbtnMasculino);
		rdbtnMasculino.setBackground(new Color(255, 255, 255));
		
		rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setBounds(6, 49, 83, 23);
		panel_1.add(rdbtnFeminino);
		rdbtnFeminino.setBackground(new Color(255, 255, 255));
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtnMasculino);
		grupo.add(rdbtnFeminino);
		
		textFieldObjetivo = new JTextField();
		textFieldObjetivo.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldObjetivo.setColumns(10);
		textFieldObjetivo.setBounds(10, 165, 217, 29);
		frmTelaDeCadastro.getContentPane().add(textFieldObjetivo);
		
		JLabel lblPagamento = new JLabel("Pagamento:");
		lblPagamento.setBounds(10, 205, 83, 14);
		frmTelaDeCadastro.getContentPane().add(lblPagamento);
		
		textFieldPagamento = new JTextField();
		textFieldPagamento.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldPagamento.setColumns(10);
		textFieldPagamento.setBounds(10, 230, 217, 29);
		frmTelaDeCadastro.getContentPane().add(textFieldPagamento);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(TelaCadastroCliente.class.getResource("/imagens/MFit logotipo redemensionada.jpg")));
		label_1.setBounds(10, 281, 253, 63);
		frmTelaDeCadastro.getContentPane().add(label_1);
		
		dataNascimento = new JDateChooser();
		dataNascimento.setBounds(82, 101, 145, 29);
		frmTelaDeCadastro.getContentPane().add(dataNascimento);
		
		JButton button = new JButton("Voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaADM.getInstance().setVisible(true);
				TelaADM.getInstance().setLocationRelativeTo(null);
				frmTelaDeCadastro.dispose();
			}
		});
		button.setIcon(new ImageIcon(TelaCadastroCliente.class.getResource("/imagens/gtkgobackltr_104397.png")));
		button.setBackground(new Color(255, 250, 240));
		button.setBounds(387, 333, 108, 29);
		frmTelaDeCadastro.getContentPane().add(button);
	}
}
