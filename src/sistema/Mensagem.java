package sistema;

public class Mensagem {
	
	//Exceptions	
	public static final String CLIENTEJACADASTRADO = " j� foi cadastrado como cliente!";
	public static final String CLIENTENAOENCONTRADO = "Este cliente n�o foi encontrado!";
	public static final String INSTRUTORJACADASTRADO = " j� foi cadastrado como instrutor!";
	public static final String MATRICULANAOENCONTRADA = "Esta matr�cula n�o foi encontrada, por favor tente novamente!";
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
	
	//Confirma��es
	public static final String CADCONFIRMA = "Confirma o cadastro?";
	public static final String EXCCONFIRMA = "Confirma a exclus�o?";
	public static final String CONFVOLTAR = "Voc� realmente deseja voltar?";
	public static final String DESEJAPROX = "Voc� realmente deseja ir?";
	public static final String PAGINAINICIAL = "Voc� realmente deseja ir para a p�gina inicial?";
	public static final String CONFENVIO = "Voc� confirma o envio?";
	
	//Erros
	public static final String ERROCADASTRO = "Erro ao Cadastrar!";
	public static final String ACESSONEGADO = "Acesso n�o permitido!";
	
	//Informa��es
	public static final String PEDINFORMACAO = "Insira na caixa de texto abaixo o dado que voc� quer que seja alterado!";
	
	
	//ClasseAssistente
	public static final String NOVAMATRICULA = "MFit Academia - Nova Matr�cula!";
	public static final String NOVAMATRICULAGERADA = "Sua nova matr�cula � ";
	
	//TelaInicial
	public static final String INFORMAEMAIL = "Qual seu email cadastrado?";
	public static final String EMAILENVIADO = "Email enviado com sucesso!";
	public static final String INFORMACPF = "Informe o CPF:";
	public static final String INFORMAMATRICULA = "Informe sua matr�cula:";
	public static final String INFORMAMATRICULACLIENTE = "Informe a matr�cula do cliente:";
	public static final String USUARIONAOEXISTE = "Este usu�rio n�o existe!";
	public static final String MATRICULAALTERADA = "Matr�cula alterada com sucesso!";
	
	//TelaCadastroCliente
	public static final String CLIENTECADASTRADO = "Cliente cadastrado com sucesso!";
	
	//TelaCadastroInstrutor
	public static final String INSTRUTORCADASTRADO = "Instrutor cadastrado com sucesso!";
	
	//TelaDadosCliente
	public static final String PDFGERADO = "PDF gerado com sucesso!";
	public static final String TREINOGERADO = "Treino gerado com sucesso!";
	
	//TelaCriarTreino
	public static final String TREINOCRIADO = "Treino criado com sucesso!";
	
	//TelaCliente e Instrutor
		public static final String ENVIOPEDIDO = "Pedido feito com sucesso!";
		public static final String MATRICULAADM= "Por favor digite sua matr�cula!";
	
		//TelaADM
		public static final String REMOVIDOSUCESSO = "Removido com sucesso!";

}
