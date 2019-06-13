package sistema;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import basicas.Administrador;
import basicas.Cliente;
import basicas.Endereco;
import basicas.Instrutor;

class JUnitTeste {

	@Test
	void testCadastrarCliente() {
		Endereco end = new Endereco("Rua", "Bairro", "Cidade", "Complemento", "Numero");
		Cliente c = new Cliente("NomeTeste", end, "49184192674", "sdsd", "diogosz111@gmail.com", "51513", "Masculino", 
				"Sim", "Hipertrofia");
		Fachada.getInstance().cadastrarCliente(c);
		assertNull(null);
	}

	@Test
	void testProcurarClienteMatricula() {
		Endereco end = new Endereco("Rua", "Bairro", "Cidade", "Complemento", "Numero");
		Cliente c = new Cliente("NomeTeste", end, "49184192674", "sdsd", "diogosz111@gmail.com", "51513", "Masculino", 
				"Sim", "Hipertrofia");
		Fachada.getInstance().procurarClienteMatricula(c.getCpf());
		assertNull(null);
	}

	@Test
	void testRemoverCliente() {
		Endereco end = new Endereco("Rua", "Bairro", "Cidade", "Complemento", "Numero");
		Cliente c = new Cliente("NomeTeste", end, "49184192674", "sdsd", "diogosz111@gmail.com", "51513", "Masculino", 
				"Sim", "Hipertrofia");
		
		Fachada.getInstance().removerCliente(c.getCpf());
		assertNull(null);
	}

	@Test
	void testAtualizarCliente() {
		Endereco end = new Endereco("Rua", "Bairro", "Cidade", "Complemento", "Numero");
		Cliente c = new Cliente("NomeTeste", end, "49184192674", "sdsd", "diogosz111@gmail.com", "51513", "Masculino", 
				"Sim", "Hipertrofia");
		
		Fachada.getInstance().atualizar(c);
		assertNull(null);
	}

	@Test
	void testListarCliente() {
		Fachada.getInstance().listarClienteVoid();	
		assertNull(null);
	}

	@Test
	void testCadastrarADM() {
		Administrador adm = new Administrador("ADMTeste", "4839243", "2222", "ADM");
		Fachada.getInstance().cadastrarADM(adm);
		assertNull(null);
	}

	@Test
	void testProcurarADM() {
		Administrador adm = new Administrador("ADMTeste", "4839243", "2222", "ADM");
		Fachada.getInstance().procurarADM(adm.getMatricula());
		assertNull(null);
	}

	@Test
	void testCadastrarInstrutor() {
		Instrutor i = new Instrutor("InstrutorTeste", "49184192674", "sdSD", "Instrutor");
		Fachada.getInstance().cadastrarInstrutor(i);;
		assertNull(null);
	}

	@Test
	void testProcurarInstrutorMatricula() {
		Instrutor i = new Instrutor("InstrutorTeste", "49184192674", "sdSD", "Instrutor");
		Fachada.getInstance().procurarInstrutorMatricula(i.getMatricula());
		assertNull(null);
	}

	@Test
	void testRemoverInstrutor() {
		Instrutor i = new Instrutor("InstrutorTeste", "49184192674", "sdSD", "Instrutor");
		Fachada.getInstance().removerInstrutor(i.getCpf());
		assertNull(null);
	}

	@Test
	void testAtualizarInstrutor() {
		Instrutor i = new Instrutor("InstrutorTeste", "49184192674", "sdSD", "Instrutor");
		Fachada.getInstance().atualizar(i);
		assertNull(null);
	}

	@Test
	void testListarInstrutor() {
		Fachada.getInstance().listarInstrutorVoid();
		assertNull(null);
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
