package sistema;

import javax.swing.JOptionPane;

public class TesteCpf {

	public static void main(String[] args) {
		
		String cpf;
		
		cpf = JOptionPane.showInputDialog("Digite o CPF");
		
		if(ValidarDados.isCPF(cpf) == true) {
			JOptionPane.showMessageDialog(null, "V�lido");
		}else {
			JOptionPane.showMessageDialog(null, "Inv�lido");
		}

	}

}
