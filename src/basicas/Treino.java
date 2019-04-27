package basicas;

public class Treino {
	
	private String obs;
	private int serie;
	private int tempoDescanso;
	private double porcentagem;
	private Instrutor instrutor;
	private Cliente cliente;
	private Exercicio exercicio;
	
	public Treino() {
		
	}
	
	public Treino(String obs, int serie, int tempoDescanso, double porcentagem, Instrutor instrutor, Cliente cliente,
			Exercicio exercicio) {
		this.obs = obs;
		this.serie = serie;
		this.tempoDescanso = tempoDescanso;
		this.porcentagem = porcentagem;
		this.instrutor = instrutor;
		this.cliente = cliente;
		this.exercicio = exercicio;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public int getSerie() {
		return serie;
	}
	public void setSerie(int serie) {
		this.serie = serie;
	}
	public int getTempoDescanso() {
		return tempoDescanso;
	}
	public void setTempoDescanso(int tempoDescanso) {
		this.tempoDescanso = tempoDescanso;
	}
	public double getPorcentagem() {
		return porcentagem;
	}
	public void setPorcentagem(double porcentagem) {
		this.porcentagem = porcentagem;
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
	
	
}
