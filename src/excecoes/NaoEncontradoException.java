package excecoes;

public class NaoEncontradoException extends Exception{
	
	private String mensagem;
	
	public NaoEncontradoException(String mensagem) {
		this.mensagem = mensagem;
	}
	
	@Override
	public String getMessage() {
		return "N�o foi possivel encontrar " + this.mensagem + "!";
	}

}
