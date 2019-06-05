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

import basicas.Cliente;
import basicas.Exercicio;
import interfaces.IRepositorioExercicio;

public class RepositorioExercicioTesteList implements IRepositorioExercicio, Serializable{
	
	private File exercicioArquivo;
	
	public RepositorioExercicioTesteList() {
		exercicioArquivo = new File("Exercicio.bin");
		if(exercicioArquivo.exists() == false) {
			try {
				exercicioArquivo.createNewFile();
			} catch (IOException e) {	
				e.printStackTrace();
			}
		}
	}
	
	public List<Exercicio> lerArquivo(){
		List<Exercicio> exers = null;
		
		if(exercicioArquivo.length() > 0) {
			ObjectInputStream in;
			try {
				in = new ObjectInputStream(new FileInputStream(exercicioArquivo));
				exers = (List<Exercicio>) in.readObject();
				in.close();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}else {
			exers = new ArrayList<>();
		}
		
		return exers;
	}
	
	@Override
	public void inserir(Exercicio exers) {
		List<Exercicio> erxerss = lerArquivo();
		
		erxerss.add(exers);
		ObjectOutputStream out;
		try {
			out = new ObjectOutputStream(new FileOutputStream(exercicioArquivo));
			out.writeObject(erxerss);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List listar() {
		List<Exercicio> erxerss = lerArquivo();
		
		return erxerss;
	}
	
}


