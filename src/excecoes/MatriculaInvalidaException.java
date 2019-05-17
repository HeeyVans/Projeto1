package excecoes;

import sistema.Mensagem;

public class MatriculaInvalidaException extends Exception{

	public String getMessage() {
		return Mensagem.MATRICULAINVALIDA;
	}

}
