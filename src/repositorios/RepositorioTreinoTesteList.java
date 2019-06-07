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
import basicas.Treino;
import excecoes.MatriculaNaoEncontradaException;
import interfaces.IRepositorioTreino;


public class RepositorioTreinoTesteList implements IRepositorioTreino, Serializable{

	private File arquivoTreino;
	
	public RepositorioTreinoTesteList() {
		arquivoTreino = new File("Treino.bin");
		if(arquivoTreino.exists() == false) {
			try {
				arquivoTreino.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public List<Treino> lerArquivo(){
		List<Treino> treinos = null;
		
		if(arquivoTreino.length() > 0) {
			ObjectInputStream in;
			try {
				in = new ObjectInputStream(new FileInputStream(arquivoTreino));
				treinos = (List<Treino>) in.readObject();
				in.close();
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			treinos = new ArrayList<>();
		}
		
		return treinos;
	}
	
	
	@Override
	public void inserir(Treino treino) throws MatriculaNaoEncontradaException {
		List<Treino> treinos = lerArquivo();
		
		treinos.add(treino);
		ObjectOutputStream out;
		try {
			out = new ObjectOutputStream(new FileOutputStream(arquivoTreino));
			out.writeObject(treinos);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void remover(String id) {
		
		
	}

	@Override
	public void atualizar(Treino treino) {
		
		
	}

	@Override
	public List listar(String matricula, String categoria) {
		List<Treino> treinos = lerArquivo();
		
		return null;
	}

	@Override
	public Treino procurarClienteTreino(String matricula, String categoria) {
		List<Treino> treinos = lerArquivo();
		
		for(Treino t : treinos) {
			if(t.getCliente().getMatricula().equals(matricula) && t.getCategoria().equals(categoria)) {
				return t;
			}
		}
		return null;
	}

}
