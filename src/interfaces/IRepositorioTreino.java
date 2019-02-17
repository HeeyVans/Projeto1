package interfaces;

import basicas.Cliente;
import basicas.Instrutor;
import basicas.Treino;

public interface IRepositorioTreino {
	
	public void inserir(Treino treino, Cliente cliente, Instrutor instrutor);
	public Treino procurar(Treino treino, Cliente cliente, Instrutor instrutor);
	public void remover(Treino treino, Cliente cliente, Instrutor instrutor);
	public void atualizar(Treino treino, Cliente cliente, Instrutor instrutor);
	//listar

}
