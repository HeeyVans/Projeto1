package sistema;

public class Mensagem {
	
	//Exceptions	
	public static final String CLIENTEJACADASTRADO = " j� foi cadastrado como cliente!";
	public static final String CLIENTENAOENCONTRADO = "Este cliente n�o foi encontrado!";
	public static final String INSTRUTORJACADASTRADO = " j� foi cadastrado como instrutor!";
	public static final String MATRICULANAOENCONTRADA = "Esta matr�cula n�o foi encontrada!";
	public static final String CPFINVALIDO = "Este CPF � inv�lido!";
	public static final String EMAILINVALIDO = "Este email � inv�lido!";
	public static final String CAMPOVAZIO = "Por favor, preencha todos os campos em branco!";
	
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
	
	//ClasseAssistente
	public static final String NOVAMATRICULA = "MFit Academia - Nova Matr�cula!";
	public static final String NOVAMATRICULAGERADA = "Sua nova matr�cula � ";
	
	//TelaLogin
	public static final String INFORMAEMAIL = "Qual seu email cadastrado?";
	public static final String EMAILENVIADO = "Email enviado com sucesso!";
}
