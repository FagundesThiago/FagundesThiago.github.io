package tad;

public interface Lista<tipo> {

	public boolean inserirAlgo(tipo algo);

	public boolean removerAlgo(tipo algo);

	public String buscarAlgo(tipo algo);

	@Override
	public String toString();
}