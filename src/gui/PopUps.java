package gui;

import javax.swing.JOptionPane;

import excecoes.CPFInvalidoException;
import excecoes.CampoVazioException;
import excecoes.EmailInvalidoException;
import excecoes.MatriculaNaoEncontradaException;
import sistema.Mensagem;

public class PopUps {
	
	//private static int confirm;
	
	//POPUPS PARA EXCEÇÕES
	public static void campoVazio(CampoVazioException cve){
		JOptionPane.showMessageDialog(null, cve.getMessage(),Mensagem.getMsgalert(),JOptionPane.WARNING_MESSAGE);
	}
	
	public static void matriculaInvalida(MatriculaNaoEncontradaException mnee) {
		JOptionPane.showMessageDialog(null, mnee.getMessage(), Mensagem.getMsgalert(),JOptionPane.WARNING_MESSAGE);
	}
	
	public static void cpfInvalido(CPFInvalidoException cie) {
		JOptionPane.showMessageDialog(null, cie.getMessage(), Mensagem.getMsgalert(), JOptionPane.WARNING_MESSAGE);
	}
	
	public static void emailInvalido(EmailInvalidoException eie) {
		JOptionPane.showMessageDialog(null, eie.getMessage(), Mensagem.getMsgalert(), JOptionPane.WARNING_MESSAGE);
	}
	
	//CONFIRMAÇÕES
	public static void emailEnviado() {
		JOptionPane.showMessageDialog(null, Mensagem.EMAILENVIADO);
	}
	public static void clienteCadastrado() {
		JOptionPane.showMessageDialog(null, Mensagem.CLIENTECADASTRADO);
	}
	public static void matriculaAlterada() {
		JOptionPane.showMessageDialog(null, Mensagem.MATRICULAALTERADA);
	}
	public static void instrutorCadastrado() {
		JOptionPane.showMessageDialog(null, Mensagem.INSTRUTORCADASTRADO);
	}
	public static void pdfgerado() {
		JOptionPane.showMessageDialog(null, Mensagem.PDFGERADO);
	}
	public static void treinoGerado() {
		JOptionPane.showMessageDialog(null, Mensagem.TREINOGERADO);
	}
	public static void treinoCriado() {
		JOptionPane.showMessageDialog(null, Mensagem.TREINOCRIADO);
	}
	
	//ERROS
	public static void ErroCadastro() {
		JOptionPane.showMessageDialog(null, Mensagem.ERROCADASTRO, Mensagem.getMsgerror(), JOptionPane.WARNING_MESSAGE);
	}
	public static void cpfInvalido() {
		JOptionPane.showMessageDialog(null, Mensagem.CPFINVALIDO, Mensagem.getMsgerror(), JOptionPane.WARNING_MESSAGE);
	}
	public static void campoVazio(){
		JOptionPane.showMessageDialog(null, Mensagem.CAMPOVAZIO, Mensagem.getMsgalert(),JOptionPane.WARNING_MESSAGE);
	}
	public static void UsuarioNaoExiste() {
		JOptionPane.showMessageDialog(null, Mensagem.USUARIONAOEXISTE, Mensagem.getMsgalert(), JOptionPane.WARNING_MESSAGE);
	}

}
