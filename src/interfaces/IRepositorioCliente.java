package interfaces;

import basicas.Cliente;
import excecoes.ClienteJaCadastradoException;

public interface IRepositorioCliente {
	
	public void inserir(Cliente cliente) throws ClienteJaCadastradoException;
	public Cliente procurar(String matricula);
	public void remover(String matricula);
	public void atualizar(Cliente cliente);
	public Cliente[] listar();
	
}
