package sistema;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import basicas.Administrador;
import basicas.Cliente;
import basicas.Exercicio;
import basicas.Instrutor;
import basicas.Treino;
import gui.PopUps;
import repositorios.RepositorioExercicioArray;

public class Assistente {
	
	//Envia um email com uma mensagem.
		public static void enviarEmail(String email1, String matricula){
			
			final String MFitEmail = "MFit.Academia10@gmail.com";
			final String MFitSenha = "mfit1010";
			
			SimpleEmail email = new SimpleEmail(); 
			
			try {  
				
				email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail
				email.addTo(email1); //destinatário
				email.setFrom(MFitEmail); // remetente
				email.setSubject(Mensagem.NOVAMATRICULA); // assunto do e-mail
				email.setMsg(Mensagem.NOVAMATRICULAGERADA + matricula); //conteudo do e-mail
				email.setAuthentication(MFitEmail, MFitSenha);
				email.setSmtpPort(465);
				email.setSSL(true);
				email.setTLS(true);
				email.send();

			      } catch (EmailException e) {  

			      System.out.println(e.getMessage());  

			      }   
		}
		
		
		//Gera uma senha de 10 caracteres, através da conversão de 
		//valores inteiros aleatóriso em caracteres.
		public static String gerarMatricula(){
			final Random random = new Random();
			final int TAMANHO = 4;
			
			char[] caracter = new char[TAMANHO];
	        for (int i = 0; i<TAMANHO; i++)
	            caracter[i] = toChar(random.nextInt(62));
	        return new String(caracter);
		}
		
		//Transforma valores inteiros em caracter
		private static char toChar(int index) {
	        if (index < 10)
	            return (char)(index + 48); //os chars 48 a 57 representam [0 - 9]
	        else if (index < 36)
	            return (char)(index + 55); //os chars 65 a 90 representam [A - Z]
	        else
	            return (char)(index + 61); //os chars 97 a 122 representam [a - z]
	    }
		
		//GerarId para Treino
		public static String gerarId(){
			final Random random = new Random();
			final int TAMANHO = 4;
			
			char[] caracter = new char[TAMANHO];
	        for (int i = 0; i<TAMANHO; i++)
	            caracter[i] = toChar(random.nextInt(62));
	        return new String(caracter);
		}
		
		//GerarPDF de Dados para Cliente
		public static void gerarPDFCliente(Cliente cliente) throws FileNotFoundException {
			
			Document document = new Document();
			
			try {
				
				PdfWriter.getInstance(document, new FileOutputStream("Cliente.pdf"));
				document.open();
				document.setPageSize(PageSize.A1);
				
				document.add(new Paragraph("Cliente:" + cliente.getNome()));
				document.add(new Paragraph(" "));
				document.add(new Paragraph("_______________________________"));
				document.add(new Paragraph("Cidade:" + cliente.getEndereco().getCidade()));
				document.add(new Paragraph("Bairro:" + cliente.getEndereco().getBairro()));
				document.add(new Paragraph("Rua:" + cliente.getEndereco().getRua()));
				document.add(new Paragraph("Rua:" + cliente.getEndereco().getComplemento()));
				document.add(new Paragraph("Número:" + cliente.getEndereco().getNumero()));
				document.add(new Paragraph(" "));
				document.add(new Paragraph("_______________________________"));
				document.add(new Paragraph("CPF:" + cliente.getCpf()));
				document.add(new Paragraph("Data de Nascimento:" + cliente.getDataDeNasc()));
				document.add(new Paragraph("Matrícula:" + cliente.getMatricula()));
				document.add(new Paragraph("Email:" + cliente.getEmail()));
				document.add(new Paragraph("Telefone:" + cliente.getTelefone()));
				document.add(new Paragraph("Gênero:" + cliente.getGenero()));
				document.add(new Paragraph(" "));
				document.add(new Paragraph("_______________________________"));
				document.add(new Paragraph("Pagamento:" + cliente.getPagamento()));
				document.add(new Paragraph("Objetivo:" + cliente.getObjetivo()));
				
				PopUps.pdfgerado();
					
				
			}catch(DocumentException | IOException ex) {
				System.out.println("Error"+ ex);
			}
			
			document.close();
		}
		
