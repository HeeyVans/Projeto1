package sistema;

public class Mensagem {
	
	//Exceptions	
	public static final String CLIENTEJACADASTRADO = " j� foi cadastrado como cliente!";
	public static final String INSTRUTORJACADASTRADO = " j� foi cadastrado como instrutor!";
	public static final String MATRICULAINVALIDA = "Esta matr�cula � inv�lida!";
	public static final String CPFINVALIDO = "Este CPF � inv�lido!";
	
	//Exceptions para PopUps
	private static final String MSGALERT = "Mensagem de alerta";
	private static final String MSGERROR = "Mensagem de erro";
	private static final String MSGINFO = "Informa��es de ajuda";
	public static String getMsgalert() {
		return MSGALERT;
	}
	public static String getMsgerror() {
		return MSGERROR;
	}
	public static String getMsginfo() {
		return MSGINFO;
	}
}
