package sistema;

import java.util.List;

import basicas.Instrutor;
import excecoes.InstrutorJaCadastradoException;
import excecoes.MatriculaNaoEncontradaException;
import interfaces.IRepositorioInstrutor;
import interfaces.IRepositorioTreino;
import repositorios.RepositorioInstrutorArray;
import repositorios.RepositorioTreinoArray;

public class CadastroInstrutor {
	
	private IRepositorioInstrutor repositorio;
	
	public CadastroInstrutor() {
		repositorio = RepositorioInstrutorArray.getInstance();
	}
	
	public void inserir(Instrutor instrutor)  {
			repositorio.inserir(instrutor);
			RepositorioInstrutorArray.salvarArquivo();
				
	}
	
	public Instrutor procurar(String cpf) {
		return repositorio.procurar(cpf);
	}
	
	public Instrutor procurarMatricula(String matricula) throws MatriculaNaoEncontradaException  {
		return repositorio.procurarMatricula(matricula);
	}
	
	public void remover(String matricula) throws MatriculaNaoEncontradaException  {
		repositorio.remover(matricula);
	}
	
	public void atualizar(Instrutor instrutor) {
		repositorio.atualizar(instrutor);
		RepositorioInstrutorArray.salvarArquivo();
	}

	public List listar(String nome) {
		return repositorio.listar(nome);
	}
	
	public List listar() {
		return repositorio.listar();
	}

}
