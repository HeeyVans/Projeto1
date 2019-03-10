package excecoes;

import sistema.Mensagem;

public class InstrutorJaCadastradoException extends Exception{
	
	String instrutor;
	
	public InstrutorJaCadastradoException(String instrutor) {
		
		this.instrutor = instrutor;
	}
	
	public String getMessage() {
		
		return instrutor + Mensagem.INSTRUTORJACADASTRADO;
	}

}
