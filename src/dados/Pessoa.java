package dados;

import java.util.Date;

public class Pessoa {
	
	private String nome;
	private Endereco endereco;
	private String cpf;
	private Date dataDeNasc;
	private int matricula;
	
	public Pessoa() {
		
	}

	public Pessoa(String nome, Endereco endereco, String cpf, Date dataDeNasc, int matricula) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.cpf = cpf;
		this.dataDeNasc = dataDeNasc;
		this.matricula = matricula;
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

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataDeNasc == null) ? 0 : dataDeNasc.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + matricula;
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
