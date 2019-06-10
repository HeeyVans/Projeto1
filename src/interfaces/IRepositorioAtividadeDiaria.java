package interfaces;

import java.util.List;

import basicas.AtividadeDiaria;

public interface IRepositorioAtividadeDiaria {
	
	public void inserir(AtividadeDiaria atividade);
	public AtividadeDiaria procurar(String cpf);
	public List listar(String cpf);
	
}
