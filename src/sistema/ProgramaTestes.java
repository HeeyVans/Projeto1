package sistema;

import basicas.Cliente;
import excecoes.ClienteJaCadastradoException;
import repositorios.RepositorioClienteArquivo;

//teste
public class ProgramaTestes {

	public static void main(String[] args) throws ClienteJaCadastradoException {

		RepositorioClienteArquivo clientes = new RepositorioClienteArquivo();
		
		Cliente c1 = new Cliente("João", null, "1528258", null, "","","", null, null, null, null);
		RepositorioClienteArquivo.getInstance().inserir(c1);
		RepositorioClienteArquivo.getInstance().lerDoArquivo();
		RepositorioClienteArquivo.getInstance().salvarArquivo();
	}

}
