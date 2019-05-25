package interfaces;


import basicas.Instrutor;

public interface IRepositorioInstrutor {
	
	public void inserir(Instrutor instrutor);
	public Instrutor procurar(String cpf);
	public Instrutor procurarMatricula(String matricula);
	public void remover(String cpf);
	public void atualizar(Instrutor instrutor);
	//listar

}
