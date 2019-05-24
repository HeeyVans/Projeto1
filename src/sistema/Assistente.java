package sistema;

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

import basicas.Administrador;
import basicas.Cliente;

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
		
		//Montando Tabelas
		public static void montarTabela(List clientes, ModeloTabelaInstrutor modelo) {
			modelo.addClienteList(clientes);
		}
		
		//GERAR ADM
		public static void gerarAdm() {
			Administrador adm = new Administrador("ADM", "44343918360", "AAAA", "Administrador");
			Fachada.getInstance().cadastrarADM(adm);
		}
		
		public static void gerarCliente() {
			Cliente c = new Cliente("Diogo", "70341656548", "bbbb", "Cliente");
			Fachada.getInstance().cadastrarCliente(c);
		
		}

}
