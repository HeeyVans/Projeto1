package excecoes;

import sistema.Mensagem;

public class ClienteJaCadastradoException extends Exception{
	
	String cliente;
	
	public ClienteJaCadastradoException(String cliente) {
		this.cliente = cliente;
	}
	
	public String getMessage() {
		
		return cliente + Mensagem.CLIENTEJACADASTRADO;
		
	}
  
}
