package sistema;

import basicas.Administrador;
import interfaces.IRepositorioADM;

public class CadastroADM {
	
	private IRepositorioADM repositorio;
	
	public CadastroADM(IRepositorioADM repositorio) {
		this.repositorio = repositorio;
	}
	
	public void inserir(Administrador adm) {
		repositorio.inserir(adm);
	}
	
	public Administrador procurar(String cpf)  {
		return repositorio.procurar(cpf);
	}

}
