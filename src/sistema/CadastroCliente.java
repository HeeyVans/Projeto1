package sistema;

import basicas.Cliente;
import interfaces.IRepositorioCliente;

public class CadastroCliente {
	
	private IRepositorioCliente repositorio;

	public CadastroCliente(IRepositorioCliente repositorio) {
		super();
		this.repositorio = repositorio;
	}
	
	public void inserir(Cliente cliente) {
		repositorio.inserir(cliente);
	}
	
	public Cliente procurar(int matricula) /*throws MatriculaNaoEncontradaException*/ {
		return repositorio.procurar(matricula);
	}
	
	public void remover(int matricula) /*throws MatriculaNaoEncontradaException*/ {
		repositorio.remover(matricula);
	}
	
	public void atualizar(Cliente cliente) {
		repositorio.atualizar(cliente);
	}

}
