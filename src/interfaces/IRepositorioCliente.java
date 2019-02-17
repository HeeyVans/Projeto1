package interfaces;

import basicas.Cliente;

public interface IRepositorioCliente {
	
	public void inserir(Cliente cliente);
	public Cliente procurar(int matricula);
	public void remover(int matricula);
	public void atualizar(Cliente cliente);
	//listar

}
