package sistema;

import java.util.List;

import basicas.AtividadeDiaria;
import basicas.Cliente;
import basicas.Treino;
import interfaces.IRepositorioRelatorio;
import repositorios.RepositorioRelatorioArray;

public class CadastroAtividade {
	
	private IRepositorioRelatorio repositorio;

	public CadastroAtividade() {		
				repositorio = new RepositorioRelatorioArray();	
	}
	
	public void inserir(AtividadeDiaria ativ) {
		repositorio.inserir(ativ);
	}
	
	public List listar() {
		return repositorio.listar();
	}

}
