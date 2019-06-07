package basicas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class teste {

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String hojeFormatado = localDate.format(formatter);
        System.out.println(hojeFormatado);
        
        LocalDateTime agoraS = LocalDateTime.now();
        DateTimeFormatter formatterS = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String agoraFormatadoS = agoraS.format(formatterS);
        System.out.println(agoraFormatadoS);		
		
	}

}
