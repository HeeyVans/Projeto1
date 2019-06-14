package sistema;

import java.util.ArrayList;

import basicas.Cliente;
import repositorios.RepositorioClienteArray;

public class Teste {

	public static void main(String[] args) {
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
				
		String cpf = "49184143674";
		for(int j = 0; j <= listaClientes.size() - 1; j++) {
			
		if(listaClientes.get(j).getCpf().equals(cpf)) {
			
			}
		}
	}

}
