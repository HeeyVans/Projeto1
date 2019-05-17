package interfaces;

import basicas.Cliente;
import excecoes.ClienteJaCadastradoException;
import excecoes.MatriculaInvalidaException;
import excecoes.NaoEncontradoException;
import excecoes.ParametroNuloException;

public interface IRepositorioCliente {
	
	public void inserir(Cliente cliente) throws ClienteJaCadastradoException;
	public Cliente procurar(String matricula) throws MatriculaInvalidaException;
	public void remover(String matricula) throws NaoEncontradoException;
	public void atualizar(Cliente cliente) throws NaoEncontradoException, ParametroNuloException;
	public Cliente[] listar();
	
}