		//Gerar PDF do Treino
		public static void gerarPDFTreino(String matricula, String categoria) {
			int i;
			Treino treino = Fachada.getInstance().procurarClienteTreino(matricula);
			
			Document document = new Document();
			
			ArrayList<Exercicio> lista = new ArrayList();
			lista = (ArrayList<Exercicio>) Fachada.getInstance().listarTreino(matricula, categoria);
			
			try {
				
				PdfWriter.getInstance(document, new FileOutputStream("Treino.pdf"));
				document.open();
				document.setPageSize(PageSize._11X17);
				
				document.add(new Paragraph("Cliente: " + treino.getCliente().getNome()));
				document.add(new Paragraph("Instrutor: " + treino.getInstrutor().getNome()));
				document.add(new Paragraph(" "));
				document.add(new Paragraph("Tipo: " + categoria));
				document.add(new Paragraph("_______________________________"));
				
				for(i = 0; i < lista.size(); i++) {
					document.add(new Paragraph("Nome: " + lista.get(i).getNome()));
					document.add(new Paragraph("Séries: " + lista.get(i).getSerie()));
					document.add(new Paragraph("Descanso: " + lista.get(i).getTempoDescanso()));
					document.add(new Paragraph("Obs: " + lista.get(i).getObs()));
					document.add(new Paragraph("_______________________________"));
				}
				
				PopUps.treinoGerado();
				
				
			}catch(DocumentException | IOException ex) {
				System.out.println("Error"+ ex);
			}
			
			document.close();
		}
		
		//Montando Tabelas
		public static void montarTabela(List clientes, ModeloTabelaInstrutor modelo) {
			modelo.addClienteList(clientes);
		}
		
		//GERAR ADM
		public static void gerarAdm() {
			Administrador adm = new Administrador("ADM", "44343918360", "AAAA", "Administrador");
			Fachada.getInstance().cadastrarADM(adm);
		}
		
		//Gerar Instrutor e Cliente
		public static void gerarInstCliente() {
			Cliente c = new Cliente("Diogo", "70341871427","bbbb", "Cliente");
			Fachada.getInstance().cadastrarCliente(c);
			Instrutor t = new Instrutor("Vanessa", "27406222106", "aaaa", "Instrutor");
			Fachada.getInstance().cadastrarInstrutor(t);
		}
		//Gerar Clientes
		public static void gerarCliente() {
			Cliente c = new Cliente("Diogo", "70341871427", "Masculino");
			Fachada.getInstance().cadastrarCliente(c);
			Cliente v = new Cliente("Vanessa", "67371781708", "rrrr", "Cliente");
			Fachada.getInstance().cadastrarCliente(v);
			Cliente f = new Cliente("Paulo", "35774928721", "hhhh", "Cliente");
			Fachada.getInstance().cadastrarCliente(f);
		
		}
		//Gerar Treino
		public static void gerarTreino() {
		Instrutor t = new Instrutor("Vanessa", "27406222106", "aaaa", "Instrutor");
		Fachada.getInstance().cadastrarInstrutor(t);
		
		Cliente c = new Cliente("Diogo", "70341871427", "bbbb", "Cliente");
		Fachada.getInstance().cadastrarCliente(c);
		
		Exercicio e = new Exercicio("obs", "Supino", 3, "1'");
		Exercicio e1 = new Exercicio("obs", "Leg", 3, "1'");
		Exercicio e2 = new Exercicio("obs", "Rosca", 3, "1'");
		
		Fachada.getInstance().inserirExercicio(e);
		Fachada.getInstance().inserirExercicio(e1);
		Fachada.getInstance().inserirExercicio(e2);
		
		RepositorioExercicioArray rep = new RepositorioExercicioArray();
		rep.inserir(e);
		rep.inserir(e1);
		
		RepositorioExercicioArray rep1 = new RepositorioExercicioArray();
		rep1.inserir(e2);
		
		Treino tr = new Treino(t, c, rep, Assistente.gerarId(), "A");		
		Fachada.getInstance().inserirTreino(tr);
		
		Treino tr1 = new Treino(t, c, rep1, Assistente.gerarId(), "B");		
		Fachada.getInstance().inserirTreino(tr1);
		}
		

}
