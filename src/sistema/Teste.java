package sistema;

import java.util.ArrayList;

import basicas.Cliente;
import basicas.Endereco;
import repositorios.RepositorioClienteArray;

public class Teste {

	public static void main(String[] args) {
		String cpf = "49184143674";
		Fachada.getInstance().removerCliente(cpf);
		
		RepositorioClienteArray repClientes = RepositorioClienteArray.getInstance();
		Cliente [] clientes = repClientes.getRepositorio();
		
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		int i = 0;
		while(i < clientes.length) {
			if(clientes[i] != null) {
			listaClientes.add(clientes[i]);
			}
			i++;
		}
	}

}
