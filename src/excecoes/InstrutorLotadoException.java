package excecoes;

import sistema.Mensagem;

public class InstrutorLotadoException extends Exception{

	public String getMessage() {
		return Mensagem.INSTRUTORLOTADO;
	}
}
