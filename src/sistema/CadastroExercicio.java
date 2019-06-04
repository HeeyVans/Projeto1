package sistema;

import java.util.List;

import basicas.Exercicio;
import interfaces.IRepositorioExercicio;
import repositorios.RepositorioExercicioArray;

public class CadastroExercicio {
	
	private IRepositorioExercicio repositorio;

	public CadastroExercicio() {
		
		repositorio = new RepositorioExercicioArray();
	}

	
	public void inserir(Exercicio exercicio) {
		this.repositorio.inserir(exercicio);
	}
	
	public List listar() {
		return repositorio.listar();
	}

}
