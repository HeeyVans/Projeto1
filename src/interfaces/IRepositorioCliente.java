package interfaces;

import java.sql.ResultSet;
import java.util.List;

import basicas.Cliente;
import excecoes.ClienteJaCadastradoException;
import excecoes.ClienteNaoEncontradoException;

public interface IRepositorioCliente {
	
	public void inserir(Cliente cliente);
	public Cliente procurar(String cpf);
	public Cliente procurarMatricula(String matricula);
	public void remover(String cpf);
	public void atualizar(Cliente cliente);
	public List listar(String nome);
	public List listarEmDia(String pagamentoEmDia);
	public List listarAtrasado(String pagamentoAtrasado);
	public List listar();
	
}
