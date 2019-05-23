package sistema;

import java.util.List;

import basicas.Cliente;
import basicas.Exercicio;
import basicas.Instrutor;
import basicas.Treino;
import excecoes.ClienteJaCadastradoException;
import excecoes.ClienteNaoEncontradoException;
import excecoes.InstrutorJaCadastradoException;
import interfaces.IRepositorioCliente;
import interfaces.IRepositorioExercicio;
import interfaces.IRepositorioInstrutor;
import interfaces.IRepositorioTreino;
import repositorios.RepositorioClienteArquivo;
import repositorios.RepositorioClienteArray;
import repositorios.RepositorioExercicioArquivo;
import repositorios.RepositorioExercicioArray;
import repositorios.RepositorioInstrutorArquivo;
import repositorios.RepositorioInstrutorArray;
import repositorios.RepositorioTreinoArquivo;
import repositorios.RepositorioTreinoArray;

public class Fachada {
	
	private static Fachada instance;
	private CadastroCliente cliente;
	private CadastroInstrutor instrutor;
	private CadastroExercicio exercicio;
	private CadastroTreino treino;
	
	public Fachada() {
		
		//Repositórios ArrayArquivo		
		//IRepositorioInstrutor repInstrutor = new RepositorioInstrutorArquivo();
		//IRepositorioCliente repCliente = new RepositorioClienteArquivo();
		//IRepositorioExercicio repExercicio = new RepositorioExercicioArquivo();
		//IRepositorioTreino repTreino = new RepositorioTreinoArquivo();
		
		IRepositorioInstrutor repInstrutor = new RepositorioInstrutorArray();
		IRepositorioCliente repCliente = new RepositorioClienteArray();
		IRepositorioExercicio repExercicio = new RepositorioExercicioArray();
		IRepositorioTreino repTreino = new RepositorioTreinoArray();
		
		cliente = new CadastroCliente(repCliente);
		instrutor = new CadastroInstrutor(repInstrutor);
		exercicio = new CadastroExercicio(repExercicio);
		treino = new CadastroTreino(repTreino);
		
	}
	
	public static Fachada getInstance(){
		
		if(instance == null){
			instance = new Fachada();
			return instance;
		}
		
		return instance;
		
	}
	
	//INICIO CRUD DE CLIENTE
	
	public void cadastrarCliente(Cliente cliente)  {
		this.cliente.inserir(cliente);
	}
	public Cliente procurarCliente(String cpf) {
		return cliente.procurar(cpf);
	}
	public void removerCliente(String cpf) {
		cliente.remover(cpf);
	}
	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException{
		this.cliente.atualizar(cliente);
	}
	public List listarCliente(String cpf) {
		return this.cliente.listar(cpf);
	}
	//listar();
	
	//FIM DE CRUD DE CLIENTE
	
	//INICIO DE CRUD DO INSTRUTOR
	public void cadastrarInstrutor(Instrutor instrutor) throws InstrutorJaCadastradoException{
		this.instrutor.inserir(instrutor);
	}
	
	public Instrutor procurarInstrutor(String cpf) {
		return instrutor.procurar(cpf);
	}

	public void removerInstrutor(String cpf) {
		instrutor.remover(cpf);
	}
	
	public void atualizar(Instrutor instrutor) {
		this.instrutor.atualizar(instrutor);
	}
	//listar();
	
	//FIM DE CRUD DO INSTRUTOR
	//INICIO DE CRUD EXERCICIO
	public void inserirExercicio(Exercicio exercicio) {
		this.exercicio.inserir(exercicio);
	}
	//FIM DE CRUD EXERCICIO
	//INICIO DE CRUD TREINO
	public void inserirTreino(Treino treino) {
		this.treino.inserir(treino);
	}
	
	public Treino procurarTreino(int id) {
		return this.treino.procurar(id);
	}
	
	public void removerTreino(int id) {
		this.treino.remover(id);
	}
	
	public void atualizarTreino(Treino treino) {
		this.treino.atualizar(treino);
	}
	//FIM DE CRUD TREINO
}
