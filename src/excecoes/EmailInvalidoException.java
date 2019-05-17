package excecoes;

import sistema.Mensagem;

public class EmailInvalidoException extends Exception{
	
	public String getMessage() {
		return Mensagem.EMAILINVALIDO;
	}

}
