package sistema;

import java.util.List;

import basicas.AtividadeDiaria;
import interfaces.IRepositorioAtividadeDiaria;
import repositorios.RepositorioAtividadeDiariaArray;

public class CadastroAtividade {
	
	private IRepositorioAtividadeDiaria repositorio;
	
	public CadastroAtividade() {
		repositorio = new RepositorioAtividadeDiariaArray();
	}
	
	public void inserir(AtividadeDiaria atividade) {
		repositorio.inserir(atividade);
		//RepositorioAtividadeDiariaArray.salvarArquivo();
	}
	
	public AtividadeDiaria procurar(String cpf) {
		return repositorio.procurar(cpf);
	}
	
	public List listar(String cpf) {
		return repositorio.listar(cpf);
	}

}
