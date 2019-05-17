package sistema;

public class Mensagem {
	
	//Exceptions	
	public static final String CLIENTEJACADASTRADO = " já foi cadastrado como cliente!";
	public static final String INSTRUTORJACADASTRADO = " já foi cadastrado como instrutor!";
	public static final String MATRICULAINVALIDA = "Esta matrícula é inválida!";
	public static final String CPFINVALIDO = "Este CPF é inválido!";
	
	//Exceptions para PopUps
	private static final String MSGALERT = "Mensagem de alerta";
	private static final String MSGERROR = "Mensagem de erro";
	private static final String MSGINFO = "Informações de ajuda";
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
