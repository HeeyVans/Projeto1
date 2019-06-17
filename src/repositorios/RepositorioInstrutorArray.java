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

import basicas.Instrutor;
import interfaces.IRepositorioInstrutor;

public class RepositorioInstrutorArray implements IRepositorioInstrutor, Serializable{

	public static final int TAM = 100;
	private int indice;
	private int i;
	private Instrutor[] repositorio;
	public static RepositorioInstrutorArray instance;

	public Instrutor[] getRepositorio() {
		return repositorio;
	}
	
	public RepositorioInstrutorArray(){
		this.repositorio = new Instrutor[TAM];
		indice = 0;
	}
	public static RepositorioInstrutorArray getInstance() {
	    if (instance == null) {
	      instance = lerDoArquivo();
	    }
	    return instance;
	  }
	
	public static RepositorioInstrutorArray lerDoArquivo() {
		RepositorioInstrutorArray instanciaLocal = null;

	    File in = new File("instrutor.dat");
	    FileInputStream fis = null;
	    ObjectInputStream ois = null;
	    try {
	      fis = new FileInputStream(in);
	      ois = new ObjectInputStream(fis);
	      Object o = ois.readObject();
	      instanciaLocal = (RepositorioInstrutorArray) o;
	    } catch (Exception e) {
	      instanciaLocal = new RepositorioInstrutorArray();
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
	    if (instance == null) {
	      return;
	    }
	    File out = new File("instrutor.dat");
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
			if(repositorio[i].getNome().contains(nome)) {
				instrutor.add(repositorio[i]);
			}			 
			 i++;
			}
		return instrutor;
		}

	@Override
	public List listar() {
		List instrutor = new ArrayList();
		i = 0;
		while(i < indice) {
			instrutor.add(repositorio[i]);		 
			 i++;
			}
		return instrutor;
	}

}
