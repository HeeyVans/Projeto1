package sistema;

public class Mensagem {
	
	//Exceptions	
	public static final String CLIENTEJACADASTRADO = " já foi cadastrado como cliente!";
	public static final String CLIENTENAOENCONTRADO = "Este cliente não foi encontrado!";
	public static final String INSTRUTORJACADASTRADO = " já foi cadastrado como instrutor!";
	public static final String MATRICULANAOENCONTRADA = "Esta matrícula não foi encontrada, por favor tente novamente!";
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
	
	//Confirmações
	public static final String CADCONFIRMA = "Confirma o cadastro?";
	public static final String EXCCONFIRMA = "Confirma a exclusão?";
	public static final String CONFVOLTAR = "Você realmente deseja voltar?";
	public static final String DESEJAPROX = "Você realmente deseja ir?";
	public static final String PAGINAINICIAL = "Você realmente deseja ir para a página inicial?";
	public static final String CONFENVIO = "Você confirma o envio?";
	
	//Erros
	public static final String ERROCADASTRO = "Erro ao Cadastrar!";
	public static final String ACESSONEGADO = "Acesso não permitido!";
	
	//Informações
	public static final String PEDINFORMACAO = "Insira na caixa de texto abaixo o dado que você quer que seja alterado!";
	
	
	//ClasseAssistente
	public static final String NOVAMATRICULA = "MFit Academia - Nova Matrícula!";
	public static final String NOVAMATRICULAGERADA = "Sua nova matrícula é ";
	
	//TelaInicial
	public static final String INFORMAEMAIL = "Qual seu email cadastrado?";
	public static final String EMAILENVIADO = "Email enviado com sucesso!";
	public static final String INFORMACPF = "Informe o CPF:";
	public static final String INFORMAMATRICULA = "Informe sua matrícula:";
	public static final String INFORMAMATRICULACLIENTE = "Informe a matrícula do cliente:";
	public static final String USUARIONAOEXISTE = "Este usuário não existe!";
	public static final String MATRICULAALTERADA = "Matrícula alterada com sucesso!";
	
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
		public static final String MATRICULAADM= "Por favor digite sua matrícula!";
	
		//TelaADM
		public static final String REMOVIDOSUCESSO = "Removido com sucesso!";

}
