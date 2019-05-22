package basicas;

import java.util.Date;

public class Instrutor extends Pessoa {
	
	private String cargo;
	private String horaTrab;
	
	public Instrutor() {
		
	}
	//CONSTRUTOR PARA TESTES
	public Instrutor(String nome, Endereco endereco, String cpf) {
		super(nome, endereco, cpf);
		
	}

	public Instrutor(String nome, Endereco endereco, String cpf, Date dataDeNasc, String matricula,
			String identificador, String email) {
		super(nome, endereco, cpf, dataDeNasc, matricula, identificador, email);
		// TODO Auto-generated constructor stub
	}

	public Instrutor(String cargo, String horaTrab) {
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
