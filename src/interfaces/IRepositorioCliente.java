package interfaces;

import basicas.Cliente;
import excecoes.ClienteJaCadastradoException;
import excecoes.NaoEncontradoException;
import excecoes.ParametroNuloException;

public interface IRepositorioCliente {
	
	public void inserir(Cliente cliente) throws ClienteJaCadastradoException;
	public Cliente procurar(String matricula) throws NaoEncontradoException, ParametroNuloException;
	public void remover(String matricula);
	public void atualizar(Cliente cliente) throws NaoEncontradoException, ParametroNuloException;
	public Cliente[] listar();
	
}
