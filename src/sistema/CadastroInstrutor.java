package sistema;

import basicas.Instrutor;
import excecoes.InstrutorJaCadastradoException;
import interfaces.IRepositorioInstrutor;

public class CadastroInstrutor {
	
	private IRepositorioInstrutor repositorio;
	
	public CadastroInstrutor(IRepositorioInstrutor repositorio) {
		this.repositorio = repositorio;
	}
	
	public void inserir(Instrutor instrutor) throws InstrutorJaCadastradoException {
		repositorio.inserir(instrutor);
	}
	
	public Instrutor procurar(String matricula) /*throws MatriculaNaoEncontradaException*/  {
		return repositorio.procurar(matricula);
	}
	
	public void remover(String matricula) /*throws MatriculaNaoEncontradaException*/   {
		repositorio.remover(matricula);
	}
	
	public void atualizar(Instrutor instrutor) {
		repositorio.atualizar(instrutor);
	}

}
