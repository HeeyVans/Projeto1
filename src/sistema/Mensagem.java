package sistema;

public class Mensagem {
	
	//Exceptions	
	public static final String CLIENTEJACADASTRADO = " já foi cadastrado como cliente!";
	public static final String CLIENTENAOENCONTRADO = "Este cliente não foi encontrado!";
	public static final String INSTRUTORJACADASTRADO = " já foi cadastrado como instrutor!";
	public static final String MATRICULANAOENCONTRADA = "Esta matrícula não foi encontrada!";
	public static final String CPFINVALIDO = "Este CPF é inválido!";
	public static final String EMAILINVALIDO = "Este email é inválido!";
	public static final String CAMPOVAZIO = "Por favor, preencha todos os campos em branco!";
	
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
	
	//ClasseAssistente
	public static final String NOVAMATRICULA = "MFit Academia - Nova Matrícula!";
	public static final String NOVAMATRICULAGERADA = "Sua nova matrícula é ";
	
	//TelaLogin
	public static final String INFORMAEMAIL = "Qual seu email cadastrado?";
	public static final String EMAILENVIADO = "Email enviado com sucesso!";
}
