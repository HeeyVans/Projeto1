package basicas;

import repositorios.RepositorioExercicioArquivo;
import repositorios.RepositorioExercicioArray;

public class Treino {
	
	private Instrutor instrutor;
	private Cliente cliente;
	private Exercicio exercicio;
	private RepositorioExercicioArray repExer;
	private String id;
	
	
	public Treino(Instrutor instrutor, Cliente cliente, Exercicio exercicio, RepositorioExercicioArray repExer,
			String string) {
		
		this.instrutor = instrutor;
		this.cliente = cliente;
		this.exercicio = exercicio;
		this.repExer = repExer;
		this.id = string;
	}


	public Treino() {
		
	}


	public Instrutor getInstrutor() {
		return instrutor;
	}


	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Exercicio getExercicio() {
		return exercicio;
	}


	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}


	public RepositorioExercicioArray getRepExer() {
		return repExer;
	}


	public void setRepExer(RepositorioExercicioArray repExer) {
		this.repExer = repExer;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	
	
	/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((exercicio == null) ? 0 : exercicio.hashCode());
		result = prime * result + ((instrutor == null) ? 0 : instrutor.hashCode());
		result = prime * result + ((obs == null) ? 0 : obs.hashCode());
		long temp;
		temp = Double.doubleToLongBits(porcentagem);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + serie;
		result = prime * result + tempoDescanso;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Treino other = (Treino) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (exercicio == null) {
			if (other.exercicio != null)
				return false;
		} else if (!exercicio.equals(other.exercicio))
			return false;
		if (instrutor == null) {
			if (other.instrutor != null)
				return false;
		} else if (!instrutor.equals(other.instrutor))
			return false;
		if (obs == null) {
			if (other.obs != null)
				return false;
		} else if (!obs.equals(other.obs))
			return false;
		if (Double.doubleToLongBits(porcentagem) != Double.doubleToLongBits(other.porcentagem))
			return false;
		if (serie != other.serie)
			return false;
		if (tempoDescanso != other.tempoDescanso)
			return false;
		return true;
	}
	*/
	
}
