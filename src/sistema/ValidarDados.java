package sistema;

import java.util.InputMismatchException;

import basicas.Pessoa;
import basicas.Cliente;
import basicas.Instrutor;
import excecoes.CPFInvalidoException;
import excecoes.CampoVazioException;
import excecoes.EmailInvalidoException;
import excecoes.MatriculaInvalidaException;
import excecoes.NaoEncontradoException;
import excecoes.ParametroNuloException;
import gui.PopUps;

public class ValidarDados {
	
	public static Pessoa pessoa;
	public static Cliente cliente;
	public static Instrutor instrutor;
	public static final String Instrutor = "Instrutor";
	public static final String Cliente = "Cliente";
	public static final String ADM = "Administrador";
	
	//VALIDAÇÃO DE CAMPOVAZIO COM 4 CAMPOS
	public static boolean validarCampoVazio(String arg0, String arg1, String arg2, String arg3) {
		try {
			if (arg0.equals("") || arg1.equals("") || arg2.equals("") || arg3.equals("")) {
				CampoVazioException cve = new CampoVazioException();
				throw cve;
			}
		} catch (CampoVazioException cve) {
			PopUps.campoVazio(cve);
			return false;
		}
		return true;
	}
	
	//VALIDAÇÃO DE CPF
	public static boolean isCPF(String CPF) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") ||
            CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999") ||
            (CPF.length() != 11))
            return(false);
          
        char dig10, dig11;
        int sm, i, r, num, peso;
          
        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
        // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {              
        // converte o i-esimo caractere do CPF em um numero:
        // por exemplo, transforma o caractere '0' no inteiro 0         
        // (48 eh a posicao de '0' na tabela ASCII)         
            num = (int)(CPF.charAt(i) - 48); 
            sm = sm + (num * peso);
            peso = peso - 1;
            }
          
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico
          
        // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }
          
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);
          
        // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                 return(true);
            else return(false);
                } catch (InputMismatchException erro) {
                return(false);
            }
        }
          
        public static String imprimeCPF(String CPF) {
            return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
            CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
        }
        
        //Identifica qual destes está fazendo o Login e o direciona para a tela correta
        public static String identificadorLogin() {
        	switch(pessoa.getIdentificador()) {
        	
        	case Instrutor:
        		return Instrutor;
        	case Cliente:
        		return Cliente;
        	case ADM:
        		return ADM;
        	default:
        		return null;
        	
        	}
        }
        
        //Valida Login De Cliente
        public static boolean validarLoginCliente(String cpf, String matricula) {
        	try {
        		cliente = Fachada.getInstance().procurarCliente(matricula);
        		if(!cliente.getCpf().equals(cpf)) {
        			MatriculaInvalidaException mie = new MatriculaInvalidaException();
        			throw mie;
        		}
        	}catch(MatriculaInvalidaException mie) {
        		PopUps.matriculaInvalida(mie);
        		return false;
        		
        	} 
        	return true;
        }
        
        //Para Validar o Email
        public static boolean validarEmail(String email){
    		try{
    			if(!email.matches("[\\w\\d]+@[^0-9]+(\\.com$|\\.br$)")){
    				EmailInvalidoException eie = new EmailInvalidoException();
    				throw eie;
    			}
    			
    		}catch(EmailInvalidoException eie ){
    			PopUps.emailInvalido(eie);
    			return false;
    		}
    		return true;
    	}
    }



