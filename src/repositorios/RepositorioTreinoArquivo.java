package repositorios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import basicas.Cliente;
import basicas.Instrutor;
import basicas.Treino;
import interfaces.IRepositorioTreino;

public class RepositorioTreinoArquivo implements IRepositorioTreino, Serializable {

	private static final long serialVersionUID = 1L;
	
	private Treino[] treino;
	private int indice;

	private final static int TAMANHO = 100;
	public static RepositorioTreinoArquivo instance;
	
	public RepositorioTreinoArquivo() {
		this.treino = new Treino[TAMANHO];
		this.indice = 0;
	}
	
	public static RepositorioTreinoArquivo getInstance() {
	    if (instance == null) {
	      instance = lerDoArquivo();
	    }
	    return instance;
	  }
	
	public static RepositorioTreinoArquivo lerDoArquivo() {
		RepositorioTreinoArquivo instanciaLocal = null;

	    File in = new File("treino.dat");
	    FileInputStream fis = null;
	    ObjectInputStream ois = null;
	    try {
	      fis = new FileInputStream(in);
	      ois = new ObjectInputStream(fis);
	      Object o = ois.readObject();
	      instanciaLocal = (RepositorioTreinoArquivo) o;
	    } catch (Exception e) {
	      instanciaLocal = new RepositorioTreinoArquivo();
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

	public void salvarArquivo() {
	    if (instance == null) {
	      return;
	    }
	    File out = new File("treino.dat");
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
	
	
	@Override
	public void inserir(Treino treino, Cliente cliente, Instrutor instrutor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Treino procurar(Treino treino, Cliente cliente, Instrutor instrutor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(Treino treino, Cliente cliente, Instrutor instrutor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Treino treino, Cliente cliente, Instrutor instrutor) {
		// TODO Auto-generated method stub
		
	}

}
