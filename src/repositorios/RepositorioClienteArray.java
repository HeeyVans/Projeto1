package repositorios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import basicas.Cliente;
import excecoes.ClienteJaCadastradoException;
import excecoes.ClienteNaoEncontradoException;
import interfaces.IRepositorioCliente;

public class RepositorioClienteArray implements IRepositorioCliente, Serializable{
	
	public static final int TAM = 100;
	private int indice;
	private int i;
	private Cliente[] repositorio;
	public static RepositorioClienteArray instance;
	
	public RepositorioClienteArray(){
		this.repositorio = new Cliente[TAM];
		indice = 0;
	}
	
	public static RepositorioClienteArray getInstance() {
	    if (instance == null) {
	      instance = lerDoArquivo();
	    }
	    return instance;
	  }
	
	public static RepositorioClienteArray lerDoArquivo() {
		 RepositorioClienteArray instanciaLocal = null;
	    //Criando um arquivo e passando o nome dele	
	    File in = new File("clientes.dat");//criando um arquivo .dat na pasta do projeto
	   
	    FileInputStream fis = null;
	    ObjectInputStream ois = null;
	    try {
	      fis = new FileInputStream(in);
	      ois = new ObjectInputStream(fis);
	      Object o = ois.readObject();
	      instanciaLocal = (RepositorioClienteArray) o;
	    } catch (Exception e) {
	      instanciaLocal = new RepositorioClienteArray();
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

	public static void salvarArquivo() {
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
			while(!(cpf.equals(repositorio[i].getCpf()))) {
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
		int i = 0;
		
		if(indice != 0) {
			while(!(matricula.equals(repositorio[i].getMatricula()))) {
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

	@Override
	public void inserir(Cliente cliente)  {
		if(!existe(cliente.getCpf())) {
			repositorio[indice] = cliente;
			indice++;
		}
	}

	@Override
	public Cliente procurar(String cpf)  {
		if(existe(cpf)) {
			return this.repositorio[i];
		}else {
			return null;
		}
		
	}
	
	@Override
	public Cliente procurarMatricula(String matricula) {
		if(existeMatricula(matricula)) {
			return this.repositorio[i];
		}else {
			return null;
		}
	}

	@Override
	public void remover(String cpf)  {
		if(!existe(cpf)) {
			
		}else {
			repositorio[i] = null;
			repositorio[i] = repositorio[indice - 1];
			repositorio[indice - 1] = null;
			indice--;
		}
		
	}

	@Override
	public void atualizar(Cliente cliente){
		if(existe(cliente.getCpf())) {
			repositorio[i] = cliente;
		}
		
		
	}

	@Override
	public List listar(String nome) {
		
		List clientes = new ArrayList();
		i = 0;
		while(i < indice) {
			if(repositorio[i].getNome().equalsIgnoreCase(nome)) {
				clientes.add(repositorio[i]);
			}			 
			 i++;
			}
		return clientes;
		}

	@Override
	public List listar() {
		
		List clientes = new ArrayList();
		i = 0;
		while(i < indice) {	
			clientes.add(repositorio[i]);
			 i++;
			}
		return clientes;
		}

	@Override
	public List listarEmDia(String pagamentoEmDia) {
		List clientes = new ArrayList();
		i = 0;
		
		while(i < indice) {
			if(repositorio[i].getPagamento().equals(pagamentoEmDia)) {
				clientes.add(repositorio[i]);
			}
			i++;
		}
		return clientes;
	}

	@Override
	public List<Cliente> listarAtrasado(String pagamentoAtrasado) {
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		i = 0;
		
		while(i < indice) {
			if((repositorio[i].getPagamento().equals(pagamentoAtrasado))) {
				clientes.add(repositorio[i]);
			}
			i++;
		}
		return clientes;
	}


	}
	


