package sistema;

import basicas.Cliente;
import excecoes.ClienteJaCadastradoException;
import repositorios.RepositorioClienteArrays;

//teste
public class ProgramaTestes {

	public static void main(String[] args) throws ClienteJaCadastradoException {

		RepositorioClienteArrays clientes = new RepositorioClienteArrays();
		
		Cliente c1 = new Cliente("João", null, "1528258", null, "","");
		RepositorioClienteArrays.getInstance().inserir(c1);
	}

}
