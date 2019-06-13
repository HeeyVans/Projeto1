package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import basicas.AtividadeDiaria;
import sistema.Fachada;
import sistema.ModeloTabelaDataString;

public class RelatorioDatas extends JFrame {

	private JPanel contentPane;
	private ModeloTabelaDataString modeloData;
	private static RelatorioDatas instance;
	private JTable tableCliente;
	private JTextField textFieldExibir;
	private JButton btnVoltar;
	
	public static RelatorioDatas getInstance() {
		if(instance == null) {
			instance =  new RelatorioDatas();
		}
		return instance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioDatas frame = new RelatorioDatas();
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
	public RelatorioDatas() {
		setTitle("Consulta de relat\u00F3rios - MFit");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RelatorioDatas.class.getResource("/imagens/biceps png.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 547);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		modeloData = new ModeloTabelaDataString();
		contentPane.setLayout(null);
		tableCliente = new JTable(modeloData);
		tableCliente.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tableCliente.setBounds(68, 163, 50, 30);
		tableCliente.setPreferredScrollableViewportSize(new Dimension(300, 50));
		tableCliente.setFillsViewportHeight(true);
		
		JScrollPane scrollPaneCliente = new JScrollPane(tableCliente);
		scrollPaneCliente.setBounds(5, 5, 431, 370);
		contentPane.add(scrollPaneCliente);
		
		JButton btnExibir = new JButton("Exibir");
		btnExibir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExibir.setBackground(new Color(0, 128, 0));
		btnExibir.setForeground(new Color(255, 255, 255));
		btnExibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				while(modeloData.getRowCount()>0) {
					modeloData.removeDataAt(0);
				}
				
				String cpf = textFieldExibir.getText();
				int i = 0;
				
				ArrayList<AtividadeDiaria> atividade = new ArrayList<AtividadeDiaria>();
				ArrayList<String> formataData = new ArrayList<String>();
				
				LocalDateTime agoraS;
		        String agoraFormatadoS;
			
				atividade = (ArrayList<AtividadeDiaria>) Fachada.getInstance().listarAtividade(cpf);
				
				while(i < atividade.size()) {
					agoraS = atividade.get(i).getData();
					DateTimeFormatter formatterS = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
					agoraFormatadoS = agoraS.format(formatterS);
					formataData.add(agoraFormatadoS);
					i++;
				}
				
				modeloData.addDataList(formataData);
			}
		});
		btnExibir.setBounds(47, 453, 133, 42);
		contentPane.add(btnExibir);
		
		textFieldExibir = new JTextField();
		textFieldExibir.setBounds(47, 411, 285, 31);
		contentPane.add(textFieldExibir);
		textFieldExibir.setColumns(10);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean confirm;
				confirm = PopUps.ConfirmarVolta();
				
				if(confirm == true) {		
						TelaConferirPagamento.getInstance().setVisible(true);
						TelaConferirPagamento.getInstance().setLocationRelativeTo(null);
						dispose();					
					
				}
				
			}
		});
		btnVoltar.setIcon(new ImageIcon(RelatorioDatas.class.getResource("/imagens/gtkgobackltr_104397.png")));
		btnVoltar.setBackground(new Color(0, 128, 0));
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(199, 453, 133, 42);
		contentPane.add(btnVoltar);
		
		JLabel lblDigiteSeuCpf = new JLabel("Digite um CPF abaixo para consultar o relat\u00F3rio");
		lblDigiteSeuCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDigiteSeuCpf.setBounds(47, 386, 263, 14);
		contentPane.add(lblDigiteSeuCpf);
	}
}
