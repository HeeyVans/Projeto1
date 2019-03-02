package interfaces;


import basicas.Instrutor;

public interface IRepositorioInstrutor {
	
	public void inserir(Instrutor instrutor);
	public Instrutor procurar(String matricula);
	public void remover(String matricula);
	public void atualizar(Instrutor instrutor);
	//listar

}
