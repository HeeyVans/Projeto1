package gui;

import javax.swing.JOptionPane;

import excecoes.CPFInvalidoException;
import excecoes.CampoVazioException;
import excecoes.EmailInvalidoException;
import excecoes.MatriculaInvalidaException;
import sistema.Mensagem;

public class PopUps {
	
	//private static int confirm;
	
	//POPUPS PARA EXCE��ES
	public static void campoVazio(CampoVazioException cve){
		JOptionPane.showMessageDialog(null, cve.getMessage(),Mensagem.getMsgalert(),JOptionPane.WARNING_MESSAGE);
	}
	
	public static void matriculaInvalida(MatriculaInvalidaException mie) {
		JOptionPane.showMessageDialog(null, mie.getMessage(), Mensagem.getMsgalert(),JOptionPane.WARNING_MESSAGE);
	}
	
	public static void cpfInvalido(CPFInvalidoException cie) {
		JOptionPane.showMessageDialog(null, cie.getMessage(), Mensagem.getMsgalert(), JOptionPane.WARNING_MESSAGE);
	}
	
	public static void emailInvalido(EmailInvalidoException eie) {
		JOptionPane.showMessageDialog(null, eie.getMessage(), Mensagem.getMsgalert(), JOptionPane.WARNING_MESSAGE);
	}

}
