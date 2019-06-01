package repositorios;

import java.util.ArrayList;
import java.util.List;

import basicas.Instrutor;
import interfaces.IRepositorioInstrutor;

public class RepositorioInstrutorArray implements IRepositorioInstrutor{

	public static final int TAM = 1000000;
	private int indice;
	private int i;
	private Instrutor[] repositorio;
	
	public RepositorioInstrutorArray(){
		this.repositorio = new Instrutor[TAM];
		indice = 0;
	}
	
	public int getIndice(String cpf) {
		int i = 0;
		
		if(indice != 0) {
			while(!(cpf.equals(repositorio[i].getCpf()))) {
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
	
	public boolean existe(String cpf) {
		i = getIndice(cpf);
		if(i == -1) {
			return false;
		}else {
			return true;
		}
	}
	
	public int getIndiceMatricula(String matricula) {
		int i = 0;
		
		if(indice != 0) {
			while(!(matricula.equals(repositorio[i].getMatricula()))) {
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
	
	public boolean existeMatricula(String matricula) {
		i = getIndiceMatricula(matricula);
		if(i == -1) {
			return false;
		}else {
			return true;
		}
	}
	
	@Override
	public void inserir(Instrutor instrutor) {
		
		if(!existe(instrutor.getCpf())) {
			repositorio[indice] = instrutor;
			indice++;
		}
	}

	@Override
	public Instrutor procurar(String cpf) {
		
		if(existe(cpf)) {
			return this.repositorio[i];
		}else {
			return null;
		}
	}
	
	@Override
	public Instrutor procurarMatricula(String matricula) {
		
		if(existeMatricula(matricula)) {
			return this.repositorio[i];
		}else {
			return null;
		}
	}

	@Override
	public void remover(String cpf) {
		
		if(existe(cpf)) {
			repositorio[i] = null;
			repositorio[i] = repositorio[indice - 1];
			repositorio[indice - 1] = null;
			indice--;
		}
	}

	@Override
	public void atualizar(Instrutor instrutor) {
		
		if(existe(instrutor.getCpf())) {
			repositorio[i] = instrutor;
		}
	}

	@Override
	public List listar(String nome) {
		
		List instrutor = new ArrayList();
		i = 0;
		while(i < indice) {
			if(repositorio[i].getNome().equals(nome)) {
				instrutor.add(repositorio[i]);
			}			 
			 i++;
			}
		return instrutor;
		}

}
