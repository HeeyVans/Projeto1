package repositorios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import basicas.Instrutor;
import interfaces.IRepositorioInstrutor;

public class RepositorioInstrutorArquivo implements IRepositorioInstrutor, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Instrutor [] instrutor;
	private int indice;

	private final static int TAMANHO = 100;
	public static RepositorioInstrutorArquivo instance;
	
	public RepositorioInstrutorArquivo() {
		this.instrutor = new Instrutor[TAMANHO];
		this.indice = 0;
	}
	
	public static RepositorioInstrutorArquivo getInstance() {
	    if (instance == null) {
	      instance = lerDoArquivo();
	    }
	    return instance;
	  }
	
	public static RepositorioInstrutorArquivo lerDoArquivo() {
		RepositorioInstrutorArquivo instanciaLocal = null;

	    File in = new File("instrutor.dat");
	    FileInputStream fis = null;
	    ObjectInputStream ois = null;
	    try {
	      fis = new FileInputStream(in);
	      ois = new ObjectInputStream(fis);
	      Object o = ois.readObject();
	      instanciaLocal = (RepositorioInstrutorArquivo) o;
	    } catch (Exception e) {
	      instanciaLocal = new RepositorioInstrutorArquivo();
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
	
	@Override
	public void inserir(Instrutor instrutor) {
		this.instrutor[indice] = instrutor;
		this.indice = this.indice +1;
		
	}

	@Override
	public Instrutor procurar(String matricula) {
		for (int i = 0; i < indice; i++) {
			if (instrutor[i].getMatricula().equals(matricula)) {
				return instrutor[i];
			}
		} 
		return null;
	} 

	@Override
	public void remover(String matricula) {
		for (int i = 0; i < indice; i++) {
			if (instrutor[i].getMatricula().equals(matricula)) {
				instrutor[i] = instrutor[this.indice];
				this.indice--;
			}

		}
		
	}

	@Override
	public void atualizar(Instrutor instrutor) {
		Instrutor instrutorAtualizado = procurar(instrutor.getMatricula());
		instrutorAtualizado = instrutor;		
	}

	@Override
	public Instrutor procurarMatricula(String matricula) {
      //Método duplicado, já existe um procurando por matrícula.
		return null;
	}

}
