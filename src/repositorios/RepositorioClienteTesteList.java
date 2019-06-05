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
import basicas.Exercicio;
import interfaces.IRepositorioCliente;
import sistema.Fachada;

public class RepositorioClienteTesteList implements IRepositorioCliente, Serializable{
	
	private File arquivoCliente;
	private List<Cliente> cliente;
	
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
			e.printStackTrace();
		}
		
	}

	@Override
	public Cliente procurar(String cpf) {
		List<Cliente> clientes = lerArquivo();
		
		for(Cliente c : clientes) {
			if(c.getCpf().equals(cpf)) {
				return c;
			}
		}
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
		List<Cliente> clientes = lerArquivo();
		
		for(int i = 0; i <= clientes.size(); i++) {
			if(clientes.get(i).getCpf().equals(cpf)) {
				clientes.remove(i);
			}
		}
		
		ObjectOutputStream out;
		try {
			out = new ObjectOutputStream(new FileOutputStream(arquivoCliente));
			out.writeObject(clientes);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void atualizar(Cliente cliente) {
		List<Cliente> clientes = lerArquivo();
		
		for(int i = 0; i < clientes.size(); i++) {
			if(clientes.get(i).getCpf().equals(cliente.getCpf())){
				clientes.set(i, cliente);
				ObjectOutputStream out;
				try {
					out = new ObjectOutputStream(new FileOutputStream(arquivoCliente));
					out.writeObject(clientes);
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public List<Cliente> listar(String nome) {
		List<Cliente> clientes = lerArquivo();
		cliente = null;
		
		for(int i = 0; i <= clientes.size(); i++) {
			if(clientes.get(i).getNome().contains(nome)) {
				cliente.add(clientes.get(i));
			}
		}
		return cliente;
		
	}

	@Override
	public List<Cliente> listar() {
		List<Cliente> clientes = lerArquivo();
		
		return clientes;
		
	}	

}
