package sistema;

import basicas.Cliente;
import interfaces.IRepositorioCliente;
import repositorios.RepositorioClienteArrays;

public class Fachada {
	
	private static Fachada instance;
	private CadastroCliente cliente;
	
	public Fachada() {
		//Repositórios Array
		
		IRepositorioCliente repCliente = new RepositorioClienteArrays();
		
		//Repositórios Arquivo
	}
	
	public static Fachada getInstance(){
		
		if(instance == null){
			instance = new Fachada();
			return instance;
		}
		
		return instance;
		
	}
	
	//INICIO CRUD DE CLIENTE
	
	public void cadastrarCliente(Cliente cliente) {
		this.cliente.inserir(cliente);
	}
	public Cliente procurarCliente(int matricula) {
		return cliente.procurar(matricula);
	}
	public void removerCliente(int matricula) {
		cliente.remover(matricula);
	}
	public void atualizar(Cliente cliente) {
		this.cliente.atualizar(cliente);
	}
	//listar();
	
	//FIM DE CRUD DE CLIENTE

}
