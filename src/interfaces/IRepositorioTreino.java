
package interfaces;

import java.util.List;

import basicas.Cliente;
import basicas.Instrutor;
import basicas.Treino;

public interface IRepositorioTreino {
	
	public void inserir(Treino treino);
	public Treino procurar(String id);
	public Treino procurarClienteTreino(String matricula);
	public void remover(String id);
	public void atualizar(Treino treino);
	public List listar(String matricula, String categoria);

}
