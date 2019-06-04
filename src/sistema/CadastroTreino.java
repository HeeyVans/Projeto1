package sistema;

import java.util.List;

import basicas.Cliente;
import basicas.Treino;
import excecoes.MatriculaNaoEncontradaException;
import interfaces.IRepositorioTreino;
import repositorios.RepositorioTreinoArray;

public class CadastroTreino {
	
	private IRepositorioTreino repositorio;

	public CadastroTreino() {
		
		repositorio = new RepositorioTreinoArray();
	}
	
	public void inserir(Treino treino) throws MatriculaNaoEncontradaException {
		this.repositorio.inserir(treino);
	}
	
	public Treino procurar(String id) {
		return this.repositorio.procurar(id);
	}
	
	public Treino procurarClienteTreino(String matricula) {
		return this.repositorio.procurarClienteTreino(matricula);
	}
	
	public void remover(String id) {
		this.repositorio.remover(id);
	}
	
	public void atualizar(Treino treino) {
		this.repositorio.atualizar(treino);
	}
	
	public List listar(String matricula, String categoria) {
		return repositorio.listar(matricula, categoria);
	}
	

}
