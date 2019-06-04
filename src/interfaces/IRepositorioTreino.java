
package interfaces;

import java.util.List;

import basicas.Cliente;
import basicas.Instrutor;
import basicas.Treino;
import excecoes.MatriculaNaoEncontradaException;

public interface IRepositorioTreino {
	
	public void inserir(Treino treino) throws MatriculaNaoEncontradaException;
	public Treino procurar(String id);
	public Treino procurarClienteTreino(String matricula);
	public void remover(String id);
	public void atualizar(Treino treino);
	public List listar(String matricula, String categoria);

}
