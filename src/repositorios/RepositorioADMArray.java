package repositorios;

import basicas.Administrador;
import interfaces.IRepositorioADM;

public class RepositorioADMArray implements IRepositorioADM{
	
	public static final int TAM = 1;
	private int indice;
	private int i;
	private Administrador[] repositorio;
	
	public RepositorioADMArray(){
		this.repositorio = new Administrador[TAM];
		indice = 0;
	}
	
	public int getIndice(String matricula) {
		int i = 0;
		
		if(indice != 0) {
			while(!matricula.equals(repositorio[i].getMatricula())) {
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
	
	public boolean existe(String matricula) {
		i = getIndice(matricula);
		if(i == -1) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public void inserir(Administrador adm) {
		
		if(!existe(adm.getCpf())) {
			repositorio[indice] = adm;
			indice++;
		}
	}

	@Override
	public Administrador procurar(String matricula) {
		
		if(existe(matricula)) {
			return this.repositorio[i];
		}else {
			return null;
		}
		
	}

}
