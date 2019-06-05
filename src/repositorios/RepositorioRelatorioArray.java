package repositorios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import basicas.AtividadeDiaria;
import basicas.Cliente;
import basicas.Treino;
import interfaces.IRepositorioRelatorio;

public class RepositorioRelatorioArray implements IRepositorioRelatorio, Serializable{
	
	public static final int TAM = 1000;
	private int indice;
	private int i;
	private AtividadeDiaria[] repositorio;
	public static RepositorioRelatorioArray instance;
	
	public RepositorioRelatorioArray(){
		this.repositorio = new AtividadeDiaria[TAM];
		indice = 0;
	}
	
	/*public static RepositorioClienteArray getInstance() {
	    if (instance == null) {
	      instance = lerDoArquivo();
	    }
	    return instance;
	  }*/
	
	public int getIndice(String cpf) {
		int i = 0;
		
		if(indice != 0) {
			while(!cpf.equals(repositorio[i].getTreino().getCliente().getCpf())) {
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
	
	@Override
	public void inserir(AtividadeDiaria ativ) {
			repositorio[indice] = ativ;
			indice++;
	}


	@Override
	public List listar() {		
		List treinos = new ArrayList();
		
		int i = 0;
		
		while(i < indice) {	
			treinos.add(repositorio[i]);
			 i++;
		}
		return treinos;
	}

}
