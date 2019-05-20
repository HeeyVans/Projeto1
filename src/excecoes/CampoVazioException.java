package excecoes;

import sistema.Mensagem;

public class CampoVazioException extends Exception{
	
	public String getMessage() {
		return Mensagem.CAMPOVAZIO;
	}

}
