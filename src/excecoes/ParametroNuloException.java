package excecoes;

public class ParametroNuloException extends Exception {

	String parametro;
	
	public ParametroNuloException(String parametro) {
		this.parametro = parametro;
	}
	
	@Override
	public String getMessage() {
		return parametro + " não pode ser nulo. Digite algo!";
	}
		
}
