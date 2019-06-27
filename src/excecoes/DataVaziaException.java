package excecoes;

import sistema.Mensagem;

public class DataVaziaException extends Exception{
	
	public String getMessage() {
		return Mensagem.DATAVAZIA;
	}

}
