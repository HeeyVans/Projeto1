package basicas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AtividadeDiaria {

	Treino treino;
	LocalDate data;
	
	public static void main(String[] args) {
		  
	        //Pega a data atual e a hora
		 	LocalDateTime agora = LocalDateTime.now();

	        System.out.println("LocalDateTime antes de formatar: " + agora);

	        DateTimeFormatter formatadorBarraEHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	        System.out.println("LocalDateTime depois de formatar: " +agora.format(formatadorBarraEHora));


	}
}
