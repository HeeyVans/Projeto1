package basicas;

import java.io.Serializable;

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

	@Override
	public void inserir(Cliente cliente) {
		//Criar uma exceção para caso o cliente já esteja cadastrado
		this.cliente[indice] = cliente;
		this.indice = this.indice +1;
		
	}

	@Override
	public Cliente procurar(int matricula) {
		/*for (int i = 0; i < indice; i++) {
			if (cliente[i].getMatricula().equals(matricula)) {
				return cliente[i];
			}
			
		} */
		return null;
	} 

	@Override
	public void remover(int matricula) {
		
	}

	@Override
	public void atualizar(Cliente cliente) {
		Cliente clienteAtualizado = procurar(cliente.getMatricula());
		clienteAtualizado = cliente;
		
	}

}
