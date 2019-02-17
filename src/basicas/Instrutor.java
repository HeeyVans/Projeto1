package basicas;

import java.util.Date;

public class Instrutor extends Pessoa {
	
	private String cargo;
	private String horaTrab;
	
	public Instrutor() {
		
	}

	public Instrutor(String nome, Endereco endereco, String cpf, Date dataDeNasc, int matricula) {
		super(nome, endereco, cpf, dataDeNasc, matricula);
		// TODO Auto-generated constructor stub
	}

	public Instrutor(String cargo, String horaTrab) {
		super();
		this.cargo = cargo;
		this.horaTrab = horaTrab;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getHoraTrab() {
		return horaTrab;
	}

	public void setHoraTrab(String horaTrab) {
		this.horaTrab = horaTrab;
	}

	@Override
	public String toString() {
		return "Instrutor [cargo=" + cargo + ", horaTrab=" + horaTrab + "]";
	}
	
	
}
