package fila;

public interface Fila {

	public boolean enfileirar(int dado);

	public String desenfileirar();

	public String obterFrente();

	public boolean verificarConteudo();

	@Override
	public String toString();
}