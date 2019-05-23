package excecoes;

import sistema.Mensagem;

public class MatriculaNaoEncontradaException extends Exception{
	
	public String getMessage() {
		return Mensagem.MATRICULANAOENCONTRADA;
	}

}
