package basicas;

import java.util.Date;

public class Administrador extends Pessoa{

	public Administrador() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Administrador(String nome, Endereco endereco, String cpf, Date dataDeNasc, String matricula,
			String identificador, String email, String telefone, String genero) {
		super(nome, endereco, cpf, dataDeNasc, matricula, identificador, email, telefone, genero);
		// TODO Auto-generated constructor stub
	}



	public Administrador(String nome, String cpf, String matricula, String genero, String email) {
		super(nome, cpf, matricula, genero, email);
		// TODO Auto-generated constructor stub
	}



	

	


}
