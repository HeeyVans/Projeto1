package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;

public class TelaDadosInstrutor extends JFrame {

	private JPanel contentPane;
	private static TelaDadosInstrutor instance;
	private JTextField textFieldRua;
	private JTextField textFieldBairro;
	private JTextField textFieldComplemento;
	private JTextField textFieldNumero;
	private JTextField textFieldCidade;
	private JTextField textFieldData;
	private JTextField textFieldSexo;
	private JTextField textFieldTelefone;
	private JTextField textFieldEmail;
	private JTextField textFieldMatricula;
	private JTextField textFieldCPF;
	private JTextField textFieldNome;
	private JTextField textFieldCargo;
	private JTextField textFieldHoraTrab;
	
	public static TelaDadosInstrutor getInstance() {
		if(instance == null) {
			instance = new TelaDadosInstrutor();
		}
		return instance;
	}
	
	public void setDados() {
		TelaEntrar.getInstance();
		textFieldNome.setText(TelaEntrar.instrutor.getNome());
		textFieldCPF.setText(TelaEntrar.instrutor.getCpf());
		textFieldMatricula.setText(TelaEntrar.instrutor.getMatricula());
		textFieldEmail.setText(TelaEntrar.instrutor.getEmail());
        /*DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dataFormatada = dateFormat.format(TelaEntrar.instrutor.getDataDeNasc());
		textFieldData.setText(dataFormatada);		
		textFieldTelefone.setText(TelaEntrar.instrutor.getTelefone());
		textFieldSexo.setText(TelaEntrar.instrutor.getGenero());
		textFieldCidade.setText(TelaEntrar.instrutor.getEndereco().getCidade());
		textFieldRua.setText(TelaEntrar.instrutor.getEndereco().getRua());
		textFieldBairro.setText(TelaEntrar.instrutor.getEndereco().getBairro());
		textFieldNumero.setText(TelaEntrar.instrutor.getEndereco().getNumero());
		textFieldComplemento.setText(TelaEntrar.instrutor.getEndereco().getComplemento());
		textFieldPagamento.setText(TelaEntrar.instrutor.getPagamento());
		textFieldObjetivo.setText(TelaEntrar.instrutor.getObjetivo());*/
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
					TelaDadosInstrutor frame = new TelaDadosInstrutor();
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
	public TelaDadosInstrutor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaDadosInstrutor.class.getResource("/imagens/biceps png.png")));
		setTitle("Tela de Dados do Instrutor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 481);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDados = new JButton("Mostrar Dados");
		btnDados.setForeground(new Color(255, 255, 255));
		btnDados.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDados.setBackground(new Color(0, 128, 0));
		btnDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDados();				
			}
		});
		btnDados.setBounds(475, 354, 142, 35);
		contentPane.add(btnDados);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(TelaDadosInstrutor.class.getResource("/imagens/gtkgobackltr_104397.png")));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVoltar.setBackground(new Color(0, 128, 0));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInstrutor.getInstance().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(475, 400, 142, 35);
		contentPane.add(btnVoltar);
		
		JButton btnAtualizacao = new JButton("Solicitar Atualiza\u00E7\u00E3o");
		btnAtualizacao.setForeground(new Color(255, 255, 255));
		btnAtualizacao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAtualizacao.setBackground(new Color(0, 128, 0));
		btnAtualizacao.setBounds(323, 400, 142, 35);
		contentPane.add(btnAtualizacao);
		
		JButton btnGerarPDF = new JButton("Gerar PDF");
		btnGerarPDF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGerarPDF.setBackground(new Color(0, 128, 0));
		btnGerarPDF.setForeground(new Color(255, 255, 255));
		btnGerarPDF.setBounds(323, 355, 142, 35);
		contentPane.add(btnGerarPDF);
		
		JLabel label = new JLabel("Informa\u00E7\u00F5es ");
		label.setToolTipText("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(247, 11, 125, 25);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Endere\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(273, 50, 332, 219);
		contentPane.add(panel);
		
		JLabel label_1 = new JLabel("Rua:");
		label_1.setBounds(10, 21, 46, 14);
		panel.add(label_1);
		
		textFieldRua = new JTextField();
		textFieldRua.setColumns(10);
		textFieldRua.setBounds(10, 43, 170, 28);
		panel.add(textFieldRua);
		
		JLabel label_2 = new JLabel("Bairro:");
		label_2.setBounds(10, 79, 46, 14);
		panel.add(label_2);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(10, 104, 170, 28);
		panel.add(textFieldBairro);
		
		JLabel label_3 = new JLabel("Complemento:");
		label_3.setBounds(10, 143, 101, 14);
		panel.add(label_3);
		
		textFieldComplemento = new JTextField();
		textFieldComplemento.setColumns(10);
		textFieldComplemento.setBounds(10, 168, 170, 28);
		panel.add(textFieldComplemento);
		
		JLabel label_4 = new JLabel("N\u00FAmero:");
		label_4.setBounds(219, 21, 53, 14);
		panel.add(label_4);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(219, 43, 86, 28);
		panel.add(textFieldNumero);
		
		JLabel label_5 = new JLabel("Cidade:");
		label_5.setBounds(219, 79, 46, 14);
		panel.add(label_5);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setColumns(10);
		textFieldCidade.setBounds(219, 104, 86, 28);
		panel.add(textFieldCidade);
		
		textFieldData = new JTextField();
		textFieldData.setColumns(10);
		textFieldData.setBounds(26, 386, 170, 28);
		contentPane.add(textFieldData);
		
		JLabel label_6 = new JLabel("Data:");
		label_6.setBounds(26, 372, 46, 14);
		contentPane.add(label_6);
		
		textFieldSexo = new JTextField();
		textFieldSexo.setColumns(10);
		textFieldSexo.setBounds(26, 334, 170, 28);
		contentPane.add(textFieldSexo);
		
		JLabel label_7 = new JLabel("Sexo:");
		label_7.setBounds(26, 320, 46, 14);
		contentPane.add(label_7);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(26, 280, 170, 28);
		contentPane.add(textFieldTelefone);
		
		JLabel label_8 = new JLabel("Telefone:");
		label_8.setBounds(26, 265, 60, 14);
		contentPane.add(label_8);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(26, 226, 170, 28);
		contentPane.add(textFieldEmail);
		
		JLabel label_9 = new JLabel("Email:");
		label_9.setBounds(26, 208, 46, 14);
		contentPane.add(label_9);
		
		textFieldMatricula = new JTextField();
		textFieldMatricula.setColumns(10);
		textFieldMatricula.setBounds(26, 169, 170, 28);
		contentPane.add(textFieldMatricula);
		
		JLabel label_10 = new JLabel("Matr\u00EDcula:");
		label_10.setBounds(26, 152, 60, 14);
		contentPane.add(label_10);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(26, 113, 170, 28);
		contentPane.add(textFieldCPF);
		
		JLabel label_11 = new JLabel("CPF:");
		label_11.setBounds(26, 97, 46, 14);
		contentPane.add(label_11);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(26, 66, 170, 28);
		contentPane.add(textFieldNome);
		
		JLabel label_12 = new JLabel("Nome:");
		label_12.setBounds(26, 50, 46, 14);
		contentPane.add(label_12);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(236, 287, 46, 14);
		contentPane.add(lblCargo);
		
		textFieldCargo = new JTextField();
		textFieldCargo.setColumns(10);
		textFieldCargo.setBounds(236, 303, 170, 28);
		contentPane.add(textFieldCargo);
		
		JLabel lblHorrioDeTrabalho = new JLabel("Hor\u00E1rio de Trabalho:");
		lblHorrioDeTrabalho.setBounds(427, 287, 119, 14);
		contentPane.add(lblHorrioDeTrabalho);
		
		textFieldHoraTrab = new JTextField();
		textFieldHoraTrab.setColumns(10);
		textFieldHoraTrab.setBounds(422, 303, 170, 28);
		contentPane.add(textFieldHoraTrab);
	}
}
