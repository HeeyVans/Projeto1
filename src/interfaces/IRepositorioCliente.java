package interfaces;

import basicas.Cliente;
import excecoes.ClienteJaCadastrado;

public interface IRepositorioCliente {
	
	public void inserir(Cliente cliente) throws ClienteJaCadastrado;
	public Cliente procurar(String matricula);
	public void remover(String matricula);
	public void atualizar(Cliente cliente);
	//listar
	

}
