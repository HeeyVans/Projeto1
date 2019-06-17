package sistema;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import basicas.Cliente;
import basicas.Endereco;
import excecoes.MatriculaNaoEncontradaException;
import repositorios.RepositorioClienteArray;

class JUnitTeste {

	@Test
	void testCadastrarCliente() {
		Endereco end = new Endereco("Rua", "Bairro", "Cidade", "Complemento", "Numero");
		Cliente c = new Cliente("NomeTeste", end, "49184143674", "sdsd", "diogosz111@gmail.com", "51513", "Masculino", 
				"Sim", "Hipertrofia");
		Fachada.getInstance().cadastrarCliente(c);
		
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
		
		boolean b = false;		
		for(int j = 0; j <= listaClientes.size() - 1; j++) {
			
		if(listaClientes.get(j).getCpf().equals(c.getCpf())) {
			b = true;
			}else {
			b = false;
			}
		}	
		assertTrue(b);
	}
		
		
	

	@Test
	void testProcurarClienteMatricula() throws MatriculaNaoEncontradaException {

		Cliente cliente = Fachada.getInstance().procurarClienteMatricula("sdsd");
		
		assertNotNull(cliente);
	}

	@Test
	void testRemoverCliente() {
		
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
		
		boolean b = false;		
		for(int j = 0; j <= listaClientes.size() - 1; j++) {
			
		if(listaClientes.get(j).getCpf().equals(cpf)) {
			b = false;
			}else {
			b = true;
			}
		}
		assertTrue(b);
	}

	@Test
	void testAtualizarCliente() {
		Endereco end = new Endereco("Rua", "Bairro", "Cidade", "Complemento", "Numero");
		Cliente c = new Cliente("NomeTeste", end, "49184143674", "sdsd", "diogosz111@gmail.com", "51513", "Masculino", 
				"Sim", "Hipertrofia");
		
		Fachada.getInstance().cadastrarCliente(c);		

		Cliente clienteNovo = new Cliente("NomeTeste22", end, "49184143674", "sdsd", "diogosz111@gmail.com", "51513", "Masculino", 
				"Sim", "Hipertrofia");
		Fachada.getInstance().atualizar(clienteNovo);
		
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
		
		boolean b = false;		
		for(int j = 0; j < listaClientes.size(); j++) {
			
		if(listaClientes.get(j).getCpf().equals(clienteNovo.getCpf())) {
				b = true;
			}else {
				b = false;
			}
		}	
		assertTrue(b);
	}

	@Test
	void testListarCliente() {
		
		RepositorioClienteArray rep = RepositorioClienteArray.getInstance();
		Cliente[] clientes = rep.getRepositorio();
		
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		int i = 0;
		while(i < clientes.length) {
			if(clientes[i] != null) {
			listaClientes.add(clientes[i]);
			}
			i++;
		}
		
		boolean b = false;
		if(listaClientes.isEmpty()) {
			b = false;
		}else {
			b = true;
		}
		
		assertTrue(b);
	}

}
