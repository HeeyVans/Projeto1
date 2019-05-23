package excecoes;

import sistema.Mensagem;

public class ClienteNaoEncontradoException extends Exception{
	
	public String getMessage() {
		return Mensagem.CLIENTENAOENCONTRADO;
	}

}
