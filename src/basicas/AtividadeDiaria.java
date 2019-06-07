package basicas;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AtividadeDiaria implements Serializable{

	Treino treino;
	LocalDateTime data;
	
	public AtividadeDiaria(Treino treino, LocalDateTime data) {
		
		this.treino = treino;
		this.data = data;
	}

	public Treino getTreino() {
		return treino;
	}

	public void setTreino(Treino treino) {
		this.treino = treino;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
}
