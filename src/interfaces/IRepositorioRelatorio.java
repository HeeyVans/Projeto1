package interfaces;

import java.util.List;

import basicas.AtividadeDiaria;
import basicas.Treino;

public interface IRepositorioRelatorio {
	
	public void inserir(AtividadeDiaria ativ);
	public List listar();

}
