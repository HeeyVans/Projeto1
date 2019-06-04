package repositorios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import basicas.Cliente;
import interfaces.IRepositorioCliente;

public class RepositorioClienteTesteList implements IRepositorioCliente, Serializable{
	
	private File arquivoCliente;
	
	public RepositorioClienteTesteList() {
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

	public List<Cliente> lerArquivo(){
		List<Cliente> clientes = null;
		
		if(arquivoCliente.length() > 0) {
			ObjectInputStream in;
			try {
				in = new ObjectInputStream(new FileInputStream(arquivoCliente));
				clientes = (List<Cliente>) in.readObject();
				in.close();
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			clientes = new ArrayList<>();
		}
		
		return clientes;
	}
	
	@Override
	public void inserir(Cliente cliente) {
		List<Cliente> clientes = lerArquivo();
		
		clientes.add(cliente);
		ObjectOutputStream out;
		try {
			out = new ObjectOutputStream(new FileOutputStream(arquivoCliente));
			out.writeObject(clientes);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Cliente procurar(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente procurarMatricula(String matricula) {
		List<Cliente> clientes = lerArquivo();
		
		for(Cliente c : clientes) {
			if(c.getMatricula().equals(matricula)) {
				return c;
			}
		}
		return null;
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
