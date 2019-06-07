package basicas;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AtividadeDiaria implements Serializable{

	Treino treino;
	LocalDate data;
	
	public AtividadeDiaria(Treino treino, LocalDate data) {
		
		this.treino = treino;
		this.data = data;
	}

	public Treino getTreino() {
		return treino;
	}

	public void setTreino(Treino treino) {
		this.treino = treino;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
}
