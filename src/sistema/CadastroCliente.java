package sistema;

import basicas.Cliente;
import excecoes.ClienteJaCadastradoException;
import excecoes.NaoEncontradoException;
import interfaces.IRepositorioCliente;

public class CadastroCliente {
	
	private IRepositorioCliente repositorio;

	public CadastroCliente(IRepositorioCliente repositorio) {
		this.repositorio = repositorio;
	}
	
	public void inserir(Cliente cliente) throws ClienteJaCadastradoException {
		repositorio.inserir(cliente);
	}
	
	public Cliente procurar(String matricula) throws NaoEncontradoException /*throws MatriculaNaoEncontradaException*/ {
		return repositorio.procurar(matricula);
	}
	
	public void remover(String matricula) /*throws MatriculaNaoEncontradaException*/ {
		repositorio.remover(matricula);
	}
	
	public void atualizar(Cliente cliente) throws NaoEncontradoException {
		repositorio.atualizar(cliente);
	}

}
