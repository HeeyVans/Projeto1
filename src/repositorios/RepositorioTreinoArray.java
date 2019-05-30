package repositorios;

import java.util.ArrayList;
import java.util.List;

import basicas.Cliente;
import basicas.Exercicio;
import basicas.Treino;
import interfaces.IRepositorioTreino;

public class RepositorioTreinoArray implements IRepositorioTreino{

	public static final int TAM = 1000000;
	private int indice;
	private int i;
	private Treino[] repositorio;
	
	public RepositorioTreinoArray(){
		this.repositorio = new Treino[TAM];
		indice = 0;
	}
	
	public int getIndice(String id) {
		int i = 0;
		
		if(indice != 0) {
			while(!(id == repositorio[i].getId())) {
				if(i == indice - 1) {
					return -1;
				}else {
					i++;
				}
			}
			return i;
		}
		return -1;
	}
	
	public boolean existe(String id) {
		i = getIndice(id);
		if(i == -1) {
			return false;
		}else {
			return true;
		}
	}
	
	public int getIndiceClienteTreino(String matricula) {
		int i = 0;
		
		if(indice != 0) {
			while(!(matricula == repositorio[i].getCliente().getMatricula())) {
				if(i == indice - 1) {
					return -1;
				}else {
					i++;
				}
			}
			return i;
		}
		return -1;
	}
	
	public boolean existeClienteTreino(String matricula) {
		i = getIndiceClienteTreino(matricula);
		if(i == -1) {
			return false;
		}else {
			return true;
		}
	}
	@Override
	public void inserir(Treino treino) {
		
		if(!existe(treino.getId())) {
			repositorio[indice] = treino;
			indice++;
		}
	}

	@Override
	public Treino procurar(String id) {
		
		if(existe(id)) {
			return this.repositorio[i];
		}else {
			return null;
		}
	}

	@Override
	public void remover(String id) {
		
		if(existe(id)) {
			repositorio[i] = null;
			repositorio[i] = repositorio[indice - 1];
			repositorio[indice - 1] = null;
			indice--;
		}
	}

	@Override
	public void atualizar(Treino treino) {
		
		if(existe(treino.getId())) {
			repositorio[i] = treino;
			}

		}
	
	public List listar(String matricula, String categoria) {
		
		List exercicios = new ArrayList();
		i = 0;
		while(i < indice) {
			if(repositorio[i].getCliente().getMatricula() == matricula && categoria == repositorio[i]
					.getCategoria()) {
				exercicios = repositorio[i].getRepExer().listar();
				
				}
			 i++;
			}
		return exercicios;
		}
	

	@Override
	public Treino procurarClienteTreino(String matricula) {
		
		if(existeClienteTreino(matricula)) {
			return this.repositorio[i];
		}else {
			return null;
			}
		
		}
	}
