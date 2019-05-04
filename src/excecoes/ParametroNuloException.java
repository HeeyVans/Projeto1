package excecoes;

public class ParametroNuloException extends Exception {

	String parametro;
	
	public ParametroNuloException(String parametro) {
		this.parametro = parametro;
	}
	
	@Override
	public String getMessage() {
		return parametro + " n�o pode ser nulo. Digite algo!";
	}
		
}
