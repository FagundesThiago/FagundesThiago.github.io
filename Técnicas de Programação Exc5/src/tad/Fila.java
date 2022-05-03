package tad;

public interface Fila<tipo> {

	public boolean enfileirar(tipo dado);

	public String desenfileirar();

	public String obterFrente();

	public int verificarConteudo();

	@Override
	public String toString();
}