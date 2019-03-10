package sistema;

import basicas.Cliente;
import basicas.Instrutor;
import excecoes.ClienteJaCadastradoException;
import interfaces.IRepositorioCliente;
import interfaces.IRepositorioInstrutor;
import repositorios.RepositorioClienteArrays;
import repositorios.RepositorioInstrutorArrays;

public class Fachada {
	
	private static Fachada instance;
	private CadastroCliente cliente;
	
	public Fachada() {
		//Repositórios Array
		
		IRepositorioInstrutor repInstrutor = new RepositorioInstrutorArrays();
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
	
	public void cadastrarCliente(Cliente cliente) throws ClienteJaCadastradoException {
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
