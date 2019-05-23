package sistema;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import basicas.Cliente;
import basicas.Endereco;
import basicas.Exercicio;
import basicas.Instrutor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;

public class TestePDF extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestePDF frame = new TestePDF();
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
	public TestePDF() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGerador = new JButton("PDF");
		btnGerador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Document document = new Document();
				try {
					
					Exercicio exer = new Exercicio("Nenhuma", "Supino", 3, "1'", 0);
					Endereco endCliente = new Endereco("Boa vista", "Cordeiro", "Recife", "", 2020);
					Cliente cliente = new Cliente("Diogo", "700000000", "Hipertrofia");
					Endereco endInstru = new Endereco("Boa viagem", "Boa viagem", "Recife", "", 2520);
					Instrutor instr = new Instrutor("Vanessa", endInstru, "7000526156");
					PdfWriter.getInstance(document, new FileOutputStream("PDF.pdf"));
					
					document.open();
					document.add(new Paragraph("Cliente:" + cliente.getNome()));
					document.add(new Paragraph("Objetivo:" + cliente.getObjetivo()));
					document.add(new Paragraph("Instrutor(a):" + instr.getNome()));
					document.add(new Paragraph(" "));
					document.add(new Paragraph("Observações:" + exer.getObs()));
					document.add(new Paragraph("Nome:" + exer.getNome()));
					document.add(new Paragraph("Séries:" + exer.getSerie()));
					document.add(new Paragraph("Descanso:" + exer.getTempoDescanso()));
					document.add(new Paragraph("Porcentagem:" + exer.getPorcentagem() +"%"));
					
					
				}catch(DocumentException | FileNotFoundException ex) {
					System.out.println("Error"+ ex);
				}
				
				document.close();
			}
		});
		btnGerador.setBounds(64, 87, 89, 23);
		contentPane.add(btnGerador);
	}
}
