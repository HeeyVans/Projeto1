package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import basicas.Instrutor;
import basicas.Endereco;
import sistema.Assistente;
import sistema.Fachada;
import sistema.ValidarDados;

import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import com.toedter.calendar.JDateChooser;

public class TelaCadastroInstrutor extends JFrame{

    JFrame frmTelaDeCadastro;
	private JTextField textFieldTelefone;
	private JTextField textFieldCPF;
	private JTextField textFieldNome;
	private JTextField textFieldEmail;
	private JTextField textFieldRua;
	private JTextField textFieldNumero;
	private JTextField textFieldBairro;
	private JTextField textFieldComplemento;
	private JTextField textFieldCidade;
	private JTextField textFieldCargo;
	private JTextField textFieldHoraTrab;
	JDateChooser dataNascimento = new JDateChooser();
	JRadioButton radioButtonMale = new JRadioButton();
	JRadioButton radioButtonFemale= new JRadioButton();
	public static TelaCadastroInstrutor instance;
	
	public static TelaCadastroInstrutor getInstance() {
		if(instance == null) {
			instance = new TelaCadastroInstrutor();
		}
		return instance;
	}
	
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
		textFieldCargo.setText("");
		textFieldHoraTrab.setText("");
	}
	
	public String radioSelect() {
		
		if(radioButtonMale.isSelected()) {
			return "Masculino";
		}else if(radioButtonFemale.isSelected()) {
			return "Feminino";
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
					TelaCadastroInstrutor window = new TelaCadastroInstrutor();
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
	public TelaCadastroInstrutor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaDeCadastro = new JFrame();
		frmTelaDeCadastro.setTitle("Tela de Cadastro de Instrutor - MFit");
		frmTelaDeCadastro.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroInstrutor.class.getResource("/imagens/biceps png.png")));
		frmTelaDeCadastro.getContentPane().setBackground(new Color(255, 255, 255));
		frmTelaDeCadastro.setBounds(100, 100, 782, 417);
		frmTelaDeCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaDeCadastro.getContentPane().setLayout(null);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 18, 59, 14);
		frmTelaDeCadastro.getContentPane().add(lblTelefone);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(62, 11, 108, 29);
		frmTelaDeCadastro.getContentPane().add(textFieldTelefone);
		
		JLabel labelCPF = new JLabel("CPF:");
		labelCPF.setBounds(10, 64, 59, 14);
		frmTelaDeCadastro.getContentPane().add(labelCPF);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(62, 57, 108, 29);
		frmTelaDeCadastro.getContentPane().add(textFieldCPF);
		
		textFieldNome = new JTextField();
		textFieldNome.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(219, 11, 186, 29);
		frmTelaDeCadastro.getContentPane().add(textFieldNome);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(219, 61, 186, 29);
		frmTelaDeCadastro.getContentPane().add(textFieldEmail);
		
		JLabel labelEmail = new JLabel("Email:");
		labelEmail.setBounds(180, 64, 59, 14);
		frmTelaDeCadastro.getContentPane().add(labelEmail);
		
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setBounds(180, 18, 47, 14);
		frmTelaDeCadastro.getContentPane().add(labelNome);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Sexo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(415, 11, 145, 79);
		frmTelaDeCadastro.getContentPane().add(panel);
		
		radioButtonMale = new JRadioButton("Masculino");
		radioButtonMale.setBackground(Color.WHITE);
		radioButtonMale.setBounds(6, 23, 109, 23);
		panel.add(radioButtonMale);
		
		radioButtonFemale = new JRadioButton("Feminino");
		radioButtonFemale.setBackground(Color.WHITE);
		radioButtonFemale.setBounds(6, 49, 83, 23);
		panel.add(radioButtonFemale);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(radioButtonFemale);
		grupo.add(radioButtonMale);
		
		JLabel labelNascimento = new JLabel("Nascimento:");
		labelNascimento.setBounds(10, 110, 83, 14);
		frmTelaDeCadastro.getContentPane().add(labelNascimento);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setToolTipText("");
		panel_1.setForeground(Color.BLACK);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Endere\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(235, 110, 327, 215);
		frmTelaDeCadastro.getContentPane().add(panel_1);
		
		JLabel labelRua = new JLabel("Rua:");
		labelRua.setBounds(10, 25, 46, 14);
		panel_1.add(labelRua);
		
		textFieldRua = new JTextField();
		textFieldRua.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldRua.setColumns(10);
		textFieldRua.setBounds(10, 42, 186, 29);
		panel_1.add(textFieldRua);
		
		JLabel labelNumero = new JLabel("N\u00FAmero:");
		labelNumero.setBounds(214, 25, 71, 14);
		panel_1.add(labelNumero);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(214, 42, 86, 29);
		panel_1.add(textFieldNumero);
		
		JLabel labelBairro = new JLabel("Bairro:");
		labelBairro.setBounds(10, 82, 46, 14);
		panel_1.add(labelBairro);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(10, 100, 186, 29);
		panel_1.add(textFieldBairro);
		
		JLabel labelComplemento = new JLabel("Complemento:");
		labelComplemento.setBounds(10, 140, 86, 14);
		panel_1.add(labelComplemento);
		
		textFieldComplemento = new JTextField();
		textFieldComplemento.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldComplemento.setColumns(10);
		textFieldComplemento.setBounds(10, 160, 186, 29);
		panel_1.add(textFieldComplemento);
		
		JLabel labelCidade = new JLabel("Cidade:");
		labelCidade.setBounds(214, 82, 76, 14);
		panel_1.add(labelCidade);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setColumns(10);
		textFieldCidade.setBounds(214, 100, 86, 29);
		panel_1.add(textFieldCidade);
		
		JButton button = new JButton("Limpar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		button.setIcon(new ImageIcon(TelaCadastroInstrutor.class.getResource("/imagens/delete_remove_bin_icon-icons.com_72400.png")));
		button.setBackground(new Color(255, 99, 71));
		button.setBounds(532, 334, 108, 29);
		frmTelaDeCadastro.getContentPane().add(button);
		
		JButton button_1 = new JButton("Cadastrar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(ValidarDados.validarCampoVazio(textFieldTelefone.getText(), textFieldNome.getText(), 
						textFieldEmail.getText(), textFieldCPF.getText(), textFieldRua.getText(), 
						textFieldBairro.getText(), textFieldCidade.getText(),(textFieldNumero.getText()),
						textFieldCargo.getText(), textFieldHoraTrab.getText())) {
					try {
						
						Endereco end = new Endereco(textFieldRua.getText(), textFieldBairro.getText()
								, textFieldCidade.getText(), textFieldComplemento.getText(), textFieldNumero.getText());
												
						String matricula = Assistente.gerarMatricula();
						Instrutor instruCadastrar;
						Instrutor instrutor = new Instrutor(textFieldNome.getText(), end, textFieldCPF.getText(),
								dataNascimento.getDate() , matricula, textFieldEmail.getText(), 
								textFieldTelefone.getText(), radioSelect(), textFieldCargo.getText(),
								textFieldHoraTrab.getText());
						
						instruCadastrar = Fachada.getInstance().procurarInstrutor(textFieldCPF.getText());
						
						if(instruCadastrar == null) {
							
							Fachada.getInstance().cadastrarInstrutor(instrutor);
							Assistente.enviarEmail(textFieldEmail.getText(), matricula);
							PopUps.instrutorCadastrado();
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
		button_1.setIcon(new ImageIcon(TelaCadastroInstrutor.class.getResource("/imagens/btn-novo.png")));
		button_1.setBackground(new Color(152, 251, 152));
		button_1.setBounds(648, 334, 108, 29);
		frmTelaDeCadastro.getContentPane().add(button_1);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(10, 143, 83, 14);
		frmTelaDeCadastro.getContentPane().add(lblCargo);
		
		textFieldCargo = new JTextField();
		textFieldCargo.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldCargo.setColumns(10);
		textFieldCargo.setBounds(7, 167, 186, 29);
		frmTelaDeCadastro.getContentPane().add(textFieldCargo);
		
		JLabel lblHoraTrab = new JLabel("Hor\u00E1rio de Trabalho:");
		lblHoraTrab.setBounds(10, 212, 145, 14);
		frmTelaDeCadastro.getContentPane().add(lblHoraTrab);
		
		textFieldHoraTrab = new JTextField();
		textFieldHoraTrab.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldHoraTrab.setColumns(10);
		textFieldHoraTrab.setBounds(7, 232, 186, 29);
		frmTelaDeCadastro.getContentPane().add(textFieldHoraTrab);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaCadastroInstrutor.class.getResource("/imagens/instrutor..jpg")));
		lblNewLabel.setBounds(580, 18, 186, 208);
		frmTelaDeCadastro.getContentPane().add(lblNewLabel);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(TelaCadastroInstrutor.class.getResource("/imagens/MFit logotipo redemensionada.jpg")));
		label_10.setBounds(7, 282, 260, 68);
		frmTelaDeCadastro.getContentPane().add(label_10);
		
		JDateChooser dateChooserNascimento = new JDateChooser();
		dateChooserNascimento.setBounds(82, 105, 145, 27);
		frmTelaDeCadastro.getContentPane().add(dateChooserNascimento);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaADM.getInstance().setVisible(true);
				frmTelaDeCadastro.dispose();
				
			}
		});
		btnVoltar.setIcon(new ImageIcon(TelaCadastroInstrutor.class.getResource("/imagens/gtkgobackltr_104397.png")));
		btnVoltar.setBackground(new Color(255, 250, 240));
		btnVoltar.setBounds(414, 334, 108, 29);
		frmTelaDeCadastro.getContentPane().add(btnVoltar);
	}
}
