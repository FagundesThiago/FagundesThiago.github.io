package listaEncadeada;

public interface ListaEncadeada {
	
	public void adicionarInicio(String dado);
	
	public void adicionarFim(String dado);
	
	public boolean adicionarMeio(int posicaoInclusao, String dado);
	
	public boolean excluirInicio();
	
	public boolean excluirFim();
	
	public boolean excluirMeio(int posicao);
	
	public boolean excluirLista();
	
	public boolean excluirNome(String nome);
	
	public int buscarNome(String nome);
	
	@Override
	public String toString();
}

