package sistema;

import java.util.Properties;

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

public class TesteEmail {
	
	public void enviarEmail() {
		
		SimpleEmail email = new SimpleEmail(); 
		
		try {  
			
			email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail
			email.addTo("diogosz111@gmail.com", "Nome"); //destinatário
			email.setFrom("digsuk360@gmail.com", "Nome"); // remetente
			email.setSubject("Teste -> Email simples"); // assunto do e-mail
			email.setMsg("Teste de Email utilizando commons-email"); //conteudo do e-mail
			email.setAuthentication("digsuk360@gmail.com", "");
			email.setSmtpPort(465);
			email.setSSL(true);
			email.setTLS(true);
			email.send();

		      } catch (EmailException e) {  

		      System.out.println(e.getMessage());  

		      }   
	}

	public static void main(String[] args) {
		
		new TesteEmail().enviarEmail();

	}

}
