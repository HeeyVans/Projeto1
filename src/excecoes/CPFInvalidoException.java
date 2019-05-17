package excecoes;

import sistema.Mensagem;

public class CPFInvalidoException extends Exception{
	
	public String getMessage() {
		return Mensagem.CPFINVALIDO;
	}

}
