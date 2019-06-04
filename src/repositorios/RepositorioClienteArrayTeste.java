package repositorios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

import basicas.Cliente;
import interfaces.IRepositorioCliente;

public class RepositorioClienteArrayTeste implements IRepositorioCliente, Serializable{
	
	public static final int TAM = 1000000;
	private int indice;
	private int i;
	private Cliente[] repositorio;
	private File arquivoCliente;
	
	public RepositorioClienteArrayTeste() {
		this.repositorio = new Cliente[TAM];
		indice = 0;
		arquivoCliente = new File("Clientes.bin");
		if(arquivoCliente.exists() == false) {
			try {
				arquivoCliente.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public Cliente[] lerArquivo() {
		
		if(arquivoCliente.length() > 0) {
			ObjectInputStream in;
			try {
				in = new ObjectInputStream(new FileInputStream(arquivoCliente));
				repositorio = (Cliente[]) in.readObject();
				in.close();
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			}
		
		return repositorio;
	}
	
	public int getIndiceMatricula(String matricula) {
		int i = 0;
		repositorio = lerArquivo();
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
	
	public boolean existeMatricula(String matricula) {
		repositorio = lerArquivo();
		i = getIndiceMatricula(matricula);
		if(i == -1) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public void inserir(Cliente cliente) {	
		if(!existeMatricula(cliente.getMatricula())) {
			repositorio[indice] = cliente;
			indice++;
			
			ObjectOutputStream out;
			try {
				out = new ObjectOutputStream(new FileOutputStream(arquivoCliente));
				out.writeObject(repositorio);
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}

	@Override
	public Cliente procurar(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente procurarMatricula(String matricula) {
		repositorio = lerArquivo();
		if(existeMatricula(matricula)) {
			return this.repositorio[i];
		}else {
			return null;
		}
	}

	@Override
	public void remover(String cpf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List listar(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
