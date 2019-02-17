package interfaces;

import basicas.Cliente;
import basicas.Instrutor;

public interface IRepositorioInstrutor {
	
	public void inserir(Instrutor instrutor);
	public Cliente procurar(int matricula);
	public void remover(int matricula);
	public void atualizar(Instrutor instrutor);
	//listar

}
