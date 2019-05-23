package interfaces;

import java.sql.ResultSet;
import java.util.List;

import basicas.Cliente;
import excecoes.ClienteJaCadastradoException;
import excecoes.ClienteNaoEncontradoException;

public interface IRepositorioCliente {
	
	public void inserir(Cliente cliente) throws ClienteJaCadastradoException;
	public Cliente procurar(String cpf);
	public void remover(String cpf);
	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException;
	public List listar();
	
}
