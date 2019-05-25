package sistema;

import java.util.List;

import basicas.Exercicio;
import interfaces.IRepositorioExercicio;

public class CadastroExercicio {
	
	private IRepositorioExercicio repositorio;

	public CadastroExercicio(IRepositorioExercicio repositorio) {
		
		this.repositorio = repositorio;
	}

	
	public void inserir(Exercicio exercicio) {
		this.repositorio.inserir(exercicio);
	}
	
	public List listar() {
		return repositorio.listar();
	}

}
