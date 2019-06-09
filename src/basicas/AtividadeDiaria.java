package basicas;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AtividadeDiaria implements Serializable{

	Cliente cliente;
	LocalDateTime data;
	
	public AtividadeDiaria(Cliente cliente, LocalDateTime data) {
		
		this.cliente = cliente;
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
