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
	private int indice = 0;
	private Cliente[] repositorio;
	public static RepositorioClienteArray instance;
	private File arquivoCliente;
	
	public RepositorioClienteTeste() throws IOException{
		arquivoCliente = new File("Clientes.dat");
		if(arquivoCliente.exists() == false) {
			arquivoCliente.createNewFile();
		}
	}
	
	
	public static void lerArquivo(Cliente rep) {
		
		FileInputStream inFile;
		try {
			inFile = new FileInputStream("Clientes.dat");
			ObjectInputStream objInput;
			objInput = new ObjectInputStream(inFile);
			rep = (Cliente) objInput.readObject();
		} catch (IOException | ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		
	}
	
	public static void salvarArquivo(Cliente rep) {
		
		FileOutputStream outFile;
		try {
			outFile = new FileOutputStream("Clientas.dat");
			ObjectOutputStream objOutput = new ObjectOutputStream(outFile);
			objOutput.writeObject(rep);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void inserir(Cliente cliente) {	
		salvarArquivo(repositorio[indice]);
		indice++;
		}
		

	@Override
	public Cliente procurar(String cpf)  {		
		return null;
	}

	@Override
	public Cliente procurarMatricula(String matricula){
		
		for(int i = 0; i <= repositorio.length; i++) {
		lerArquivo(repositorio[i]);
		if(repositorio[i].getMatricula() == matricula) {
				return repositorio[i];
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
