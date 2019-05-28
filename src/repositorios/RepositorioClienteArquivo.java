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
import excecoes.ClienteJaCadastradoException;
import excecoes.NaoEncontradoException;
import excecoes.ParametroNuloException;
import interfaces.IRepositorioCliente;

public class RepositorioClienteArquivo implements IRepositorioCliente, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Cliente[] cliente;
	private int indice;
	private int i;
	
	private final static int TAMANHO = 100;
	public static RepositorioClienteArquivo instance;
	
	public RepositorioClienteArquivo() {
		this.cliente = new Cliente[TAMANHO];
		this.indice = 0;
	}
	
	public static RepositorioClienteArquivo getInstance() {
	    if (instance == null) {
	      instance = lerDoArquivo();
	    }
	    return instance;
	  }
	
	public static RepositorioClienteArquivo lerDoArquivo() {
		RepositorioClienteArquivo instanciaLocal = null;
	    //Criando um arquivo e passando o nome dele	
	    File in = new File("clientes.dat");//criando um arquivo .dat na pasta do projeto
	   
	    /*boolean exists() – arquivo ou diretório existe;
	      boolean isDirectory() – é um diretório;
	      boolean isFile() – é um arquivo;
	      boolean canRead() – pode ler;
	      boolean canWrite() – pode escrever;
	      boolean mkdir() – cria uma diretório;
	      boolean mkdirs() – cria vários diretórios;
	      boolean renameTo(File file) - renomear;
	      long length() - tamanho;
	      long lastModified(ultima modificação);
	      boolean delete() - deletar;*/	
	   
	    FileInputStream fis = null;
	    ObjectInputStream ois = null;
	    try {
	      fis = new FileInputStream(in);
	      ois = new ObjectInputStream(fis);
	      Object o = ois.readObject();
	      instanciaLocal = (RepositorioClienteArquivo) o;
	    } catch (Exception e) {
	      instanciaLocal = new RepositorioClienteArquivo();
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
	    if (!(instance == null)) {
	     
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
	} 
	
	public int getIndice(String cpf) {
		int i = 0;
		
		if(indice != 0) {
			while(!cpf.equals(cliente[i].getCpf())) {
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
	
	@Override
	public void inserir(Cliente clientes)  {
		if(!existe(clientes.getCpf())) {
			cliente[indice] = clientes;
			indice++;
		}
		
	}

	@Override
	public Cliente procurar(String cpf) {
		if(existe(cpf)) {
			return this.cliente[i];
		}else {
			return null;
		}
		
	} 

	@Override
	public void remover(String cpf) {
		if(!existe(cpf)) {
			
		}else {
			cliente[i] = null;
			cliente[i] = cliente[indice - 1];
			cliente[indice - 1] = null;
			indice--;
		}
		
	}

	@Override
	public void atualizar(Cliente clienteAtualizado) {
         for (int i = 0; i < indice; i++) {
        	 if(clienteAtualizado.getMatricula().equals(cliente[i].getMatricula())) {
        		 cliente[i] = clienteAtualizado;
        	 }
			
		}		
	}
	
	public List listar() {
		List clientes = new ArrayList();
		i = 0;
		while(i < indice) {
			 clientes.add(cliente[i]);
			 i++;
			}
		return clientes;
		}

	@Override
	public Cliente procurarMatricula(String matricula) {
		for (int i = 0; i < indice; i++) {
			if (cliente[i].getMatricula().equals(matricula)) {
				return cliente[i];
			}
		} 
		return null;
	}

	@Override
	public List listar(String nome) {
		// TODO Auto-generated method stub
		return null;
	}
}


