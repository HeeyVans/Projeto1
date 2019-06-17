package sistema;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.text.MaskFormatter;

import basicas.Pessoa;
import basicas.Administrador;
import basicas.Cliente;
import basicas.Instrutor;
import excecoes.CPFInvalidoException;
import excecoes.CampoVazioException;
import excecoes.EmailInvalidoException;
import excecoes.MatriculaNaoEncontradaException;
import gui.PopUps;

public class ValidarDados {
	
	public static Administrador adm;
	public static Cliente cliente;
	public static Instrutor instrutor;
	public static final String Instrutor = "Instrutor";
	public static final String Cliente = "Cliente";
	public static final String ADM = "Administrador";
	
	//VALIDA플O DE CAMPOVAZIO COM 4 CAMPOS
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
	
	//Valida豫o de Telefone
	  public static String formatString(String value, String pattern) {
	        MaskFormatter mf;
	        try {
	            mf = new MaskFormatter(pattern);
	            mf.setValueContainsLiteralCharacters(false);
	            return mf.valueToString(value);
	        } catch (ParseException ex) {
	            return value;
	        }
	    }
	
	//VALIDA플O DE CAMPOVAZIO COM 1 CAMPO
			public static boolean validarCampoVazio(String arg0) {
				try {
					if (arg0.equals("")) {
						CampoVazioException cve = new CampoVazioException();
						throw cve;
					}
				} catch (CampoVazioException cve) {
					PopUps.campoVazio(cve);
					return false;
				}
				return true;
			}
	
	//VALIDA플O DE CAMPOVAZIO COM 2 CAMPOS
		public static boolean validarCampoVazio(String arg0, String arg1) {
			try {
				if (arg0.equals("") || arg1.equals("")) {
					CampoVazioException cve = new CampoVazioException();
					throw cve;
				}
			} catch (CampoVazioException cve) {
				PopUps.campoVazio(cve);
				return false;
			}
			return true;
		}
		
		//VALIDA플O DE CAMPOVAZIO COM 9 CAMPOS
				public static boolean validarCampoVazio(String arg0, String arg1, String arg2, String arg3
						, String arg4, String arg5, String arg6, String arg7, String arg8) {
					try {
						if (arg0.equals("") || arg1.equals("") || arg2.equals("") || arg3.equals("")
								|| arg4.equals("") || arg5.equals("") || arg6.equals("") || arg7.equals("")
								|| arg8.equals("")) {
							CampoVazioException cve = new CampoVazioException();
							throw cve;
						}
					} catch (CampoVazioException cve) {
						PopUps.campoVazio(cve);
						return false;
					}
					return true;
				}
				
				//VALIDA플O DE CAMPOVAZIO COM 10 CAMPOS
				public static boolean validarCampoVazio(String arg0, String arg1, String arg2, String arg3
						, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9) {
					try {
						if (arg0.equals("") || arg1.equals("") || arg2.equals("") || arg3.equals("")
								|| arg4.equals("") || arg5.equals("") || arg6.equals("") || arg7.equals("")
								|| arg8.equals("") || arg9.equals("")) {
							CampoVazioException cve = new CampoVazioException();
							throw cve;
						}
					} catch (CampoVazioException cve) {
						PopUps.campoVazio(cve);
						return false;
					}
					return true;
				}
				
				//VALIDA플O DE CAMPOVAZIO COM 20 CAMPOS
				public static boolean validarCampoVazio(String arg0, String arg1, String arg2, String arg3
						, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10
						, String arg11 , String arg12, String arg13, String arg14, String arg15, String arg16, String arg17
						) {
					try {
						if (arg0.equals("") || arg1.equals("") || arg2.equals("") || arg3.equals("")
								|| arg4.equals("") || arg5.equals("") || arg6.equals("") || arg7.equals("")
								|| arg8.equals("") || arg9.equals("") || arg10.equals("") || arg11.equals("") ||
								arg12.equals("") || arg13.equals("") || arg14.equals("") || arg15.equals("")
								 || arg16.equals("")  || arg17.equals("")) {
							CampoVazioException cve = new CampoVazioException();
							throw cve;
						}
					} catch (CampoVazioException cve) {
						PopUps.campoVazio(cve);
						return false;
					}
					return true;
				}
	
	//VALIDA플O DE CPF
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
        
        //Valida Login De Cliente
        public static Cliente validarLoginCliente(String cpf, String matricula) {
        	try {
        		cliente = Fachada.getInstance().procurarCliente(cpf);
        		if(!cliente.getMatricula().equals(matricula)) {
        			MatriculaNaoEncontradaException mnee = new MatriculaNaoEncontradaException();
        			throw mnee;
        		}
        	}catch(MatriculaNaoEncontradaException mnee) {
        		PopUps.matriculaInvalida(mnee);
        		return null;
        		
        	} 
        	return cliente;
        }
        
        
        public static boolean validarLoginADM(String matricula) {
        	try {
        		adm = Fachada.getInstance().procurarADM(matricula);
        		if(adm == null) {
        			MatriculaNaoEncontradaException mnee = new MatriculaNaoEncontradaException();
        			throw mnee;
        		}
        	}catch(MatriculaNaoEncontradaException mnee) {
        		PopUps.matriculaInvalida(mnee);
        		return false;
        		
        	} 
        	return true;
        }
        
        
        public static Instrutor validarLoginInstrutor(String cpf, String matricula) {
        	try {
        		instrutor = Fachada.getInstance().procurarInstrutor(cpf);
        		if(!instrutor.getMatricula().equals(matricula)) {
        			MatriculaNaoEncontradaException mnee = new MatriculaNaoEncontradaException();
        			throw mnee;
        		}
        	}catch(MatriculaNaoEncontradaException mnee) {
        		PopUps.matriculaInvalida(mnee);
        		return null;
        		
        	} 
        	return instrutor;
        }
             	
         //Para Validar o Email
        public static boolean validarEmail(String email){
    		try{
    			//if(!email.matches("[\\w\\d]+@[^0-9]+(\\.com$|\\.br$)")){
    			if(!email.matches( "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
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



