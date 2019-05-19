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
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class TelaCadastroInstrutor {

	private JFrame frmTelaDeCadastro;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
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
					TelaCadastroInstrutor window = new TelaCadastroInstrutor();
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
		
		JLabel label = new JLabel("Matr\u00EDcula:");
		label.setBounds(10, 18, 59, 14);
		frmTelaDeCadastro.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(62, 11, 108, 29);
		frmTelaDeCadastro.getContentPane().add(textField);
		
		JLabel label_1 = new JLabel("CPF:");
		label_1.setBounds(10, 64, 59, 14);
		frmTelaDeCadastro.getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(62, 57, 108, 29);
		frmTelaDeCadastro.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.LEFT);
		textField_2.setColumns(10);
		textField_2.setBounds(219, 11, 186, 29);
		frmTelaDeCadastro.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.LEFT);
		textField_3.setColumns(10);
		textField_3.setBounds(219, 61, 186, 29);
		frmTelaDeCadastro.getContentPane().add(textField_3);
		
		JLabel label_2 = new JLabel("Email:");
		label_2.setBounds(180, 64, 59, 14);
		frmTelaDeCadastro.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Nome:");
		label_3.setBounds(180, 18, 47, 14);
		frmTelaDeCadastro.getContentPane().add(label_3);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Sexo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(415, 11, 145, 79);
		frmTelaDeCadastro.getContentPane().add(panel);
		
		JRadioButton radioButton = new JRadioButton("Masculino");
		radioButton.setBackground(Color.WHITE);
		radioButton.setBounds(6, 23, 109, 23);
		panel.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("Feminino");
		radioButton_1.setBackground(Color.WHITE);
		radioButton_1.setBounds(6, 49, 83, 23);
		panel.add(radioButton_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(85, 103, 108, 29);
		frmTelaDeCadastro.getContentPane().add(textField_4);
		
		JLabel label_4 = new JLabel("Nascimento:");
		label_4.setBounds(10, 110, 83, 14);
		frmTelaDeCadastro.getContentPane().add(label_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setToolTipText("");
		panel_1.setForeground(Color.BLACK);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Endere\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(235, 110, 327, 215);
		frmTelaDeCadastro.getContentPane().add(panel_1);
		
		JLabel label_5 = new JLabel("Rua:");
		label_5.setBounds(10, 25, 46, 14);
		panel_1.add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.LEFT);
		textField_5.setColumns(10);
		textField_5.setBounds(10, 42, 186, 29);
		panel_1.add(textField_5);
		
		JLabel label_6 = new JLabel("N\u00FAmero:");
		label_6.setBounds(214, 25, 71, 14);
		panel_1.add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(214, 42, 86, 29);
		panel_1.add(textField_6);
		
		JLabel label_7 = new JLabel("Bairro:");
		label_7.setBounds(10, 82, 46, 14);
		panel_1.add(label_7);
		
		textField_7 = new JTextField();
		textField_7.setHorizontalAlignment(SwingConstants.LEFT);
		textField_7.setColumns(10);
		textField_7.setBounds(10, 100, 186, 29);
		panel_1.add(textField_7);
		
		JLabel label_8 = new JLabel("Complemento:");
		label_8.setBounds(10, 140, 86, 14);
		panel_1.add(label_8);
		
		textField_8 = new JTextField();
		textField_8.setHorizontalAlignment(SwingConstants.LEFT);
		textField_8.setColumns(10);
		textField_8.setBounds(10, 160, 186, 29);
		panel_1.add(textField_8);
		
		JLabel label_9 = new JLabel("Cidade:");
		label_9.setBounds(214, 82, 76, 14);
		panel_1.add(label_9);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(214, 100, 86, 29);
		panel_1.add(textField_9);
		
		JButton button = new JButton("Limpar");
		button.setIcon(new ImageIcon(TelaCadastroInstrutor.class.getResource("/imagens/delete_remove_bin_icon-icons.com_72400.png")));
		button.setBackground(new Color(255, 99, 71));
		button.setBounds(532, 334, 108, 29);
		frmTelaDeCadastro.getContentPane().add(button);
		
		JButton button_1 = new JButton("Cadastrar");
		button_1.setIcon(new ImageIcon(TelaCadastroInstrutor.class.getResource("/imagens/btn-novo.png")));
		button_1.setBackground(new Color(152, 251, 152));
		button_1.setBounds(648, 334, 108, 29);
		frmTelaDeCadastro.getContentPane().add(button_1);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(10, 143, 83, 14);
		frmTelaDeCadastro.getContentPane().add(lblCargo);
		
		textField_10 = new JTextField();
		textField_10.setHorizontalAlignment(SwingConstants.LEFT);
		textField_10.setColumns(10);
		textField_10.setBounds(7, 167, 186, 29);
		frmTelaDeCadastro.getContentPane().add(textField_10);
		
		JLabel lblHorrioDeTrabalho = new JLabel("Hor\u00E1rio de Trabalho:");
		lblHorrioDeTrabalho.setBounds(10, 212, 108, 14);
		frmTelaDeCadastro.getContentPane().add(lblHorrioDeTrabalho);
		
		textField_11 = new JTextField();
		textField_11.setHorizontalAlignment(SwingConstants.LEFT);
		textField_11.setColumns(10);
		textField_11.setBounds(7, 232, 186, 29);
		frmTelaDeCadastro.getContentPane().add(textField_11);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaCadastroInstrutor.class.getResource("/imagens/instrutor..jpg")));
		lblNewLabel.setBounds(580, 18, 186, 208);
		frmTelaDeCadastro.getContentPane().add(lblNewLabel);
	}

}
