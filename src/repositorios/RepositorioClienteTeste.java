package repositorios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

import basicas.Cliente;
import interfaces.IRepositorioCliente;

public class RepositorioClienteTeste implements IRepositorioCliente, Serializable{
	
	public static final int TAM = 1000000;
	private int indice;
	private int i;
	private Cliente[] repositorio;
	public static RepositorioClienteArray instance;
	private File arquivoCliente;
	
	public RepositorioClienteTeste() throws IOException{
		arquivoCliente = new File("Clientes.bin");
		if(arquivoCliente.exists() == false) {
			arquivoCliente.createNewFile();
		}
	}
	
	public int getIndice(String cpf) {
		int i = 0;
		
		if(indice != 0) {
			while(!cpf.equals(repositorio[i].getCpf())) {
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
		try {
			repositorio = lerArquivoCliente();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = 0;
		
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
		i = getIndiceMatricula(matricula);
		if(i == -1) {
			return false;
		}else {
			return true;
		}
	}
	
	public Cliente[] lerArquivoCliente() throws FileNotFoundException, IOException, ClassNotFoundException {
		Cliente[] clientes;
		
		if(arquivoCliente.length() > 0) {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivoCliente));
			clientes = (Cliente[]) in.readObject();
			in.close();
		}else {
			clientes = new Cliente[TAM];
			indice = 0;
		}
		
		return clientes;
	}

	@Override
	public void inserir(Cliente cliente) {	
		if(!existe(cliente.getCpf())) {
			try {
				repositorio[indice] = cliente;
				indice++;
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivoCliente));
				out.writeObject(repositorio);	
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Cliente procurar(String cpf)  {		
		return null;
	}

	@Override
	public Cliente procurarMatricula(String matricula){
		try {
			repositorio = lerArquivoCliente();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
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
