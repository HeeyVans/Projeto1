package gui;

import javax.swing.JOptionPane;

import excecoes.CampoVazioException;
import sistema.Mensagem;

public class PopUps {
	
	private static int confirm;
	
	//POPUPS PARA EXCEÇÕES
	public static void campoVazio(CampoVazioException cve){
		JOptionPane.showMessageDialog(null, cve.getMessage(),Mensagem.getMsgalert(),JOptionPane.WARNING_MESSAGE);
	}

}
