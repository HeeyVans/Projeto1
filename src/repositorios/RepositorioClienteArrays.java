package repositorios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import basicas.Cliente;
import excecoes.ClienteJaCadastradoException;
import interfaces.IRepositorioCliente;

public class RepositorioClienteArrays implements IRepositorioCliente, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Cliente[] cliente;
	private int indice;
	
	private final static int TAMANHO = 100;
	public static RepositorioClienteArrays instance;
	
	public RepositorioClienteArrays() {
		this.cliente = new Cliente[TAMANHO];
		this.indice = 0;
	}
	
	public static RepositorioClienteArrays getInstance() {
	    if (instance == null) {
	      instance = lerDoArquivo();
	    }
	    return instance;
	  }
	
	public static RepositorioClienteArrays lerDoArquivo() {
		RepositorioClienteArrays instanciaLocal = null;

	    File in = new File("clientes.dat");
	    FileInputStream fis = null;
	    ObjectInputStream ois = null;
	    try {
	      fis = new FileInputStream(in);
	      ois = new ObjectInputStream(fis);
	      Object o = ois.readObject();
	      instanciaLocal = (RepositorioClienteArrays) o;
	    } catch (Exception e) {
	      instanciaLocal = new RepositorioClienteArrays();
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
	    File out = new File("clientes.dat");
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
	public void inserir(Cliente cliente) throws ClienteJaCadastradoException {
		//Criar uma exceção para caso o cliente já esteja cadastrado
		/*if () {
			//throw new ClienteJaCadastrado("Cliente: "+cliente.getNome()+" já está cadastrado!");
		} else { */
		if(cliente != null) {
		this.cliente[indice] = cliente;
		this.indice = this.indice +1;
		}
	}

	@Override
	public Cliente procurar(String matricula) {
		for (int i = 0; i < indice; i++) {
			if (cliente[i].getMatricula().equals(matricula)) {
				return cliente[i];
			}
		} 
		return null;
	} 

	@Override
	public void remover(String matricula) {
		for (int i = 0; i < indice; i++) {
			if (cliente[i].getMatricula().equals(matricula)) {
				cliente[i] = cliente[this.indice];
				this.indice--;
			}

		}
	}

	@Override
	public void atualizar(Cliente cliente) {
		Cliente clienteAtualizado = procurar(cliente.getMatricula());
		clienteAtualizado = cliente;
		
	}
	
	public Cliente[] listar() {
		return cliente;
	}

}
