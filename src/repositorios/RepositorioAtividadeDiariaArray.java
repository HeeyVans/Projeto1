package repositorios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import basicas.AtividadeDiaria;
import interfaces.IRepositorioAtividadeDiaria;

public class RepositorioAtividadeDiariaArray implements IRepositorioAtividadeDiaria, Serializable{
	
	public static final int TAM = 1000000;
	private int indice;
	private AtividadeDiaria[] repositorio;
	private int i;
	public static RepositorioAtividadeDiariaArray instance;
	
	public RepositorioAtividadeDiariaArray(){
		this.repositorio = new AtividadeDiaria[TAM];
		indice = 0;
	}
	
	public static RepositorioAtividadeDiariaArray getInstance() {
	    if (instance == null) {
	      instance = lerDoArquivo();
	    }
	    return instance;
	  }
	
	public static RepositorioAtividadeDiariaArray lerDoArquivo() {
		RepositorioAtividadeDiariaArray instanciaLocal = null;
	    //Criando um arquivo e passando o nome dele	
	    File in = new File("atividade.dat");//criando um arquivo .dat na pasta do projeto
	   
	    FileInputStream fis = null;
	    ObjectInputStream ois = null;
	    try {
	      fis = new FileInputStream(in);
	      ois = new ObjectInputStream(fis);
	      Object o = ois.readObject();
	      instanciaLocal = (RepositorioAtividadeDiariaArray) o;
	    } catch (Exception e) {
	      instanciaLocal = new RepositorioAtividadeDiariaArray();
	    } finally {
	      if (ois != null) {
	        try {
	          ois.close();
	        } catch (IOException e) {
	        }
	      }
	    }

	    return instanciaLocal;
	  }

	public static void salvarArquivo() {
	    if (!(instance == null)) {
	     
	    File out = new File("atividade.dat");
	    FileOutputStream fos = null;
	    ObjectOutputStream oos = null;

	    try {
	      fos = new FileOutputStream(out);
	      oos = new ObjectOutputStream(fos);
	      oos.writeObject(instance); 
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      if (oos != null) {
	        try {
	          oos.close();
	        } catch (IOException e) {
	        }
	      }
	    }
	   }
	} 
	
	public int getIndice(String cpf) {
		int i = 0;
		
		if(indice != 0) {
			while(!cpf.equals(repositorio[i].getCliente().getCpf())) {
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
	public void inserir(AtividadeDiaria atividade) {
		if(!existe(atividade.getCliente().getCpf())) {
			repositorio[indice] = atividade;
			indice++;
			}
		}

	@Override
	public AtividadeDiaria procurar(String cpf) {
		if(existe(cpf)) {
			return this.repositorio[i];
		}else {
			return null;
		}
	}

	@Override
	public List<AtividadeDiaria> listar(String cpf) {
		List<AtividadeDiaria> atividade = new ArrayList<AtividadeDiaria>();
		int i = 0;
		
		while(i < indice) {
			if((repositorio[i].getCliente().getCpf().contains(cpf))) {
				atividade.add(repositorio[i]);
			}
			i++;
		}
		return atividade;
	}
}
