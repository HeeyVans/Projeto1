package sistema;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import basicas.Administrador;
import basicas.Cliente;
import basicas.Endereco;
import basicas.Instrutor;
import excecoes.MatriculaNaoEncontradaException;
import repositorios.RepositorioClienteArray;
import repositorios.RepositorioInstrutorArray;

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

		Cliente c = Fachada.getInstance().procurarClienteMatricula("sdsd");
		
		boolean b;
		
		if(c == null) {
			b = false;
		}else {
			b = true;
		}
		
		assertTrue(b);
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
		Cliente c = new Cliente("NomeTeste", end, "49184143674", "sdsasad", "diogosz111@gmail.com", "51513", "Masculino", 
				"Sim", "Hipertrofia");
		Fachada.getInstance().atualizar(c);
		
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
	void testListarCliente() {
		
	}

	@Test
	void testCadastrarADM() {
		
	}

	@Test
	void testProcurarADM() {
		
	}

	@Test
	void testCadastrarInstrutor() {
		Instrutor in = new Instrutor("InstrutorNomeTeste", "12345678", "abab","Instrutor");
		Fachada.getInstance().cadastrarInstrutor(in);
		
		RepositorioInstrutorArray repInstrutores = RepositorioInstrutorArray.getInstance();
		Instrutor [] instrutores = repInstrutores.getRepositorio();
		
		ArrayList<Instrutor> listaInstrutores = new ArrayList<Instrutor>();
		int i = 0;
		while(i < instrutores.length) {
			if(instrutores[i] != null) {
			listaInstrutores.add(instrutores[i]);
			}
			i++;
		}
		
		boolean b = false;		
		for(int j = 0; j <= listaInstrutores.size() - 1; j++) {
			
		if(listaInstrutores.get(j).getCpf().equals(in.getCpf())) {
			b = true;
			}else {
			b = false;
			}
		}
		assertTrue(b);
	}

	@Test
	void testProcurarInstrutorMatricula() throws MatriculaNaoEncontradaException {
		Instrutor in = Fachada.getInstance().procurarInstrutorMatricula("abab");
		
		boolean b;
		
		if(in == null) {
			b = false;
		}else {
			b = true;
		}
		assertTrue(b);
	}

	@Test
	void testRemoverInstrutor() throws MatriculaNaoEncontradaException {
		String cpf = "12345678";
		Fachada.getInstance().removerInstrutor(cpf);
		
		RepositorioInstrutorArray repInstrutores = RepositorioInstrutorArray.getInstance();
		Instrutor [] instrutores = repInstrutores.getRepositorio();
		
		ArrayList<Instrutor> listaInstrutores = new ArrayList<Instrutor>();
		int i = 0;
		while(i < instrutores.length) {
			if(instrutores[i] != null) {
			listaInstrutores.add(instrutores[i]);
			}
			i++;
		}
		
		boolean b = false;		
		for(int j = 0; j <= listaInstrutores.size() - 1; j++) {
			
		if(listaInstrutores.get(j).getCpf().equals(cpf)) {
			b = true;
			}else {
			b = false;
			}
		}
		assertTrue(b);
	}

	@Test
	void testAtualizarInstrutor() {
		Instrutor in = new Instrutor("InstrutorNomeTeste", "12345678", "SSabab","Instrutor");
		Fachada.getInstance().atualizar(in);
		
		RepositorioInstrutorArray repInstrutores = RepositorioInstrutorArray.getInstance();
		Instrutor [] instrutores = repInstrutores.getRepositorio();
		
		ArrayList<Instrutor> listaInstrutores = new ArrayList<Instrutor>();
		int i = 0;
		while(i < instrutores.length) {
			if(instrutores[i] != null) {
			listaInstrutores.add(instrutores[i]);
			}
			i++;
		}
		
		boolean b = false;		
		for(int j = 0; j <= listaInstrutores.size() - 1; j++) {
			
		if(listaInstrutores.get(j).getCpf().equals(in.getCpf())) {
			b = true;
			}else {
			b = false;
			}
		}
		assertTrue(b);
	}

	@Test
	void testListarInstrutor() {
		
	}

	@Test
	void testInserirTreino() {
		
	}

	@Test
	void testProcurarClienteTreino() {
		
	}

	@Test
	void testAtualizarTreino() {
		
	}

	@Test
	void testListarTreino() {
		
	}

	@Test
	void testInserirAtividade() {
	
	}

	@Test
	void testProcurarAtividade() {
		
	}

	@Test
	void testListarAtividade() {
		
	}

}
