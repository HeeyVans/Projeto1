package repositorios;

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
	
	public int getIndice(int id) {
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
	
	public boolean existe(int id) {
		i = getIndice(id);
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
	public Treino procurar(int id) {
		
		if(existe(id)) {
			return this.repositorio[i];
		}else {
			return null;
		}
	}

	@Override
	public void remover(int id) {
		
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
	}
