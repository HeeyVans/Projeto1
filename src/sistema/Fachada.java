package sistema;

import basicas.Cliente;
import basicas.Exercicio;
import basicas.Instrutor;
import basicas.Treino;
import excecoes.ClienteJaCadastradoException;
import excecoes.InstrutorJaCadastradoException;
import excecoes.MatriculaInvalidaException;
import excecoes.NaoEncontradoException;
import interfaces.IRepositorioCliente;
import interfaces.IRepositorioExercicio;
import interfaces.IRepositorioInstrutor;
import interfaces.IRepositorioTreino;
import repositorios.RepositorioClienteArrays;
import repositorios.RepositorioExercicioArrays;
import repositorios.RepositorioInstrutorArrays;
import repositorios.RepositorioTreinoArrays;

public class Fachada {
	
	private static Fachada instance;
	private CadastroCliente cliente;
	private CadastroInstrutor instrutor;
	private CadastroExercicio exercicio;
	private CadastroTreino treino;
	
	public Fachada() {
		//Repositórios ArrayArquivo
		
		IRepositorioInstrutor repInstrutor = new RepositorioInstrutorArrays();
		IRepositorioCliente repCliente = new RepositorioClienteArrays();
		IRepositorioExercicio repExercicio = new RepositorioExercicioArrays();
		IRepositorioTreino repTreino = new RepositorioTreinoArrays();
		
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
	public Cliente procurarCliente(String matricula) throws MatriculaInvalidaException {
		return cliente.procurar(matricula);
	}
	public void removerCliente(String matricula) throws NaoEncontradoException {
		cliente.remover(matricula);
	}
	public void atualizar(Cliente cliente) throws NaoEncontradoException{
		this.cliente.atualizar(cliente);
	}
	//listar();
	
	//FIM DE CRUD DE CLIENTE
	
	//INICIO DE CRUD DO INSTRUTOR
	public void cadastrarInstrutor(Instrutor instrutor) throws InstrutorJaCadastradoException{
		this.instrutor.inserir(instrutor);
	}
	
	public Instrutor procurarInstrutor(String matricula) {
		return instrutor.procurar(matricula);
	}

	public void removerInstrutor(String matricula) {
		instrutor.remover(matricula);
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
