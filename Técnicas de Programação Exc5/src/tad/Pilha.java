package tad;

public interface Pilha<tipo> {

	public boolean empilhar(tipo dado);

	public String desempilhar();

	public String obterTopo();

	public int verificarConteudo();

	@Override
	public String toString();
}