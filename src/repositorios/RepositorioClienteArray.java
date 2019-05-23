package repositorios;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import basicas.Cliente;
import excecoes.ClienteJaCadastradoException;
import excecoes.ClienteNaoEncontradoException;
import interfaces.IRepositorioCliente;

public class RepositorioClienteArray implements IRepositorioCliente{
	
	public static final int TAM = 1000000;
	private int indice;
	private int i;
	private Cliente[] repositorio;
	
	public RepositorioClienteArray(){
		this.repositorio = new Cliente[TAM];
		indice = 0;
	}
	
	public int getIndice(String cpf) {
		int i = 0;
		
		if(indice != 0) {
			while(!cpf.equals(repositorio[i].getCpf())) {
				if(i == indice - 1) {
					return -1;
				}else {
					i++;
				}
			}
			return i;
		}
		return -1;
	}
	
	public boolean existe(String cpf) {
		i = getIndice(cpf);
		if(i == -1) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public void inserir(Cliente cliente)  {
		if(!existe(cliente.getCpf())) {
			repositorio[indice] = cliente;
			indice++;
		}
		
		
	}

	@Override
	public Cliente procurar(String cpf)  {
		if(existe(cpf)) {
			return this.repositorio[i];
		}else {
			return null;
		}
		
	}

	@Override
	public void remover(String cpf)  {
		if(!existe(cpf)) {
			
		}else {
			repositorio[i] = null;
			repositorio[i] = repositorio[indice - 1];
			repositorio[indice - 1] = null;
			indice--;
		}
		
	}

	@Override
	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException{
		if(existe(cliente.getCpf())) {
			repositorio[i] = cliente;
		}else {
			ClienteNaoEncontradoException cnee = new ClienteNaoEncontradoException();
			throw cnee;
		}
		
	}

	@Override
	public List listar() {
		
		List clientes = new ArrayList();
		i = 0;
		while(i < indice) {
			 clientes.add(repositorio[i]);
			 i++;
			}
		return clientes;
		}

	}
	

