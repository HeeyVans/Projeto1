package sistema;

import basicas.Treino;
import interfaces.IRepositorioTreino;

public class CadastroTreino {
	
	private IRepositorioTreino repositorio;

	public CadastroTreino(IRepositorioTreino repositorio) {
		
		this.repositorio = repositorio;
	}
	
	public void inserir(Treino treino) {
		this.repositorio.inserir(treino);
	}
	
	public Treino procurar(int id) {
		return this.repositorio.procurar(id);
	}
	
	public void remover(int id) {
		this.repositorio.remover(id);
	}
	
	public void atualizar(Treino treino) {
		this.repositorio.atualizar(treino);
	}

}
