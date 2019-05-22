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
			email.addTo("digsuk360@gmail.com"); //destinatário
			email.setFrom("MFit.Academia10@gmail.com"); // remetente
			email.setSubject("Teste -> Email simples"); // assunto do e-mail
			email.setMsg("Teste de Email utilizando commons-email"); //conteudo do e-mail
			email.setAuthentication("MFit.Academia10@gmail.com", "mfit1010");
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
