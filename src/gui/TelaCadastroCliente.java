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

public class TelaCadastroCliente {

	private JFrame frmTelaDeCadastro;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_2;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

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
					TelaCadastroCliente window = new TelaCadastroCliente();
					window.frmTelaDeCadastro.setVisible(true);
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
		frmTelaDeCadastro.setTitle("Tela de Cadastro - MFit");
		frmTelaDeCadastro.setBounds(100, 100, 755, 412);
		frmTelaDeCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaDeCadastro.getContentPane().setLayout(null);
		
		JLabel lblMatrcula = new JLabel("Matr\u00EDcula:");
		lblMatrcula.setBounds(10, 15, 59, 14);
		frmTelaDeCadastro.getContentPane().add(lblMatrcula);
		
		textField = new JTextField();
		textField.setBounds(62, 8, 108, 29);
		frmTelaDeCadastro.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(180, 15, 47, 14);
		frmTelaDeCadastro.getContentPane().add(lblNome);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setColumns(10);
		textField_1.setBounds(219, 8, 186, 29);
		frmTelaDeCadastro.getContentPane().add(textField_1);
		
		JLabel lblNascimento = new JLabel("Nascimento:");
		lblNascimento.setBounds(10, 107, 83, 14);
		frmTelaDeCadastro.getContentPane().add(lblNascimento);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 61, 59, 14);
		frmTelaDeCadastro.getContentPane().add(lblCpf);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(62, 54, 108, 29);
		frmTelaDeCadastro.getContentPane().add(textField_3);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(180, 61, 59, 14);
		frmTelaDeCadastro.getContentPane().add(lblEmail);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.LEFT);
		textField_4.setColumns(10);
		textField_4.setBounds(219, 58, 186, 29);
		frmTelaDeCadastro.getContentPane().add(textField_4);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaCadastroCliente.class.getResource("/imagens/foto perfil cadastro cliente novo novo.jpg")));
		label.setBounds(572, 8, 157, 186);
		frmTelaDeCadastro.getContentPane().add(label);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setIcon(new ImageIcon(TelaCadastroCliente.class.getResource("/imagens/btn-novo.png")));
		btnCadastrar.setBackground(new Color(152, 251, 152));
		btnCadastrar.setBounds(621, 333, 108, 29);
		frmTelaDeCadastro.getContentPane().add(btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(TelaCadastroCliente.class.getResource("/imagens/delete_remove_bin_icon-icons.com_72400.png")));
		btnLimpar.setBackground(new Color(255, 99, 71));
		btnLimpar.setBounds(505, 333, 108, 29);
		frmTelaDeCadastro.getContentPane().add(btnLimpar);
		
		JLabel lblSexo = new JLabel("Objetivo:");
		lblSexo.setBounds(10, 143, 59, 14);
		frmTelaDeCadastro.getContentPane().add(lblSexo);
		
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
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.LEFT);
		textField_2.setColumns(10);
		textField_2.setBounds(10, 42, 186, 29);
		panel.add(textField_2);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setBounds(214, 25, 71, 14);
		panel.add(lblNmero);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(214, 42, 86, 29);
		panel.add(textField_5);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 82, 46, 14);
		panel.add(lblBairro);
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.LEFT);
		textField_6.setColumns(10);
		textField_6.setBounds(10, 100, 186, 29);
		panel.add(textField_6);
		
		JLabel lblCidade = new JLabel("Complemento:");
		lblCidade.setBounds(10, 140, 86, 14);
		panel.add(lblCidade);
		
		textField_7 = new JTextField();
		textField_7.setHorizontalAlignment(SwingConstants.LEFT);
		textField_7.setColumns(10);
		textField_7.setBounds(10, 160, 186, 29);
		panel.add(textField_7);
		
		JLabel lblComplemento = new JLabel("Cidade:");
		lblComplemento.setBounds(214, 82, 76, 14);
		panel.add(lblComplemento);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(214, 100, 86, 29);
		panel.add(textField_9);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(85, 100, 108, 29);
		frmTelaDeCadastro.getContentPane().add(textField_8);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new TitledBorder(null, "Sexo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(415, 8, 145, 79);
		frmTelaDeCadastro.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(6, 23, 109, 23);
		panel_1.add(rdbtnMasculino);
		rdbtnMasculino.setBackground(new Color(255, 255, 255));
		
		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setBounds(6, 49, 83, 23);
		panel_1.add(rdbtnFeminino);
		rdbtnFeminino.setBackground(new Color(255, 255, 255));
		
		textField_10 = new JTextField();
		textField_10.setHorizontalAlignment(SwingConstants.LEFT);
		textField_10.setColumns(10);
		textField_10.setBounds(10, 165, 217, 29);
		frmTelaDeCadastro.getContentPane().add(textField_10);
		
		JLabel lblPagamento = new JLabel("Pagamento:");
		lblPagamento.setBounds(10, 205, 83, 14);
		frmTelaDeCadastro.getContentPane().add(lblPagamento);
		
		textField_11 = new JTextField();
		textField_11.setHorizontalAlignment(SwingConstants.LEFT);
		textField_11.setColumns(10);
		textField_11.setBounds(10, 230, 217, 29);
		frmTelaDeCadastro.getContentPane().add(textField_11);
	}
}
