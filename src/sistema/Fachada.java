package sistema;

import java.util.List;

import basicas.Administrador;
import basicas.Cliente;
import basicas.Exercicio;
import basicas.Instrutor;
import basicas.Treino;
import excecoes.ClienteJaCadastradoException;
import excecoes.ClienteNaoEncontradoException;
import excecoes.InstrutorJaCadastradoException;
import excecoes.MatriculaNaoEncontradaException;
import interfaces.IRepositorioADM;
import interfaces.IRepositorioCliente;
import interfaces.IRepositorioExercicio;
import interfaces.IRepositorioInstrutor;
import interfaces.IRepositorioTreino;
import repositorios.RepositorioADMArray;
import repositorios.RepositorioClienteArray;
import repositorios.RepositorioExercicioArray;
import repositorios.RepositorioInstrutorArray;
import repositorios.RepositorioTreinoArray;

public class Fachada {
	
	private static Fachada instance;
	private CadastroCliente cliente;
	private CadastroInstrutor instrutor;
	private CadastroExercicio exercicio;
	private CadastroTreino treino;
	private CadastroADM adm;
	
	public Fachada() {
		
		//Repositórios ArrayArquivo		
		//IRepositorioInstrutor repInstrutor = new RepositorioInstrutorArquivo();
		//IRepositorioCliente repCliente = new RepositorioClienteArquivo();
		//IRepositorioExercicio repExercicio = new RepositorioExercicioArquivo();
		//IRepositorioTreino repTreino = new RepositorioTreinoArquivo();
		
		IRepositorioADM repADM = new RepositorioADMArray();
		IRepositorioInstrutor repInstrutor = new RepositorioInstrutorArray();
		IRepositorioCliente repCliente = new RepositorioClienteArray();
		IRepositorioExercicio repExercicio = new RepositorioExercicioArray();
		IRepositorioTreino repTreino = new RepositorioTreinoArray();
		
		adm = new CadastroADM(repADM);
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
	public Cliente procurarClienteMatricula(String matricula) {
		return cliente.procurarMatricula(matricula);
	}
	public void removerCliente(String cpf) {
		cliente.remover(cpf);
	}
	public void atualizar(Cliente cliente){
		this.cliente.atualizar(cliente);
	}
	public List listarCliente(String nome) {
		return this.cliente.listar(nome);
	}
	public List listarClienteVoid() {
		return this.cliente.listar();
	}
	
	//FIM DE CRUD DE CLIENTE
	//INICIO CRUD ADM
	public void cadastrarADM(Administrador adm)  {
		this.adm.inserir(adm);
	}
	public Administrador procurarADM(String matricula) {
		return adm.procurar(matricula);
	}
	//FIM CRUD ADM
	//INICIO DE CRUD DO INSTRUTOR
	public void cadastrarInstrutor(Instrutor instrutor){
		this.instrutor.inserir(instrutor);
	}
	
	public Instrutor procurarInstrutor(String cpf) {
		return instrutor.procurar(cpf);
	}
	
	public Instrutor procurarInstrutorMatricula(String matricula) {
		return instrutor.procurarMatricula(matricula);
	}

	public void removerInstrutor(String cpf) {
		instrutor.remover(cpf);
	}
	
	public void atualizar(Instrutor instrutor) {
		this.instrutor.atualizar(instrutor);
	}
	public List listarInstrutor(String nome) {
		return this.instrutor.listar(nome);
	}
	public List listarInstrutorVoid() {
		return this.instrutor.listar();
	}
	
	//FIM DE CRUD DO INSTRUTOR
	//INICIO DE CRUD EXERCICIO
	public void inserirExercicio(Exercicio exercicio) {
		this.exercicio.inserir(exercicio);
	}
	public List listarTreino() {
		return this.exercicio.listar();
	}
	//FIM DE CRUD EXERCICIO
	//INICIO DE CRUD TREINO
	public void inserirTreino(Treino treino) throws MatriculaNaoEncontradaException {
		this.treino.inserir(treino);
	}
	
	public Treino procurarTreino(String id) {
		return this.treino.procurar(id);
	}
	
	public Treino procurarClienteTreino(String matricula) {
		return this.treino.procurarClienteTreino(matricula);
	}
	
	public void removerTreino(String id) {
		this.treino.remover(id);
	}
	
	public void atualizarTreino(Treino treino) {
		this.treino.atualizar(treino);
	}
	public List listarTreino(String matricula, String categoria) {
		return this.treino.listar(matricula, categoria);
	}
	//FIM DE CRUD TREINO
}
