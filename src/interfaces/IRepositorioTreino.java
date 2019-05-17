
package interfaces;

import basicas.Cliente;
import basicas.Instrutor;
import basicas.Treino;

public interface IRepositorioTreino {
	
	public void inserir(Treino treino);
	public Treino procurar(int id);
	public void remover(int id);
	public void atualizar(Treino treino);
	//listar

}
