package sistema;

import java.util.List;

import basicas.Administrador;
import basicas.AtividadeDiaria;
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
import interfaces.IRepositorioInstrutor;
import interfaces.IRepositorioTreino;
import repositorios.RepositorioADMArray;
import repositorios.RepositorioClienteArray;
import repositorios.RepositorioInstrutorArray;
import repositorios.RepositorioTreinoArray;

public class Fachada {
	
	private static Fachada instance;
	private CadastroCliente cliente;
	private CadastroInstrutor instrutor;
	private CadastroTreino treino;
	private CadastroADM adm;
	
	public Fachada() {
		
		adm = new CadastroADM();
		cliente = new CadastroCliente();
		instrutor = new CadastroInstrutor();
		treino = new CadastroTreino();
		
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
	public List listarClienteEmDia(String pagamentoEmDia) {
		return this.cliente.listarEmDia(pagamentoEmDia);
	}
	public List listarClienteAtrasado(String pagamentoAtrasado) {
		return this.cliente.listarAtrasado(pagamentoAtrasado);
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
	//INICIO DE CRUD TREINO
	public void inserirTreino(Treino treino) throws MatriculaNaoEncontradaException {
		this.treino.inserir(treino);
	}
	
	public Treino procurarClienteTreino(String matricula, String categoria) {
		return this.treino.procurarClienteTreino(matricula, categoria);
	}
	public void atualizarTreino(Treino treino) {
		this.treino.atualizar(treino);
	}
	public List listarTreino(String matricula, String categoria) {
		return this.treino.listar(matricula, categoria);
	}
	//FIM DE CRUD TREINO
}
