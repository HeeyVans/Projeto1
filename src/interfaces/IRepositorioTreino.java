
package interfaces;

import java.util.List;

import basicas.Cliente;
import basicas.Instrutor;
import basicas.Treino;
import excecoes.MatriculaNaoEncontradaException;

public interface IRepositorioTreino {
	
	public void inserir(Treino treino) throws MatriculaNaoEncontradaException;
	public Treino procurarClienteTreino(String matricula, String categoria);
	public Treino procurarIdTreino(int id, String categoria);
	public void atualizar(Treino treino);
	public List listar(String matricula, String categoria);
	public int contaInstrutorPorCliente(String matriculaInstrutor);

}
