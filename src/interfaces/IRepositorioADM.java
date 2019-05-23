package interfaces;

import basicas.Administrador;

public interface IRepositorioADM {
	
	public void inserir(Administrador adm);
	public Administrador procurar(String cpf);

}
