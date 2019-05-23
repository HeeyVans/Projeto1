package basicas;

import java.util.Date;

public class Cliente extends Pessoa{
	
	private String pagamento;
	private String objetivo;
	
	public Cliente() {
		
	}

	

	public Cliente(String pagamento, String objetivo) {
		super();
		this.pagamento = pagamento;
		this.objetivo = objetivo;
	}
	//CONSTRUTOR PARA TESTESa

	public Cliente(String nome, String cpf, String matricula, String genero, String email) {
		super(nome, cpf, matricula, genero, email);
		// TODO Auto-generated constructor stub
	}
	
	public String getPagamento() {
		return pagamento;
	}

	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	@Override
	public String toString() {
		return "Cliente [pagamento=" + pagamento + ", objetivo=" + objetivo + "]";
	}
	
}
