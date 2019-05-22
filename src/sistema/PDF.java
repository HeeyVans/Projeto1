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

import basicas.Exercicio;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;

public class PDF extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PDF frame = new PDF();
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
	public PDF() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGerador = new JButton("PDF");
		btnGerador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					Document document = new Document();
					Exercicio exer = new Exercicio("Nenhuma", "Supino", 3, "1'", 0);
					PdfWriter.getInstance(document, new FileOutputStream("PDF.pdf"));
					
					document.open();
					document.add(new Paragraph("Observações:" + exer.getObs()));
					document.add(new Paragraph("Exercício:" + exer.getNome()));
					document.add(new Paragraph("Séries:" + exer.getSerie()));
					document.add(new Paragraph("Descanso:" + exer.getTempoDescanso()));
					document.add(new Paragraph("Porcentagem:" + exer.getPorcentagem()));
					
				}catch(DocumentException | FileNotFoundException ex) {
					System.out.println("Error"+ ex);
				}
			}
		});
		btnGerador.setBounds(64, 87, 89, 23);
		contentPane.add(btnGerador);
	}
}
