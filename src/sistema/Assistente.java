package sistema;

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

public class Assistente {
	
	//Envia um email com uma mensagem.
		public static void enviarEmail(String email, String matricula){
			final String MFitEmail = "MFit.Academia10@gmail.com";
			final String MFitSenha = "mfit1010";
			Properties props = new Properties();
	        /** Parâmetros de conexão com servidor Gmail */
			props.put("mail.smtp.user", MFitEmail);
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "25");
			props.put("mail.debug", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.EnableSSL.enable", "true");
			
            props.setProperty("mail.smtp.socketFactory.port", "465");
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            //props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.smtp.port", "465");
 
            Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
 
                   protected PasswordAuthentication getPasswordAuthentication() {
                          return new PasswordAuthentication(MFitEmail, MFitSenha);
                   }
	                    });

	        /** Ativa Debug para sessão */
	        session.setDebug(true);

	        try {
	              Message message = new MimeMessage(session);
	              message.setFrom(new InternetAddress(MFitEmail)); //Remetente

	              Address[] toUser = InternetAddress //Destinatário(s)
	                         .parse(email);  

	              message.setRecipients(Message.RecipientType.TO, toUser);
	              message.setSubject(Mensagem.NOVAMATRICULA);//Assunto
	              message.setText(Mensagem.NOVAMATRICULAGERADA + matricula);

	              /**Método para enviar a mensagem criada*/
	              Transport.send(message);

	         } catch (MessagingException e) {
	              throw new RuntimeException(e);
	        }
		}
		
		//Gera uma senha de 10 caracteres, através da conversão de 
		//valores inteiros aleatóriso em caracteres.
		public static String gerarMatricula(){
			final Random random = new Random();
			final int TAMANHO = 10;
			
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

}
