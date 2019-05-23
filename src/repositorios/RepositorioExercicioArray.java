package repositorios;

import basicas.Exercicio;
import interfaces.IRepositorioExercicio;

public class RepositorioExercicioArray implements IRepositorioExercicio{
	
	public static final int TAM = 1000000;
	private int indice = 0;
	private Exercicio[] repositorio;
	
	public RepositorioExercicioArray(){
		this.repositorio = new Exercicio[TAM];
		indice = 0;
	}
	

	@Override
	public void inserir(Exercicio exercicio) {		
		repositorio[indice] = exercicio;
		indice++;
	}

}
