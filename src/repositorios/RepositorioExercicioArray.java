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

import basicas.Exercicio;
import interfaces.IRepositorioExercicio;

public class RepositorioExercicioArray implements IRepositorioExercicio, Serializable{
	
	public static final int TAM = 1000000;
	private int indice = 0;
	private Exercicio[] repositorio;
	int i;
	public static RepositorioExercicioArray instance;
	
	public RepositorioExercicioArray(){
		this.repositorio = new Exercicio[TAM];
		indice = 0;
	}
	
	public static RepositorioExercicioArray getInstance() {
	    if (instance == null) {
	      instance = lerDoArquivo();
	    }
	    return instance;
	  }
	
	public static RepositorioExercicioArray lerDoArquivo() {
		RepositorioExercicioArray instanciaLocal = null;

	    File in = new File("treino.dat");
	    FileInputStream fis = null;
	    ObjectInputStream ois = null;
	    try {
	      fis = new FileInputStream(in);
	      ois = new ObjectInputStream(fis);
	      Object o = ois.readObject();
	      instanciaLocal = (RepositorioExercicioArray) o;
	    } catch (Exception e) {
	      instanciaLocal = new RepositorioExercicioArray();
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
