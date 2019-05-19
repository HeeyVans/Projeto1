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

public class TelaCadastroCliente {

	private JFrame frmTelaDeCadastro;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;

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
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(84, 100, 51, 29);
		frmTelaDeCadastro.getContentPane().add(spinner_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(145, 100, 51, 29);
		frmTelaDeCadastro.getContentPane().add(spinner);
		
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
	}
}
