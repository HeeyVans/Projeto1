package basicas;

import java.io.Serializable;
import java.util.Date;

public abstract class Pessoa implements Serializable{
	
	private String nome;
	private Endereco endereco;
	private String cpf;
	private Date dataDeNasc;
	private String matricula;
	private String email;
	private String telefone;
	private String genero;
	
	public Pessoa() {
		
	}
	//CONSTRUTOR PARA TESTES	
	public Pessoa(String nome, Endereco endereco, String cpf, Date dataDeNasc, String matricula,
			String email, String telefone, String genero) {
		
		this.nome = nome;
		this.endereco = endereco;
		this.cpf = cpf;
		this.dataDeNasc = dataDeNasc;
		this.matricula = matricula;
		this.email = email;
		this.telefone = telefone;
		this.genero = genero;
	}
	
	public Pessoa(String nome, String cpf, String matricula, String identificador) {
		this.nome = nome;
		this.cpf = cpf;
		this.matricula = matricula;
		
	}
	
	public Pessoa(String nome, String cpf, String genero) {
		this.nome = nome;
		this.cpf = cpf;
		this.genero = genero;
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataDeNasc() {
		return dataDeNasc;
	}

	public void setDataDeNasc(Date dataDeNasc) {
		this.dataDeNasc = dataDeNasc;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataDeNasc == null) ? 0 : dataDeNasc.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataDeNasc == null) {
			if (other.dataDeNasc != null)
				return false;
		} else if (!dataDeNasc.equals(other.dataDeNasc))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (matricula != other.matricula)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", endereco=" + endereco + ", cpf=" + cpf + ", dataDeNasc=" + dataDeNasc
				+ ", matricula=" + matricula + "]";
	}
	
}
