package excecoes;

public class ClienteJaCadastrado extends Exception{
	
	public ClienteJaCadastrado(String message) {
		super(message);
	}
  //Deixar pra a exce��o ser tratada dentro da classe RepositorioClienteArrays ou aqui
}
