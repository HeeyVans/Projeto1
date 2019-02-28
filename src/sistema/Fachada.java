package sistema;

import basicas.Cliente;
import excecoes.ClienteJaCadastrado;
import interfaces.IRepositorioCliente;
import repositorios.RepositorioClienteArrays;

public class Fachada {
	
	private static Fachada instance;
	private CadastroCliente cliente;
	
	public Fachada() {
		//Reposit�rios Array
		
		IRepositorioCliente repCliente = new RepositorioClienteArrays();
		
		//Reposit�rios Arquivo
	}
	
	public static Fachada getInstance(){
		
		if(instance == null){
			instance = new Fachada();
			return instance;
		}
		
		return instance;
		
	}
	
	//INICIO CRUD DE CLIENTE
	
	public void cadastrarCliente(Cliente cliente) throws ClienteJaCadastrado {
		this.cliente.inserir(cliente);
	}
	public Cliente procurarCliente(String matricula) {
		return cliente.procurar(matricula);
	}
	public void removerCliente(String matricula) {
		cliente.remover(matricula);
	}
	public void atualizar(Cliente cliente) {
		this.cliente.atualizar(cliente);
	}
	//listar();
	
	//FIM DE CRUD DE CLIENTE

}
