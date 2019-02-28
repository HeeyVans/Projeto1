package sistema;

import basicas.Cliente;
import excecoes.ClienteJaCadastrado;
import repositorios.RepositorioClienteArrays;

public class Testes {

	public static void main(String[] args) throws ClienteJaCadastrado {

		RepositorioClienteArrays clientes = new RepositorioClienteArrays();
		
		Cliente c1 = new Cliente("João", null, "1528258", null, "");
		RepositorioClienteArrays.getInstance().inserir(c1);
		RepositorioClienteArrays.getInstance().salvarArquivo();
		RepositorioClienteArrays.getInstance().lerDoArquivo();
	}

}
