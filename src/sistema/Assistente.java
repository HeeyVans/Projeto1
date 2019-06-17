package sistema;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import basicas.AtividadeDiaria;
import basicas.Cliente;
import basicas.Endereco;
import basicas.Exercicio;
import basicas.Instrutor;
import basicas.Treino;
import excecoes.MatriculaNaoEncontradaException;
import gui.PopUps;

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
		
		//Envia um email com uma mensagem2.
				public static void enviarEmailClienteparaADM(String mensagem, Cliente c){
					
					final String MFitEmail = "MFit.Academia10@gmail.com";
					final String MFitSenha = "mfit1010";
					
					SimpleEmail email = new SimpleEmail(); 
					
					try {  
						
						email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail
						email.addTo("admMFitAcademia@gmail.com"); //destinatário
						email.setFrom(MFitEmail); // remetente
						email.setSubject("Solicitação de Atualização Cliente: " + c.getNome() + " com matrícula -" + c.getMatricula()); // assunto do e-mail
						email.setMsg(mensagem); //conteudo do e-mail
						email.setAuthentication(MFitEmail, MFitSenha);
						email.setSmtpPort(465);
						email.setSSL(true);
						email.setTLS(true);
						email.send();

					      } catch (EmailException e) {  

					      System.out.println(e.getMessage());  

					      }   
				}
				
				//Envia um email com uma mensagem3.
				public static void enviarEmailInstrutorparaADM(String mensagem, Instrutor in){
					
					final String MFitEmail = "MFit.Academia10@gmail.com";
					final String MFitSenha = "mfit1010";
					
					SimpleEmail email = new SimpleEmail(); 
					
					try {  
						
						email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail
						email.addTo("admMFitAcademia@gmail.com"); //destinatário
						email.setFrom(MFitEmail); // remetente
						email.setSubject("Solicitação de Atualização Instrutor: " + in.getNome() + " com matrícula -" + in.getMatricula()); // assunto do e-mail
						email.setMsg(mensagem); //conteudo do e-mail
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
		
		public static int gerarID() {
			int id;
			Random numero = new Random();
			id = numero.nextInt(5000);

			return id;
		}
		
		//GerarPDF de Dados para Cliente
		public static void gerarPDFCliente(Cliente cliente) throws FileNotFoundException {
			
			Document document = new Document();
			
			try {
				
				PdfWriter.getInstance(document, new FileOutputStream("Cliente.pdf"));
				document.open();
				document.setPageSize(PageSize.A1);
				
				document.add(new Paragraph("-------MFit Academia: Saúde em primeiro lugar-------"));
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
		
		//GerarPDF de Dados para Cliente
				public static void gerarPDFInstrutor(Instrutor instrutor) throws FileNotFoundException {
					
					Document document = new Document();
					
					try {
						
						PdfWriter.getInstance(document, new FileOutputStream("Instrutor.pdf"));
						document.open();
						document.setPageSize(PageSize.A1);
						
						document.add(new Paragraph("-------MFit Academia: Saúde em primeiro lugar-------"));
						document.add(new Paragraph("Cliente:" + instrutor.getNome()));
						document.add(new Paragraph(" "));
						document.add(new Paragraph("_______________________________"));
						document.add(new Paragraph("Cidade:" + instrutor.getEndereco().getCidade()));
						document.add(new Paragraph("Bairro:" + instrutor.getEndereco().getBairro()));
						document.add(new Paragraph("Rua:" + instrutor.getEndereco().getRua()));
						document.add(new Paragraph("Rua:" + instrutor.getEndereco().getComplemento()));
						document.add(new Paragraph("Número:" + instrutor.getEndereco().getNumero()));
						document.add(new Paragraph(" "));
						document.add(new Paragraph("_______________________________"));
						document.add(new Paragraph("CPF:" + instrutor.getCpf()));
						document.add(new Paragraph("Data de Nascimento:" + instrutor.getDataDeNasc()));
						document.add(new Paragraph("Matrícula:" + instrutor.getMatricula()));
						document.add(new Paragraph("Email:" + instrutor.getEmail()));
						document.add(new Paragraph("Telefone:" + instrutor.getTelefone()));
						document.add(new Paragraph("Gênero:" + instrutor.getGenero()));
						document.add(new Paragraph(" "));
						document.add(new Paragraph("_______________________________"));
						document.add(new Paragraph("Horas de Trabalho:" + instrutor.getHoraTrab()));
						document.add(new Paragraph("Cargo:" + instrutor.getCargo()));
						
						PopUps.pdfgerado();
							
						
					}catch(DocumentException | IOException ex) {
						System.out.println("Error"+ ex);
					}
					
					document.close();
				}
		
		//Gerar PDF do Treino
		public static void gerarPDFTreino(String matricula, String categoria) {
			int i;
			Treino treino = Fachada.getInstance().procurarClienteTreino(matricula, categoria);
			
			Document document = new Document();
			
			ArrayList<Exercicio> lista = new ArrayList<Exercicio>();
			lista = ((ArrayList<Exercicio>) Fachada.getInstance().listarTreino(matricula, categoria));
			
			try {
				
				PdfWriter.getInstance(document, new FileOutputStream("Treino.pdf"));
				document.open();
				document.setPageSize(PageSize._11X17);
				
				document.add(new Paragraph("-------MFit Academia: Saúde em primeiro lugar-------"));
				document.add(new Paragraph("Treino realizado por: " +treino.getInstrutor().getNome()+ "\n E-mail: " +treino.getInstrutor().getEmail()));
				document.add(new Paragraph("Autorizado por: Administração MFit Academia \nE-mail: Mfit.academia10@gmail.com"));
				document.add(new Paragraph(" "));
				document.add(new Paragraph("Cliente: " + treino.getCliente().getNome()));
				document.add(new Paragraph("Instrutor: " + treino.getInstrutor().getNome()));
				document.add(new Paragraph(" "));
				document.add(new Paragraph("Tipo: " + categoria));
				document.add(new Paragraph("Treino: " + treino.getContadorTreino() + "/" + treino.getNumeroTreinos()));
				LocalDateTime data = treino.getDataCriacao();
				LocalDateTime dataVence = data.plusDays(30);
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		        String agoraFormatado = data.format(formatter);
		        
		        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		        String agoraFormatado1 = dataVence.format(formatter1);
				document.add(new Paragraph("Criado em: " + agoraFormatado + "  Vence em: " +agoraFormatado1));
				document.add(new Paragraph(" "));
				
				LocalDateTime agoraS = LocalDateTime.now();
		        DateTimeFormatter formatterS = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		        String agoraFormatadoS = agoraS.format(formatterS);
		        
				document.add(new Paragraph("Ficha retirada em: " + agoraFormatadoS));
				document.add(new Paragraph("_______________________________"));
				
				for(i = 0; i < lista.size(); i++) {
					document.add(new Paragraph("Nome: " + lista.get(i).getNome()));
					document.add(new Paragraph("Séries: " + lista.get(i).getSerie()));
					document.add(new Paragraph("Descanso: " + lista.get(i).getTempoDescanso()));
					document.add(new Paragraph("Obs: " + lista.get(i).getObs()));
					document.add(new Paragraph("_______________________________"));
				}
				
				int contadorTreino = (treino.getContadorTreino() + 1);

				Treino t = new Treino(treino.getInstrutor(), treino.getCliente(), treino.getRepExer(),
						categoria, treino.getNumeroTreinos(), contadorTreino, treino.getDataCriacao(), treino.getId());
				Fachada.getInstance().atualizarTreino(t);
				
				contadorTreino = 0;
				
				PopUps.treinoGerado();
				
				
			}catch(DocumentException | IOException ex) {
				System.out.println("Error"+ ex);
			}
			
			document.close();
		}
		
		//GerarPDFAtrasados
		public static void gerarPDFClientesAtrasados() {
			int i;	
			
			Document document = new Document();
			
			ArrayList<Cliente> lista = new ArrayList();
			lista = (ArrayList<Cliente>) Fachada.getInstance().listarClienteAtrasado("Não");
			
			try {
				
				PdfWriter.getInstance(document, new FileOutputStream("Atrasados.pdf"));
				document.open();
				document.setPageSize(PageSize._11X17);
				
				document.add(new Paragraph("_______________________________"));	
				document.add(new Paragraph("Clientes Atrasados:"));
				document.add(new Paragraph("_______________________________"));	
				
				for(i = 0; i <= lista.size() - 1; i++) {
				document.add(new Paragraph("Cliente: " + lista.get(i).getNome()));	
				}
			}catch(DocumentException | IOException ex) {
				System.out.println("Error"+ ex);
			}
			
			document.close();
		}
		//GerarPDFEmDia
		public static void gerarPDFClientesEmDia() {
			int i;	
			
			Document document = new Document();
			
			ArrayList<Cliente> lista = new ArrayList();
			lista = (ArrayList<Cliente>) Fachada.getInstance().listarClienteEmDia("Sim");
			
			try {
				
				PdfWriter.getInstance(document, new FileOutputStream("EmDia.pdf"));
				document.open();
				document.setPageSize(PageSize._11X17);
				
				document.add(new Paragraph("_______________________________"));	
				document.add(new Paragraph("Clientes em dia:"));
				document.add(new Paragraph("_______________________________"));	
				
				for(i = 0; i <= lista.size() - 1; i++) {
				document.add(new Paragraph("Cliente: " + lista.get(i).getNome()));	
				}
			}catch(DocumentException | IOException ex) {
				System.out.println("Error"+ ex);
			}
			
			document.close();
		}
		//GerarPDFTodosClientes
		public static void gerarPDFTodosClientes() {
			int i;	
			
			Document document = new Document();
			
			ArrayList<Cliente> lista1 = new ArrayList();
			lista1 = (ArrayList<Cliente>) Fachada.getInstance().listarClienteEmDia("Sim");
			ArrayList<Cliente> lista2 = new ArrayList();
			lista2 = (ArrayList<Cliente>) Fachada.getInstance().listarClienteAtrasado("Não");
			
			try {
				
				PdfWriter.getInstance(document, new FileOutputStream("TodosClientes.pdf"));
				document.open();
				document.setPageSize(PageSize._11X17);
				
				document.add(new Paragraph("_______________________________"));	
				document.add(new Paragraph("Clientes em dia:"));
				document.add(new Paragraph("_______________________________"));	
				document.add(new Paragraph("_______________________________"));	
				for(i = 0; i <= lista1.size() - 1; i++) {
				document.add(new Paragraph("Cliente: " + lista1.get(i).getNome()));	
				}
				
				document.add(new Paragraph("_______________________________"));	
				document.add(new Paragraph("Clientes Atrasados:"));
				document.add(new Paragraph("_______________________________"));	
				document.add(new Paragraph("_______________________________"));	
				for(i = 0; i <= lista2.size() - 1; i++) {
					document.add(new Paragraph("Cliente: " + lista2.get(i).getNome()));	
					}
				
			}catch(DocumentException | IOException ex) {
				System.out.println("Error"+ ex);
			}
			
			document.close();
		}
		
		//GerarPDFHorariosCliente
		public static void gerarPDFClienteHorario(String matricula) {
			int i;
			Cliente cliente = null;
			try {
				cliente = Fachada.getInstance().procurarClienteMatricula(matricula);
			} catch (MatriculaNaoEncontradaException mnee) {
				PopUps.matriculaInvalida(mnee);
			}
			Document document = new Document();
			
			ArrayList<AtividadeDiaria> ativ = new ArrayList<AtividadeDiaria>();
			ativ =  (ArrayList<AtividadeDiaria>) Fachada.getInstance().listarAtividade(cliente.getCpf());
			
			try {
				PdfWriter.getInstance(document, new FileOutputStream("Horarios.pdf"));
				document.open();
				document.setPageSize(PageSize._11X17);
							
						
				for(i = 0; i <= ativ.size() -1; i++) {
					LocalDateTime agoraS = ativ.get(i).getData();
					DateTimeFormatter formatterS = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
					String agoraFormatadoS = agoraS.format(formatterS);	
					
					document.add(new Paragraph(agoraFormatadoS));	
				}
			}catch(DocumentException | IOException ex) {
				System.out.println("Error"+ ex);
			}
			
			document.close();
			
		}
		//Montando Tabelas
		public static void montarTabela(List<Cliente> clientes, ModeloTabelaInstrutor modelo) {
			modelo.addClienteList(clientes);
		}
		
		//GERAR ADM
		public static void gerarAdm() {
			Administrador adm = new Administrador("ADM", "44343918360", "AAAA", "Administrador");
			Fachada.getInstance().cadastrarADM(adm);
		}
		/*
		//Gerar Treino
		public static void gerarTreino() throws MatriculaNaoEncontradaException {
		Instrutor t = new Instrutor("Vanessa", "27406222106", "aaaa", "Instrutor");
		Fachada.getInstance().cadastrarInstrutor(t);
		
		Endereco end = new Endereco("Rua","Bairro","Cidade","Complemento","Número");
		Cliente c = new Cliente("Diogo", end, "70341871427", "bbbb", "digsuk360@gmail.com", "84504668", "Masculino",
				"Sim", "Hipertrofia");
		Fachada.getInstance().cadastrarCliente(c);
		
		Exercicio e = new Exercicio("", "Supino", 3, "1'");
		Exercicio e1 = new Exercicio("", "Fly", 3, "1'");
		Exercicio e2 = new Exercicio("", "Elevação Frontal", 3, "1'");
		Exercicio e3 = new Exercicio("", "Flexão de braços aberta", 3, "1'");
		Exercicio e4 = new Exercicio("", "Flexão de braços fechada", 3, "1'");
		Exercicio e5 = new Exercicio("", "Tríceps Pulley", 3, "1'");
		
		ArrayList<Exercicio> categoriaA = new ArrayList<Exercicio>();
		categoriaA.add(e);
		categoriaA.add(e1);
		categoriaA.add(e2);
		categoriaA.add(e3);
		categoriaA.add(e4);
		categoriaA.add(e5);
		
		Treino tr = new Treino(t, c, categoriaA, "A", 10, 0);		
		Fachada.getInstance().inserirTreino(tr);
		
		Exercicio e6 = new Exercicio("", "Total Leg", 3, "1'");
		Exercicio e7 = new Exercicio("", "Leg 90", 3, "1'");
		Exercicio e8 = new Exercicio("", "Extensora", 3, "1'");
		Exercicio e9 = new Exercicio("", "Panturrilha Sentada", 3, "1'");
		Exercicio e10 = new Exercicio("", "Panturrilha Smith", 3, "1'");
		Exercicio e11 = new Exercicio("", "Abdução", 3, "1'");
		
		ArrayList<Exercicio> categoriaB = new ArrayList<Exercicio>();
		categoriaB.add(e6);
		categoriaB.add(e7);
		categoriaB.add(e8);
		categoriaB.add(e9);
		categoriaB.add(e10);
		categoriaB.add(e11);
		
		Treino tr1 = new Treino(t, c, categoriaB, "B", 10, 0);		
		Fachada.getInstance().inserirTreino(tr1);
		}*/
		
		//Gerador de números para o atributo ID.
	

}
