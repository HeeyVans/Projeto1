package sistema;

import basicas.Administrador;
import interfaces.IRepositorioADM;
import repositorios.RepositorioADMArray;

public class CadastroADM {
	
	private IRepositorioADM repositorio;
	
	public CadastroADM() {
		repositorio = new RepositorioADMArray();
	}
	
	public void inserir(Administrador adm) {
		repositorio.inserir(adm);
	}
	
	public Administrador procurar(String matricula)  {
		return repositorio.procurar(matricula);
	}

}
