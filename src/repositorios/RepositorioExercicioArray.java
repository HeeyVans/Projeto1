package repositorios;

import java.util.ArrayList;
import java.util.List;

import basicas.Exercicio;
import interfaces.IRepositorioExercicio;

public class RepositorioExercicioArray implements IRepositorioExercicio{
	
	public static final int TAM = 1000000;
	private int indice = 0;
	private Exercicio[] repositorio;
	int i;
	
	public RepositorioExercicioArray(){
		this.repositorio = new Exercicio[TAM];
		indice = 0;
	}
	

	@Override
	public void inserir(Exercicio exercicio) {		
		repositorio[indice] = exercicio;
		indice++;
	}
	
	public List listar() {
		
		List exercicios = new ArrayList();
		i = 0;
		while(i < indice) {
			exercicios.add(repositorio[i]);
			 i++;
			}
		return exercicios;
		}

}
